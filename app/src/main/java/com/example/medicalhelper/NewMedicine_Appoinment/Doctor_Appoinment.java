package com.example.medicalhelper.NewMedicine_Appoinment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.medicalhelper.R;
import com.example.medicalhelper.dataManger.ManagerSnnpier;
import com.example.medicalhelper.helper.SpinnerX;

public class Doctor_Appoinment extends AppCompatActivity {
    Spinner mSnipperHour;
    Spinner mSnipperMin;
    EditText doctorName;
    EditText notes;
    Button add_Apponitment ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_appoinment);
        mSnipperMin = findViewById(R.id.spinner_time_for_medcine);
        mSnipperHour =findViewById(R.id.spinner_to);
        doctorName = findViewById(R.id.doctor_name_edit_text);
        notes = findViewById(R.id.notes_appionitment_s_edit_text);
        add_Apponitment = findViewById(R.id.add_new_appointment);
        SpinnerX.setSpinnerData(mSnipperMin, ManagerSnnpier.getHourtList(),getApplicationContext());
        SpinnerX.setSpinnerData(mSnipperHour, ManagerSnnpier.getMintList(),getApplicationContext());

        add_Apponitment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add_Apponitment();
            }
        });



    }






    private void add_Apponitment() {
        String message = "you have appointment with doctor "+
                doctorName + " at "+ mSnipperHour.getSelectedItem().toString()
                + " : "+ mSnipperMin.getSelectedItem().toString() + "\n notes:  "+notes;




        OutDataToAlarm.outData(
                Integer.parseInt(mSnipperHour.getSelectedItem().toString()),
                Integer.parseInt(mSnipperMin.getSelectedItem().toString()),
                message ,
                getApplicationContext()
        );

    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        com.example.medicalhelper.helper.Menu.menuSelection(item,getApplicationContext());
        return super.onOptionsItemSelected(item);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }




}