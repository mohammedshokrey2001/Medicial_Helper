package com.example.medicalhelper.dataManger;

import java.util.ArrayList;

public final class  manager1 {



    public   static ArrayList<String>  getMintList(){
        ArrayList<String> numbers = new ArrayList<String>(23);

        for (int i = 1; i < 12; i++) {


            numbers.add(String.valueOf(i*5));
        }

        return numbers;
    }


    public   static ArrayList<String>  getHourtList(){
        ArrayList<String> numbers = new ArrayList<String>(23);

        for (int i = 1; i < 23; i++) {


            numbers.add(String.valueOf(i));
        }

        return numbers;
    }


}
