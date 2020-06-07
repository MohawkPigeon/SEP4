package com.example.supermegatron4000;

import androidx.lifecycle.MutableLiveData;

import com.example.supermegatron4000.ConnectionPack.ConnectionManager;
import com.example.supermegatron4000.FileManager.ActionFactory;
import com.example.supermegatron4000.FileManager.RoomFactory;
import com.example.supermegatron4000.FileManager.SensorDataFactory;
import com.example.supermegatron4000.FileManager.UserFactory;
import com.example.supermegatron4000.model.SensorData;
import com.example.supermegatron4000.FileManager.UserDao;
import com.example.supermegatron4000.model.User;
import com.example.supermegatron4000.model.myRoom;
import com.example.supermegatron4000.model.Action;
import java.util.List;

public class ReferenceManager {

    String username = "sep4@gmail.com"; // hardcoded da authentifikation blev irrellevant
    String password = "password";

    UserFactory dataManager;
    RoomFactory roomFactory;
    ActionFactory actionFactory;
    SensorDataFactory sensorDataFactory;

    ConnectionManager connectionManager;
    final MutableLiveData<User> user = new MutableLiveData<User>();

    MutableLiveData<User> getUser(){
        if (user.getValue() != null){
            return user;
        } else {
            if(connectionManager.hasConnection()){
                connectionManager.loginUser(username,password,user);

                if (dataManager.getAllUsers().isEmpty())
                dataManager.insertUser(user.getValue());

            }else{
                user.setValue(getSavedUser().getValue()) ;
            }
        }
        return user;
    }

    MutableLiveData<User> getSavedUser(){
        user.setValue(dataManager.getAllUsers().get(0));
        return user;
    }

    private void getAllRooms(final MutableLiveData<List<myRoom>> rooms){
        if(connectionManager.hasConnection())
        connectionManager.getAllRooms(rooms);
        else if(!getSavedRooms().isEmpty())
            rooms.setValue(getSavedRooms());

        if (getSavedRooms().isEmpty() && rooms.getValue() != null){
            for(int i=0; i < rooms.getValue().size(); i++)
                roomFactory.insertRoom(rooms.getValue().get(i));
        }
    }

    private void getRoom(int RoomID, final MutableLiveData<myRoom> room){
        connectionManager.getRoom(RoomID, room);
    }
    private void getAllAction(final MutableLiveData<List<Action>> action){
        connectionManager.getAllAction(action);
    }
    private void getAction(int actionID, final MutableLiveData<Action> action){
        connectionManager.getAction(actionID, action);
    }


    List<myRoom> getSavedRooms(){
        return roomFactory.getAllRooms();
    }

    List<Action> getSavedActions(){
        return actionFactory.getAllActions();
    }

    void saveAction(Action action){
        actionFactory.insertAction(action);
    }

    List<SensorData> getSavedSensorData(){
        return sensorDataFactory.getAllSensorData();
    }

    void saveSensorData(SensorData sensorData){
        sensorDataFactory.insertSensorData(sensorData);
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
