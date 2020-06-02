package com.example.supermegatron4000.FileManager;

import android.os.AsyncTask;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class SensorDataFactory extends AppCompatActivity {


    public void insertSensorData(SensorData sensorData){

        InsertAsyncTask insertAsyncTask = new InsertAsyncTask();
        insertAsyncTask.execute(sensorData);
    }

    public List<SensorData> getAllSensorData(){

        getAllAsyncTask getAllAsyncTask = new getAllAsyncTask();
        getAllAsyncTask.execute();
        try {
            return getAllAsyncTask.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    class InsertAsyncTask extends AsyncTask<SensorData, Void, Void>{

        @Override
        protected Void doInBackground(SensorData... sensorData){
            AppDatabase.getInstance(getApplicationContext())
                    .SensorDataDao()
                    .insert(sensorData);

            return null;
        }
    }

    class getAllAsyncTask extends AsyncTask<Void, Void, List<SensorData>> {

        @Override
        protected List<SensorData> doInBackground(Void... voids){

            return AppDatabase.getInstance(getApplicationContext())
                    .SensorDataDao()
                    .getAll();
        }

    }


}

