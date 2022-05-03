package com.example.olioht;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;



//View to see all the movies and get access to movie page

public class ViewActivity extends AppCompatActivity {
    ArrayList<movie> movies = new ArrayList<movie>();
    ArrayList<movie> moviesRated = new ArrayList<movie>();
    int age = 0;
    GridView gridView;
    Button button;
    EditText editText;
    Adapter gridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        getSupportActionBar().hide();
        int age  = UserinfoBase.get().getCurrentUser().getmAge();
        System.out.println(age);
        readXML();



        movies = Movies.getInstance().getAgeLimitedList(age);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_view);
        button = findViewById(R.id.profileButton);
        gridView = findViewById(R.id.gridView);
        editText = findViewById(R.id.searchLine);
        gridAdapter = new Adapter(ViewActivity.this, movies);
        gridView.setAdapter(gridAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int id = movies.get(i).getID();
                MovieView(id);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProfileView();
            }
        });
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                movies = Movies.getInstance().getFilteredList(editText.getText().toString());
                Adapter gridAdapter = new Adapter(ViewActivity.this, movies);
                gridView.setAdapter(gridAdapter);
                gridAdapter.notifyDataSetChanged();
                return false;
            }
        });

    }

    public void FilterView(String text, Adapter adapter) {
        System.out.print(editText.getText().toString());
        movies = Movies.getInstance().getFilteredList(editText.getText().toString());
        System.out.println(movies.size());



    }
    public void ProfileView() {
        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
        startActivity(intent);
    }
    public void MovieView(int id) {
        Intent intent = new Intent(getApplicationContext(), MovieActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }

    public void readXML () {
        try {
            String title;
            String time;
            int releaseYear;
            int duration;
            String ageLimit;
            String ageLimitUrl;
            int ID;
            String picURL;
            String actors;
            String directors;
            String synopsis;
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            String urlString = "https://www.finnkino.fi/xml/Events/";
            Document doc = builder.parse(urlString);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getDocumentElement().getElementsByTagName("Event");

            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    ID = Integer.parseInt(element.getElementsByTagName("ID").item(0).getTextContent());
                    title = element.getElementsByTagName("Title").item(0).getTextContent();
                    time = element.getElementsByTagName("dtLocalRelease").item(0).getTextContent();
                    releaseYear = Integer.parseInt(element.getElementsByTagName("ProductionYear").item(0).getTextContent());
                    duration = Integer.parseInt(element.getElementsByTagName("LengthInMinutes").item(0).getTextContent());
                    ageLimit = element.getElementsByTagName("Rating").item(0).getTextContent();
                    ageLimit = ageLimit.trim();

                    //XML file has "undefined" ratings this fixes the bug by implementing hard coded ratings
                    if (ageLimit != "(none)" && !ageLimit.contains("Luok") && !ageLimit.contains("Tulossa") && !ageLimit.contains("S")) {
                        ageLimitUrl = element.getElementsByTagName("RatingImageUrl").item(0).getTextContent();
                    } else {
                        ageLimitUrl = "https://media.finnkino.fi/images/rating_large_S.png";
                        ageLimit = "0";
                    }
                    if (element.getElementsByTagName("EventMediumImagePortrait").item(0) != null) {
                        picURL = element.getElementsByTagName("EventMediumImagePortrait").item(0).getTextContent();
                    }else {
                        picURL = null;
                    }
                    actors = element.getElementsByTagName("Cast").item(0).getTextContent();
                    directors = element.getElementsByTagName("Directors").item(0).getTextContent();
                    synopsis = element.getElementsByTagName("Synopsis").item(0).getTextContent();
                    Movies.getInstance().addMovie(ID ,new movie(title, time, releaseYear, duration, Integer.parseInt(ageLimit), ageLimitUrl, ID, picURL, actors, directors, synopsis));

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } finally {
        }

    }
}