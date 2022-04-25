package com.example.olioht;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.olioht.databinding.ActivityMainBinding;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class ViewActivity extends AppCompatActivity {
    ArrayList<movie> movies = new ArrayList<movie>();
    GridView gridView;

    //String [] names = {"Kissa1", "Kissa2", "Kissa3", "Kissa4", "Kissa5", "Kissa6"};
    //String[] images = {"https://media.finnkino.fi/1012/Event_13317/portrait_medium/FantasticBeasts3_1080b.jpg","https://media.finnkino.fi/1012/Event_13317/portrait_medium/FantasticBeasts3_1080b.jpg","https://media.finnkino.fi/1012/Event_13317/portrait_medium/FantasticBeasts3_1080b.jpg","https://media.finnkino.fi/1012/Event_13317/portrait_medium/FantasticBeasts3_1080b.jpg","https://media.finnkino.fi/1012/Event_13317/portrait_medium/FantasticBeasts3_1080b.jpg","https://media.finnkino.fi/1012/Event_13317/portrait_medium/FantasticBeasts3_1080b.jpg"};

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

        gridView = findViewById(R.id.gridView);
        GridAdapter gridAdapter = new GridAdapter(ViewActivity.this, names, images);
        gridView.setAdapter(gridAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int id = movies.get(i).getID();
                Intent intent = new Intent(getApplicationContext(), MovieActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });

    }
    public void readXML () {
        try {
            String title;
            String time;
            int releaseYear;
            int duration;
            int ageLimit;
            String genres;
            int ID;
            String picText;
            String picURL;
            storeData[] storeData_array;
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            String urlString = "https://www.finnkino.fi/xml/Schedule/";
            Document doc = builder.parse(urlString);
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getDocumentElement().getElementsByTagName("Show");

            storeData_array = new storeData[nList.getLength()];
            int identifier = 0;
            for (int i = 0; i < nList.getLength(); i++) {
                storeData_array[i] = new storeData();
                Node node = nList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    title = element.getElementsByTagName("Title").item(0).getTextContent();
                    time = element.getElementsByTagName("dtAccounting").item(0).getTextContent();
                    releaseYear = Integer.parseInt(element.getElementsByTagName("ProductionYear").item(0).getTextContent());
                    duration = Integer.parseInt(element.getElementsByTagName("LengthInMinutes").item(0).getTextContent());
                    String temp;
                    if((temp = element.getElementsByTagName("Rating").item(0).getTextContent()) == "S") {
                        ageLimit = 0;
                    }else {
                        ageLimit = 0;
                        //ageLimit = Integer.parseInt(temp);
                    }
                    genres = element.getElementsByTagName("Genres").item(0).getTextContent();
                    ID = Integer.parseInt(element.getElementsByTagName("EventID").item(0).getTextContent());
                    picText = element.getElementsByTagName("ShowURL").item(0).getTextContent();
                    picURL = element.getElementsByTagName("EventMediumImagePortrait").item(0).getTextContent();
                    movies.add(new movie(title, time, releaseYear, duration, ageLimit, genres, ID, picText, picURL));
                    Movies.getInstance().addMovie(ID ,new movie(title, time, releaseYear, duration, ageLimit, genres, ID, picText, picURL));
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