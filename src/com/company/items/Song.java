package com.company.items;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.Year;
import java.util.Date;

public class Song extends CatalogItem{
    private String path;

    public Song(String path, Year releaseYear) throws IOException {
        super(path, releaseYear);
        this.path = path;
    }

    @Override
    public void play() throws IOException {
        if(Desktop.isDesktopSupported()){
            Desktop desktop = Desktop.getDesktop();
            desktop.open(new File(path));
        }
    }
}
