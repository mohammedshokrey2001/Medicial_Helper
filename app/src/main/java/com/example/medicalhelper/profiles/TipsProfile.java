package com.example.medicalhelper.profiles;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.medicalhelper.R;
import com.example.medicalhelper.Adapterss.MedicalTipsViewAdapter;

import java.util.ArrayList;

public class TipsProfile extends AppCompatActivity {


    RecyclerView mRecyclerView ;
    private MedicalTipsViewAdapter mAdapter;
    ArrayList<String> data ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_tips);

      mRecyclerView = findViewById(R.id.recycle_view_tips_diabtes);
                         Intent intent = getIntent();
            data = intent.getStringArrayListExtra("TIPS_DATA");
        Log.i("data", "onCreate: "+data);
        adapter();
    }



    void adapter(){

        mAdapter = new MedicalTipsViewAdapter(data);
        RecyclerView.LayoutManager layoutManager =  new GridLayoutManager(getApplicationContext(),2);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        DividerItemDecoration dividerItemDecoration  = new DividerItemDecoration(mRecyclerView.getContext(),
                DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(dividerItemDecoration);
        mRecyclerView.setAdapter(mAdapter);


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        com.example.medicalhelper.helper.Menu.menuSelection(item,getApplicationContext());
        return super.onOptionsItemSelected(item);

    }





}