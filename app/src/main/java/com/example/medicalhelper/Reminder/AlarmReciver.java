package com.example.medicalhelper.Reminder;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.medicalhelper.MAIN.ui.home.HomeFragment;
import com.example.medicalhelper.R;

public class AlarmReciver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Intent intent1 = new Intent(context, HomeFragment.class);
        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_CLEAR_TASK);
       PendingIntent pendingIntent = PendingIntent.getActivity(context,0,intent1,0);

        NotificationCompat.Builder builder= new NotificationCompat.Builder(context,"foxandroid")
                .setSmallIcon(R.drawable.care)
                .setContentTitle("Alarm for Medicine")
                .setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setSound(Settings.System.DEFAULT_RINGTONE_URI)
                .setContentIntent(pendingIntent)
                .setPriority(NotificationCompat.PRIORITY_HIGH);
        int random_int = (int)Math.floor(Math.random()*(1000-120+1)+120);


        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
        notificationManagerCompat.notify(random_int,builder.build());


    }
}
