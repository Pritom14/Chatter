package com.codingblocks.chatter;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import timber.log.Timber;

public class AuthenticatorService extends Service {

    private Authenticator mAuthenticator;

    @Override
    public void onCreate() {
        Timber.d("AuthenticatorService onCreate");
        // Create a new authenticator object
        mAuthenticator = new Authenticator(this);
        Timber.d("Authenticator instance created");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Timber.d("AuthenticatorService onBind called");
        return mAuthenticator.getIBinder();
    }
}


