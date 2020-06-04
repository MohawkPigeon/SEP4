package com.example.supermegatron4000.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity(tableName = "sensorData")
public class SensorData implements Serializable {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "dateTime")
    @SerializedName("timestamp")
    @Expose public String dateTime;

    @ColumnInfo(name = "humidity")
    @SerializedName("humidity")
    @Expose public int humidity;

    @ColumnInfo(name = "CO2")
    @SerializedName("cO2")
    @Expose public int CO2;

    @ColumnInfo(name = "audiolevel")
    @SerializedName("audioLevel")
    @Expose public int audiolevel;


    @ColumnInfo(name = "temperature")
    @SerializedName("temperature")
    @Expose public int temperature;

    @ColumnInfo(name = "isOccupied")
    public boolean isOccupied;

    public SensorData(String dateTime, int humidity, int CO2, int audiolevel, int temperature, boolean isOccupied) {
        this.dateTime = dateTime;
        this.humidity = humidity;
        this.CO2 = CO2;
        this.audiolevel = audiolevel;
        this.temperature = temperature;
        this.isOccupied = isOccupied;
    }

    public SensorData(){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getCO2() {
        return CO2;
    }

    public void setCO2(int CO2) {
        this.CO2 = CO2;
    }

    public int getAudiolevel() {
        return audiolevel;
    }

    public void setAudiolevel(int audiolevel) {
        this.audiolevel = audiolevel;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}