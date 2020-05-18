package com.example.supermegatron4000;

import android.widget.Toast;
import com.example.supermegatron4000.User;
import com.example.supermegatron4000.Room;

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

    String URL = "klc/api/";
    Retrofit retrofit;
    roomService rS;

    public ConnectionManager(){
        retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        rS = retrofit.create(Room.class);
    }

    boolean hasConnection(){
        return true;
    }

    void login(){

    }

    Object get(String path, Object dataObj){

    }
    boolean append(Object obj){

    }

    /*Room CRUD*/
    /*private void create(Room room){
        Room service = retrofit.create(Room.class);
        Call<Room> r = service.createRoom(room);
    }*/

    private List<Room> readAll(Room room) {

        Call<List<Room>> r = rS.getAllRooms();

        int[] i = {};
        List<Room>[] rooms = new List<Room>;



        r.enqueue(new Callback<List<Room>>() {
            @Override
            public void onResponse(Call<List<Room>> call, Response<List<Room>> response) {
                if (response.isSuccessful()) {
                    rooms[0] = response.body();
                }
            }

            @Override
            public void onFailure(Call<List<Room>> call, Throwable t) {
                System.out.println("Call faliled recieved: " + t);
            }
        });
        return rooms[0];
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
        /*
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

    public interface roomService{
        @POST("rooms/new")
        Call<Room> createRoom(@Body Room room);

        @GET("room")
        Call<List<Room>> getAllRooms ();

        @GET("rooms/{room}")
        Call<List<Room>> getRoom (@Path("room") String room);

        @PUT("update/{id}")
        Call<Room> updateRoom(@Path("id") String id, @Body Room room);

        @DELETE("delete/{id}")
        Call<Room> deleteRoom(@Path("id") String id);
    }

    public interface User{
        @POST("users/new")
        Call<User> createUser(@Body User user);

        @GET("users")
        Call<List<Room>> getAllRooms (@Path("rooms") String room);

        @GET("users/{user}")
        Call<List<User>> getUser (@Path("user") String user);

        @PUT("update/{id}")
        Call<User> updateUser(@Path("id") String id, @Body User user);

        @DELETE("delete/{id}")
        Call<User> deleteUser(@Path("id") String id);
    }
    public interface SensorData{
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
    public interface Action{
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
