package com.example.medicalhelper.helper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicalhelper.R;

import java.util.ArrayList;

public class MedicalTipsViewAdapter extends RecyclerView.Adapter<MedicalTipsViewAdapter.MyViewHolder> {

    ArrayList<String> data;

    public MedicalTipsViewAdapter(ArrayList<String> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tip_card,parent,false);

        return  new MedicalTipsViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

         String data_update  = data.get(position);
         holder.tips.setText(data_update);


    }

    @Override
    public int getItemCount() {
        return data.size();
    }





    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tips;


        public MyViewHolder(View itemView) {
            super(itemView);
            tips = itemView.findViewById(R.id.textView_Tips);
        }


    }

}

