package com.android.tripolis.culturefreeintellecttest.Database.Query;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by v.karyagin on 10.11.2017.
 */

public abstract class SelectQuery<T> extends Query implements WithWhereCondition<T> {

    protected static final String SELECT_ALL = "*";

    protected ArrayList<String> columns;
    protected String groupBy;
    protected String orderBy;
    protected String limit;
    protected String having;
    protected boolean distinct;

    public SelectQuery(String tableName) {
        super(tableName);
        columns = new ArrayList<>();
        distinct = false;
    }

    public void setGroupBy(String groupBy) {
        this.groupBy = groupBy;
    }

    public String getGroupBy() {
        return groupBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getLimit() {
        return limit;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean getDistinct() {
        return distinct;
    }

    public void setHaving(String having) {
        this.having = having;
    }

    public String getHaving() {
        return having;
    }

    public void addColumns(String[] columns) {
        this.columns.addAll(Arrays.asList(columns));
    }

    public void addColumn(String column) {
        this.columns.add(column);
    }

    public String[] getColumns() {
        return columns.toArray(new String[columns.size()]);
    }

}
