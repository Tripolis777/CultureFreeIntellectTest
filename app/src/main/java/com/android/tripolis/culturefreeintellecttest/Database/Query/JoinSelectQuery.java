package com.android.tripolis.culturefreeintellecttest.Database.Query;

import com.android.tripolis.culturefreeintellecttest.Database.Query.Condition.WhereCondition;

/**
 * Created by tripo on 11/13/2017.
 */

public class JoinSelectQuery extends SelectQuery<String> {

    private WhereCondition<String> whereCondition;
    private String joinTableName;

    public JoinSelectQuery(String tableName) {
        super(tableName);
        joinTableName = tableName;
    }

    @Override
    public String getTableName() {
        return joinTableName;
    }

    @Override
    public void setWhereCondition(WhereCondition<String> whereCondition) {
        this.whereCondition = whereCondition;
    }

    @Override
    public String getWhereSQL() {
        return whereCondition.getWhereSQL();
    }

    public void joinTable(String sqlString) {
        joinTableName += " " + sqlString;
    }

    public void joinTable(String tableName, String joinTableKey, String joinSelfKey) {
        joinTableName = String.format("%s INNER JOIN %s ON %s.%s = %s.%s",
                joinTableName, tableName, tableName, joinTableKey, this.tableName, joinSelfKey);
    }
}
