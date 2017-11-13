package com.android.tripolis.culturefreeintellecttest.Database.Entries;

/**
 * Created by tripo on 11/5/2017.
 */

public abstract class DatabaseEntry {
    protected long id;

    public long getEntryId() {
       return id;
    }

    void setEntryId(long id) {
        this.id = id;
    }
}
