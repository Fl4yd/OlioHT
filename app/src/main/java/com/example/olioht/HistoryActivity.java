package com.example.olioht;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ListView;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {
    ArrayList<movie> movies = new ArrayList<movie>();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        movies.add(Movies.getInstance().searchMovie(303322));
        movies.add(Movies.getInstance().searchMovie(303583));
        movies.add(Movies.getInstance().searchMovie(303884));

        String[] names = new String[movies.size()];
        String[] images = new String[movies.size()];

        for (int i = 0; i < movies.size(); i++) {
            names[i] = movies.get(i).getName();
            images[i] = movies.get(i).getPicURL();
        }
        setContentView(R.layout.activity_history);

        listView = findViewById(R.id.listView);
        ListAdapter listAdapter = new ListAdapter(HistoryActivity.this, names, images);
        listView.setAdapter(listAdapter);
    }
}