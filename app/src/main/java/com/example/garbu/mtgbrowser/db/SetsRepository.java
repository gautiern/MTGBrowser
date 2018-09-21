package com.example.garbu.mtgbrowser.db;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.garbu.mtgbrowser.model.MTGSets;
import com.example.garbu.mtgbrowser.model.Set;
import com.example.garbu.mtgbrowser.remote.MTGInterface;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by garbu on 9/17/2018.
 */

public class SetsRepository {
    private SetsDao mSetsDao;
    private static final String TAG = SetsRepository.class.getSimpleName();

    public SetsRepository(Application application){
        MTGDB database = MTGDB.getInstance(application);
        mSetsDao = database.setsDao();

    }

    public LiveData<List<Set>> getAllSets(){
        refreshSets();
        return mSetsDao.loadAllSets();
    }

    public void refreshSets (){
        new refreshAsyncTask(mSetsDao).execute();
    }

    private static class refreshAsyncTask extends AsyncTask<Void, Void, Void>{

        private SetsDao mAsyncTaskDao;

        refreshAsyncTask(SetsDao dao){
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Void...voids) {
            Set set = mAsyncTaskDao.loadASet();
            if (set==null){
                //make an API call to get sets from MTG API
                final String setTypes = "core|expansion";

                MTGInterface mtgInterface = MTGInterface.retrofit.create(MTGInterface.class);
                Call<MTGSets> call = mtgInterface.getSets(setTypes);


                try{
                    Response<MTGSets> response = call.execute();

                    if(response.isSuccessful()){
                        mAsyncTaskDao.insertAll(response.body().getSets());
                    } else {
                        int statusCode = response.code();
                        Log.e(TAG, "There was an error receiving data from the server: " + statusCode);
                    }
                } catch (IOException e){
                    Log.e(TAG, "Network error:" + e);
                }

            }
            return null;
        }

    }
}
