package com.example.olioht;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    TextView username;
    TextView password;
    TextView rePassword;
    Button registerBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.setUsername);
        password = findViewById(R.id.setPassword);
        rePassword = findViewById(R.id.setRePassword);
        registerBtn = findViewById(R.id.register);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((username.getText().toString().isEmpty() == false)
                        && (password.getText().toString().isEmpty() == false)
                        && (rePassword.getText().toString().isEmpty() == false)
                        && rePassword.getText().toString() == password.getText().toString()) {
                    Toast.makeText(RegisterActivity.this, "valid registry", Toast.LENGTH_SHORT).show();
                }else {
                    if (username.getText().toString().isEmpty() == true) {
                        Toast.makeText(RegisterActivity.this, "Invalid username", Toast.LENGTH_SHORT).show();
                    }else if (password.getText().toString().isEmpty() == true) {
                        Toast.makeText(RegisterActivity.this, "Invalid Password", Toast.LENGTH_SHORT).show();
                    }else if (rePassword.getText().toString() == password.getText().toString()) {
                        Toast.makeText(RegisterActivity.this, "Not same password", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(RegisterActivity.this, "Something unexpected happened", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }
}