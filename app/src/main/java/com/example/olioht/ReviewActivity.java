package com.example.olioht;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.google.android.material.textfield.TextInputLayout;

public class ReviewActivity extends AppCompatActivity {
    ImageView upload;
    TextInputLayout reviewtextfield;
    private Spinner reviewrating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_review);
        reviewtextfield = findViewById(R.id.textInputLayout);
        upload = findViewById(R.id.upload_review_button);
        reviewrating = findViewById(R.id.review_score_spinner);



        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editable text = reviewtextfield.getEditText().getText();
                ReviewSingleton.get().AddReview(UserinfoBase.get().getCurrentUser().getmUser(), text.toString(), reviewrating.getSelectedItem().toString());
            }
        }
        );
    }
}