package com.android.tripolis.culturefreeintellecttest;

import android.app.Application;
import android.content.SharedPreferences;
import android.util.Log;

import com.android.tripolis.culturefreeintellecttest.Core.Question;
import com.android.tripolis.culturefreeintellecttest.Realm.AnswerEntry;
import com.android.tripolis.culturefreeintellecttest.Realm.CFITModule;
import com.android.tripolis.culturefreeintellecttest.Realm.Description.ExampleEntry;
import com.android.tripolis.culturefreeintellecttest.Realm.Description.ExampleEntryImage;
import com.android.tripolis.culturefreeintellecttest.Realm.DescriptionEntry;
import com.android.tripolis.culturefreeintellecttest.Realm.ImageAssetEntry;
import com.android.tripolis.culturefreeintellecttest.Realm.QuestionEntry;
import com.android.tripolis.culturefreeintellecttest.Realm.SubtestEntry;
import com.android.tripolis.culturefreeintellecttest.Realm.TestEntry;
import com.facebook.stetho.Stetho;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmList;

/**
 * Created by tripo on 11/14/2017.
 */

public class CFITApplication extends Application {

    private static final String PREFERENSE_NAME = "application_prefs";

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration CFITConfig = new RealmConfiguration.Builder()
                .name("cfit.realm")
                //.assetFile(copyBundledRealmFile(this.getResources().openRawResource(R.raw.cfit), "cfit.realm"))
                .schemaVersion(1)
                .modules(new CFITModule())
                .build();
        Realm.setDefaultConfiguration(CFITConfig);

        SharedPreferences settings = getSharedPreferences(PREFERENSE_NAME, 0);
        boolean firstStartup = settings.getBoolean("first_startup", true);

        if (firstStartup) {
            initTestDatabase(Realm.getInstance(CFITConfig));

            SharedPreferences.Editor editor = settings.edit();
            editor.putBoolean("first_startup", false);
            editor.commit();
        }

        Stetho.initialize(
            Stetho.newInitializerBuilder(this)
                    .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                    //.enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                    .enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build())
                    //.enableWebKitInspector(RealmInspectorModulesProvider.builder(this)
                            //.databaseNamePattern(Pattern.compile(".+\\.realm"))
                            //.build())
                    .build());
    }

    private void initTestDatabase(Realm realm) {
        // Create Image Asset
        realm.beginTransaction();
        ImageAssetEntry imageAssetEntry = realm.createObject(ImageAssetEntry.class);
        imageAssetEntry.setResourceName("image_description1");
        realm.commitTransaction();

        // Create Answer Atlas Asset
        realm.beginTransaction();
        ImageAssetEntry answerAtlasEntry = realm.createObject(ImageAssetEntry.class);
        answerAtlasEntry.setResourceName("answers_atlas_1");
        answerAtlasEntry.setColumnsCnt(8);
        answerAtlasEntry.setRowsCnt(8);
        realm.commitTransaction();

        // Create Question Atlas Asset
        realm.beginTransaction();
        ImageAssetEntry questionAtlasEntry = realm.createObject(ImageAssetEntry.class);
        questionAtlasEntry.setResourceName("questions_atlas_1");
        questionAtlasEntry.setColumnsCnt(6);
        questionAtlasEntry.setRowsCnt(6);
        realm.commitTransaction();

        String descriptionData = "";
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put(DescriptionEntry.DescriptionEntryData.FIELD_TEST_NAME_KEY, "description1_test_name");
            jsonObject.put(DescriptionEntry.DescriptionEntryData.FIELD_TEST_INFO_KEY, "description1_test_info");
            jsonObject.put(DescriptionEntry.DescriptionEntryData.FIELD_EXAMPLES_COUNT_KEY, 2);

            JSONObject example1 = new JSONObject();
            example1.put(ExampleEntry.EXAMPLE_TITLE_KEY, "example1_title");
            example1.put(ExampleEntry.EXAMPLE_TYPE_KEY, 2);
            example1.put(ExampleEntryImage.EXAMPLE_IMAGE_KEY, "image_description1");
            example1.put(ExampleEntryImage.EXAMPLE_IMAGE_NAME_KEY, "example1_image_name");
            example1.put(ExampleEntryImage.EXAMPLE_IMAGE_INFO_KEY, "example1_image_info");

            JSONObject example2 = new JSONObject();
            example2.put(ExampleEntry.EXAMPLE_TITLE_KEY, "example2_title");
            example2.put(ExampleEntry.EXAMPLE_TYPE_KEY, 2);
            example2.put(ExampleEntryImage.EXAMPLE_IMAGE_KEY, "image_description1");
            example2.put(ExampleEntryImage.EXAMPLE_IMAGE_NAME_KEY, "example2_image_name");
            example2.put(ExampleEntryImage.EXAMPLE_IMAGE_INFO_KEY, "example2_image_info");

            JSONArray array = new JSONArray();
            array.put(example1).put(example2);
            jsonObject.put(DescriptionEntry.DescriptionEntryData.FIELD_EXAMPLES_KEY, array);

            descriptionData = jsonObject.toString();
        } catch (JSONException e) {
            Log.e("[TEST REALM]", "Init description data fail.");
        }

        // Create Description
        realm.beginTransaction();
        DescriptionEntry descriptionEntry = realm.createObject(DescriptionEntry.class);
        //descriptionEntry.setTest(testEntry);
        descriptionEntry.setSubtestIdx(1);
        descriptionEntry.setDescriptionData(descriptionData);
        realm.commitTransaction();


        descriptionData = "";
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put(DescriptionEntry.DescriptionEntryData.FIELD_TEST_NAME_KEY, "description1_subtest_name");
            jsonObject.put(DescriptionEntry.DescriptionEntryData.FIELD_TEST_INFO_KEY, "description1_subtest_info");
            jsonObject.put(DescriptionEntry.DescriptionEntryData.FIELD_EXAMPLES_COUNT_KEY, 2);

            JSONObject example1 = new JSONObject();
            example1.put(ExampleEntry.EXAMPLE_TITLE_KEY, "subtest_example1_title");
            example1.put(ExampleEntry.EXAMPLE_TYPE_KEY, 2);
            example1.put(ExampleEntryImage.EXAMPLE_IMAGE_KEY, "image_description2");
            example1.put(ExampleEntryImage.EXAMPLE_IMAGE_NAME_KEY, "subtest_example1_image_name");
            example1.put(ExampleEntryImage.EXAMPLE_IMAGE_INFO_KEY, "subtest_example1_image_info");

            JSONObject example2 = new JSONObject();
            example2.put(ExampleEntry.EXAMPLE_TITLE_KEY, "subtest_example2_title");
            example2.put(ExampleEntry.EXAMPLE_TYPE_KEY, 2);
            example2.put(ExampleEntryImage.EXAMPLE_IMAGE_KEY, "image_description2");
            example2.put(ExampleEntryImage.EXAMPLE_IMAGE_NAME_KEY, "subtest_example2_image_name");
            example2.put(ExampleEntryImage.EXAMPLE_IMAGE_INFO_KEY, "subtest_example2_image_info");

            JSONArray array = new JSONArray();
            array.put(example1).put(example2);
            jsonObject.put(DescriptionEntry.DescriptionEntryData.FIELD_EXAMPLES_KEY, array);

            descriptionData = jsonObject.toString();
        } catch (JSONException e) {
            Log.e("[TEST REALM]", "Init description data fail.");
        }


        realm.beginTransaction();
        DescriptionEntry descriptionEntry2 = realm.createObject(DescriptionEntry.class);
        //descriptionEntry.setTest(testEntry);
        descriptionEntry2.setSubtestIdx(1);
        descriptionEntry2.setDescriptionData(descriptionData);
        realm.commitTransaction();

        // Create test
        realm.beginTransaction();
        TestEntry testEntry = realm.createObject(TestEntry.class);
        testEntry.setName("Testing_Test");
        testEntry.setTestDescription(descriptionEntry);
        realm.commitTransaction();


        // Create Answer
        realm.beginTransaction();
        AnswerEntry answerEntry = realm.createObject(AnswerEntry.class);
        answerEntry.setImageAssetEntry(answerAtlasEntry);
        answerEntry.setWeight(100);
        answerEntry.setType(1);
        realm.commitTransaction();


        // Create Question 1
        realm.beginTransaction();
        QuestionEntry questionEntry = realm.createObject(QuestionEntry.class);
        questionEntry.setType(1);
        questionEntry.setNum(1);
        questionEntry.setTest(testEntry);
        questionEntry.setSubtestIdx(1);
        questionEntry.setAnswerEntry(answerEntry);
        questionEntry.setImageAssetEntry(questionAtlasEntry);
        realm.commitTransaction();

        //Create Question 2
        realm.beginTransaction();
        QuestionEntry questionEntry2 = realm.createObject(QuestionEntry.class);
        questionEntry2.setType(1);
        questionEntry2.setNum(2);
        questionEntry2.setTest(testEntry);
        questionEntry2.setSubtestIdx(1);
        questionEntry2.setAnswerEntry(answerEntry);
        questionEntry2.setImageAssetEntry(questionAtlasEntry);
        realm.commitTransaction();

        // Create Subtest
        realm.beginTransaction();
        SubtestEntry subtestEntry = realm.createObject(SubtestEntry.class);
        subtestEntry.setIndex(1);
        subtestEntry.setQuestionsList(new RealmList<QuestionEntry>(questionEntry, questionEntry2));
        subtestEntry.setSubtestDesctiprion(descriptionEntry2);
        realm.commitTransaction();

        realm.beginTransaction();
        testEntry.setSubtestList(new RealmList<SubtestEntry>(subtestEntry));
        realm.commitTransaction();
    }

    private String copyBundledRealmFile(InputStream inputStream, String outFileName) {
        try {
            File file = new File(this.getFilesDir(), outFileName);
            FileOutputStream outputStream = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buf)) > 0) {
                outputStream.write(buf, 0, bytesRead);
            }
            outputStream.close();
            return file.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
