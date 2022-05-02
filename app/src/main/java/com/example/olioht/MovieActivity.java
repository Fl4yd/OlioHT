package com.example.olioht;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MovieActivity extends AppCompatActivity {
    TextView movieName;
    ImageView ageLimit;
    ImageView moviePicture;
    TextView productionYear;
    TextView duration;
    TextView actors;
    TextView directors;
    String actorsString = "";
    TextView synopsis;
    TextView reviews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_movie);

        Intent intent = this.getIntent();
        moviePicture = findViewById(R.id.moviePicture);
        movieName = findViewById(R.id.movie_name);
        ageLimit = findViewById(R.id.ageLimit);
        productionYear = findViewById(R.id.productionYear);
        duration = findViewById(R.id.duration);
        actors = findViewById(R.id.actors);
        directors = findViewById(R.id.producers);
        synopsis = findViewById(R.id.setSynopsis);
        reviews = (TextView)findViewById(R.id.movieReview);


        if (intent != null) {
            int ID = intent.getIntExtra("id", 0);

            movie Movie = Movies.getInstance().searchMovie(ID);
            movieName.setText(Movie.getName());
            productionYear.setText(String.valueOf(Movie.getReleaseYear()));
            duration.setText(getTimeString(Movie.getDuration()));
            directors.setText(Movie.getDirectors());
            synopsis.setText(Movie.getSynopsis());
            Picasso.get().load(Movie.getAgeLimit()).into(ageLimit);
            Picasso.get().load(Movie.getPicURL()).into(moviePicture);
            parseString(Movie.getActors());
            actors.setText(this.actorsString);
            System.out.println(this.actorsString);

        }

        reviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int ID = intent.getIntExtra("id", 0);
                ReviewView(ID);
            }
        }
        );

    }
    public void ReviewView(int ID) {
        Intent intent = new Intent(getApplicationContext(), ReviewActivity.class);
        intent.putExtra("id", ID);
        startActivity(intent);
    }

    public void parseString(String string) {
        String[] split = string.replaceAll(" ", "").replaceAll("\n\n", " ").split("\n");

        String[] pairs = new String[split.length / 2];
        if (split.length == 1) {
            this.actorsString = "Actors not available";
            return          ;

        }else {
            for (int i = 0; i < split.length; i = i + 2) {
                pairs[i / 2] = split[i] + " " + split[i + 1].substring(0, split[i + 1].length());
            }
        }
        for (int i = 0; i < pairs.length; i++) {
            this.actorsString = (this.actorsString + pairs[i] + ", ");
        }
        this.actorsString = this.actorsString.substring(0, this.actorsString.length()-2);
    }

    public String getTimeString(int min) {
        int hours = (int) min / 60;
        int minutes = min % 60;
        return String.valueOf(hours) + " h " + String.valueOf(minutes) + " min";
    }



}

