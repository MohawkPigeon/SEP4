package com.example.supermegatron4000;

import androidx.lifecycle.MutableLiveData;

import com.example.supermegatron4000.ConnectionPack.ConnectionManager;
import com.example.supermegatron4000.DataManager;
import com.example.supermegatron4000.FileManager.UserDao;
import com.example.supermegatron4000.model.User;

public class ReferenceManager { // måske bare lad være med at bruge denne klasse.

    String username;
    String password;

    UserDao dataManager;
    ConnectionManager connectionManager;
    final MutableLiveData<User> user = new MutableLiveData<User>();

    MutableLiveData<User> getUser(){
        if (user.getValue() != null){
            return user.getValue();
        } else {
            if(connectionManager.hasConnection()){
                connectionManager.loginUser(username,password,user);
            }else{
                user.setValue(dataManager.getAll().get(0)); // Bruger foskellige brugere.
            }
        }
        return user;
    }
    User getSavedUser(){
        user.setValue(dataManager.getAll().get(0));
    }
    private void Update(property changedProperty){

    }
    void append(property parent, property property){

    }
    private searchUser(){
        if(ConnectionManager.hasConnection()){
            ConnectionManager.
        }else {

        }
    }
 */
}
