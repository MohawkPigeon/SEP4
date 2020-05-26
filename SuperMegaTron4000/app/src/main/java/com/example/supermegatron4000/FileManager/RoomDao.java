package com.example.supermegatron4000.FileManager;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.sql.Timestamp;
import java.util.List;

@Dao
public abstract class RoomDao implements BaseDao<Room> {
    @Query("SELECT * FROM room")
    public abstract List<Room> getAll();

    @Query("SELECT * FROM room WHERE id IN (:roomIds)")
    public abstract List<Room> loadAllByIds(int[] roomIds);

    @Query("SELECT * FROM room join user on user.rooms = room.roomName")
    public abstract List<Room> getAllRoomByUser();

}
