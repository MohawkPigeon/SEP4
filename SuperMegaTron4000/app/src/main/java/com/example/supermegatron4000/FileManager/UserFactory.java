package com.example.supermegatron4000.FileManager;

import android.os.AsyncTask;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class UserFactory extends AppCompatActivity {


    public void insertUser(User user){

        InsertAsyncTask insertAsyncTask = new InsertAsyncTask();
        insertAsyncTask.execute(user);
    }

    public List<User> getAllUsers(){

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

    class InsertAsyncTask extends AsyncTask<User, Void, Void>{

        @Override
        protected Void doInBackground(User... user){
            AppDatabase.getInstance(getApplicationContext())
                    .UserDao()
                    .insert(user);

            return null;
        }
    }

    class getAllAsyncTask extends AsyncTask<Void, Void, List<User>> {

        @Override
        protected List<User> doInBackground(Void... voids){

            return AppDatabase.getInstance(getApplicationContext())
                    .UserDao()
                    .getAll();
        }

    }


}
