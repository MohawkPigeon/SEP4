package com.example.supermegatron4000.ConnectionPack;

<<<<<<< HEAD
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Room;

import com.example.supermegatron4000.model.Action;
=======
import androidx.lifecycle.MutableLiveData;

>>>>>>> 0e35229f4c0978d13f7b2eac5675d0c957709055
import com.example.supermegatron4000.model.Room_simple;
import com.example.supermegatron4000.model.SensorData;
import com.example.supermegatron4000.model.User;

import java.io.IOException;
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
import retrofit2.http.Query;

public class ConnectionManager {

    String URL = "http://klc.one/api/";
    Retrofit retrofit;
    roomService rS;
    userService uS;
    dataService dS;
    actionService aS;

    public ConnectionManager(){
        retrofit = new retrofit2.Retrofit.Builder() // Opretter retrofit klasse
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
<<<<<<< HEAD
        rS = retrofit.create(roomService.class); //opretter services baseret på indbyggede interfaces.
        uS = retrofit.create(userService.class);
        dS = retrofit.create(dataService.class);
        aS = retrofit.create(actionService.class);
=======
        rS = retrofit.create(roomService.class);
    }
    public List<Room_simple> getAllRooms(final MutableLiveData<List<Room_simple>> rd){
        return readAll(rd);
>>>>>>> 0e35229f4c0978d13f7b2eac5675d0c957709055
    }
    public void getAllRooms(final MutableLiveData<List<Room_simple>> rd){
        readAllRooms(rd);

    }

    public boolean hasConnection(){
        return true;
    }

    public void login(String Username, String Password){

    }

    public void getUser(String userID, final MutableLiveData<User> user){
        readUser(userID,user);
    }
    public void getRoom(int roomID, final MutableLiveData<Room_simple> room){
        readRoom(roomID,room);
    }
    public void getAction(int actionID, final MutableLiveData<Action> action){
        readAction(actionID,action);
    }
    public void getSensorData(int dataID, final MutableLiveData<SensorData> SensorData){
        readData(dataID,SensorData);
    }
    public void get(User t, String userID, final MutableLiveData<User> user){ // t variabler bruges til at bestemme metode.
        readUser(userID,user);
    }
    public void get(Room_simple t, int roomID, final MutableLiveData<Room_simple> room){
        readRoom(roomID,room);
    }
    public void get(Action t, int actionID, final MutableLiveData<Action> action){
        readAction(actionID,action);
    }
    public void get(SensorData t, int dataID, final MutableLiveData<SensorData> SensorData){
        readData(dataID,SensorData);
    }
    public void update(User user){
        updateUser(user);
    }
    public void update(Room_simple room){
        updateRoom(room);
    }
    public void update(Action action){
        updateAction(action);
    }
    public void update(SensorData data){
        updateData(data);
    }
    /*
    public void updateuser(User user){
        updateUser(user);
    }
    public void updateroom(Room_simple room){
        updateRoom(room);
    }
    public void updateaction(Action action){
        updateAction(action);
    }
    public void updatedata(SensorData data){
        updateData(data);
    }*/

    public void create(User user){
        createUser(user);
    }
    public void create(Room_simple room){
        createRoom(room);
    }
    public void create(Action action){
        createAction(action);
    }
    public void create(SensorData data){
        createData(data);
    }

    public void delete(User user){
        deleteUser(user);
    }
    public void delete(Room_simple room){
        deleteRoom(room);
    }
    public void delete(Action action){
        deleteAction(action);
    }
    public void delete(SensorData data){
        deleteData(data);
    }





    /*Room CRUD*/
    /*private void create(Room room){
=======
    */
<<<<<<< HEAD
/*Room CRUD*/
=======
    /*Room CRUD*//*
>>>>>>> 0e35229f4c0978d13f7b2eac5675d0c957709055

    private void createRoom(Room_simple room){

<<<<<<< HEAD
        Call<Room_simple> req = rS.createRoom(room); // opretter et kald udfra indbyggede interfaces.
                                                                //Room_simple bliver passeret som parameter.
=======
    private List<Room_simple> readAll(final MutableLiveData<List<Room_simple>> rd) {
>>>>>>> 0e35229f4c0978d13f7b2eac5675d0c957709055

        req.enqueue(new Callback<Room_simple>() { //Opretter et anonymt Callback for at gøre kaldet asynkront.
            @Override
            public void onResponse(Call<Room_simple> call, Response<Room_simple> response) {

            }

            @Override
            public void onFailure(Call<Room_simple> call, Throwable t) {
                System.out.println("Call failed, recieved: " + t); // SOUT hvis kaldet fejler printes fejlen til konsollet. Bruges til debugging.
            }
        });

    }

    private void readAllRooms(final MutableLiveData<List<Room_simple>> rd) {

        Call<List<Room_simple>> req = rS.getAllRooms();

        req.enqueue(new Callback<List<Room_simple>>() {
            @Override
            public void onResponse(Call<List<Room_simple>> call, Response<List<Room_simple>> response) {
                if (response.isSuccessful()) {
<<<<<<< HEAD
                    rd.setValue(response.body()); //resultatet på kaldet bliver indsat i MutableLiveData variablet, som så læses andre steder.
                } else {
                    System.out.println("Response was not succesfull.\n");
=======
                    rd.setValue(response.body());
                    RoomHold.setRoom(response.body());
                    System.out.println(RoomHold.getRoom().get(0).getNavn());
>>>>>>> 0e35229f4c0978d13f7b2eac5675d0c957709055
                }
            }

            @Override
            public void onFailure(Call<List<Room_simple>> call, Throwable t) {
                System.out.println("Call failed, recieved: " + t);
            }
        });
<<<<<<< HEAD
=======
        System.out.println("got all rooms");
        return RoomHold.getRoom();
>>>>>>> 0e35229f4c0978d13f7b2eac5675d0c957709055
    }
    private void readRoom(int roomID, final MutableLiveData<Room_simple> room){

        Call<Room_simple> req = rS.getRoom(roomID);

        req.enqueue(new Callback<Room_simple>() {
            @Override
            public void onResponse(Call<Room_simple> call, Response<Room_simple> response) {
                if(response.isSuccessful()){
                    room.setValue(response.body());
                } else {
                    System.out.println("Response was not succesfull.\n");
                }
            }

            @Override
            public void onFailure(Call<Room_simple> call, Throwable t) {
                System.out.println("Call faliled recieved: " + t);
            }
        });
    }
    private void updateRoom(Room_simple room){
        Call<Room_simple> req = rS.updateRoom(room.getRoomID(), room);

        req.enqueue(new Callback<Room_simple>() {
            @Override
            public void onResponse(Call<Room_simple> call, Response<Room_simple> response) {

            }

            @Override
            public void onFailure(Call<Room_simple> call, Throwable t) {
                System.out.println("Call faliled recieved: " + t);
            }
        });

    }
    private void deleteRoom(Room_simple room){
        Call<Room_simple> req = rS.deleteRoom(room.getRoomID());

        req.enqueue(new Callback<Room_simple>() {
            @Override
            public void onResponse(Call<Room_simple> call, Response<Room_simple> response) {

            }

            @Override
            public void onFailure(Call<Room_simple> call, Throwable t) {
                System.out.println("Call faliled recieved: " + t);
            }
        });
    }


<<<<<<< HEAD
/*User CRUD*/
    private void createUser(User user){
        Call<User> req = uS.createUser(user);
        req.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){

                } else {
                    System.out.println("Response was not succesfull.\n");
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                System.out.println("Call faliled recieved: " + t);
            }
        });
    }
    private void readUser(String userId, final MutableLiveData<User> user){

        Call<User> req = uS.getUser(userId);
        req.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){
                    user.setValue(response.body());
                } else {
                    System.out.println("Response was not succesfull.\n");
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                System.out.println("Call faliled recieved: " + t);
            }
        });
    }
    private void updateUser(User user){

        Call<User> req = uS.updateUser(user.getUsername(), user);
        req.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){

                } else {
                    System.out.println("Response was not succesfull.\n");
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                System.out.println("Call faliled recieved: " + t);
            }
        });
    }
    private void deleteUser(User user){
        Call<User> req = uS.deleteUser(user.getUsername());
        req.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                System.out.println("Call faliled recieved: " + t);
            }
        });
=======
    /*User CRUD*//*
    private void create(User user){
        User service = retrofit.create(User.class);
        Call<User> u = service.createUser(user);
>>>>>>> 0e35229f4c0978d13f7b2eac5675d0c957709055
    }

    public void loginUser(String username, String password, final MutableLiveData<User> user){
        Call<User> req = uS.loginUser(username, password);
        req.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                user.setValue(response.body());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                System.out.println("Call faliled recieved: " + t);
            }
        });
    }

    /*Action CRUD*/
    private void createAction(Action action){
        Call<Action> req = aS.createAction(action);
        req.enqueue(new Callback<Action>() {
            @Override
            public void onResponse(Call<Action> call, Response<Action> response) {

            }

            @Override
            public void onFailure(Call<Action> call, Throwable t) {
                System.out.println("Call faliled recieved: " + t);
            }
        });
    }
    private void readAction(int actionId, final MutableLiveData<Action> action){

        Call<Action> req = aS.getAction(actionId);
        req.enqueue(new Callback<Action>() {
            @Override
            public void onResponse(Call<Action> call, Response<Action> response) {
                action.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Action> call, Throwable t) {
                System.out.println("Call faliled recieved: " + t);
            }
        });
    }
    private void updateAction(Action action){

        Call<Action> req = aS.updateAction(action.ActionID, action);
        req.enqueue(new Callback<Action>() {
            @Override
            public void onResponse(Call<Action> call, Response<Action> response) {

            }

            @Override
            public void onFailure(Call<Action> call, Throwable t) {
                System.out.println("Call faliled recieved: " + t);
            }
        });
    }
    private void deleteAction(Action action){
        Call<Action> req = aS.deleteAction(action.ActionID);
        req.enqueue(new Callback<Action>() {
            @Override
            public void onResponse(Call<Action> call, Response<Action> response) {

            }

            @Override
            public void onFailure(Call<Action> call, Throwable t) {
                System.out.println("Call faliled recieved: " + t);
            }
        });
    }

    /*Data CRUD*/
    private void createData(SensorData data){ // Denne metode bør ikke blive brugt.
        Call<SensorData> req = dS.createSensorData(data);
        req.enqueue(new Callback<SensorData>() {
            @Override
            public void onResponse(Call<SensorData> call, Response<SensorData> response) {

            }

            @Override
            public void onFailure(Call<SensorData> call, Throwable t) {
                System.out.println("Call faliled recieved: " + t);
            }
        });
    }
    private void readData(int dataId,final MutableLiveData<SensorData> data){

        Call<SensorData> req = dS.getSensorData(dataId);
        req.enqueue(new Callback<SensorData>() {
            @Override
            public void onResponse(Call<SensorData> call, Response<SensorData> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<SensorData> call, Throwable t) {
                System.out.println("Call faliled recieved: " + t);
            }
        });
    }
    private void updateData(SensorData data){ // Denne metode bør ikke bruges.

        Call<SensorData> req = dS.updateSensorData(data.getDateTime().getNanos(), data);
        req.enqueue(new Callback<SensorData>() {
            @Override
            public void onResponse(Call<SensorData> call, Response<SensorData> response) {

            }

            @Override
            public void onFailure(Call<SensorData> call, Throwable t) {
                System.out.println("Call faliled recieved: " + t);
            }
        });
    }
    private void deleteData(SensorData data){
        Call<SensorData> req = dS.deleteSensorData(data.getDateTime().getNanos());
    }
}

interface roomService{
    @POST("rooms/new")
    Call<Room_simple> createRoom(@Body Room_simple room);

    @GET("room")
    Call<List<Room_simple>> getAllRooms ();

    @GET("rooms/{room}")
    Call<Room_simple> getRoom (@Path("room") int room);

    @PUT("update/{id}")
    Call<Room_simple> updateRoom(@Path("id") int id, @Body Room_simple room);

    @DELETE("delete/{id}")
    Call<Room_simple> deleteRoom(@Path("id") int id);
}
interface userService {
    @POST("users/new")
    Call<User> createUser(@Body User user);

    @GET("users/{user}")
    Call<User> getUser(@Path("user") String user);

    @PUT("update/{id}")
    Call<User> updateUser(@Path("id") String id, @Body User user);

    @DELETE("delete/{id}")
    Call<User> deleteUser(@Path("id") String id);

    @GET("user/{username}/{password}")
    Call<User> loginUser(@Query("username") String username,@Query("password") String password);
}
interface dataService {
    @POST("sensorData/new")
    Call<SensorData> createSensorData(@Body SensorData sensorData);

    @GET("sensordata")
    Call<List<SensorData>> getAllSensorData (@Path("sensorData") int sensorData);

    @GET("sensorData/{sensorData}")
    Call<SensorData> getSensorData (@Path("sensorData") int sensorData);

    @PUT("update/{id}")
    Call<SensorData> updateSensorData(@Path("id") int id, @Body SensorData sensorData);

    @DELETE("delete/{id}")
    Call<SensorData> deleteSensorData(@Path("id") int id);
}
interface actionService{
    @POST("actiontrigger/new")
    Call<Action> createAction(@Body Action action);

    @GET("actiontrigger")
    Call<List<Action>> getAllAction (@Path("action") int action);

    @GET("actiontrigger/{action}")
    Call<Action> getAction (@Path("action") int action);

    @PUT("actiontrigger/{id}")
    Call<Action> updateAction(@Path("id") int id, @Body Action action);

    @DELETE("actiontrigger/{id}")
    Call<Action> deleteAction(@Path("id") int id);
}


