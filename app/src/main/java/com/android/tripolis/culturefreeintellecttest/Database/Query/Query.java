package com.android.tripolis.culturefreeintellecttest.Database.Query;

/**
 * Created by v.karyagin on 10.11.2017.
 */

public abstract class Query {

    protected final String tableName;

    public Query(String tableName) {
        this.tableName = tableName;
    }


    public String getTableName() {
        return tableName;
    }

}
