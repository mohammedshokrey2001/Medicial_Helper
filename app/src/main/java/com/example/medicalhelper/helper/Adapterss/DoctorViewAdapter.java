package com.example.medicalhelper.helper.Adapterss;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicalhelper.R;
import com.example.medicalhelper.dataModels.dataModelDoctors;

import java.util.ArrayList;

public class DoctorViewAdapter extends RecyclerView.Adapter<DoctorViewAdapter.MyViewHolder> {

    private ArrayList<dataModelDoctors> mDataModelDoctors;
    private RecycleViewListener listener;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.doctor_card,parent,false);

        return  new MyViewHolder(view);
    }


    public DoctorViewAdapter(ArrayList<dataModelDoctors> modelMdoctors , RecycleViewListener listener){
        mDataModelDoctors = modelMdoctors;
         this.listener = listener;

    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
              String name = mDataModelDoctors.get(position).getName();
        String city = mDataModelDoctors.get(position).getCity();

        holder.name.setText(name);
        holder.city.setText(city);

    }

    @Override
    public int getItemCount() {
        Log.i("size in rcv", "getItemCount: "+mDataModelDoctors.size());
        return mDataModelDoctors.size();

    }


    public class MyViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView name;
        private TextView city;


        public MyViewHolder( View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.doctorNmaeEditText);
            city = itemView.findViewById(R.id.city_data_doctors);
            //img  = itemView.findViewById(R.id.doctorNameIMG);


            itemView.setOnClickListener(this);



        }

        @Override
        public void onClick(View view) {

            listener.onClick(view ,getAdapterPosition());
        }


    }



    public  interface RecycleViewListener{
        void onClick(View v , int position);


    }}







