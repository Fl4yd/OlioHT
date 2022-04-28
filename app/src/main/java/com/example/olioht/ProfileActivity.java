package com.example.olioht;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class ProfileActivity extends AppCompatActivity {

    TextView outputField;
    private Spinner theatreSpinner;
    View hbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_profile);
        outputField = findViewById(R.id.textView4);
        hbutton = findViewById(R.id.movie_history_btn);

        List<Theatre> Theatres = TheaterSingleton.get().getTheaters();

        theatreSpinner = findViewById(R.id.theatreSpinner);
        ArrayAdapter<Theatre> adapter = new ArrayAdapter<Theatre>(this, android.R.layout.simple_spinner_item, Theatres);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        theatreSpinner.setAdapter(adapter);

        hbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View h) {
                HistoryPage();
            }
        });


    }


    public void HistoryPage() {
        Intent intent = new Intent(this, HistoryActivity.class);
        startActivity(intent);
    }
    public void buttonpress (View v){
        Spinner mySpinner = findViewById(R.id.theatreSpinner);
        outputField.setText(mySpinner.getSelectedItem().toString());
    }

}