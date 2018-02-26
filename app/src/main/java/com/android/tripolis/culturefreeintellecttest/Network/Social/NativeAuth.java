package com.android.tripolis.culturefreeintellecttest.Network.Social;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.android.tripolis.culturefreeintellecttest.Network.Constants;
import com.android.tripolis.culturefreeintellecttest.Network.Session;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.Moshi;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by v.karyagin on 2/17/18.
 */

public final class NativeAuth implements Auth {
    private static final String LOG_TAG = "[NativeAuth]";

    private static final String FIELD_LOGIN = "email";
    private static final String FIELD_PASSWORD = "password";
    private static final String FIELD_REMEMBER = "remember-me";
    private static final String FIELD_TASK = "task";

    private static final String TASK_LOGIN = "login";
    private static final String TASK_LOGOUT = "logout";

    private static final String URL = Constants.NATIVE_AUTH_URL;

    private final Moshi moshi = new Moshi.Builder().build();
    private final JsonAdapter<NativeAuthResponse> responseJsonAdapter = moshi.adapter(NativeAuthResponse.class);

    public static class LoginData {
        public String login = null;
        public String password = null;

        public boolean remember = false;
    }

    public static class NativeAuthResponse {
        public String status;
        public String message;
        public String code;
        public String data;

        public static final String STATUS_ERROR = "err";
        public static final String CODE_PASS = "password";

        public boolean isSuccess() {
            return !this.status.equals(NativeAuthResponse.STATUS_ERROR);
        }
    }

    private final LoginData loginData;
    private final Context context;


    public NativeAuth(Context context, @NonNull LoginData loginData) {
        this.loginData = loginData;
        this.context = context;
    }

    @Override
    public boolean signIn() {
        RequestBody requestBody = new FormBody.Builder()
                .add(FIELD_LOGIN, loginData.login)
                .add(FIELD_PASSWORD, loginData.password)
                .add(FIELD_REMEMBER, loginData.remember ? "1" : "0")
                .add(FIELD_TASK, TASK_LOGIN)
                .build();
        Response response;

        try {
            response = doPostRequest(requestBody);

        } catch (IOException e) {
            Log.e(LOG_TAG, "signIn(): " + e.getMessage());
            return false;
        }

        Session session = Session.getInstance(context);
        session.setAuth(isSuccess(response));
        return session.isAuth();
    }

    @Override
    public void signOut() {
        RequestBody requestBody = new FormBody.Builder()
                .add(FIELD_TASK, TASK_LOGOUT)
                .build();

        try {
            doPostRequest(requestBody);
        } catch (IOException e) {
            Log.e(LOG_TAG, "signOut(): " + e.getMessage());
        }
    }

    private boolean isSuccess(Response response) {
        if (!response.isSuccessful())
            return false;

        NativeAuthResponse responseData;
        try {
            responseData = responseJsonAdapter.fromJson(response.body().source());
        } catch (IOException e) {
            Log.e("NativeAuth", "isSuccess(). Error=" + e.getMessage());
            // TODO: Its very strange behavior
            return false;
        } catch (JsonDataException e) {
            Log.e("NativeAuth", "isSuccess(). Error=" + e.getMessage());
            return true;
        }

        return responseData.isSuccess();
    }

    private Response doPostRequest(RequestBody requestBody) throws IOException {
        OkHttpClient httpClient = Session.getInstance(context).getHttpClient();
        Request request = new Request.Builder()
                .url(URL)
                .post(requestBody)
                .build();

        return httpClient.newCall(request).execute();
    }

}
