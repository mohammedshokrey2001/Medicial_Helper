package com.example.medicalhelper.MAIN.ui.Doctors;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DoctorSViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DoctorSViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}