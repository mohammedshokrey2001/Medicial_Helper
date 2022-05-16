package com.example.medicalhelper.helper;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public final   class internetC {
    public   static boolean checkInternetConnection(Context context){
        boolean connected = false;
        context.getApplicationContext();
        ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            connected = true;
        }
        else
            connected = false;

        return connected;

    }

}
