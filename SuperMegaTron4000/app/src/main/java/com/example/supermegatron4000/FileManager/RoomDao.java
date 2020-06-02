package com.example.supermegatron4000.FileManager;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public abstract class RoomDao implements BaseDao<myRoom> {
    @Query("SELECT * FROM Room")
    public abstract List<myRoom> getAll();

    @Query("SELECT * FROM Room WHERE id IN (:roomIds)")
    public abstract List<myRoom> loadAllByIds(int[] roomIds);

    @Query("SELECT * FROM Room inner join user on user.rooms = Room.roomName")
    public abstract List<myRoom> getAllRoomByUser();

    @Query("SELECT * FROM Room WHERE id IN (:roomIds)")
    public abstract myRoom loadById(int roomIds);

}
