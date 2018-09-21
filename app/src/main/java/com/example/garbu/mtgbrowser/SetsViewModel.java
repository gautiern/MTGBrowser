package com.example.garbu.mtgbrowser;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.garbu.mtgbrowser.db.MTGDB;
import com.example.garbu.mtgbrowser.db.SetsDao;
import com.example.garbu.mtgbrowser.db.SetsRepository;
import com.example.garbu.mtgbrowser.model.Set;

import java.util.List;

/**
 * Created by garbu on 9/10/2018.
 */

public class SetsViewModel extends AndroidViewModel {
    //private MTGDB database;
    private SetsRepository mSetsRepository;
    private LiveData<List<Set>> mAllSets;
    private static final String TAG = SetsViewModel.class.getSimpleName();

    public SetsViewModel(@NonNull Application application) {
        super(application);
        mSetsRepository = new SetsRepository(application);
        Log.d(TAG,"Getting sets list from repository");
        mAllSets = mSetsRepository.getAllSets();
    }

    public LiveData<List<Set>> getSets(){
        return mAllSets;
    }

    /*
    public void insertAll(List<Set> sets){
        mSetsRepository.insertAllSets(sets);
    }
    */
}
