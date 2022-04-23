package com.example.olioht;

import java.util.ArrayList;

public class Elokuva {
    private String nimi;
    private String aika;
    private int julkaisuvuosi;
    private int kesto;
    private int ikaRaja;
    private ArrayList<String> genret = new ArrayList<String>();
    private int ID;
    private String kuvateksti;

    public Elokuva(String nimi, String aika, int julkaisuvuosi, int kesto, int ikaRaja, ArrayList<String> genret, int ID, String kuvateksti) {
        this.nimi = nimi;
        this.aika = aika;
        this.julkaisuvuosi = julkaisuvuosi;
        this.kesto = kesto;
        this.ikaRaja = ikaRaja;
        this.genret = genret;
        this.ID = ID;
        this.kuvateksti = kuvateksti;
    }

}
