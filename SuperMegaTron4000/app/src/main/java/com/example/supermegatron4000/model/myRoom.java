package com.example.supermegatron4000.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

@Entity(tableName = "room")
public class myRoom implements Serializable {

    @SerializedName("roomID")
    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @Expose public int id;

    @SerializedName("name")
    @ColumnInfo(name = "roomName")
    @Expose public String roomName;

    @ColumnInfo(name = "minThreshold")
    public int minThreshold;

    @ColumnInfo(name = "maxThreshold")
    public int maxThreshold;

    @ColumnInfo(name = "actions")
    public int actions;

    @SerializedName("sensorData")
    @ColumnInfo(name = "sData")
    @Expose public int sData;

    @Ignore
    public List<Action> actionList;

    @Ignore
    public List<SensorData> sensorDataList;

    //Brug denne til at uploade
    public myRoom(String roomName, int minThreshold, int maxThreshold, int actions, int sData) {
        this.roomName = roomName;
        this.minThreshold = minThreshold;
        this.maxThreshold = maxThreshold;
        this.actions = actions;
        this.sData = sData;
    }

    //Brug denne til at downloade
    public myRoom(int id, String roomName, int minThreshold, int maxThreshold, List<Action> actionList, List<SensorData> sensorDataList) {
        this.id = id;
        this.roomName = roomName;
        this.minThreshold = minThreshold;
        this.maxThreshold = maxThreshold;
        this.actionList = actionList;
        this.sensorDataList = sensorDataList;
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

    public int getActions() {
        return actions;
    }

    public void setActions(int actions) {
        this.actions = actions;
    }

    public int getsData() {
        return sData;
    }

    public void setsData(int sData) {
        this.sData = sData;
    }
}