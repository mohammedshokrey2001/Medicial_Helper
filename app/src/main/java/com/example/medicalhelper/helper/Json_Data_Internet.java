package com.example.medicalhelper.helper;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.medicalhelper.dataModels.dataModelDoctors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class Json_Data_Internet {
   final static String cairo = "cairo";
   final static  String Tanta = "Tanta";
   final static String Shiben = "Shibin";
    private static HashMap<String, ArrayList<dataModelDoctors>> sAll_doctors;


    public   static void NotifyDa(){
         Retrofit retrofit = new Retrofit.Builder().
                 baseUrl(" https://api.npoint.io/").
                 addConverterFactory(GsonConverterFactory.create())
                 .build() ;



         JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);


         Call<List<dataModelDoctors>> call = jsonPlaceHolderApi.getPost();
         call.enqueue(new Callback<List<dataModelDoctors>>() {
             @Override
             public void onResponse(Call<List<dataModelDoctors>> call, Response<List<dataModelDoctors>> response) {
                 if (! response.isSuccessful()){
                     Log.i("dataModelDoctors_JSon", "onSuccess:--1");
                     return;
                 }

                 List<dataModelDoctors>posts = response.body();
                 Log.i("bnnn", "onResponse: "+call);
                 for (int i = 0; i < posts.size(); i++) {

                     sAll_doctors = arrangeData(posts);


                     //for test retrived data
                   Log.i("data : ", "onResponse: " +arrangeData(posts).get(Tanta).get(0).getName() );


                 }



             }

             @Override
             public void onFailure(@NonNull Call<List<dataModelDoctors>> call, @NonNull Throwable t) {
                 Log.i("dataModelDoctors", "onFailure: ++1");
             }
         });






     }

    private static HashMap<String ,ArrayList<dataModelDoctors>>arrangeData(List<dataModelDoctors> posts) {
        HashMap<String , ArrayList<dataModelDoctors>> data = new HashMap<>();

        ArrayList<dataModelDoctors> dataModelDoctorsCairo = new ArrayList<dataModelDoctors>();
        ArrayList<dataModelDoctors> dataModelDoctorsShiben = new ArrayList<dataModelDoctors>();
        ArrayList<dataModelDoctors> dataModelDoctorsTanta = new ArrayList<dataModelDoctors>();


        for (int i = 0; i <posts.size() ; i++) {
            if (posts.get(i).getCity().equals(cairo)){
                dataModelDoctorsCairo.add(posts.get(i));

            }
            else if(posts.get(i).getCity().equals(Shiben)){
                dataModelDoctorsShiben.add(posts.get(i));
            }
            else {
                dataModelDoctorsTanta.add(posts.get(i));
            }

        }

        data.put(cairo,dataModelDoctorsCairo);
        data.put(Shiben,dataModelDoctorsShiben);
        data.put(Tanta,dataModelDoctorsTanta);

       return data;

     }


     public static  ArrayList<dataModelDoctors> getCityDoctors(String city){

        return sAll_doctors.get(city);

     }


    public static  ArrayList<dataModelDoctors> getALL(){

        ArrayList<dataModelDoctors> dataModelDoctorss = new ArrayList<dataModelDoctors>();
        dataModelDoctorss.addAll(sAll_doctors.get(Shiben));
        dataModelDoctorss.addAll(sAll_doctors.get(cairo));
        dataModelDoctorss.addAll(sAll_doctors.get(Tanta));



        return dataModelDoctorss;
    }




}
