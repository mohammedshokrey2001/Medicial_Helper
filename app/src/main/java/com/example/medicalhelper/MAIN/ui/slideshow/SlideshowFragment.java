package com.example.medicalhelper.MAIN.ui.slideshow;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.medicalhelper.R;
import com.example.medicalhelper.dataModels.DataModelMedicine;
import com.example.medicalhelper.databinding.FragmentSlideshowBinding;
import com.example.medicalhelper.profiles.Diabtes_tips;

import java.util.ArrayList;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;
    private FragmentSlideshowBinding binding;

    CardView diabetes;
    CardView health;
    CardView covid;
    CardView pressure;


    @SuppressLint("RestrictedApi")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        diabetes = root.findViewById(R.id.Card_Diabtes_tips);
        health = root.findViewById(R.id.Card_Healthy_tips);
        covid = root.findViewById(R.id.Card_covid_tips);
        pressure = root.findViewById(R.id.Card_Pressure_disease_tips);


        hasOptionsMenu();
        diabetes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "diabetes tips  ", Toast.LENGTH_LONG).show();
                  startActivity(new Intent(getContext(), Diabtes_tips.class));
            }
        });

        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "healthy life tips  ", Toast.LENGTH_LONG).show();
                //  startActivity(new Intent(getContext(),));
            }
        });


        pressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "pressure tips  ", Toast.LENGTH_LONG).show();
                //  startActivity(new Intent(getContext(),));
            }
        });


        covid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "covid-19 tips  ", Toast.LENGTH_LONG).show();
                //  startActivity(new Intent(getContext(),));
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
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        com.example.medicalhelper.helper.Menu.menuSelection(item, getContext());
        return super.onOptionsItemSelected(item);

    }
}

