package com.example.supermegatron4000.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "action")
public class Action implements Serializable {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "command")
    public String command;

    public Action(@NonNull String command) {
        this.command = command;
    }

    public Action(){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getCommand() {
        return command;
    }

    public void setCommand(@NonNull String command) {
        this.command = command;
    }
}
