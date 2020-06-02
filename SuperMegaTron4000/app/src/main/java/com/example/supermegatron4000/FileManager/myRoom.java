package com.example.supermegatron4000.FileManager;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "room")
public class myRoom {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "roomName")
    public String roomName;

    @ColumnInfo(name = "minThreshold")
    public int minThreshold;

    @ColumnInfo(name = "maxThreshold")
    public int maxThreshold;

    @ColumnInfo(name = "actions")
    public String actions;

    @ColumnInfo(name = "sData")
    public String sData;


    public myRoom(String roomName, int minThreshold, int maxThreshold, String actions, String sData) {
        this.roomName = roomName;
        this.minThreshold = minThreshold;
        this.maxThreshold = maxThreshold;
        this.actions = actions;
        this.sData = sData;
    }

    public myRoom(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getMinThreshold() {
        return minThreshold;
    }

    public void setMinThreshold(int minThreshold) {
        this.minThreshold = minThreshold;
    }

    public int getMaxThreshold() {
        return maxThreshold;
    }

    public void setMaxThreshold(int maxThreshold) {
        this.maxThreshold = maxThreshold;
    }

    public String getActions() {
        return actions;
    }

    public void setActions(String actions) {
        this.actions = actions;
    }

    public String getsData() {
        return sData;
    }

    public void setsData(String sData) {
        this.sData = sData;
    }
}