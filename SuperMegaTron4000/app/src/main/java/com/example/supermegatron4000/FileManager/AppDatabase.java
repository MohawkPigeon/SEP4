package com.example.supermegatron4000.FileManager;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class, SensorData.class, myRoom.class, Action.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao UserDao();
    public abstract SensorDataDao SensorDataDao();
    public abstract RoomDao RoomDao();
    public abstract ActionDao ActionDao();

}
