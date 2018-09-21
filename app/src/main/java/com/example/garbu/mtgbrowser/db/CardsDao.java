package com.example.garbu.mtgbrowser.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.garbu.mtgbrowser.model.Card;

import java.util.List;

/**
 * Created by garbu on 9/10/2018.
 */
@Dao
public interface CardsDao {
    //"cards" table operations
    //query all cards in selected set
    @Query("SELECT * FROM cards WHERE setCode = :setCode")
    LiveData<List<Card>> loadCardSet(String setCode);

    //query 1 card to check if the card set is in the database
    @Query("SELECT * FROM cards WHERE setCode = :setCode LIMIT 1")
    Card loadACard(String setCode);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Card card);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Card> cards);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateCard(Card card);

    @Delete
    void deleteCard(Card card);
}
