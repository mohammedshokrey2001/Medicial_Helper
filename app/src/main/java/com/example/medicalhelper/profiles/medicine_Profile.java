package com.example.medicalhelper.profiles;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.medicalhelper.R;
import com.example.medicalhelper.dataModels.DataModelMedicine;

import java.util.Locale;

public class medicine_Profile extends AppCompatActivity {

    DataModelMedicine mMedicine ;
    TextView medcineName;
    TextView desc;
    ImageView img;
    TextToSpeech mTextToSpeech ;
    ImageButton voiceS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_profile);
        medcineName = findViewById(R.id.medicine_name_medcine_profile);
        desc = findViewById(R.id.medicine_descrption_medcine_profile);
        img = findViewById(R.id.medcine_profile_img_view);
        voiceS = findViewById(R.id.text_to_speech_medcine_profile);
        Intent intent = getIntent();
        mMedicine = intent.getParcelableExtra("MedcineInfo");


        mTextToSpeech = new TextToSpeech(this,
                new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int i) {
                        if (i == TextToSpeech.SUCCESS) {
                            int res = mTextToSpeech.setLanguage(Locale.US);


                            if (res == TextToSpeech.LANG_MISSING_DATA || res == TextToSpeech.LANG_NOT_SUPPORTED) {
                                Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
                            } else {
                                Log.i("dataN", "onInit: w");
                            }
                        } else {
                            Log.i("dataN", "onInit: s");
                        }
                    }

                } );

        setDataToView();


        voiceS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  setTextToSpeech();
            }
        });

    }

    private void setDataToView() {
      //  generateVoice();
          img.setImageBitmap(mMedicine.getMedicineImg());
          medcineName.setText(mMedicine.getMedicineName());
          desc.setText(generateDataVoice());

    }

    private String generateDataVoice() {
        String voiceData = "welcome sir \n\n" +
                " you should take " + mMedicine.getMedicineName()  + " "+mMedicine.getFrequency() + " Times today \n"
                 +" Starting from "+ mMedicine.getsTime() + "o clock \n"  + "and medcine notes is  "+mMedicine.getNotes();
        return  voiceData;

    }


    void setTextToSpeech(){

        float pitch = 1;
        float speed = 1;
        mTextToSpeech.setPitch(pitch);
        mTextToSpeech.setSpeechRate(speed);
        mTextToSpeech.speak(generateDataVoice(),TextToSpeech.QUEUE_FLUSH ,null);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        com.example.medicalhelper.helper.Menu.menuSelection(item,this);
        return super.onOptionsItemSelected(item);

    }


}