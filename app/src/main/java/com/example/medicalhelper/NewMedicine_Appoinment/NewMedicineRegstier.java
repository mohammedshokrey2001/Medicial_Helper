package com.example.medicalhelper.NewMedicine_Appoinment;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.medicalhelper.helper.DBHelper;
import com.example.medicalhelper.R;
import com.example.medicalhelper.dataManger.manager1;
import com.example.medicalhelper.dataModels.DataModelMedicine;
import com.example.medicalhelper.helper.SpinnerX;
import com.example.medicalhelper.helper.WorkImage;

import java.io.File;
import java.util.ArrayList;

public class NewMedicineRegstier extends AppCompatActivity {
        Spinner mSpinner_hours_first;
        EditText name;
        EditText freq;
        ImageButton img;
        EditText notes;
        Button add_new_medicine;
        DBHelper mDBHelper ;
        ImageView imgRegster;

         private static final  int PICK_IMAGE = 1;
         Uri imageVri;
    private Bitmap mBitmap_for_insertion_DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_medicine_regstier);

        mSpinner_hours_first = findViewById(R.id.spinner_time_for_medcine);
        name = findViewById(R.id.doctor_name_edit_text);
        freq = findViewById(R.id.notes_appionitment_s_edit_text);
        notes = findViewById(R.id.editTextTextMultiLine_for_notes_addead);
        img   = findViewById(R.id.imageButton);
        add_new_medicine = findViewById(R.id.add_new_appointment);
         imgRegster = findViewById(R.id.imageView_register);

        add_new_medicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addMedicine();
            }
        });


        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                       mGetContent.launch("image/*");
            }
        });


        ArrayList<String> data = manager1.getHourtList();
        data.add(0,"timing of first dose");
        SpinnerX.setSpinnerData(mSpinner_hours_first, data,this);


        //db
        mDBHelper = new DBHelper(this);
    }

    private void addMedicine() {

        imgRegster.invalidate();
        BitmapDrawable drawable = (BitmapDrawable) imgRegster.getDrawable();
        Bitmap bitmap = drawable.getBitmap();
        byte [] imgg = WorkImage.prepareForDB(bitmap);


        DataModelMedicine medicine = new DataModelMedicine(
                name.getText().toString(),
                imgg,
                notes.getText().toString(),
               Integer.valueOf( mSpinner_hours_first.getSelectedItem().toString()),
                Integer.valueOf(freq.getText().toString()));


        mDBHelper.addMedicine(medicine);

    };


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mDBHelper.close();
    }





    private  void createFolder() {
        if (isStoragePermissionGranted()) {
            File folder = new File(Environment.getExternalStorageDirectory() + File.separator + "MedicineApp");

            if (!folder.exists()) {
                folder.mkdir();
                Log.i("ssss", "createFolder: s");
            }
        }


    }




    public   boolean isStoragePermissionGranted() {

            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                return true;
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                return false;
            }


        }






        ActivityResultLauncher<String> mGetContent = registerForActivityResult(
                new ActivityResultContracts.GetContent(),
                new ActivityResultCallback<Uri>() {
                    @Override
                    public void onActivityResult(Uri result) {
                        if (result !=null){
                            imgRegster.setImageURI(result);

                        }
                    }

});

}










