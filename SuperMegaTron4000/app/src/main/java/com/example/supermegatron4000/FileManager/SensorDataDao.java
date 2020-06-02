package com.example.supermegatron4000.FileManager;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.sql.Timestamp;
import java.util.List;

@Dao
public abstract class SensorDataDao implements BaseDao<SensorData> {
    @Query("SELECT * FROM sensorData")
    public abstract List<SensorData> getAll();

    @Query("SELECT * FROM sensorData WHERE id IN (:sensorIds)")
    public abstract List<SensorData> loadAllByIds(int[] sensorIds);

    @Query("SELECT * FROM sensorData WHERE dateTime LIKE :first AND " +
            "isOccupied LIKE :last LIMIT 1")
    public abstract SensorData findByDateTime(String first, Boolean last);

}
