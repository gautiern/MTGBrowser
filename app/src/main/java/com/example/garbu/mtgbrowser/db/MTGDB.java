package com.example.garbu.mtgbrowser.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.util.Log;

import com.example.garbu.mtgbrowser.model.Card;
import com.example.garbu.mtgbrowser.model.Set;

/**
 * Created by garbu on 9/10/2018.
 */
@Database(entities = {Set.class,Card.class},version = 1, exportSchema = false)
public abstract class MTGDB extends RoomDatabase {

    private static final String LOG_TAG = MTGDB.class.getSimpleName();
    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "mtg_cards";
    private static  MTGDB sInstance;

    public static MTGDB getInstance(Context context){
        if(sInstance==null){
            synchronized (LOCK){
                Log.d(LOG_TAG, "Creating new DB instance");
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        MTGDB.class,
                        MTGDB.DATABASE_NAME)
                        //.allowMainThreadQueries() //to be removed
                        .build();
            }
        }
        Log.d(LOG_TAG,"Getting DB instance");
        return sInstance;
    }
    public abstract SetsDao setsDao();
    public abstract CardsDao cardsDao();
}
