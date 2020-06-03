package com.example.supermegatron4000.ConnectionPack;

import android.os.Handler;

import com.example.supermegatron4000.model.myRoom;

import java.util.List;
public class Main {
    public static void main(String[] args) {
        ConnectionManager cm = new ConnectionManager();
        List<myRoom> rs = cm.getAllRooms();
        rs.get(0).getRoomName();
    }
}
