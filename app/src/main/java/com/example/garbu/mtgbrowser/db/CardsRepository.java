package com.example.garbu.mtgbrowser.db;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.util.Log;

import com.example.garbu.mtgbrowser.model.Card;
import com.example.garbu.mtgbrowser.model.CardList;
import com.example.garbu.mtgbrowser.remote.MTGInterface;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by garbu on 9/21/2018.
 */

public class CardsRepository {
    private static final String TAG = SetsRepository.class.getSimpleName();
    private CardsDao mCardsDao;

    public CardsRepository(Application application){
        MTGDB database = MTGDB.getInstance(application);
        mCardsDao = database.cardsDao();

    }

    public LiveData<List<Card>> getAllCards(String setCode){
        refreshCards(setCode);
        return mCardsDao.loadCardSet(setCode);
    }

    public void refreshCards (String setCode){
        new refreshAsyncTask(mCardsDao).execute(setCode);
    }

    private static class refreshAsyncTask extends AsyncTask<String, Void, Void> {

        private CardsDao mAsyncTaskDao;

        refreshAsyncTask(CardsDao dao){
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(String...params) {
            String setCode = params[0];
            Card card = mAsyncTaskDao.loadACard(setCode);
            if (card==null){
                //make an API call to get sets from MTG API
                //final String setTypes = "core|expansion";

                MTGInterface mtgInterface = MTGInterface.retrofit.create(MTGInterface.class);
                Call<CardList> call = mtgInterface.getCards(params[0],1);


                try{
                    Response<CardList> response = call.execute();

                    if(response.isSuccessful()){
                        mAsyncTaskDao.insertAll(response.body().getCards());
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
