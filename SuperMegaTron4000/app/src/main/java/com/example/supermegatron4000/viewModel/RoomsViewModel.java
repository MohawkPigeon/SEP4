package com.example.supermegatron4000.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.supermegatron4000.model.Room_simple;
import com.example.supermegatron4000.repositories.RoomsRepository;

import java.util.List;

public class RoomsViewModel extends ViewModel {

    private MutableLiveData<List<Room_simple>> mRooms ;
    private RoomsRepository mRepo;
    private MutableLiveData<Boolean> mUpdate = new MutableLiveData<>();

    public void init(){
        if (mRooms!= null){
            return;
        }
        mRepo = RoomsRepository.getInstance();
        mRooms = mRepo.getRooms();
    }

    public void newData (final Room_simple rooms){
        mUpdate.setValue(true);
    }

    public LiveData<List<Room_simple>> getRooms(){
        return mRooms;
    }

    public LiveData<Boolean> getIsUpdating(){
        return mUpdate;
    }
}
