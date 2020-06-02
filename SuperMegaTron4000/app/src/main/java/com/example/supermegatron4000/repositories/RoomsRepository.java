package com.example.supermegatron4000.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.supermegatron4000.ConnectionPack.ConnectionManager;
import com.example.supermegatron4000.model.Room_simple;

import java.util.ArrayList;
import java.util.List;


public class RoomsRepository {
    private static RoomsRepository instance;
    private ArrayList<Room_simple> dataSet = new ArrayList<>();
    ConnectionManager cm = new ConnectionManager();


    public static RoomsRepository getInstance(){
        if (instance==null){
            instance = new RoomsRepository();
        }
        return instance;
    }

    public MutableLiveData<List<Room_simple>> getRooms(){

        MutableLiveData<List<Room_simple>> data = new MutableLiveData<>();
        cm.getAllRooms(data);
        return data;
    }
}
