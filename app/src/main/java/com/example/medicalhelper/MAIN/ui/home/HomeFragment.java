package com.example.medicalhelper.MAIN.ui.home;

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
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicalhelper.NewMedicine_Appoinment.NewMedicineRegstier;
import com.example.medicalhelper.R;
import com.example.medicalhelper.dataModels.DataModelMedicine;
import com.example.medicalhelper.databinding.FragmentHomeBinding;
import com.example.medicalhelper.helper.DBHelper;
import com.example.medicalhelper.Adapterss.MedicineViewAdapter;
import com.example.medicalhelper.profiles.medicine_Profile;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    RecyclerView recyclerView;
    ArrayList<DataModelMedicine> all_meidicine;
    private MedicineViewAdapter.RecycleViewListener listener;
    private MedicineViewAdapter mAdapter;
    private DBHelper mDb;
    FloatingActionButton add_Medicine;
    private MenuItem menuItem;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        recyclerView = root.findViewById(R.id.recyle_View_Medicine_Table_Tap);
        add_Medicine = root.findViewById(R.id.floatingActionButton_add_medicine);
        setHasOptionsMenu(true);



        add_Medicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), NewMedicineRegstier.class));

            }
        });



        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



    void adapter(){
        setOnClickListener();
        mAdapter = new MedicineViewAdapter(all_meidicine,listener);
        RecyclerView.LayoutManager layoutManager =  new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);




    }

    private void setOnClickListener() {
        listener = new MedicineViewAdapter.RecycleViewListener() {
            @Override
            public void onClick(View v, int postion) {
                Intent intent = new Intent(getContext(), medicine_Profile.class);
                intent.putExtra("MedcineInfo", all_meidicine.get(postion));
                startActivity(intent);



            }

            @Override
            public boolean onLongClick(View v, int position) {
                Log.i("Main Delete Medicine", "onLongClick: ++1");
                     mDb.deleteMedicine(all_meidicine.get(position).getId());
                         return false;
            }

        };


    }




    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onResume() {
        super.onResume();
        mDb = new DBHelper(getContext());
        all_meidicine = (ArrayList<DataModelMedicine>) mDb.getAllMedicine();

        adapter();

    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.added, menu);
        menuItem = menu.findItem(R.id.app_bar_search);

        SearchView searchView = (SearchView) menuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public boolean onQueryTextSubmit(String s) {
                all_meidicine = (ArrayList<DataModelMedicine>) mDb.searchMedicine(s);

                adapter();

                 return false;
            }

            @SuppressLint("NotifyDataSetChanged")
            @Override
            public boolean onQueryTextChange(String s) {
                all_meidicine = (ArrayList<DataModelMedicine>) mDb.searchMedicine(s);
                adapter();
                return false;
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        com.example.medicalhelper.helper.Menu.menuSelection(item,getContext());
        return super.onOptionsItemSelected(item);

    }

}