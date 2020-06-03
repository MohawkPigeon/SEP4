package com.example.supermegatron4000;

import androidx.lifecycle.MutableLiveData;

import com.example.supermegatron4000.ConnectionPack.ConnectionManager;
import com.example.supermegatron4000.model.SensorData;
import com.example.supermegatron4000.FileManager.UserDao;
import com.example.supermegatron4000.model.User;
import com.example.supermegatron4000.model.myRoom;
import com.example.supermegatron4000.model.Action;
import java.util.List;

public class ReferenceManager { // måske bare lad være med at bruge denne klasse.

    String username = "sep4@gmail.com"; // hardcoded da authentifikation blev irrellevant
    String password = "password";

    UserDao dataManager;
    ConnectionManager connectionManager;
    final MutableLiveData<User> user = new MutableLiveData<User>();

    MutableLiveData<User> getUser(){
        if (user.getValue() != null){
            //return user.getValue();
        } else {
            if(connectionManager.hasConnection()){
                connectionManager.loginUser(username,password,user);
            }else{
                user.setValue(dataManager.getAll().get(0));
            }
        }
        return user;
    }
    MutableLiveData<User> getSavedUser(){
        user.setValue(dataManager.getAll().get(0));
        return user;
    }

    private void getAllRooms(final MutableLiveData<List<myRoom>> rooms){
        connectionManager.getAllRooms(rooms);
    }

    private void Create(User user){
        connectionManager.create(user);
    }
    private void Create(myRoom room){
        connectionManager.create(room);
    }
    private void Create(Action action){
        connectionManager.create(action);
    }
    private void Create(SensorData data){
        connectionManager.create(data);
    }
    private void Update(User user){
        connectionManager.update(user);
    }
    private void Update(myRoom room){
        connectionManager.update(room);
    }
    private void Update(Action action){
        connectionManager.update(action);
    }
    private void Update(SensorData data){
        connectionManager.update(data);
    }
    private void Delete(User user){
        connectionManager.delete(user);
    }
    private void Delete(myRoom room){
        connectionManager.delete(room);
    }
    private void Delete(Action action){
        connectionManager.delete(action);
    }
    private void Delete(SensorData data){
        connectionManager.delete(data);
    }
}
