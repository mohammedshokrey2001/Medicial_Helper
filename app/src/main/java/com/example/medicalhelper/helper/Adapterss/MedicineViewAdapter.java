package com.example.medicalhelper.helper.Adapterss;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicalhelper.R;
import com.example.medicalhelper.dataModels.DataModelMedicine;

import java.util.ArrayList;

public class MedicineViewAdapter extends RecyclerView.Adapter<MedicineViewAdapter.MyViewHolder> {

    private ArrayList<DataModelMedicine> mDataModelMedicines;
    private RecycleViewListener listener;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.medicine_card,parent,false);

        return  new MyViewHolder(view);
    }


    public MedicineViewAdapter(ArrayList<DataModelMedicine> modelMedicines , RecycleViewListener listener){
        mDataModelMedicines = modelMedicines;
         this.listener = listener;

    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
              String name = mDataModelMedicines.get(position).getMedicineName();
              Bitmap img = mDataModelMedicines.get(position).getMedicineImg();


              holder.img.setImageBitmap(img);
              holder.name.setText(name);

    }

    @Override
    public int getItemCount() {
        return mDataModelMedicines.size();
    }


    public class MyViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener{
        private TextView name;
        private ImageView img ;


        public MyViewHolder( View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.doctorNmaeEditText);
            img  = itemView.findViewById(R.id.doctorNameIMG);


            itemView.setOnClickListener(this);



        }

        @Override
        public void onClick(View view) {

            listener.onClick(view ,getAdapterPosition());
        }

        @Override
        public boolean onLongClick(View view) {
            listener.onLongClick(view ,getAdapterPosition());
           return false;
        }
    }



    public  interface RecycleViewListener{
        void onClick(View v , int position);
        boolean onLongClick(View v , int position);

    }}







