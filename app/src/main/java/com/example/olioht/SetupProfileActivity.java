package com.example.olioht;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

//Activity for the Profile setup
public class SetupProfileActivity extends AppCompatActivity {

    String user;
    String pass;
    EditText nameTextView;
    EditText ageTextView;
    TextView details;
    String name;
    Button registerButton;
    Spinner theatre;
    String selectedTheatre;
    int age;
    Spinner theatreSpinner;
    Button reLogin;

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
        reLogin = findViewById(R.id.reLogin);
        theatreSpinner = findViewById(R.id.profileSpinner);
        List<Theatre> Theatres = TheaterSingleton.get().getTheaters();
        ArrayAdapter<Theatre> adapter = new ArrayAdapter<Theatre>(this, android.R.layout.simple_spinner_item, Theatres);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        theatreSpinner.setAdapter(adapter);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = nameTextView.getText().toString();
                age =  Integer.parseInt(ageTextView.getText().toString());
                selectedTheatre = theatreSpinner.getSelectedItem().toString();
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
                        UserinfoBase.get().loadData(SetupProfileActivity.this);
                        UserinfoBase.get().addUser(user, age, name, selectedTheatre);
                        UserinfoBase.get().selectUser(user);
                        UserinfoBase.get().saveData(SetupProfileActivity.this);
                        Toast.makeText(SetupProfileActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SetupProfileActivity.this, ViewActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });
        reLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(SetupProfileActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });


    }
}