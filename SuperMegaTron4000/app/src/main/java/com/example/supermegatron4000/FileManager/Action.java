package com.example.supermegatron4000.FileManager;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "action")
public class Action {

    @NonNull
    @PrimaryKey()
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "command")
    public String command;

    public Action(int id, @NonNull String command) {
        this.id = id;
        this.command = command;
    }

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