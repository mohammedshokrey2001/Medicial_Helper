package com.example.medicalhelper.dataModels;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import com.example.medicalhelper.helper.WorkImage;

import java.util.Arrays;

public class DataModelMedicine implements Parcelable {
    String medicineName;
    public byte [] medicineImg;
    String notes;
    int sTime;
    int frequency;
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DataModelMedicine(String medicineName, byte[] medicineImg, String notes, int sTime, int frequency) {
        this.medicineName = medicineName;
        this.medicineImg = medicineImg;
        this.notes = notes;
        this.sTime = sTime;
        this.frequency = frequency;
    }

    protected DataModelMedicine(Parcel in) {
        medicineName = in.readString();
        medicineImg = in.createByteArray();
        notes = in.readString();
        sTime = in.readInt();
        frequency = in.readInt();
    }

    public static final Creator<DataModelMedicine> CREATOR = new Creator<DataModelMedicine>() {
        @Override
        public DataModelMedicine createFromParcel(Parcel in) {
            return new DataModelMedicine(in);
        }

        @Override
        public DataModelMedicine[] newArray(int size) {
            return new DataModelMedicine[size];
        }
    };

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getsTime() {
        return sTime;
    }

    public void setsTime(int sTime) {
        this.sTime = sTime;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public DataModelMedicine(String medicineName, byte [] medicineImg) {
        this.medicineName = medicineName;
        this.medicineImg = medicineImg;
    }


    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public Bitmap getMedicineImg() {
         Bitmap img = WorkImage.decodeImg(medicineImg);
         return img;
    }

    public void setMedicineImg(byte[] medicineImg) {
        this.medicineImg = medicineImg;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(medicineName);
        parcel.writeByteArray(medicineImg);
        parcel.writeString(notes);
        parcel.writeInt(sTime);
        parcel.writeInt(frequency);
    }


    @Override
    public String toString() {
        return "DataModelMedicine{" +
                "medicineName='" + medicineName + '\'' +
                ", medicineImg=" + Arrays.toString(medicineImg) +
                ", notes='" + notes + '\'' +
                ", sTime=" + sTime +
                ", frequency=" + frequency +
                ", id=" + id +
                '}';

    }


}
