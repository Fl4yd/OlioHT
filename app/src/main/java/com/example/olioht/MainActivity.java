package com.example.olioht;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class MainActivity extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        button = findViewById(R.id.kirjautumisSivu);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KirjautumisSivu();
            }
        });

    }
    public void KirjautumisSivu() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
    public void readXML (View v) {
        try {
            String ID;
            String name;
            storeData[] storeData_array;
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            String urlString = "https://www.finnkino.fi/xml/TheatreAreas/";
            Document doc = builder.parse(urlString);
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getDocumentElement().getElementsByTagName("TheatreArea");

            storeData_array = new storeData[nList.getLength()];

            for (int i = 0; i < nList.getLength(); i++) {
                storeData_array[i] = new storeData();
                Node node = nList.item(i);
                // System.out.println("Element is this: " + node.getNodeName());

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    ID = element.getElementsByTagName("ID").item(0).getTextContent();
                    storeData_array[i].setID(ID);
                    System.out.println("Theatre ID: "+storeData_array[i].getID());
                    name = element.getElementsByTagName("Name").item(0).getTextContent();
                    storeData_array[i].setName(name);
                    System.out.println("Theatre name: "+storeData_array[i].getName());
                    storeData_array[i].storeData(ID, name);

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } finally {
            System.out.println("The information has been stored.");
        }
    }
}