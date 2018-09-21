package com.example.garbu.mtgbrowser;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.garbu.mtgbrowser.db.CardsRepository;
import com.example.garbu.mtgbrowser.db.MTGDB;
import com.example.garbu.mtgbrowser.model.Card;

import java.util.List;

/**
 * Created by garbu on 9/11/2018.
 */

public class CardsViewModel extends AndroidViewModel {
    //private MTGDB database;
    private CardsRepository mCardsRepository;
    private String mSetCode;
    private LiveData<List<Card>> mCards;
    private static final String TAG = SetsViewModel.class.getSimpleName();

    public CardsViewModel(@NonNull Application application, String setCode) {
        super(application);
        mCardsRepository = new CardsRepository(application);
        Log.d(TAG,"Getting cards list from repository");
        mCards = mCardsRepository.getAllCards(setCode);
    }


    public LiveData<List<Card>> getCards(){
        return mCards;
    }

/*    public void insertAll(List<Card> cards){
        database.cardsDao().insertAll(cards);
    }*/
}
