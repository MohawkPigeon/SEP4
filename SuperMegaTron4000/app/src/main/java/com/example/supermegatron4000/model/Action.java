package com.example.supermegatron4000.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity(tableName = "action")
public class Action implements Serializable {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @SerializedName("RoomID")
    @Expose int id;

    @ColumnInfo(name = "command")
    @SerializedName("Command")
    @Expose public String command;

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
