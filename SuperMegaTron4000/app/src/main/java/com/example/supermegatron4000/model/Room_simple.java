package com.example.supermegatron4000.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observer;

public class Room_simple implements Serializable {
    @SerializedName("sensorData")
    @Expose private ArrayList<SensorData> sData;

    private HardwareUnit hunit;

    @SerializedName("roomID")
    @Expose private int RoomID;

    @SerializedName("name")
    @Expose private String navn;

    private Enum Sensor;
    private int min;
    private int max;

    public Room_simple(ArrayList<SensorData> sData, HardwareUnit hunit, int roomID, String navn, Enum sensor, int min, int max) {
        this.sData = sData;
        //this.hunit = hunit;
        this.RoomID = roomID;
        this.navn = navn;
        //this.Sensor = sensor;
        //this.min = min;
        //this.max = max;
    }

    public ArrayList<SensorData> getsData() {
        return sData;
    }

    public void setsData(ArrayList<SensorData> sData) {
        this.sData = sData;
    }

    public HardwareUnit getHunit() {
        return hunit;
    }

    public void setHunit(HardwareUnit hunit) {
        this.hunit = hunit;
    }

    public int getRoomID() {
        return RoomID;
    }

    public void setRoomID(int roomID) {
        RoomID = roomID;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public Enum getSensor() {
        return Sensor;
    }

    public void setSensor(Enum sensor) {
        Sensor = sensor;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void assignAction(Action action){

    }

    public void subscribe(Observer observer){

    }
}
