package com.example.supermegatron4000.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.sql.Timestamp;

public class SensorData implements Serializable {

    @SerializedName("sensorDatatimestamp")
    @Expose public Timestamp dateTime;

    @SerializedName("humidity")
    @Expose public int luftfugtighed;

    @SerializedName("cO2")
    @Expose public int CO2;

    @SerializedName("audioLevel")
    @Expose public int audioLevel;

    public SensorData(Timestamp dateTime, int luftfugtighed, int CO2, int audioLevel) {
        this.dateTime = dateTime;
        this.luftfugtighed = luftfugtighed;
        this.CO2 = CO2;
        this.audioLevel = audioLevel;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public int getLuftfugtighed() {
        return luftfugtighed;
    }

    public void setLuftfugtighed(int luftfugtighed) {
        this.luftfugtighed = luftfugtighed;
    }

    public int getCO2() {
        return CO2;
    }

    public void setCO2(int CO2) {
        this.CO2 = CO2;
    }

    public int getAudioLevel() {
        return audioLevel;
    }

    public void setAudioLevel(int audioLevel) {
        this.audioLevel = audioLevel;
    }
}
