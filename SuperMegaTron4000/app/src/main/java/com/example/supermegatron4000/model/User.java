package com.example.supermegatron4000.model;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private Boolean installer;
    private Boolean rooms;
    private ArrayList<Action> Actions;

    public User(String username, String password, Boolean installer, Boolean rooms, ArrayList<Action> actions) {
        this.username = username;
        this.password = password;
        this.installer = installer;
        this.rooms = rooms;
        Actions = actions;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getInstaller() {
        return installer;
    }

    public void setInstaller(Boolean installer) {
        this.installer = installer;
    }

    public Boolean getRooms() {
        return rooms;
    }

    public void setRooms(Boolean rooms) {
        this.rooms = rooms;
    }

    public ArrayList<Action> getActions() {
        return Actions;
    }

    public void setActions(ArrayList<Action> actions) {
        Actions = actions;
    }

    public void addAction(Action action){
        Actions.add(action);
    }
}
