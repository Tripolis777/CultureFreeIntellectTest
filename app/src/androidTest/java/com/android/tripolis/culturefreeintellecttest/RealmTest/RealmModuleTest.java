package com.android.tripolis.culturefreeintellecttest.RealmTest;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.android.tripolis.culturefreeintellecttest.R;
import com.android.tripolis.culturefreeintellecttest.Realm.AnswerEntry;
import com.android.tripolis.culturefreeintellecttest.Realm.CFITModule;
import com.android.tripolis.culturefreeintellecttest.Realm.ImageAssetEntry;
import com.android.tripolis.culturefreeintellecttest.Realm.QuestionEntry;
import com.android.tripolis.culturefreeintellecttest.Realm.TestEntry;
import com.facebook.stetho.Stetho;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmQuery;
import io.realm.RealmResults;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by v.karyagin on 20.11.2017.
 */

@RunWith(AndroidJUnit4.class)
public class RealmModuleTest {

    private static final String REALM_DATABASE_NAME = "realTest.realm";

    Context context = InstrumentationRegistry.getTargetContext();;

    @Test
    public void fakeTest() throws Exception {
        assertTrue(true);
    }

//    @Test
//    public void initRealmDefault() throws Exception {
//        Realm.init(context);
//        RealmConfiguration CFITConfig = new RealmConfiguration.Builder()
//                .build();
//        Realm.setDefaultConfiguration(CFITConfig);
//
//        assertNotNull("Realm init done.", Realm.getDefaultInstance());
//    }
//
//    @Test
//    public void useRealmModule() throws Exception {
//        // Context of the app under test.
//        this.initCFITRealm();
//
//        Realm realm = Realm.getDefaultInstance();
//        assertNotNull("Realm init done.", realm);
//
//        RealmConfiguration configuration = realm.getConfiguration();
//        assertEquals("Config ", REALM_DATABASE_NAME, configuration.getRealmFileName());
//    }
//
//    @Test
//    public void testRealmTransaction() {
//        this.initCFITRealm();
//        Realm realm = Realm.getDefaultInstance();
//        this.createData(realm);
//
//        RealmQuery<AnswerEntry> query =realm.where(AnswerEntry.class);
//        query.equalTo("type", 1);
//
//        RealmResults<AnswerEntry> result1 = query.findAll();
//        assertEquals("Realm result query is not empty", result1.isEmpty(), false);
//        assertEquals("Realm result query size", result1.size(), 1);
//
//    }

    private void createData(Realm realm) {
        realm.beginTransaction();
        ImageAssetEntry imageAssetEntry = realm.createObject(ImageAssetEntry.class);
        imageAssetEntry.setResourceName("test.xml");
        realm.commitTransaction();

        QuestionEntry questionEntry = new QuestionEntry();

        realm.beginTransaction();
        AnswerEntry answerEntry = realm.createObject(AnswerEntry.class);
        answerEntry.setImageAssetEntry(imageAssetEntry);
       // answerEntry.setQuestionEntry(questionEntry);
        answerEntry.setType(2);
        answerEntry.setWeight(100);
        realm.commitTransaction();

        realm.beginTransaction();
        AnswerEntry answerEntry2 = realm.createObject(AnswerEntry.class);
        answerEntry2.setType(1);
        answerEntry2.setWeight(200);
        answerEntry2.setImageAssetEntry(imageAssetEntry);
        realm.commitTransaction();

        realm.beginTransaction();
        questionEntry.setImageAssetEntry(imageAssetEntry);
        questionEntry.setAnswerEntry(answerEntry);
        questionEntry.setType(2);
        questionEntry.setTest(new TestEntry());
        questionEntry.setSubtestIdx(1);
        QuestionEntry questionEntry1 = realm.copyToRealm(questionEntry);
        realm.commitTransaction();
    }

    private void initCFITRealm() {
        Realm.init(context);
        RealmConfiguration CFITConfig = new RealmConfiguration.Builder()
                .name(REALM_DATABASE_NAME)
                .modules(new CFITModule())
                .build();
        Realm.setDefaultConfiguration(CFITConfig);

    }
}
