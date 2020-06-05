package com.example.supermegatron4000.FileManager;

import android.os.AsyncTask;

import androidx.appcompat.app.AppCompatActivity;

import com.example.supermegatron4000.model.myRoom;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class RoomFactory extends AppCompatActivity {


    public void insertRoom(myRoom room){

        InsertAsyncTask insertAsyncTask = new InsertAsyncTask();
        insertAsyncTask.execute(room);
    }

    public List<myRoom> getAllRooms(){

        getAllAsyncTask getAllAsyncTask = new getAllAsyncTask();
        getAllAsyncTask.execute();
        try {
            ActionFactory actionFactory = new ActionFactory();
            SensorDataFactory sensorDataFactory = new SensorDataFactory();
            List<myRoom> roomList = null;
            for (int i = 0; i < getAllAsyncTask.get().size(); i++){
                myRoom myRoom = getAllAsyncTask.get().get(i);
                myRoom.actionList = actionFactory.getWhereId(myRoom.actions);
                myRoom.sensorDataList = sensorDataFactory.getWhereId(myRoom.sData);

                roomList.add(myRoom);
            }
            return roomList;

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    class InsertAsyncTask extends AsyncTask<myRoom, Void, Void>{

        @Override
        protected Void doInBackground(myRoom... room){
            AppDatabase.getInstance(getApplicationContext())
                    .RoomDao()
                    .insert(room);

            return null;
        }
    }

    class getAllAsyncTask extends AsyncTask<Void, Void, List<myRoom>> {

        @Override
        protected List<myRoom> doInBackground(Void... voids){

            return AppDatabase.getInstance(getApplicationContext())
                    .RoomDao()
                    .getAll();
        }

    }


}

