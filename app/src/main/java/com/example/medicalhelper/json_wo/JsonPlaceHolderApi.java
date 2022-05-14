package com.example.medicalhelper.json_wo;


import com.example.medicalhelper.dataModels.dataModelDoctors;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("731d178f2f08bae27e39")
     Call<List<dataModelDoctors>> getPost();

}
