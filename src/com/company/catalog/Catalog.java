package com.company.catalog;

import com.company.exceptions.UnknownCatalogTypeException;
import com.company.items.CatalogItem;
import com.company.items.Movie;
import com.company.items.Song;

import java.io.*;
import java.time.Year;
import java.util.LinkedList;
import java.util.List;

public class Catalog {

    private List<CatalogItem> itemsList;

    public Catalog() {
        this.itemsList = new LinkedList<>();
    }

    public void add(String type, String path, Year releaseYear) throws UnknownCatalogTypeException, IOException {

        if(type.equals("SONG")){
            itemsList.add(new Song(path, releaseYear));
        } else if(type.equals("MOVIE")){
            itemsList.add(new Movie(path, releaseYear));
        } else{
            throw new UnknownCatalogTypeException(type);
        }
    }

    public void list() {
        for (var item: itemsList) {
            item.list();
        }
    }

    public void play(int index) throws IOException {
        itemsList.get(0).play();
    }

    public void save(String catalogName) throws IOException {
        FileOutputStream fileOut =
                new FileOutputStream("C:\\Users\\Emilian\\Desktop\\Facultate\\Anul2\\A2S2\\PA\\Seminar 5\\" + catalogName);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(itemsList);

        out.close();
        fileOut.close();
        System.out.printf("The catalog was saved at path " +
                "C:\\Users\\Emilian\\Desktop\\Facultate\\Anul2\\A2S2\\PA\\Seminar 5\\"  + catalogName);

    }

    /**
     *
     * @param path the path of the file to be deserialized
     */
    public void load(String path) {
//        CatalogItem currentItem;
        itemsList = new LinkedList<CatalogItem>();
        try {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            itemsList = (List<CatalogItem>) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("The catalog was loaded successfully");
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Catalog class not found");
            c.printStackTrace();
        }
    }

}
