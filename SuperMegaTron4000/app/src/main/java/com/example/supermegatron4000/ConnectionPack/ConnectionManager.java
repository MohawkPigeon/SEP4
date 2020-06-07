package com.example.supermegatron4000.ConnectionPack;

import androidx.lifecycle.MutableLiveData;

import com.example.supermegatron4000.model.myRoom;
import com.example.supermegatron4000.model.SensorData;
import com.example.supermegatron4000.model.User;
import com.example.supermegatron4000.model.Action;
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

        rS = retrofit.create(roomService.class); //opretter services baseret på indbyggede interfaces.
        uS = retrofit.create(userService.class);
        dS = retrofit.create(dataService.class);
        aS = retrofit.create(actionService.class);
        rS = retrofit.create(roomService.class);
    }

    public void getAllRooms(final MutableLiveData<List<myRoom>> rd){
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
    public void getRoom(int roomID, final MutableLiveData<myRoom> room){
        readRoom(roomID,room);
    }
    public void getAllAction(final MutableLiveData<List<Action>> action){
        readAllAction(action);
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
    public void get(myRoom t, int roomID, final MutableLiveData<myRoom> room){
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
    public void update(myRoom room){
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
    public void updateroom(myRoom room){
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
    public void create(myRoom room){
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
    public void delete(myRoom room){
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

    */

/*Room CRUD*/

    /*Room CRUD*/


    private void createRoom(myRoom room) {

        Call<myRoom> req = rS.createRoom(room); // opretter et kald udfra indbyggede interfaces.
                                                        //myRoom bliver passeret som parameter.
        req.enqueue(new Callback<myRoom>() {
            @Override
            public void onResponse(Call<myRoom> call, Response<myRoom> response) {

            }

            @Override
            public void onFailure(Call<myRoom> call, Throwable t) {
                System.out.println("Call failed, recieved: " + t); // SOUT hvis kaldet fejler printes fejlen til konsollet. Bruges til debugging.
            }
        });
    }

    private void readAllRooms(final MutableLiveData<List<myRoom>> rd) {

        Call<List<myRoom>> req = rS.getAllRooms();

        req.enqueue(new Callback<List<myRoom>>() {
            @Override
            public void onResponse(Call<List<myRoom>> call, Response<List<myRoom>> response) {
                if (response.isSuccessful()) {

                    rd.setValue(response.body()); //resultatet på kaldet bliver indsat i MutableLiveData variablet, som så læses andre steder.
                } else {
                    System.out.println("Response was not succesfull.\n");

                    rd.setValue(response.body());

                }
            }

            @Override
            public void onFailure(Call<List<myRoom>> call, Throwable t) {
                System.out.println("Call failed, recieved: " + t);
            }
        });
    }
    private void readRoom(int roomID, final MutableLiveData<myRoom> room){

        Call<myRoom> req = rS.getRoom(roomID);

        req.enqueue(new Callback<myRoom>() {
            @Override
            public void onResponse(Call<myRoom> call, Response<myRoom> response) {
                if(response.isSuccessful()){
                    room.setValue(response.body());
                    System.out.println("Print CO2 \n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println(room.getValue().getSensordata().get(1).getCO2());
                } else {
                    System.out.println("Response was not succesfull.\n");
                }
            }

            @Override
            public void onFailure(Call<myRoom> call, Throwable t) {
                System.out.println("Call faliled recieved: " + t);
            }
        });
    }
    private void updateRoom(myRoom room){
        Call<myRoom> req = rS.updateRoom(room.getId(), room);

        req.enqueue(new Callback<myRoom>() {
            @Override
            public void onResponse(Call<myRoom> call, Response<myRoom> response) {

            }

            @Override
            public void onFailure(Call<myRoom> call, Throwable t) {
                System.out.println("Call faliled recieved: " + t);
            }
        });

    }
    private void deleteRoom(myRoom room){
        Call<myRoom> req = rS.deleteRoom(room.getId());

        req.enqueue(new Callback<myRoom>() {
            @Override
            public void onResponse(Call<myRoom> call, Response<myRoom> response) {

            }

            @Override
            public void onFailure(Call<myRoom> call, Throwable t) {
                System.out.println("Call faliled recieved: " + t);
            }
        });
    }
    
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
    private void readAllAction(final MutableLiveData<List<Action>> action){

        Call<List<Action>> req = aS.getAllAction();
        req.enqueue(new Callback<List<Action>>() {
            @Override
            public void onResponse(Call<List<Action>> call, Response<List<Action>> response) {
                action.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Action>> call, Throwable t) {
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

        Call<Action> req = aS.updateAction(action.getId(), action);
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
        Call<Action> req = aS.deleteAction(action.getId());
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

        Call<SensorData> req = dS.updateSensorData(data.getId(), data);
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
        Call<SensorData> req = dS.deleteSensorData(data.getId());
    }
}

interface roomService{
    @POST("room")
    Call<myRoom> createRoom(@Body myRoom room);

    @GET("room")
    Call<List<myRoom>> getAllRooms ();

    @GET("room/{room}")
    Call<myRoom> getRoom (@Path("room") int room);

    @PUT("room/{id}")
    Call<myRoom> updateRoom(@Path("id") int id, @Body myRoom room);

    @DELETE("room/{id}")
    Call<myRoom> deleteRoom(@Path("id") int id);
}
interface userService {
    @POST("user")
    Call<User> createUser(@Body User user);

    @GET("user/{user}")
    Call<User> getUser(@Path("user") String user);

    @PUT("user/{id}")
    Call<User> updateUser(@Path("id") String id, @Body User user);

    @DELETE("user/{id}")
    Call<User> deleteUser(@Path("id") String id);

    @GET("user/{username}/{password}")
    Call<User> loginUser(@Query("username") String username,@Query("password") String password);
}
interface dataService {
    @POST("sensorData")
    Call<SensorData> createSensorData(@Body SensorData sensorData);

    @GET("sensordata")
    Call<List<SensorData>> getAllSensorData ();

    @GET("sensorData/{sensorData}")
    Call<SensorData> getSensorData (@Path("sensorData") int sensorData);

    @PUT("sensorData/{id}")
    Call<SensorData> updateSensorData(@Path("id") int id, @Body SensorData sensorData);

    @DELETE("sensorData/{id}")
    Call<SensorData> deleteSensorData(@Path("id") int id);
}
interface actionService{
    @POST("actiontrigger")
    Call<Action> createAction(@Body Action action);

    @GET("actiontrigger")
    Call<List<Action>> getAllAction ();

    @GET("actiontrigger/{action}")
    Call<Action> getAction (@Path("action") int action);

    @PUT("actiontrigger/{id}")
    Call<Action> updateAction(@Path("id") int id, @Body Action action);

    @DELETE("actiontrigger/{id}")
    Call<Action> deleteAction(@Path("id") int id);
}


