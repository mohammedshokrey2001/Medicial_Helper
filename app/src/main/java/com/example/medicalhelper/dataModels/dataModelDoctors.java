package com.example.medicalhelper.dataModels;

import android.os.Parcel;
import android.os.Parcelable;

public class dataModelDoctors implements Parcelable {


        private String name;
        private long id;
        private String city;
        private String desc;
        private  String address;

    protected dataModelDoctors(Parcel in) {
        name = in.readString();
        id = in.readLong();
        city = in.readString();
        desc = in.readString();
        address = in.readString();
    }

    public static final Creator<dataModelDoctors> CREATOR = new Creator<dataModelDoctors>() {
        @Override
        public dataModelDoctors createFromParcel(Parcel in) {
            return new dataModelDoctors(in);
        }

        @Override
        public dataModelDoctors[] newArray(int size) {
            return new dataModelDoctors[size];
        }
    };

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() { return name; }
        public void setName(String value) { this.name = value; }

        public long getID() { return id; }
        public void setID(long value) { this.id = value; }

        public String getCity() { return city; }
        public void setCity(String value) { this.city = value; }

        public String getDesc() { return desc; }
        public void setDesc(String value) { this.desc = value; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeLong(id);
        parcel.writeString(city);
        parcel.writeString(desc);
        parcel.writeString(address);
    }
}


