package com.example.olioht;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MovieActivity extends AppCompatActivity {
    TextView movieName;
    ImageView ageLimit;
    TextView productionYear;
    TextView duration;
    TextView actors;
    TextView directors;

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
        directors = findViewById(R.id.producers);

        if(intent != null) {
            int ID = intent.getIntExtra("id", 0);

            movie Movie = Movies.getInstance().searchMovie(ID);
            movieName.setText(Movie.getName());
            productionYear.setText(String.valueOf(Movie.getReleaseYear()));
            duration.setText(String.valueOf(Movie.getDuration()));
            actors.setText(Movie.getActors());
            directors.setText(Movie.getDirectors());
            Picasso.get().load(Movie.getAgeLimit()).into(ageLimit);
            String[] pairs = parseString(Movie.getActors());

            for(int i = 0; i < pairs.length; i++) {
                System.out.println(pairs[i]);
            }
        }

    }

    public String[] parseString(String string) {
        String[] split = string.replaceAll(" ", "").replaceAll("\n\n", " ").split("\n");
        String[] pairs = new String[split.length/2];
        for(int i = 0; i < split.length; i = i + 2) {
            pairs[i/2] = split[i] + " " + split[i+1];
        }

        for(int i = 0; i < pairs.length; i++) {
            System.out.println(pairs[i]);
        }
        return pairs;
    }



}

