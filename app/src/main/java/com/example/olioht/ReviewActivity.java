package com.example.olioht;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;

import com.google.android.material.textfield.TextInputLayout;


public class ReviewActivity extends AppCompatActivity {
    ImageView upload;
    TextInputLayout reviewtextfield;
    private Spinner reviewrating;
    ListView listView;
    int size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_review);



        Intent intent = this.getIntent();
        int ID = intent.getIntExtra("id", 0);
        reviewtextfield = findViewById(R.id.textInputLayout);
        upload = findViewById(R.id.upload_review_button);
        reviewrating = findViewById(R.id.review_score_spinner);
        size = Movies.getInstance().searchMovie(ID).getReviews().size();
        listView = findViewById(R.id.listView1);
        ReviewAdapter reviewAdapter = new ReviewAdapter(ReviewActivity.this, Movies.getInstance().searchMovie(ID).getReviews(), 1);
        listView.setAdapter(reviewAdapter);




        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editable text = reviewtextfield.getEditText().getText();
                Review review = new Review(UserinfoBase.get().getCurrentUser().getmUser(), text.toString(), reviewrating.getSelectedItem().toString(), ID);
                UserinfoBase.get().getCurrentUser().addReview(review);
                Movies.getInstance().searchMovie(ID).addReview(review);

            }
        }
        );

    }
}