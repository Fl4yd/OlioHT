package com.example.olioht;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    EditText rePassword;
    TextView details;
    Button registerBtn;
    Button reLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.setUsername);
        password = findViewById(R.id.setPassword);
        rePassword = findViewById(R.id.setRePassword);
        details = findViewById(R.id.details);
        registerBtn = findViewById(R.id.register);
        reLogin = findViewById(R.id.reLogin);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((username.getText().toString().isEmpty() == false)
                        && (password.getText().toString().isEmpty() == false)
                        && (rePassword.getText().toString().isEmpty() == false)
                        && rePassword.getText().toString() == password.getText().toString()) {
                }else {
                    if (username.getText().toString().isEmpty() == true) {
                        Toast.makeText(RegisterActivity.this, "Invalid username", Toast.LENGTH_SHORT).show();
                        System.out.println("Invalid username");
                        details.setText("Invalid username");
                    }else if (password.getText().toString().isEmpty() == true) {
                        Toast.makeText(RegisterActivity.this, "Invalid Password", Toast.LENGTH_SHORT).show();
                        System.out.println("Invalid Password");
                        details.setText("Invalid Password");
                    }else if (!(rePassword.getText().toString().equals(password.getText().toString()))) {
                        Toast.makeText(RegisterActivity.this, "Not same password", Toast.LENGTH_SHORT).show();
                        System.out.println("Not same password");
                        details.setText("Not same password");
                    }else{
                        Toast.makeText(RegisterActivity.this, "Something unexpected happened", Toast.LENGTH_SHORT).show();
                        System.out.println("Registered successfully");
                        details.setText("Registered successfully");
                    }

                }
            }
        });
        reLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });


    }
}