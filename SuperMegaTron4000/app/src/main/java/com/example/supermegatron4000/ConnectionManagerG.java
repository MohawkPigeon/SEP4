package com.example.logappdev2;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public class ConnectionManagerG <T> {

    String URL = "database";
    Retrofit retrofit;
    Room service;

    public ConnectionManagerG(){
        retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(Room.class);

    }

    boolean hasConnection(){

    }

    void login(){

    }

    Object get(String path, Object dataObj){

    }
    boolean append(Object obj){

    }

    private void create(T type){
        Room service = retrofit.create(Room.class);
        Call<Room> r = service.createRoom(room);
    }
    private Room read(String Id){
        Room service = retrofit.create(Room.class);
        Call<List<Room>> room = service.getRoom(roomId);
        return service;
    }
    private void update(String roomId){
        Room service = retrofit.create(Room.class);
        Call<Room> r = service.updateRoom(Room);
    }
    private void delete(String roomId){
        Room service = retrofit.create(Room.class);
        Call<Room> r = service.deleteRoom(Room);
    }


    public interface Room{
        @POST("rooms/new")
        Call<Room> createRoom(@Body Room room);

        @GET("rooms")
        Call<List<Room>> getAllRooms (@Path("rooms") String room);

        @GET("rooms/{room}")
        Call<List<Room>> getRoom (@Path("room") String room);

        @PUT("update/{id}")
        Call<Room> updateRoom(@Path("id") int id, @Body Room room);

        @DELETE("delete/{id}")
        Call<Room> deleteRoom(@Path("id") int id);
    }
}
