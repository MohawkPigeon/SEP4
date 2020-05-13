package com.example.logappdev2;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public class ConnectionManager {

    String URL = "database";
    Retrofit retrofit;

    public ConnectionManager(){
        retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    boolean hasConnection(){

    }

    void login(){

    }

    Object get(String path, Object dataObj){

    }
    boolean append(Object obj){

    }

    private void create(Room room){
        createRoom service = retrofit.create(createRoom.class);
        Call<Room> r = service.createRoom(room);
    }
    private void read(String roomId){
        getRoom service = retrofit.create(getRoom.class);
        Call<List<Room>> room = service.getRoom(roomId);
    }
    private void update(){
        putRoom service = retrofit.create(putRoom.class);
        Call<Room> r = service.updateRoom(room);
    }
    private void delete(){
        deleteRoom service = retrofit.create(deleteRoom.class);
        Call<Room> r = service.deleteRoom(room);
    }


    public interface createRoom{
        @POST("rooms/new")
        Call<Room> createRoom(@Body Room room);
    }

    public interface getAllRooms {
        @GET("rooms")
        Call<List<Room>> getAllRooms (@Path("rooms") String room);
    }
    public interface getRoom {
        @GET("rooms/{room}")
        Call<List<Room>> getRoom (@Path("room") String room);
    }
    public interface putRoom{
        @PUT("update/{id}")
        Call<Room> updateRoom(@Path("id") int id, @Body Room room);
    }
    public interface deleteRoom{
        @DELETE("delete/{id}")
        Call<Room> deleteRoom(@Path("id") int id);
    }
}
