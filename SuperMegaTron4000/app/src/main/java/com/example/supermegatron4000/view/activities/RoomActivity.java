package com.example.supermegatron4000.view.activities;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.logappdev2.R;

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

        final TextView gaugeText = findViewById(R.id.gaugeText);
        final CustomGauge gauge = findViewById(R.id.customGauge);
        Button minus = findViewById(R.id.minusBtn);
        Button plus = findViewById(R.id.plusBtn);
        gaugeText.setText(String.valueOf(gauge.getValue()));

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gauge.setStartValue(0);
                gauge.setEndValue(100);
                if (i==gauge.getEndValue()){

                }
                else {
                    gauge.setValue(i+5);
                    gaugeText.setText(String.valueOf(gauge.getValue()));
                    i+=5;
                }
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gauge.setStartValue(0);
                gauge.setEndValue(100);
                if (i==gauge.getStartValue()){

                }
                else {
                    gauge.setValue(i-5);
                    gaugeText.setText(String.valueOf(gauge.getValue()));
                    i-=5;
                }
            }
        });

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.ActionsList, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter);
    }
}
