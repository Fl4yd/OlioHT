package com.example.olioht;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
//Shows users profile
public class ProfileActivity extends AppCompatActivity {

    TextView outputField;
    TextView name;
    TextView age;
    int aloitus  = 1;
    private Spinner theatreSpinner;
    Button buttonHis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_profile);
        outputField = findViewById(R.id.textView4);
        theatreSpinner = findViewById(R.id.theatreSpinner);
        buttonHis = findViewById(R.id.movie_history_btn);
        name = findViewById(R.id.nameField);
        age = findViewById(R.id.ageField);

        List<Theatre> Theatres = TheaterSingleton.get().getTheaters();


        ArrayAdapter<Theatre> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Theatres);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        theatreSpinner.setAdapter(adapter);
        name.setText(UserinfoBase.get().getCurrentUser().getmName());
        age.setText(String.valueOf(UserinfoBase.get().getCurrentUser().getmAge()));
        outputField.setText(UserinfoBase.get().getCurrentUser().getmTheatre());

        // Here is the method for the spinner in profile, when a theatre is selected,
        // it uploads the the change to the profile information singleton(UserInfoBase)

        theatreSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (aloitus == 1) {
                    aloitus = 0;
                } else {
                    UserinfoBase.get().loadData(ProfileActivity.this);
                    outputField.setText(theatreSpinner.getSelectedItem().toString());
                    UserinfoBase.get().getCurrentUser().setmTheatre(theatreSpinner.getSelectedItem().toString());
                    UserinfoBase.get().getUserData(UserinfoBase.get().getCurrentUser().getmName()).setmTheatre(theatreSpinner.getSelectedItem().toString());
                    UserinfoBase.get().saveData(ProfileActivity.this);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //Button to get to historyview
        buttonHis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( ProfileActivity.this, HistoryActivity.class);
                startActivity(intent);
            }
        });

    }

}