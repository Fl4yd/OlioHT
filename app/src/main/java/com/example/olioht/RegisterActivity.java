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
    DatabaseHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_register);

        DB = new DatabaseHelper(this);

        username = findViewById(R.id.setUsername);
        password = findViewById(R.id.setPassword);
        rePassword = findViewById(R.id.setRePassword);
        details = findViewById(R.id.details);

        registerBtn = findViewById(R.id.register);
        reLogin = findViewById(R.id.reLogin);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = rePassword.getText().toString();


                if (user.equals("") || pass.equals("") || repass.equals("")) {
                    details.setText("Please enter all the fields");
                }else {
                    if (pass.equals(repass)) {
                        Boolean checkuser = DB.checkusername(user);
                        details.setText("Username is taken");
                        if(checkuser==false) {
                            Boolean insert = DB.addCredentials(user, pass);
                            if(insert == true) {
                                Toast.makeText(RegisterActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(RegisterActivity.this, ViewActivity.class);
                                intent.putExtra("username",user);
                                startActivity(intent);
                            }
                        }
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