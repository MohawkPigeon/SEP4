package com.example.supermegatron4000.ConnectionPack;

import com.example.supermegatron4000.model.Room_simple;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public class ConnectionManager {

    String URL = "http://klc.one/api/";
    Retrofit retrofit;
    roomService rS;

    public ConnectionManager(){
        retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        rS = retrofit.create(roomService.class);
    }
    public List<Room_simple> getAllRooms(){
        return readAll();
    }

    /*boolean hasConnection(){
        return true;
    }

    void login(){

    }

    Object get(String path, Object dataObj){

    }
    boolean append(Object obj){

    }*/

    /*Room CRUD*/
    /*private void create(Room room){
=======
    */
/*Room CRUD*//*

    private void create(Room room){
        Room service = retrofit.create(Room.class);
        Call<Room> r = service.createRoom(room);
    }*/

    private List<Room_simple> readAll() {

        Call<List<Room_simple>> r = rS.getAllRooms();

        //int[] i = {};
        //List<Room_simple>[] rooms = new List<Room_simple>[1];
        final tmpRoomHold RoomHold = new tmpRoomHold();


        r.enqueue(new Callback<List<Room_simple>>() {
            @Override
            public void onResponse(Call<List<Room_simple>> call, Response<List<Room_simple>> response) {
                if (response.isSuccessful()) {
                    RoomHold.setRoom(response.body());
                    //System.out.println(RoomHold.getRoom().get(0).getNavn());
                }
            }

            @Override
            public void onFailure(Call<List<Room_simple>> call, Throwable t) {
                System.out.println("Call failed, recieved: " + t);
            }
        });
        return RoomHold.getRoom();
    }
    /*private Room read(Room room){

        Call<List<Room>> r = roomService.getRoom(room.getId());
        List<Room> rooms;

        r.enqueue(new Callback<List<Room>>() {
            @Override
            public void onResponse(Call<List<Room>> call, Response<List<Room>> response) {
                if(response.isSuccessful()){
                    List<Room> rooms = response.body();
                }
            }

            @Override
            public void onFailure(Call<List<Room>> call, Throwable t) {
                List<Room> rooms = null;
                System.out.println("Call faliled recieved: " + t);
            }
        });

        return rooms;
    }
    private void update(String roomId, Room room){
        Room service = retrofit.create(Room.class);
        Call<Room> r = service.updateRoom(roomId, room);
    }
    private void delete(String roomId){
        Room service = retrofit.create(Room.class);
        Call<Room> r = service.deleteRoom(roomId);
    }*/

    /*User CRUD*/

/*User CRUD*//*
    private void create(User user){
        User service = retrofit.create(User.class);
        Call<User> u = service.createUser(user);
    }
    private User read(User user){
        User service = retrofit.create(User.class);
        Call<List<User>> u = service.getUser(user.getId);
        return service;
    }
    private void update(String userId, User user){
        Room service = retrofit.create(Room.class);
        Call<Room> r = service.updateRoom(userId, user);
    }
    private void delete(String roomId){
        Room service = retrofit.create(Room.class);
        Call<Room> r = service.deleteRoom(roomId);
    }*/
}

interface roomService{
    @POST("rooms/new")
    Call<Room_simple> createRoom(@Body Room_simple room);

    @GET("room")
    Call<List<Room_simple>> getAllRooms ();

    @GET("rooms/{room}")
    Call<List<Room_simple>> getRoom (@Path("room") String room);

    @PUT("update/{id}")
    Call<Room_simple> updateRoom(@Path("id") String id, @Body Room_simple room);

    @DELETE("delete/{id}")
    Call<Room_simple> deleteRoom(@Path("id") String id);
}
interface User {
    @POST("users/new")
    Call<User> createUser(@Body User user);

    @GET("users/{user}")
    Call<List<User>> getUser(@Path("user") String user);

    @PUT("update/{id}")
    Call<User> updateUser(@Path("id") String id, @Body User user);

    @DELETE("delete/{id}")
    Call<User> deleteUser(@Path("id") String id);
}
interface SensorData{
    @POST("sensorData/new")
    Call<SensorData> createSensorData(@Body SensorData sensorData);

    @GET("sensorData")
    Call<List<SensorData>> getAllSensorData (@Path("sensorData") String sensorData);

    @GET("sensorData/{sensorData}")
    Call<List<SensorData>> getSensorData (@Path("sensorData") String sensorData);

    @PUT("update/{id}")
    Call<SensorData> updateSensorData(@Path("id") String id, @Body SensorData sensorData);

    @DELETE("delete/{id}")
    Call<SensorData> deleteSensorData(@Path("id") String id);
}
interface Action{
    @POST("action/new")
    Call<Action> createAction(@Body Action action);

    @GET("action")
    Call<List<Action>> getAllAction (@Path("action") String action);

    @GET("action/{action}")
    Call<List<Action>> getAction (@Path("action") String action);

    @PUT("update/{id}")
    Call<Action> updateAction(@Path("id") String id, @Body Action action);

    @DELETE("delete/{id}")
    Call<Action> deleteAction(@Path("id") String id);
}


