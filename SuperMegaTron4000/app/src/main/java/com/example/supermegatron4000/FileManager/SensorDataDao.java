package com.example.supermegatron4000.FileManager;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.supermegatron4000.model.SensorData;

import java.util.List;

@Dao
public abstract class SensorDataDao implements BaseDao<SensorData> {
    @Query("SELECT * FROM sensorData")
    public abstract List<SensorData> getAll();

    @Query("SELECT * FROM sensorData WHERE id IN (:sensorIds)")
    public abstract List<SensorData> loadAllByIds(Integer... sensorIds);

    @Query("SELECT * FROM sensorData WHERE dateTime LIKE :first AND " +
            "isOccupied LIKE :last LIMIT 1")
    public abstract SensorData findByDateTime(String first, Boolean last);

}
