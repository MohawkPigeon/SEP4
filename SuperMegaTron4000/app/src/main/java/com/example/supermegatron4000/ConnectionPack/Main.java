package com.example.supermegatron4000.ConnectionPack;

import android.os.Handler;

import com.example.supermegatron4000.model.Room_simple;

import java.util.List;
public class Main {
    public static void main(String[] args) {
        ConnectionManager cm = new ConnectionManager();
        List<Room_simple> rs = cm.getAllRooms();
        rs.get(0).getNavn();
    }
}