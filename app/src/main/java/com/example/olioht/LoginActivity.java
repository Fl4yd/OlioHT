package com.example.olioht;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        TextView username = (TextView) findViewById(R.id.username);
        TextView password = (TextView) findViewById(R.id.password);


        Button loginbtn = (Button) findViewById(R.id.login);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
                    Toast.makeText(LoginActivity.this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show();
                    Login();
                //}else {
                //    Toast.makeText(LoginActivity.this, "LOGIN FAILED", Toast.LENGTH_SHORT).show();
                //}
            }
        });
    }


    public void Login() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}