package com.example.supermegatron4000.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.supermegatron4000.model.User;

import java.util.List;

public class LogInViewModel extends ViewModel {

    private MutableLiveData<List<User>> users;
    public LiveData<List<User>> getUser(){
        if (users==null){
            users = new MutableLiveData<List<User>>();
            //loadUsers;
        }
        return users;
    }

    private void loadUsers(){

    }
}
