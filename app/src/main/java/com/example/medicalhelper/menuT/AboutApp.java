package com.example.medicalhelper.menuT;

import android.net.Uri;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.medicalhelper.R;
import com.example.medicalhelper.helper.Menu;

public class AboutApp extends AppCompatActivity {



    VideoView medcineTable;
    VideoView tips;
    VideoView appoinment;
    VideoView Reminder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_app);

        medcineTable = findViewById(R.id.videoView_addMedcine);
        tips = findViewById(R.id.videoView_seeMedicalTips);
        appoinment = findViewById(R.id.videoView_addappoinment);
        Reminder = findViewById(R.id.videoView_addReminder);



        String path_video = "android.resource://" +getPackageName() +"/" +R.raw.medtable;
        Uri uri = Uri.parse(path_video);
        medcineTable.setVideoURI(uri);
        medcineTable.setMediaController(new MediaController(this));

        String path_video2 = "android.resource://" +getPackageName() +"/" +R.raw.appointment;
        Uri uri2 = Uri.parse(path_video2);
        appoinment.setVideoURI(uri2);
        appoinment.setMediaController(new MediaController(this));


        String path_video3 = "android.resource://" +getPackageName() +"/" +R.raw.reminder;
        Uri uri3 = Uri.parse(path_video3);
        Reminder.setVideoURI(uri3);
        Reminder.setMediaController(new MediaController(this));



    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.navigation, menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Menu.menuSelection(item,getApplicationContext());
        return super.onOptionsItemSelected(item);

    }
}