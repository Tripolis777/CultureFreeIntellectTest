package com.android.tripolis.culturefreeintellecttest.Database.Query;

import com.android.tripolis.culturefreeintellecttest.Database.Query.Condition.WhereCondition;

/**
 * Created by v.karyagin on 10.11.2017.
 */

public interface WithWhereCondition<T> {

    void setWhereCondition (WhereCondition<T> whereCondition);
    String getWhereSQL ();

}
