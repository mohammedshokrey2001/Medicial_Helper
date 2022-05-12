package com.example.medicalhelper.helper;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.ByteArrayOutputStream;
import java.io.File;

public final class WorkImage {


       static Context mContext;


    public final static Bitmap decodeImg(byte[] byteImage){
        return BitmapFactory.decodeByteArray(byteImage, 0, byteImage.length);
    }

    public final static Bitmap decodeImg(Bitmap byteImage){
            return  byteImage;
    }



    public final static byte[] prepareForDB(Bitmap image){
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        image.compress(Bitmap.CompressFormat.PNG, 100, stream);

        byte[] byteArray = stream.toByteArray();
        return  byteArray;

    }



}