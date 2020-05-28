package com.example.supermegatron4000.FileManager;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class, SensorData.class, myRoom.class, Action.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao UserDao();
    public abstract SensorDataDao SensorDataDao();
    public abstract RoomDao RoomDao();
    public abstract ActionDao ActionDao();

    //Singleton Pattern
    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context) {
        if(INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if(INSTANCE == null) {
                    INSTANCE = Room.inMemoryDatabaseBuilder(context.getApplicationContext(), AppDatabase.class).enableMultiInstanceInvalidation().build();
                }
            }
        }
        return INSTANCE;
    }

}
