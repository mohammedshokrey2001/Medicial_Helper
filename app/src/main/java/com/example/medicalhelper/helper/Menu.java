
package com.example.medicalhelper.helper;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;

import com.example.medicalhelper.MAIN.NavigationS;
import com.example.medicalhelper.R;
import com.example.medicalhelper.Reminder.ReminderS;
import com.example.medicalhelper.menuT.AboutApp;
import com.example.medicalhelper.menuT.SettingsActivity;


public  final  class Menu {

         static Context mContext ;
         public final static  void mainw(Context context){
             Intent intent = new Intent( context, NavigationS.class)  ;
             intent.setFlags(FLAG_ACTIVITY_NEW_TASK);

             context.startActivity(intent);
         }


         public final static void aboutApp(Context context){
             mContext = context;
             Intent i = new Intent(mContext, AboutApp.class);
             i.addFlags(FLAG_ACTIVITY_NEW_TASK);
             context.startActivity(i);
         }



    public final static void setting(Context context){
        mContext = context;
        Intent i = new Intent(mContext, SettingsActivity.class);
        i.addFlags(FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);


    }


    public final static void menuSelection(MenuItem item ,Context context){
       context = context;
        int id = item.getItemId();
        if (id== R.id.Main_W_menu_Item){
           mainw(context);
        }
        if (id== R.id.remeinderMenuItem){
            reminder(context);
        }

        else if (id == R.id.About_App){
            aboutApp(context);
        }


    }

    private static void reminder(Context context) {
        Intent intent = new Intent( context, ReminderS.class)  ;
        intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
         }

}
