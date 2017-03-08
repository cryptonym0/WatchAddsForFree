package com.cryptonym0.watchaddsforfree;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.SignInButton;
import com.google.firebase.messaging.FirebaseMessaging;

import static android.R.attr.onClick;


public class MainActivity extends AppCompatActivity {
    //variables
    Button subBtn;
    MyFirebaseIDService tokenHelper = new MyFirebaseIDService();

    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        subBtn = (Button)findViewById(R.id.subBTN);

        subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseMessaging.getInstance().subscribeToTopic("news");
            }
        });

        MobileAds.initialize(getApplicationContext(), "ca-app-pub-7931829766866330~4200774409");

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        //Get device token
//        tokenHelper.onTokenRefresh();



        //Add topic
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkPlayServices();
    }
    @Override
    protected void onPause() {
        super.onPause();
    }

    private boolean checkPlayServices() {
        GoogleApiAvailability apiAvailability = GoogleApiAvailability.getInstance();
        int resultCode = apiAvailability.isGooglePlayServicesAvailable(this);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (apiAvailability.isUserResolvableError(resultCode)) {
                apiAvailability.getErrorDialog(this, resultCode, PLAY_SERVICES_RESOLUTION_REQUEST).show();
            } else {
                Log.i("GOOGLE PLAY", "This device is not supported.");
                finish();
            }
            return false;
        }
        return true;
    }



}
