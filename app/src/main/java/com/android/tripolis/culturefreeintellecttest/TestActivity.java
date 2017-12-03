package com.android.tripolis.culturefreeintellecttest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.FrameLayout;

import com.android.tripolis.culturefreeintellecttest.Core.Description;
import com.android.tripolis.culturefreeintellecttest.Core.SubtestManager;
import com.android.tripolis.culturefreeintellecttest.Core.Test;
import com.android.tripolis.culturefreeintellecttest.Fragment.CFITFragment;
import com.android.tripolis.culturefreeintellecttest.Fragment.SubtestInfoFragment;
import com.android.tripolis.culturefreeintellecttest.Realm.DescriptionEntry;
import com.android.tripolis.culturefreeintellecttest.Realm.TestEntry;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class TestActivity extends AppCompatActivity {

    public static final String EXTRA_TEST_NAME = "extra_test_name";

    private FrameLayout fragmentPlaceholder;
    private FragmentManager fragmentManager;

    private Test test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        String testName = intent.getStringExtra(EXTRA_TEST_NAME);

        final Realm realm = Realm.getDefaultInstance();
        TestEntry testEntry = realm.where(TestEntry.class)
                .equalTo("name", testName)
                .findFirst();

        test = new Test(this, testEntry);

        fragmentPlaceholder = (FrameLayout) findViewById(R.id.testFragmentPlaceholder);
        fragmentManager = getSupportFragmentManager();

        CFITFragment startFragment = test.getStartFragment();
        fragmentManager.beginTransaction()
                .add(R.id.testFragmentPlaceholder, startFragment, startFragment.getFragmentTag())
                .commit();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.action_bar, menu);
//        return true;
//    }
}
