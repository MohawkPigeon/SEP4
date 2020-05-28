package com.example.supermegatron4000.FileManager;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.supermegatron4000.ConnectionPack.Main;

public class DBHelper extends AppCompatActivity {

    private AppDatabase db;
    private UserDao userDao;
    private SensorDataDao sensorDataDao;
    private RoomDao roomDao;
    private ActionDao actionDao;

    public void createDb() {
        db.getInstance(this);
        userDao = db.UserDao();
        sensorDataDao = db.SensorDataDao();
        roomDao = db.RoomDao();
        actionDao = db.ActionDao();
    }

    public AppDatabase getDb() {
        return db;
    }

    public void setDb(AppDatabase db) {
        this.db = db;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public SensorDataDao getSensorDataDao() {
        return sensorDataDao;
    }

    public void setSensorDataDao(SensorDataDao sensorDataDao) {
        this.sensorDataDao = sensorDataDao;
    }

    public RoomDao getRoomDao() {
        return roomDao;
    }

    public void setRoomDao(RoomDao roomDao) {
        this.roomDao = roomDao;
    }

    public ActionDao getActionDao() {
        return actionDao;
    }

    public void setActionDao(ActionDao actionDao) {
        this.actionDao = actionDao;
    }
}
