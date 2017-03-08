package com.cryptonym0.watchaddsforfree;

import android.app.DownloadManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import java.util.HashMap;
import java.util.Map;

import static com.google.android.gms.internal.zzs.TAG;

/**
 * Created by t00055219 on 3/7/2017.
 */

public class MyFirebaseIDService extends FirebaseInstanceIdService {
    //Creat instance
    //Variables


    @Override
    public void onTokenRefresh() {
        //Send to server - Firebase
        String r_token = FirebaseInstanceId.getInstance().getToken();
        sendRegistrationToServer(r_token);

        Log.d("TOKEN:", r_token );

        //put in schared prefs
//        SharedPreferences share = getApplicationContext().getSharedPreferences(getString(R.string.FCM_PREF), Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = share.edit();
//        editor.putString(getString(R.string.FCM_TOKEN), r_token);
//        editor.commit();

    }

    //Send registration to MY APP server
    private void sendRegistrationToServer(String r_token) {

    }
}