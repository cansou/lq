package org.jsoup.parser;

import java.util.Arrays;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Entities;
import org.jsoup.parser.Token;

final class Tokeniser {
    private static final char[] notCharRefCharsSorted = {9, 10, 13, 12, ' ', '<', '&'};
    static final char replacementChar = '�';
    Token.Character charPending = new Token.Character();
    private final char[] charRefHolder = new char[1];
    private StringBuilder charsBuilder = new StringBuilder(1024);
    private String charsString = null;
    Token.Comment commentPending = new Token.Comment();
    StringBuilder dataBuffer = new StringBuilder(1024);
    Token.Doctype doctypePending = new Token.Doctype();
    private Token emitPending;
    Token.EndTag endPending = new Token.EndTag();
    private ParseErrorList errors;
    private boolean isEmitPending = false;
    private String lastStartTag;
    private CharacterReader reader;
    private boolean selfClosingFlagAcknowledged = true;
    Token.StartTag startPending = new Token.StartTag();
    private TokeniserState state = TokeniserState.Data;
    Token.Tag tagPending;

    static {
        Arrays.sort(notCharRefCharsSorted);
    }

    Tokeniser(CharacterReader reader2, ParseErrorList errors2) {
        this.reader = reader2;
        this.errors = errors2;
    }

    /* access modifiers changed from: package-private */
    public Token read() {
        if (!this.selfClosingFlagAcknowledged) {
            error("Self closing flag not acknowledged");
            this.selfClosingFlagAcknowledged = true;
        }
        while (!this.isEmitPending) {
            this.state.read(this, this.reader);
        }
        if (this.charsBuilder.length() > 0) {
            String str = this.charsBuilder.toString();
            this.charsBuilder.delete(0, this.charsBuilder.length());
            this.charsString = null;
            return this.charPending.data(str);
        } else if (this.charsString != null) {
            Token.Character data = this.charPending.data(this.charsString);
            this.charsString = null;
            return data;
        } else {
            this.isEmitPending = false;
            return this.emitPending;
        }
    }

    /* access modifiers changed from: package-private */
    public void emit(Token token) {
        Validate.isFalse(this.isEmitPending, "There is an unread token pending!");
        this.emitPending = token;
        this.isEmitPending = true;
        if (token.type == Token.TokenType.StartTag) {
            Token.StartTag startTag = (Token.StartTag) token;
            this.lastStartTag = startTag.tagName;
            if (startTag.selfClosing) {
                this.selfClosingFlagAcknowledged = false;
            }
        } else if (token.type == Token.TokenType.EndTag && ((Token.EndTag) token).attributes != null) {
            error("Attributes incorrectly present on end tag");
        }
    }

    /* access modifiers changed from: package-private */
    public void emit(String str) {
        if (this.charsString == null) {
            this.charsString = str;
            return;
        }
        if (this.charsBuilder.length() == 0) {
            this.charsBuilder.append(this.charsString);
        }
        this.charsBuilder.append(str);
    }

    /* access modifiers changed from: package-private */
    public void emit(char[] chars) {
        emit(String.valueOf(chars));
    }

    /* access modifiers changed from: package-private */
    public void emit(char c) {
        emit(String.valueOf(c));
    }

    /* access modifiers changed from: package-private */
    public TokeniserState getState() {
        return this.state;
    }

    /* access modifiers changed from: package-private */
    public void transition(TokeniserState state2) {
        this.state = state2;
    }

    /* access modifiers changed from: package-private */
    public void advanceTransition(TokeniserState state2) {
        this.reader.advance();
        this.state = state2;
    }

    /* access modifiers changed from: package-private */
    public void acknowledgeSelfClosingFlag() {
        this.selfClosingFlagAcknowledged = true;
    }

    /* access modifiers changed from: package-private */
    public char[] consumeCharacterReference(Character additionalAllowedCharacter, boolean inAttribute) {
        boolean found;
        if (this.reader.isEmpty()) {
            return null;
        }
        if (additionalAllowedCharacter != null && additionalAllowedCharacter.charValue() == this.reader.current()) {
            return null;
        }
        if (this.reader.matchesAnySorted(notCharRefCharsSorted)) {
            return null;
        }
        char[] charRef = this.charRefHolder;
        this.reader.mark();
        if (this.reader.matchConsume("#")) {
            boolean isHexMode = this.reader.matchConsumeIgnoreCase("X");
            String numRef = isHexMode ? this.reader.consumeHexSequence() : this.reader.consumeDigitSequence();
            if (numRef.length() == 0) {
                characterReferenceError("numeric reference with no numerals");
                this.reader.rewindToMark();
                return null;
            }
            if (!this.reader.matchConsume(";")) {
                characterReferenceError("missing semicolon");
            }
            int charval = -1;
            try {
                charval = Integer.valueOf(numRef, isHexMode ? 16 : 10).intValue();
            } catch (NumberFormatException e) {
            }
            if (charval == -1 || ((charval >= 55296 && charval <= 57343) || charval > 1114111)) {
                characterReferenceError("character outside of valid range");
                charRef[0] = replacementChar;
                return charRef;
            } else if (charval >= 65536) {
                return Character.toChars(charval);
            } else {
                charRef[0] = (char) charval;
                return charRef;
            }
        } else {
            String nameRef = this.reader.consumeLetterThenDigitSequence();
            boolean looksLegit = this.reader.matches(';');
            if (Entities.isBaseNamedEntity(nameRef) || (Entities.isNamedEntity(nameRef) && looksLegit)) {
                found = true;
            } else {
                found = false;
            }
            if (!found) {
                this.reader.rewindToMark();
                if (looksLegit) {
                    characterReferenceError(String.format("invalid named referenece '%s'", new Object[]{nameRef}));
                }
                return null;
            } else if (!inAttribute || (!this.reader.matchesLetter() && !this.reader.matchesDigit() && !this.reader.matchesAny('=', '-', '_'))) {
                if (!this.reader.matchConsume(";")) {
                    characterReferenceError("missing semicolon");
                }
                charRef[0] = Entities.getCharacterByName(nameRef).charValue();
                return charRef;
            } else {
                this.reader.rewindToMark();
                return null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Token.Tag createTagPending(boolean start) {
        this.tagPending = start ? this.startPending.reset() : this.endPending.reset();
        return this.tagPending;
    }

    /* access modifiers changed from: package-private */
    public void emitTagPending() {
        this.tagPending.finaliseTag();
        emit((Token) this.tagPending);
    }

    /* access modifiers changed from: package-private */
    public void createCommentPending() {
        this.commentPending.reset();
    }

    /* access modifiers changed from: package-private */
    public void emitCommentPending() {
        emit((Token) this.commentPending);
    }

    /* access modifiers changed from: package-private */
    public void createDoctypePending() {
        this.doctypePending.reset();
    }

    /* access modifiers changed from: package-private */
    public void emitDoctypePending() {
        emit((Token) this.doctypePending);
    }

    /* access modifiers changed from: package-private */
    public void createTempBuffer() {
        Token.reset(this.dataBuffer);
    }

    /* access modifiers changed from: package-private */
    public boolean isAppropriateEndTagToken() {
        return this.lastStartTag != null && this.tagPending.tagName.equals(this.lastStartTag);
    }

    /* access modifiers changed from: package-private */
    public String appropriateEndTagName() {
        if (this.lastStartTag == null) {
            return null;
        }
        return this.lastStartTag;
    }

    /* access modifiers changed from: package-private */
    public void error(TokeniserState state2) {
        if (this.errors.canAddError()) {
            this.errors.add(new ParseError(this.reader.pos(), "Unexpected character '%s' in input state [%s]", Character.valueOf(this.reader.current()), state2));
        }
    }

    /* access modifiers changed from: package-private */
    public void eofError(TokeniserState state2) {
        if (this.errors.canAddError()) {
            this.errors.add(new ParseError(this.reader.pos(), "Unexpectedly reached end of file (EOF) in input state [%s]", state2));
        }
    }

    private void characterReferenceError(String message) {
        if (this.errors.canAddError()) {
            this.errors.add(new ParseError(this.reader.pos(), "Invalid character reference: %s", message));
        }
    }

    private void error(String errorMsg) {
        if (this.errors.canAddError()) {
            this.errors.add(new ParseError(this.reader.pos(), errorMsg));
        }
    }

    /* access modifiers changed from: package-private */
    public boolean currentNodeInHtmlNS() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public String unescapeEntities(boolean inAttribute) {
        StringBuilder builder = new StringBuilder();
        while (!this.reader.isEmpty()) {
            builder.append(this.reader.consumeTo('&'));
            if (this.reader.matches('&')) {
                this.reader.consume();
                char[] c = consumeCharacterReference((Character) null, inAttribute);
                if (c == null || c.length == 0) {
                    builder.append('&');
                } else {
                    builder.append(c);
                }
            }
        }
        return builder.toString();
    }
}
