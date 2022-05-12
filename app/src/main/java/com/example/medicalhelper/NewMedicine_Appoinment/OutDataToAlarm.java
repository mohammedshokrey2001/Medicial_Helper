package com.example.medicalhelper.NewMedicine_Appoinment;

import android.content.Context;
import android.content.Intent;
import android.provider.AlarmClock;

public final class OutDataToAlarm {


     public static void outData(int hours, int minute, String message, Context context){


        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
        intent.putExtra(AlarmClock.EXTRA_HOUR,hours);
        intent.putExtra(AlarmClock.EXTRA_MINUTES ,minute);
        intent.putExtra(AlarmClock.EXTRA_SKIP_UI,true);
        intent.putExtra(AlarmClock.EXTRA_MESSAGE ,"please open the medicine app right now" );
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

         context.startActivity(intent);
    }
}

