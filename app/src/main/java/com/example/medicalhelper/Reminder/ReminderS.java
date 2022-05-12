package com.example.medicalhelper.Reminder;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.icu.number.IntegerWidth;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.medicalhelper.R;
import com.example.medicalhelper.databinding.ActivityMainBinding;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

import java.util.Calendar;

public class ReminderS extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MaterialTimePicker picker;
    private Calendar calendar;
    private AlarmManager alarmManager;
    private PendingIntent pendingIntent;

    static  int flag  ;
    Button selectTimeBtn;
    Button setAlarmBtn;
    Button cancelAlarmBtn;
    TextView selectedTime;
    EditText hours ;
    EditText minute ;



    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setContentView(R.layout.activity_reminder);
        flag =0;
        selectTimeBtn = findViewById(R.id.selectTimeBtn);
        setAlarmBtn = findViewById(R.id.setAlarmBtn);
        cancelAlarmBtn = findViewById(R.id.cancelAlarmBtn);
        selectedTime = findViewById(R.id.selectedTime);
        hours = findViewById(R.id.editTextHoursRepationRemindre);
        minute = findViewById(R.id.editTextminRepationRemindre);




        createNotificationChannel();



        selectTimeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showTimePicker();

            }
        });

        setAlarmBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.Q)
            @Override
            public void onClick(View v) {

                setAlarm(calcTimeForReptaion());
            }
        });

        cancelAlarmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cancelAlarm();

            }
        });

    }

    private void cancelAlarm() {

        Intent intent = new Intent(this, AlarmReciver.class);

        pendingIntent = PendingIntent.getBroadcast(this,0,intent,0);

        if (alarmManager == null){

            alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        }

        alarmManager.cancel(pendingIntent);
        Toast.makeText(this, "Alarm Cancelled", Toast.LENGTH_SHORT).show();
    }

    private void setAlarm(long RepatinTime) {

        alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(this,AlarmReciver.class);

        pendingIntent = PendingIntent.getBroadcast(this,0,intent,0);

        alarmManager.setRepeating(AlarmManager.RTC,calendar.getTimeInMillis(),
                RepatinTime,pendingIntent);

        Toast.makeText(this, "Alarm set Successfully", Toast.LENGTH_SHORT).show();



    }

    private void showTimePicker() {

        picker = new MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_12H)
                .setHour(12)
                .setMinute(0)
                .setTitleText("Select Alarm Time")
                .build();

        picker.show(getSupportFragmentManager(),"foxandroid");

        picker.addOnPositiveButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (picker.getHour() > 12){

                    selectedTime.setText(
                            String.format("%02d",(picker.getHour()-12))+" : "+String.format("%02d",picker.getMinute())+" PM"
                    );

                }else {

                    selectedTime.setText(picker.getHour()+" : " + picker.getMinute() + " AM");

                }

                calendar = Calendar.getInstance();
                calendar.set(Calendar.HOUR_OF_DAY,picker.getHour());
                calendar.set(Calendar.MINUTE,picker.getMinute());
                calendar.set(Calendar.SECOND,0);
                calendar.set(Calendar.MILLISECOND,0);

            }
        });


    }

    private void createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "foxandroidReminderChannel";
            String description = "Channel For Alarm Manager";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel("foxandroid",name,importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);

        }



    }


    long calcTimeForReptaion(){
         int time_min = ((Integer.parseInt( hours.getText().toString())*60) + Integer.parseInt( minute.getText().toString()));
         long TimeForReptaion = time_min * 60000;
              return  TimeForReptaion;
    }
}