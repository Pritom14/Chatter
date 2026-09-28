package com.codingblocks.chatter;

import android.app.Application;
import timber.log.Timber;

public class ChatterApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }
}
