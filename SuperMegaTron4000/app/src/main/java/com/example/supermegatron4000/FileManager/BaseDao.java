package com.example.sep4.FileManager;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Update;

@Dao
public interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(T ... entity);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(T... entity);

    @Delete()
    void delete(T entity);
}