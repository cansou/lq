package com.amazonaws.services.dynamodbv2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryRequest extends AmazonWebServiceRequest implements Serializable {
    private List<String> attributesToGet;
    private String conditionalOperator;
    private Boolean consistentRead;
    private Map<String, AttributeValue> exclusiveStartKey;
    private Map<String, String> expressionAttributeNames;
    private Map<String, AttributeValue> expressionAttributeValues;
    private String filterExpression;
    private String indexName;
    private String keyConditionExpression;
    private Map<String, Condition> keyConditions;
    private Integer limit;
    private String projectionExpression;
    private Map<String, Condition> queryFilter;
    private String returnConsumedCapacity;
    private Boolean scanIndexForward;
    private String select;
    private String tableName;

    public QueryRequest() {
    }

    public QueryRequest(String tableName2) {
        setTableName(tableName2);
    }

    public String getTableName() {
        return this.tableName;
    }

    public void setTableName(String tableName2) {
        this.tableName = tableName2;
    }

    public QueryRequest withTableName(String tableName2) {
        this.tableName = tableName2;
        return this;
    }

    public String getIndexName() {
        return this.indexName;
    }

    public void setIndexName(String indexName2) {
        this.indexName = indexName2;
    }

    public QueryRequest withIndexName(String indexName2) {
        this.indexName = indexName2;
        return this;
    }

    public String getSelect() {
        return this.select;
    }

    public void setSelect(String select2) {
        this.select = select2;
    }

    public QueryRequest withSelect(String select2) {
        this.select = select2;
        return this;
    }

    public void setSelect(Select select2) {
        this.select = select2.toString();
    }

    public QueryRequest withSelect(Select select2) {
        this.select = select2.toString();
        return this;
    }

    public List<String> getAttributesToGet() {
        return this.attributesToGet;
    }

    public void setAttributesToGet(Collection<String> attributesToGet2) {
        if (attributesToGet2 == null) {
            this.attributesToGet = null;
        } else {
            this.attributesToGet = new ArrayList(attributesToGet2);
        }
    }

    public QueryRequest withAttributesToGet(String... attributesToGet2) {
        if (getAttributesToGet() == null) {
            this.attributesToGet = new ArrayList(attributesToGet2.length);
        }
        for (String value : attributesToGet2) {
            this.attributesToGet.add(value);
        }
        return this;
    }

    public QueryRequest withAttributesToGet(Collection<String> attributesToGet2) {
        setAttributesToGet(attributesToGet2);
        return this;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public void setLimit(Integer limit2) {
        this.limit = limit2;
    }

    public QueryRequest withLimit(Integer limit2) {
        this.limit = limit2;
        return this;
    }

    public Boolean isConsistentRead() {
        return this.consistentRead;
    }

    public Boolean getConsistentRead() {
        return this.consistentRead;
    }

    public void setConsistentRead(Boolean consistentRead2) {
        this.consistentRead = consistentRead2;
    }

    public QueryRequest withConsistentRead(Boolean consistentRead2) {
        this.consistentRead = consistentRead2;
        return this;
    }

    public Map<String, Condition> getKeyConditions() {
        return this.keyConditions;
    }

    public void setKeyConditions(Map<String, Condition> keyConditions2) {
        this.keyConditions = keyConditions2;
    }

    public QueryRequest withKeyConditions(Map<String, Condition> keyConditions2) {
        this.keyConditions = keyConditions2;
        return this;
    }

    public QueryRequest addKeyConditionsEntry(String key, Condition value) {
        if (this.keyConditions == null) {
            this.keyConditions = new HashMap();
        }
        if (this.keyConditions.containsKey(key)) {
            throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
        }
        this.keyConditions.put(key, value);
        return this;
    }

    public QueryRequest clearKeyConditionsEntries() {
        this.keyConditions = null;
        return this;
    }

    public Map<String, Condition> getQueryFilter() {
        return this.queryFilter;
    }

    public void setQueryFilter(Map<String, Condition> queryFilter2) {
        this.queryFilter = queryFilter2;
    }

    public QueryRequest withQueryFilter(Map<String, Condition> queryFilter2) {
        this.queryFilter = queryFilter2;
        return this;
    }

    public QueryRequest addQueryFilterEntry(String key, Condition value) {
        if (this.queryFilter == null) {
            this.queryFilter = new HashMap();
        }
        if (this.queryFilter.containsKey(key)) {
            throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
        }
        this.queryFilter.put(key, value);
        return this;
    }

    public QueryRequest clearQueryFilterEntries() {
        this.queryFilter = null;
        return this;
    }

    public String getConditionalOperator() {
        return this.conditionalOperator;
    }

    public void setConditionalOperator(String conditionalOperator2) {
        this.conditionalOperator = conditionalOperator2;
    }

    public QueryRequest withConditionalOperator(String conditionalOperator2) {
        this.conditionalOperator = conditionalOperator2;
        return this;
    }

    public void setConditionalOperator(ConditionalOperator conditionalOperator2) {
        this.conditionalOperator = conditionalOperator2.toString();
    }

    public QueryRequest withConditionalOperator(ConditionalOperator conditionalOperator2) {
        this.conditionalOperator = conditionalOperator2.toString();
        return this;
    }

    public Boolean isScanIndexForward() {
        return this.scanIndexForward;
    }

    public Boolean getScanIndexForward() {
        return this.scanIndexForward;
    }

    public void setScanIndexForward(Boolean scanIndexForward2) {
        this.scanIndexForward = scanIndexForward2;
    }

    public QueryRequest withScanIndexForward(Boolean scanIndexForward2) {
        this.scanIndexForward = scanIndexForward2;
        return this;
    }

    public Map<String, AttributeValue> getExclusiveStartKey() {
        return this.exclusiveStartKey;
    }

    public void setExclusiveStartKey(Map<String, AttributeValue> exclusiveStartKey2) {
        this.exclusiveStartKey = exclusiveStartKey2;
    }

    public QueryRequest withExclusiveStartKey(Map<String, AttributeValue> exclusiveStartKey2) {
        this.exclusiveStartKey = exclusiveStartKey2;
        return this;
    }

    public QueryRequest addExclusiveStartKeyEntry(String key, AttributeValue value) {
        if (this.exclusiveStartKey == null) {
            this.exclusiveStartKey = new HashMap();
        }
        if (this.exclusiveStartKey.containsKey(key)) {
            throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
        }
        this.exclusiveStartKey.put(key, value);
        return this;
    }

    public QueryRequest clearExclusiveStartKeyEntries() {
        this.exclusiveStartKey = null;
        return this;
    }

    public String getReturnConsumedCapacity() {
        return this.returnConsumedCapacity;
    }

    public void setReturnConsumedCapacity(String returnConsumedCapacity2) {
        this.returnConsumedCapacity = returnConsumedCapacity2;
    }

    public QueryRequest withReturnConsumedCapacity(String returnConsumedCapacity2) {
        this.returnConsumedCapacity = returnConsumedCapacity2;
        return this;
    }

    public void setReturnConsumedCapacity(ReturnConsumedCapacity returnConsumedCapacity2) {
        this.returnConsumedCapacity = returnConsumedCapacity2.toString();
    }

    public QueryRequest withReturnConsumedCapacity(ReturnConsumedCapacity returnConsumedCapacity2) {
        this.returnConsumedCapacity = returnConsumedCapacity2.toString();
        return this;
    }

    public String getProjectionExpression() {
        return this.projectionExpression;
    }

    public void setProjectionExpression(String projectionExpression2) {
        this.projectionExpression = projectionExpression2;
    }

    public QueryRequest withProjectionExpression(String projectionExpression2) {
        this.projectionExpression = projectionExpression2;
        return this;
    }

    public String getFilterExpression() {
        return this.filterExpression;
    }

    public void setFilterExpression(String filterExpression2) {
        this.filterExpression = filterExpression2;
    }

    public QueryRequest withFilterExpression(String filterExpression2) {
        this.filterExpression = filterExpression2;
        return this;
    }

    public String getKeyConditionExpression() {
        return this.keyConditionExpression;
    }

    public void setKeyConditionExpression(String keyConditionExpression2) {
        this.keyConditionExpression = keyConditionExpression2;
    }

    public QueryRequest withKeyConditionExpression(String keyConditionExpression2) {
        this.keyConditionExpression = keyConditionExpression2;
        return this;
    }

    public Map<String, String> getExpressionAttributeNames() {
        return this.expressionAttributeNames;
    }

    public void setExpressionAttributeNames(Map<String, String> expressionAttributeNames2) {
        this.expressionAttributeNames = expressionAttributeNames2;
    }

    public QueryRequest withExpressionAttributeNames(Map<String, String> expressionAttributeNames2) {
        this.expressionAttributeNames = expressionAttributeNames2;
        return this;
    }

    public QueryRequest addExpressionAttributeNamesEntry(String key, String value) {
        if (this.expressionAttributeNames == null) {
            this.expressionAttributeNames = new HashMap();
        }
        if (this.expressionAttributeNames.containsKey(key)) {
            throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
        }
        this.expressionAttributeNames.put(key, value);
        return this;
    }

    public QueryRequest clearExpressionAttributeNamesEntries() {
        this.expressionAttributeNames = null;
        return this;
    }

    public Map<String, AttributeValue> getExpressionAttributeValues() {
        return this.expressionAttributeValues;
    }

    public void setExpressionAttributeValues(Map<String, AttributeValue> expressionAttributeValues2) {
        this.expressionAttributeValues = expressionAttributeValues2;
    }

    public QueryRequest withExpressionAttributeValues(Map<String, AttributeValue> expressionAttributeValues2) {
        this.expressionAttributeValues = expressionAttributeValues2;
        return this;
    }

    public QueryRequest addExpressionAttributeValuesEntry(String key, AttributeValue value) {
        if (this.expressionAttributeValues == null) {
            this.expressionAttributeValues = new HashMap();
        }
        if (this.expressionAttributeValues.containsKey(key)) {
            throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
        }
        this.expressionAttributeValues.put(key, value);
        return this;
    }

    public QueryRequest clearExpressionAttributeValuesEntries() {
        this.expressionAttributeValues = null;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getTableName() != null) {
            sb.append("TableName: " + getTableName() + ",");
        }
        if (getIndexName() != null) {
            sb.append("IndexName: " + getIndexName() + ",");
        }
        if (getSelect() != null) {
            sb.append("Select: " + getSelect() + ",");
        }
        if (getAttributesToGet() != null) {
            sb.append("AttributesToGet: " + getAttributesToGet() + ",");
        }
        if (getLimit() != null) {
            sb.append("Limit: " + getLimit() + ",");
        }
        if (getConsistentRead() != null) {
            sb.append("ConsistentRead: " + getConsistentRead() + ",");
        }
        if (getKeyConditions() != null) {
            sb.append("KeyConditions: " + getKeyConditions() + ",");
        }
        if (getQueryFilter() != null) {
            sb.append("QueryFilter: " + getQueryFilter() + ",");
        }
        if (getConditionalOperator() != null) {
            sb.append("ConditionalOperator: " + getConditionalOperator() + ",");
        }
        if (getScanIndexForward() != null) {
            sb.append("ScanIndexForward: " + getScanIndexForward() + ",");
        }
        if (getExclusiveStartKey() != null) {
            sb.append("ExclusiveStartKey: " + getExclusiveStartKey() + ",");
        }
        if (getReturnConsumedCapacity() != null) {
            sb.append("ReturnConsumedCapacity: " + getReturnConsumedCapacity() + ",");
        }
        if (getProjectionExpression() != null) {
            sb.append("ProjectionExpression: " + getProjectionExpression() + ",");
        }
        if (getFilterExpression() != null) {
            sb.append("FilterExpression: " + getFilterExpression() + ",");
        }
        if (getKeyConditionExpression() != null) {
            sb.append("KeyConditionExpression: " + getKeyConditionExpression() + ",");
        }
        if (getExpressionAttributeNames() != null) {
            sb.append("ExpressionAttributeNames: " + getExpressionAttributeNames() + ",");
        }
        if (getExpressionAttributeValues() != null) {
            sb.append("ExpressionAttributeValues: " + getExpressionAttributeValues());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int i = 0;
        int hashCode4 = ((((((((((((((((((((((getTableName() == null ? 0 : getTableName().hashCode()) + 31) * 31) + (getIndexName() == null ? 0 : getIndexName().hashCode())) * 31) + (getSelect() == null ? 0 : getSelect().hashCode())) * 31) + (getAttributesToGet() == null ? 0 : getAttributesToGet().hashCode())) * 31) + (getLimit() == null ? 0 : getLimit().hashCode())) * 31) + (getConsistentRead() == null ? 0 : getConsistentRead().hashCode())) * 31) + (getKeyConditions() == null ? 0 : getKeyConditions().hashCode())) * 31) + (getQueryFilter() == null ? 0 : getQueryFilter().hashCode())) * 31) + (getConditionalOperator() == null ? 0 : getConditionalOperator().hashCode())) * 31) + (getScanIndexForward() == null ? 0 : getScanIndexForward().hashCode())) * 31) + (getExclusiveStartKey() == null ? 0 : getExclusiveStartKey().hashCode())) * 31;
        if (getReturnConsumedCapacity() == null) {
            hashCode = 0;
        } else {
            hashCode = getReturnConsumedCapacity().hashCode();
        }
        int hashCode5 = (((((hashCode4 + hashCode) * 31) + (getProjectionExpression() == null ? 0 : getProjectionExpression().hashCode())) * 31) + (getFilterExpression() == null ? 0 : getFilterExpression().hashCode())) * 31;
        if (getKeyConditionExpression() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getKeyConditionExpression().hashCode();
        }
        int i2 = (hashCode5 + hashCode2) * 31;
        if (getExpressionAttributeNames() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getExpressionAttributeNames().hashCode();
        }
        int i3 = (i2 + hashCode3) * 31;
        if (getExpressionAttributeValues() != null) {
            i = getExpressionAttributeValues().hashCode();
        }
        return i3 + i;
    }

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof QueryRequest)) {
            return false;
        }
        QueryRequest other = (QueryRequest) obj;
        if ((other.getTableName() == null) ^ (getTableName() == null)) {
            return false;
        }
        if (other.getTableName() != null && !other.getTableName().equals(getTableName())) {
            return false;
        }
        if (other.getIndexName() == null) {
            z = true;
        } else {
            z = false;
        }
        if (z ^ (getIndexName() == null)) {
            return false;
        }
        if (other.getIndexName() != null && !other.getIndexName().equals(getIndexName())) {
            return false;
        }
        if (other.getSelect() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 ^ (getSelect() == null)) {
            return false;
        }
        if (other.getSelect() != null && !other.getSelect().equals(getSelect())) {
            return false;
        }
        if (other.getAttributesToGet() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3 ^ (getAttributesToGet() == null)) {
            return false;
        }
        if (other.getAttributesToGet() != null && !other.getAttributesToGet().equals(getAttributesToGet())) {
            return false;
        }
        if (other.getLimit() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4 ^ (getLimit() == null)) {
            return false;
        }
        if (other.getLimit() != null && !other.getLimit().equals(getLimit())) {
            return false;
        }
        if (other.getConsistentRead() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5 ^ (getConsistentRead() == null)) {
            return false;
        }
        if (other.getConsistentRead() != null && !other.getConsistentRead().equals(getConsistentRead())) {
            return false;
        }
        if (other.getKeyConditions() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z6 ^ (getKeyConditions() == null)) {
            return false;
        }
        if (other.getKeyConditions() != null && !other.getKeyConditions().equals(getKeyConditions())) {
            return false;
        }
        if (other.getQueryFilter() == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7 ^ (getQueryFilter() == null)) {
            return false;
        }
        if (other.getQueryFilter() != null && !other.getQueryFilter().equals(getQueryFilter())) {
            return false;
        }
        if (other.getConditionalOperator() == null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z8 ^ (getConditionalOperator() == null)) {
            return false;
        }
        if (other.getConditionalOperator() != null && !other.getConditionalOperator().equals(getConditionalOperator())) {
            return false;
        }
        if (other.getScanIndexForward() == null) {
            z9 = true;
        } else {
            z9 = false;
        }
        if (z9 ^ (getScanIndexForward() == null)) {
            return false;
        }
        if (other.getScanIndexForward() != null && !other.getScanIndexForward().equals(getScanIndexForward())) {
            return false;
        }
        if (other.getExclusiveStartKey() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10 ^ (getExclusiveStartKey() == null)) {
            return false;
        }
        if (other.getExclusiveStartKey() != null && !other.getExclusiveStartKey().equals(getExclusiveStartKey())) {
            return false;
        }
        if (other.getReturnConsumedCapacity() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11 ^ (getReturnConsumedCapacity() == null)) {
            return false;
        }
        if (other.getReturnConsumedCapacity() != null && !other.getReturnConsumedCapacity().equals(getReturnConsumedCapacity())) {
            return false;
        }
        if (other.getProjectionExpression() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12 ^ (getProjectionExpression() == null)) {
            return false;
        }
        if (other.getProjectionExpression() != null && !other.getProjectionExpression().equals(getProjectionExpression())) {
            return false;
        }
        if (other.getFilterExpression() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z13 ^ (getFilterExpression() == null)) {
            return false;
        }
        if (other.getFilterExpression() != null && !other.getFilterExpression().equals(getFilterExpression())) {
            return false;
        }
        if (other.getKeyConditionExpression() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (z14 ^ (getKeyConditionExpression() == null)) {
            return false;
        }
        if (other.getKeyConditionExpression() != null && !other.getKeyConditionExpression().equals(getKeyConditionExpression())) {
            return false;
        }
        if (other.getExpressionAttributeNames() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (getExpressionAttributeNames() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z15 ^ z16) {
            return false;
        }
        if (other.getExpressionAttributeNames() != null && !other.getExpressionAttributeNames().equals(getExpressionAttributeNames())) {
            return false;
        }
        if (other.getExpressionAttributeValues() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (getExpressionAttributeValues() == null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z17 ^ z18) {
            return false;
        }
        if (other.getExpressionAttributeValues() == null || other.getExpressionAttributeValues().equals(getExpressionAttributeValues())) {
            return true;
        }
        return false;
    }
}
