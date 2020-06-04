package com.example.supermegatron4000.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.logappdev2.R;
import com.example.supermegatron4000.model.myRoom;

import pl.pawelkleczkowski.customgauge.CustomGauge;

public class RoomActivity extends AppCompatActivity {


    private int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room_view_layout);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        myRoom room = (myRoom) getIntent().getSerializableExtra("Selected_Room");



        TextView data = findViewById(R.id.dataView);
        TextView roomName = findViewById(R.id.roomNameTextView);
        Button minus = findViewById(R.id.minusBtn);
        Button plus = findViewById(R.id.plusBtn);
        roomName.setText(room.getRoomName());
        data.setText(room.getsData());


    }

}
