package com.example.olioht;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

public class MovieActivity extends AppCompatActivity {
    TextView movieName;
    TextView ageLimit;
    TextView productionYear;
    TextView duration;
    TextView actors;
    TextView producers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_movie);

        Intent intent = this.getIntent();

        movieName = findViewById(R.id.movie_name);
        ageLimit = findViewById(R.id.ageLimit);
        productionYear = findViewById(R.id.productionYear);
        duration = findViewById(R.id.duration);
        actors = findViewById(R.id.actors);
        producers = findViewById(R.id.producers);

        if(intent != null) {
            int ID = intent.getIntExtra("id", 0);

            movie Movie = Movies.getInstance().searchMovie(ID);
            movieName.setText(Movie.getName());
            ageLimit.setText(String.valueOf(Movie.getAgeLimit()));
            productionYear.setText(String.valueOf(Movie.getReleaseYear()));
            duration.setText(String.valueOf(Movie.getDuration()));
        }

    }
}