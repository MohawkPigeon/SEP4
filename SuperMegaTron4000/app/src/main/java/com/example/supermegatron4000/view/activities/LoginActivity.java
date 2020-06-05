package com.example.supermegatron4000.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.example.logappdev2.R;


public class LoginActivity extends AppCompatActivity {

    private Button btn;
    private CheckBox rbtn;
    private String username, password;
    private EditText usernameText, passwordText;
    private CheckBox box;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.login_view_layout);
        getSupportActionBar().hide();

        box = findViewById(R.id.checkBox);
        usernameText = findViewById(R.id.username);
        passwordText = findViewById(R.id.password);
        btn = findViewById(R.id.log_in_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (usernameText.getText().toString().equals("sep4@gmail.com")&&passwordText.getText().toString().equals("password") || box.isChecked()){
                    openHomePage();
                }
                else{
                    Toast.makeText(v.getContext(), "Incorrect email or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void openHomePage(){
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }

    public void openAdminPage(){
        Intent intent = new Intent(this, InstallerActivity.class);
        startActivity(intent);
    }

    public void update (){

    }
}
