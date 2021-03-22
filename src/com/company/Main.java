package com.company;

import com.company.catalog.Catalog;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Year;

public class Main {

    public static void main(String[] args) {

        try {

            Catalog catalog = new Catalog();
            catalog.add("SONG", "C:\\Users\\Emilian\\Desktop\\Facultate\\Anul2\\A2S2\\PA\\Seminar 5\\David Guetta & Sia - Flames", Year.of(2018));
            catalog.add("SONG", "C:\\Users\\Emilian\\Desktop\\Facultate\\Anul2\\A2S2\\PA\\Seminar 5\\Matt Simons - Catch & Release", Year.of(2007));
            catalog.add("MOVIE", "C:\\Users\\Emilian\\Desktop\\From The Past\\Discursuri\\Toastmasters\\Cine nu are o Luminita sa-si cumpere!\\Cine nu are o Luminita, sa-si cumpere!", Year.of(2019));

            catalog.list();
            catalog.save("Catalog1");

            catalog.load("C:\\Users\\Emilian\\Desktop\\Facultate\\Anul2\\A2S2\\PA\\Seminar 5\\Catalog1");
            catalog.list();
            catalog.play(0);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
