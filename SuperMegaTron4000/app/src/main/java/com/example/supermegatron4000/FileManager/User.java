package com.example.supermegatron4000.FileManager;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

//@Entity(primaryKeys = {"username", "password"})
@Entity(tableName = "user")
public class User {

    @NonNull
    @PrimaryKey()
    @ColumnInfo(name = "id")
    public int id;

    @NonNull
    @ColumnInfo(name = "username")
    public String username;

    @NonNull
    @ColumnInfo(name = "password")
    public String password;

    @ColumnInfo(name = "rooms")
    public String rooms;

    @ColumnInfo(name = "role")
    public String role;


    public User(int id, @NonNull String username, @NonNull String password, String rooms, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.rooms = rooms;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getUsername() {
        return username;
    }

    public void setUsername(@NonNull String username) {
        this.username = username;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    public String getRooms() {
        return rooms;
    }

    public void setRooms(String rooms) {
        this.rooms = rooms;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}


