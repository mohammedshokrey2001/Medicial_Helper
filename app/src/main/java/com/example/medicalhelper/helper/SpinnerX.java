package com.example.medicalhelper.helper;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.medicalhelper.MAIN.ui.gallery.GalleryFragment;

import java.util.ArrayList;

public final class SpinnerX {

      public static void setSpinnerData(Spinner snipper , ArrayList<String> data , Context context){
        ArrayAdapter<String> adapterCourses =
                new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, data);
        adapterCourses.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        snipper.setAdapter(adapterCourses);
    }


}
