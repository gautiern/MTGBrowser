package com.example.garbu.mtgbrowser.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.garbu.mtgbrowser.model.Card;
import com.example.garbu.mtgbrowser.model.Set;

import java.util.List;

/**
 * Created by garbu on 9/10/2018.
 * Room database operations
 */
@Dao
public interface SetsDao {

    //"sets" table operations
    //query all sets
    @Query("SELECT * FROM sets ORDER BY name COLLATE NOCASE ASC")
    LiveData<List<Set>> loadAllSets();

    //query 1 set to verify DB populated
    @Query("SELECT * FROM sets LIMIT 1")
    Set loadASet();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Set set);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Set> sets);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateSet(Set set);

    @Delete
    void deleteSet(Set set);

}
