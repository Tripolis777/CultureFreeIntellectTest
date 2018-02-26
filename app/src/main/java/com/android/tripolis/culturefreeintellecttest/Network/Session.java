package com.android.tripolis.culturefreeintellecttest.Network;

import android.content.Context;

import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;

import okhttp3.CookieJar;
import okhttp3.OkHttpClient;


/**
 * Created by v.karyagin on 2/18/18.
 */

public final class Session {
    private static Session instance;

    private final OkHttpClient httpClient;
    private boolean auth;

    public static Session getInstance(Context context) {
        if(instance == null)
            instance = new Session(context);
        return instance;
    }

    public OkHttpClient getHttpClient() {
        return httpClient;
    }

    public boolean isAuth() {
        return auth;
    }

    public void setAuth (boolean auth) {
        this.auth = auth;
    }

    private Session(Context context) {
        CookieJar cookieJar = new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(context));

        httpClient = new OkHttpClient.Builder()
                .cookieJar(cookieJar)
                .build();

        auth = false;
    }
}
