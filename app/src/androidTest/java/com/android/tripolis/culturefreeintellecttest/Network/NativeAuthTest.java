package com.android.tripolis.culturefreeintellecttest.Network;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.android.tripolis.culturefreeintellecttest.Network.Social.NativeAuth;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by v.karyagin on 2/25/18.
 */

@RunWith(AndroidJUnit4.class)
public class NativeAuthTest {

    private static NativeAuth.LoginData loginData = new NativeAuth.LoginData();

    private final Moshi moshi = new Moshi.Builder().build();
    private final JsonAdapter<SessionTestResponse> responseJsonAdapter = moshi.adapter(SessionTestResponse.class);

    private Context appContext;

    public static class SessionTestResponse {
        public static final String STATUS_ERROR = "error";

        public String status;

        public boolean isSuccess() {
            return !status.equals(STATUS_ERROR);
        }
    }

    @Before
    public void setLoginData() {
        loginData.login = Constants.AUTH_TEST_USERNAME;
        loginData.password = Constants.AUTH_TETS_PASSWORD;

        appContext = InstrumentationRegistry.getTargetContext();
    }

    @Test
    public void session_fail() throws Exception {
//        PowerMockito.mockStatic(Log.class);
        assertFalse(false);
    }

    @Test
    public void auth_success() throws Exception {
        // PowerMockito.mockStatic(Log.class);
        NativeAuth auth = new NativeAuth(appContext, loginData);
        assertTrue(auth.signIn());
    }

    @Test
    public void session_success() throws Exception {
        assertTrue(sessionIsAuth());
    }

    @Test
    public void logout_success() throws Exception {
        //PowerMockito.mockStatic(Log.class);
        NativeAuth auth = new NativeAuth(appContext, loginData);
        auth.signOut();
    }

    @Test
    public void login_failed() throws Exception {
        //PowerMockito.mockStatic(Log.class);
        NativeAuth.LoginData failData = new NativeAuth.LoginData();
        failData.login = "failtest";
        failData.password = "sasasa";
        NativeAuth auth = new NativeAuth(appContext, failData);
        assertFalse(auth.signIn());
    }

    private boolean sessionIsAuth(){
        Session session = Session.getInstance(appContext);
        OkHttpClient okHttpClient = session.getHttpClient();
        Request request = new Request.Builder()
                .url(Constants.SESSION_TEST_URL)
                .build();

        SessionTestResponse sessionTestResponse;
        try {
            Response response = okHttpClient.newCall(request).execute();
            sessionTestResponse = responseJsonAdapter.fromJson(response.body().source());
            System.out.println("Response status:" + sessionTestResponse.status);
        } catch (IOException e) {
            System.out.println("Something went wrong. Error=" + e.getMessage());
            return false;
        }

        return sessionTestResponse.isSuccess();
    }

}
