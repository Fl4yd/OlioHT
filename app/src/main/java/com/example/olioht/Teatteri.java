package com.example.olioht;

import java.util.ArrayList;

public class Teatteri {
    private ArrayList<Elokuva> elokuvat = new ArrayList<Elokuva>();

    public Teatteri() {

    }

    public void lisaaElokuva(String nimi, String aika, int julkaisuvuosi, int kesto, int ikaRaja, ArrayList<String> genret, int ID, String kuvateksti) {

        elokuvat.add(new Elokuva(nimi, aika, julkaisuvuosi, kesto, ikaRaja, genret, ID, kuvateksti));
    }
}
