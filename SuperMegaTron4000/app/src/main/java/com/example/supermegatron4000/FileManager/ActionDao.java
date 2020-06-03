package com.example.supermegatron4000.FileManager;

import com.example.supermegatron4000.model.Action;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.sql.Timestamp;
import java.util.List;

@Dao
public abstract class ActionDao implements BaseDao<Action> {
    @Query("SELECT * FROM `action`")
    public abstract List<Action> getAll();

    @Query("SELECT * FROM `action` WHERE id IN (:actionIds)")
    public abstract List<Action> loadAllByIds(int[] actionIds);

}
