package com.example.supermegatron4000.FileManager;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public abstract class UserDao implements BaseDao<User> {
    @Query("SELECT * FROM user")
    public abstract List<User> getAll();

    @Query("SELECT * FROM user WHERE id IN (:userIds)")
    public abstract List<User> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM user WHERE username LIKE :first AND " +
            "password LIKE :last LIMIT 1")
    public abstract User findByName(String first, String last);

}

