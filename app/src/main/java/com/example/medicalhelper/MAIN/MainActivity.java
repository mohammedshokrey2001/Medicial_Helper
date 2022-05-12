package com.example.medicalhelper.MAIN;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.medicalhelper.R;

public class MainActivity extends AppCompatActivity {

     Button startBT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
           startBT = findViewById(R.id.main_activity_start_bt);

           startBT.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   Intent intent = new Intent(MainActivity.this, NavigationS.class);
                   startActivity(intent);
               }
           });




    }
}