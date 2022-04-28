package com.example.olioht;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.example.olioht.databinding.ActivityMainBinding;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class ViewActivity extends AppCompatActivity {
    ArrayList<movie> movies = new ArrayList<movie>();
    GridView gridView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        getSupportActionBar().hide();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        readXML();
        String[] names = new String[movies.size()];
        String[] images = new String[movies.size()];

        for (int i = 0; i < movies.size(); i++) {
            names[i] = movies.get(i).getName();
            images[i] = movies.get(i).getPicURL();
        }
        setContentView(R.layout.activity_view);
        button = findViewById(R.id.profileButton);
        gridView = findViewById(R.id.gridView);
        GridAdapter gridAdapter = new GridAdapter(ViewActivity.this, names, images);
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
        int counter1 = 0;
        int counter2 = 0;
        try {
            String title;
            String time;
            int releaseYear;
            int duration;
            String ageLimit;
            String genres;
            int ID;
            String picText;
            String picURL;
            String actors;
            String directors;
            storeData[] storeData_array;
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            String urlString = "https://www.finnkino.fi/xml/Events/";
            Document doc = builder.parse(urlString);
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getDocumentElement().getElementsByTagName("Event");

            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    title = element.getElementsByTagName("Title").item(0).getTextContent();
                    time = element.getElementsByTagName("dtLocalRelease").item(0).getTextContent();
                    releaseYear = Integer.parseInt(element.getElementsByTagName("ProductionYear").item(0).getTextContent());
                    duration = Integer.parseInt(element.getElementsByTagName("LengthInMinutes").item(0).getTextContent());
                    ageLimit = element.getElementsByTagName("Rating").item(0).getTextContent();
                    if (ageLimit != "(none)") {
                        ageLimit = element.getElementsByTagName("RatingImageUrl").item(0).getTextContent();
                    } else {
                        ageLimit = "https://media.finnkino.fi/images/rating_large_S.png";
                    }
                    genres = element.getElementsByTagName("Genres").item(0).getTextContent();
                    ID = Integer.parseInt(element.getElementsByTagName("ID").item(0).getTextContent());
                    picText = element.getElementsByTagName("Synopsis").item(0).getTextContent();
                    if (element.getElementsByTagName("EventMediumImagePortrait").item(0) != null) {
                        picURL = element.getElementsByTagName("EventMediumImagePortrait").item(0).getTextContent();
                    }else {
                        picURL = null;
                    }
                    actors = element.getElementsByTagName("Cast").item(0).getTextContent();
                    directors = element.getElementsByTagName("Directors").item(0).getTextContent();
                    movies.add(new movie(title, time, releaseYear, duration, ageLimit, genres, ID, picText, picURL, actors, directors));
                    Movies.getInstance().addMovie(ID ,new movie(title, time, releaseYear, duration, ageLimit, genres, ID, picText, picURL, actors, directors));
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
        }finally {
            System.out.println("The information has been stored.");

        }
    }
}