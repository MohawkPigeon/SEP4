package com.example.supermegatron4000.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.supermegatron4000.ConnectionPack.ConnectionManager;
import com.example.supermegatron4000.model.myRoom;

import java.util.ArrayList;
import java.util.List;


public class RoomsRepository {
    private static RoomsRepository instance;
    private ArrayList<myRoom> dataSet = new ArrayList<>();
    ConnectionManager cm = new ConnectionManager();


    public static RoomsRepository getInstance(){
        if (instance==null){
            instance = new RoomsRepository();
        }
        return instance;
    }

    public MutableLiveData<List<myRoom>> getRooms(){

        MutableLiveData<List<myRoom>> data = new MutableLiveData<>();
        cm.getAllRooms(data);
        return data;
    }
}
