package com.example.medicalhelper.AboutApp;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.medicalhelper.R;


public class GuideFragment extends Fragment {

     VideoView mVideoView ;
     Button add_medicine;
    Button add_appoinment;
    Button add_reminder;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_guide, container, false);
          mVideoView = view.findViewById(R.id.videoView);
          add_medicine = view.findViewById(R.id.button_about_app_add_medcine);
        add_appoinment = view.findViewById(R.id.button_about_app_add_appinment);
        add_reminder = view.findViewById(R.id.button_about_app_how_to_create_reminder);
        final String[] path_video = {" "};


        MediaController controller = new MediaController(getContext());
        add_medicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                path_video[0] = "android.resource://" +getContext().getPackageName() +"/" +R.raw.medtable;
                Uri uri = Uri.parse(path_video[0]);
                mVideoView.setVideoURI(uri);
                mVideoView.start();
                mVideoView.setMediaController(controller);
            }
        });
        add_appoinment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                path_video[0] = "android.resource://" +getContext().getPackageName() +"/" +R.raw.appointment;
                Uri uri = Uri.parse(path_video[0]);
                mVideoView.setVideoURI(uri);
                mVideoView.start();
                mVideoView.setMediaController(controller);

            }
        });
        add_reminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                path_video[0] = "android.resource://" +getContext().getPackageName() +"/" +R.raw.reminder;
                Uri uri = Uri.parse(path_video[0]);
                mVideoView.setVideoURI(uri);
                mVideoView.start();
                mVideoView.setMediaController(controller);


            }
        });





    return  view;
    }
}