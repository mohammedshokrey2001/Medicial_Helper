package com.example.medicalhelper.profiles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.medicalhelper.R;
import com.example.medicalhelper.dataModels.dataModelDoctors;

public class Doctor_Profile extends AppCompatActivity {


    TextView doctor_name;
    TextView city;
    TextView address;
    TextView desc;
    dataModelDoctors mDataModelDoctor ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_profile);

        doctor_name = findViewById(R.id.doctor_name_doctor_profile);
        city = findViewById(R.id.city_doctor_profle224);
        address = findViewById(R.id.doctor_address_doctor_profile);
        desc = findViewById(R.id.describtion_data_doctor_profile);

        Intent intent = getIntent();


        mDataModelDoctor = intent.getParcelableExtra("Data_Doctor");

        doctor_name.setText(mDataModelDoctor.getName());
        city.setText(mDataModelDoctor.getCity());
        address.setText(mDataModelDoctor.getAddress());

        String[] splitted = mDataModelDoctor.getDesc().split(",");


        String string = "";
        for (int i = 0; i < splitted.length; i++) {
            string +=splitted[i];
            string+="\n";
        }
        desc.setText(string);
        Log.i("ddd", "onCreate: "+string);

    }
}