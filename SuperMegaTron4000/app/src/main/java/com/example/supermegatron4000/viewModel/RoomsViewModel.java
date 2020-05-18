package com.example.supermegatron4000.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.supermegatron4000.model.Room_simple;

import java.util.List;

public class RoomsViewModel extends ViewModel {
    private MutableLiveData<List<Room_simple>> rooms;
    public LiveData<List<Room_simple>> getRooms(){
        if (rooms==null){
            rooms = new MutableLiveData<List<Room_simple>>();
            //loadRooms;
        }
        return rooms;
    }

    private void loadRooms(){

    }
}
