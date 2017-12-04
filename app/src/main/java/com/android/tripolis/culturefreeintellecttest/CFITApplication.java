package com.android.tripolis.culturefreeintellecttest;

import android.app.Application;
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

        initTestDatabase(Realm.getInstance(CFITConfig));

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


        // Create test
        realm.beginTransaction();
        TestEntry testEntry = realm.createObject(TestEntry.class);
        testEntry.setName("Testing_Test");
        testEntry.setTestDescription(descriptionEntry);
        realm.commitTransaction();

        realm.beginTransaction();
        AnswerEntry answerEntry = realm.createObject(AnswerEntry.class);
        answerEntry.setImageAssetEntry(imageAssetEntry);
        answerEntry.setWeight(100);
        answerEntry.setType(1);
        realm.commitTransaction();

        realm.beginTransaction();
        QuestionEntry questionEntry = realm.createObject(QuestionEntry.class);
        questionEntry.setType(1);
        questionEntry.setTest(testEntry);
        questionEntry.setSubtestIdx(1);
        questionEntry.setAnswerEntry(answerEntry);
        questionEntry.setImageAssetEntry(imageAssetEntry);
        realm.commitTransaction();

        realm.beginTransaction();
        SubtestEntry subtestEntry = realm.createObject(SubtestEntry.class);
        subtestEntry.setIndex(1);
        subtestEntry.setQuestionsList(new RealmList<QuestionEntry>(questionEntry));
        subtestEntry.setSubtestDesctiprion(descriptionEntry);
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
