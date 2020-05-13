package com.example.sep4.FileManager;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

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

    public User(int id, @NonNull String username, @NonNull String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
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
}

