package com.example.supermegatron4000.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

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
    public String actions;

    @SerializedName("sensorData")
    @ColumnInfo(name = "sData")
    @Expose public String sData;


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