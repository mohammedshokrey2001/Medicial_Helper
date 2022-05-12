package com.example.medicalhelper.MAIN.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.medicalhelper.NewMedicine_Appoinment.OutDataToAlarm;
import com.example.medicalhelper.R;
import com.example.medicalhelper.dataManger.manager1;
import com.example.medicalhelper.databinding.FragmentGalleryBinding;
import com.example.medicalhelper.helper.SpinnerX;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    private FragmentGalleryBinding binding;
    Spinner mSnipperHour;
    Spinner mSnipperMin;
    EditText doctorName;
    EditText notes;
    Button add_Apponitment ;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        mSnipperMin = root.findViewById(R.id.spinner_time_for_medcine);
        mSnipperHour = root.findViewById(R.id.spinner_to);
        doctorName = root.findViewById(R.id.doctor_name_edit_text);
        notes = root.findViewById(R.id.notes_appionitment_s_edit_text);
        add_Apponitment = root.findViewById(R.id.add_new_appointment);
        SpinnerX.setSpinnerData(mSnipperMin,manager1.getHourtList(),getContext());
        SpinnerX.setSpinnerData(mSnipperHour, manager1.getMintList(),getContext());


     add_Apponitment.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             add_Apponitment();
         }
     });


        return root;

    }

    private void add_Apponitment() {
        String message = "you have appointment with doctor "+
                doctorName + " at "+ mSnipperHour.getSelectedItem().toString()
                + " : "+ mSnipperMin.getSelectedItem().toString() + "\n notes:  "+notes;




        OutDataToAlarm.outData(
                Integer.parseInt(mSnipperHour.getSelectedItem().toString()),
                Integer.parseInt(mSnipperMin.getSelectedItem().toString()),
                message ,
                getContext()
        );

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        com.example.medicalhelper.helper.Menu.menuSelection(item,getContext());
        return super.onOptionsItemSelected(item);

    }


}