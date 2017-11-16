package com.android.tripolis.culturefreeintellecttest;

import android.app.Application;

import com.android.tripolis.culturefreeintellecttest.Realm.CFITModule;
import com.facebook.stetho.Stetho;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;

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
                .name("cfit.realm")
                //.assetFile("cfit.realm")
                .schemaVersion(1)
                .modules(new CFITModule())
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
}
