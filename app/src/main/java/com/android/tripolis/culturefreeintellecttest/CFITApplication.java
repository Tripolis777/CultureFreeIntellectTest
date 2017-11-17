package com.android.tripolis.culturefreeintellecttest;

import android.app.Application;
import android.net.Uri;

import com.android.tripolis.culturefreeintellecttest.Realm.CFITModule;
import com.facebook.stetho.Stetho;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by tripo on 11/14/2017.
 */

public class CFITApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration CFITConfig = new RealmConfiguration.Builder()
               // .name("cfit.realm")
                .assetFile(copyBundledRealmFile(this.getResources().openRawResource(R.raw.default0), "default0.realm"))
                .schemaVersion(1)
               // .modules(new CFITModule())
                .build();
        Realm.setDefaultConfiguration(CFITConfig);

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
