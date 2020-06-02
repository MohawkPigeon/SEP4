package com.example.supermegatron4000.FileManager;

import android.os.AsyncTask;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class ActionFactory extends AppCompatActivity {


    public void insertAction(Action action){

        InsertAsyncTask insertAsyncTask = new InsertAsyncTask();
        insertAsyncTask.execute(action);
    }

    public List<Action> getAllActions(){

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

    class InsertAsyncTask extends AsyncTask<Action, Void, Void>{

        @Override
        protected Void doInBackground(Action... action){
            AppDatabase.getInstance(getApplicationContext())
                    .ActionDao()
                    .insert(action);

            return null;
        }
    }

    class getAllAsyncTask extends AsyncTask<Void, Void, List<Action>> {

        @Override
        protected List<Action> doInBackground(Void... voids){

            return AppDatabase.getInstance(getApplicationContext())
                    .ActionDao()
                    .getAll();
        }

    }


}

