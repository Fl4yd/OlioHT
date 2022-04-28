package com.example.olioht;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SetupProfileActivity extends AppCompatActivity {

    String user;
    String pass;
    EditText nameTextView;
    EditText ageTextView;
    TextView details;
    String name;
    Button registerButton;
    Spinner theatre;
    int age;
    DatabaseHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_setup_profile);
        DB = new DatabaseHelper(this);
        nameTextView = findViewById(R.id.setName);
        ageTextView = findViewById(R.id.setAge);
        details = findViewById(R.id.details2);
        registerButton = findViewById(R.id.register);
        name = nameTextView.getText().toString();
        System.out.println("Moi");
        System.out.println("My name is " + name);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = nameTextView.getText().toString();
                age =  Integer.parseInt(ageTextView.getText().toString());
                if (name.isEmpty()) {
                    details.setText("Please enter all the fields");
                }else if (age > 100 || age < 1) {
                    details.setText("Set proper age");
                }else {
                    Intent retrieveExtras = getIntent();
                    user = retrieveExtras.getStringExtra("username");
                    pass = retrieveExtras.getStringExtra("password");

                    Boolean insert = DB.addCredentials(user, pass);

                    if (insert == true) {
                        Toast.makeText(SetupProfileActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SetupProfileActivity.this, ViewActivity.class);
                        intent.putExtra("username", user);
                        startActivity(intent);
                    }
                }
            }
        });


    }
}