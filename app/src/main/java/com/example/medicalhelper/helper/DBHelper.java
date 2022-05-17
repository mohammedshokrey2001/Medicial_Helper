package com.example.medicalhelper.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.medicalhelper.dataModels.DataModelMedicine;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
     //basic
    private  final Context context;
    private static final String DATABASE_NAME = "mysqldb.db";
    private static final int DATABASE_VERISON = 1;


    //table1
    public static final String MED_TABLE = "Med_TABLE";
    public static final String ID = "id";
    public static final String NAME = "NAME";
    public static final String NOTES = "NOTES";
    public static final String MEDICINE_IMG = "IMAGE";
    public static final String FREQ = "Freq";
    public static final String STRING = "Start_Hour";




    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERISON);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create_Statment = "Create Table " + MED_TABLE + " ( " + ID + "  INTEGER PRIMARY KEY AUTOINCREMENT,  "
                + NAME + "  VARCHAR(40),  "
                + MEDICINE_IMG + " BLOB ,  " +
                FREQ + "  INTEGER (1)  , " +
                NOTES + "  VARCHAR(150) , " +
                STRING + " INTEGER(2) "+
                " ); "      ;

        sqLiteDatabase.execSQL(create_Statment);

    }



    public  boolean addMedicine(DataModelMedicine dataModel1){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(NAME ,dataModel1.getMedicineName());
         cv.put(FREQ,dataModel1.getFrequency());
         cv.put(NOTES,dataModel1.getNotes());
         cv.put(STRING,dataModel1.getsTime());
        cv.put(MEDICINE_IMG, dataModel1.medicineImg);

        long insert = db.insert(MED_TABLE ,null,cv);

        if ( insert==-1){

            return  false;
        }else {
            return true;
        }

    }

    public List<DataModelMedicine> getAllMedicine(){
        List<DataModelMedicine> returnList = new ArrayList<DataModelMedicine>();
        String query = "SELECT * FROM "+MED_TABLE +"  ; ";

        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("select *  from  " +
                        MED_TABLE ,
                new String[]{ });
        if (cursor.moveToFirst()){
            do{
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                byte[] img = cursor.getBlob(2);
                int freq= cursor.getInt(3);
                String notes = cursor.getString(4);
                int startTime = cursor.getInt(5);




                DataModelMedicine dataModel1 = new DataModelMedicine(name,img,notes,startTime,freq);
                              dataModel1.setId(id);
                returnList.add(dataModel1);
            }while (cursor.moveToNext());

        }else {
            /////
            Log.i("DB", "getAllMedicine: --1 get data from Table "+MED_TABLE);
        }
        return  returnList;
    }



    public List<DataModelMedicine> searchMedicine(String namew){
        List<DataModelMedicine> returnList = new ArrayList<DataModelMedicine>();

        SQLiteDatabase database = this.getReadableDatabase();
        String query = " SELECT * FROM "+MED_TABLE +" WHERE "+NAME +" like '%"+ namew +"%';";
        Cursor cursor = database.rawQuery(query,new String[]{});

        if (cursor.moveToFirst()){
            do{
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                byte[] img = cursor.getBlob(2);
                int freq= cursor.getInt(3);
                String notes = cursor.getString(4);
                int startTime = cursor.getInt(5);




                DataModelMedicine dataModel1 = new DataModelMedicine(name,img,notes,startTime,freq);

                returnList.add(dataModel1);
            }while (cursor.moveToNext());

        }else {
            /////

        }
        return  returnList;
    }





    public void deleteMedicine(int id){
        SQLiteDatabase db = getWritableDatabase();

        int d =  db.delete( MED_TABLE,"id=? ",new String[]{String.valueOf(id)});
        Log.i("DB", "deleteMedicine: "+d);

    }







    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


}
