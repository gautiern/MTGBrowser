package com.example.garbu.mtgbrowser;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

/**
 * Created by garbu on 9/21/2018.
 * Referenced https://stackoverflow.com/questions/46283981/android-viewmodel-additional-arguments
 */

public class CardsViewModelFactory extends ViewModelProvider.NewInstanceFactory{

    private Application mApplication;
    private String mSetCode;


    public CardsViewModelFactory(Application application, String param) {
        mApplication = application;
        mSetCode = param;
    }


    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        return (T) new CardsViewModel(mApplication, mSetCode);
    }
}
