package com.example.medicalhelper.MAIN.ui.Doctors;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicalhelper.R;
import com.example.medicalhelper.dataModels.dataModelDoctors;
import com.example.medicalhelper.databinding.FragmentDoctorsDataJsonBinding;
import com.example.medicalhelper.Adapterss.DoctorViewAdapter;
import com.example.medicalhelper.helper.internetC;
import com.example.medicalhelper.helper.Json_Data_Internet;
import com.example.medicalhelper.profiles.DoctorProfile;

import java.util.ArrayList;

public class DoctorSFragment extends Fragment {

    private DoctorSViewModel mDoctorSViewModel;
    private FragmentDoctorsDataJsonBinding binding;

    RecyclerView recyclerView;
    ImageButton mImageButton;
    private MenuItem menuItem;
    private DoctorViewAdapter.RecycleViewListener listener;
    private DoctorViewAdapter mAdapter;
    private ArrayList<dataModelDoctors> all_doctors;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mDoctorSViewModel =
                new ViewModelProvider(this).get(DoctorSViewModel.class);

        binding = FragmentDoctorsDataJsonBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        mImageButton = root.findViewById(R.id.imageButton2);
        recyclerView = root.findViewById(R.id.recycle_view_doctors_json);
        Json_Data_Internet.NotifyDa();


        Toast.makeText(getContext(), "you should have a connection to " +
                "the internet to use this feature !! ", Toast.LENGTH_LONG).show();

        Toast.makeText(getContext(), "if you dont have internet connection please don't " +
                "\n"+ "use this feature ",Toast.LENGTH_LONG ).show();


        setHasOptionsMenu(true);


        Log.i("internet connection", "onCreateView: " +   internetC.checkInternetConnection(getContext()));




        if ( !internetC.checkInternetConnection(getContext())){
            mImageButton.setVisibility(View.INVISIBLE);
        }





           mImageButton.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {


                     all_doctors = Json_Data_Internet.getALL();
                   for (dataModelDoctors d:
                           all_doctors) {
                       Log.i("hrr", "ss: "+d.getName());
                   }
                     adapter();
               }
           });


        return root;

    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }




    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.added, menu);
        menuItem = menu.findItem(R.id.app_bar_search);

        SearchView searchView = (SearchView) menuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                all_doctors = (ArrayList<dataModelDoctors>) Json_Data_Internet.getCityDoctors(s);

                if (all_doctors==null){
                    Toast.makeText(getContext(), "please enter the city name correctly " +
                            "Shibin ,Tanta ,cairo ", Toast.LENGTH_LONG).show();

                }else {
                    adapter();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                return false;
            }
        });


    }




    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onResume() {
        super.onResume();


    }

    void adapter(){
        setOnClickListener();

        mAdapter = new DoctorViewAdapter(all_doctors,listener);
        RecyclerView.LayoutManager layoutManager =  new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

    }


    private void setOnClickListener() {
        listener = new DoctorViewAdapter.RecycleViewListener() {
            @Override
            public void onClick(View v, int position) {
                Log.i("D", "onClick: sd");
                Intent sd = new Intent(getContext(), DoctorProfile.class);

                sd.putExtra("Data_Doctor",all_doctors.get(position));
                startActivity(sd);
            }



        };

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        com.example.medicalhelper.helper.Menu.menuSelection(item,getContext());
        return super.onOptionsItemSelected(item);

    }


}