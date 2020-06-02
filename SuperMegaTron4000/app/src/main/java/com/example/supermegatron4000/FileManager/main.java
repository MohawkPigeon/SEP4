package com.example.supermegatron4000.FileManager;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;


public class main extends AppCompatActivity {

    public static void main(String[] args) {

        UserFactory userFactory = new UserFactory();

        User user = new User("bob","123",null,null);
        userFactory.insertUser(user);

        System.out.println(userFactory.getAllUsers().get(0).username);


    }
}
