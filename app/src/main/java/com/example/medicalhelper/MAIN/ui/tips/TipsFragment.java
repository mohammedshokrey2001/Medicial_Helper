package com.example.medicalhelper.MAIN.ui.tips;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.medicalhelper.R;
import com.example.medicalhelper.dataManger.MangerTips;
import com.example.medicalhelper.databinding.FragmentTipsBinding;
import com.example.medicalhelper.helper.Json_Data_Internet;
import com.example.medicalhelper.profiles.TipsProfile;

public class TipsFragment extends Fragment {

    private TipsViewModel mTipsViewModel;
    private FragmentTipsBinding binding;

    CardView diabetes;
    CardView health;
    CardView covid;
    CardView pressure;


    @SuppressLint("RestrictedApi")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mTipsViewModel =
                new ViewModelProvider(this).get(TipsViewModel.class);

        binding = FragmentTipsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        diabetes = root.findViewById(R.id.Card_Diabtes_tips);
        health = root.findViewById(R.id.Card_Healthy_tips);
        covid = root.findViewById(R.id.Card_covid_tips);
        pressure = root.findViewById(R.id.Card_Pressure_disease_tips);






        Intent intent = new Intent(getContext() , TipsProfile.class);

        diabetes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "diabetes tips  ", Toast.LENGTH_LONG).show();


                  intent.putExtra("TIPS_DATA", MangerTips.dataDiabtes());
                  startActivity(intent);

            }
        });

        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "healthy life tips  ", Toast.LENGTH_LONG).show();
                intent.putExtra("TIPS_DATA", MangerTips.dataHealth());
                startActivity(intent);
            }
        });


        pressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "pressure tips  ", Toast.LENGTH_LONG).show();
                intent.putExtra("TIPS_DATA", MangerTips.dataPresserue());

                Json_Data_Internet.NotifyDa();

                startActivity(intent);
            }
        });


        covid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "covid-19 tips  ", Toast.LENGTH_LONG).show();
                intent.putExtra("TIPS_DATA", MangerTips.dataCovid());
                startActivity(intent);
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

