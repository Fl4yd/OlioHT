package com.example.olioht;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ListView;

import java.util.ArrayList;

//Activity to show users ratings
public class HistoryActivity extends AppCompatActivity {
    ArrayList<movie> movies = new ArrayList<>();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_history);
// constructs the layout of the historyview, from the review entries in the review arraylist of this profile in the UserInfoBase.
        listView = findViewById(R.id.listView);
        ReviewAdapter reviewAdapter = new ReviewAdapter(HistoryActivity.this, UserinfoBase.get().getCurrentUser().getReviews(), 0);
        listView.setAdapter(reviewAdapter);
    }
}