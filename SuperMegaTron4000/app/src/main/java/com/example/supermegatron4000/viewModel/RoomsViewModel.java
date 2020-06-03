package com.example.supermegatron4000.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.supermegatron4000.model.myRoom;
import com.example.supermegatron4000.repositories.RoomsRepository;

import java.util.List;

public class RoomsViewModel extends ViewModel {

    private MutableLiveData<List<myRoom>> mRooms ;
    private RoomsRepository mRepo;
    private MutableLiveData<Boolean> mUpdate = new MutableLiveData<>();

    public void init(){
        if (mRooms!= null){
            return;
        }
        mRepo = RoomsRepository.getInstance();
        mRooms = mRepo.getRooms();
    }

    public void newData (final myRoom rooms){
        mUpdate.setValue(true);
    }

    public LiveData<List<myRoom>> getRooms(){
        return mRooms;
    }

    public LiveData<Boolean> getIsUpdating(){
        return mUpdate;
    }
}
