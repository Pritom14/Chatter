package com.codingblocks.chatter;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import timber.log.Timber;


public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme_Splash);
        super.onCreate(savedInstanceState);

        Timber.d("SplashActivity onCreate");

        SharedPreferences sharedPreferences =
                this.getApplicationContext().getSharedPreferences("UserPreferences", 0);
        String accessToken = sharedPreferences.getString("accessToken", "");

        Intent intent;
        // Check if the token exists and redirect the user to authentication activity if
        // he there is internet connection (else he would be send to NoNetworkActivity)
        // or redirect him to the dashboard activity accordingly.
        if (accessToken.equals("")) {
            Timber.d("No access token found");
            if (isNetworkAvailable()) {
                Timber.d("Network available, starting AuthenticationActivity");
                intent = new Intent(this, AuthenticationActivity.class);
            } else {
                Timber.d("No network available, starting NoNetworkActivity");
                intent = new Intent(this, NoNetworkActivity.class);
                intent.putExtra("calledFrom", "SplashActivity");
            }
        } else {
            Timber.d("Access token found, starting DashboardActivity");
            intent = new Intent(this, DashboardActivity.class);
        }
        this.startActivity(intent);
        finish();
    }

    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        boolean isAvailable = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        Timber.d("Network available: %b", isAvailable);
        return isAvailable;
    }
}
