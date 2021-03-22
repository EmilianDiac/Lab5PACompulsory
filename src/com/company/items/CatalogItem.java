package com.company.items;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Date;

public abstract class CatalogItem implements Serializable {
    private Date lastModifiedDate;
    private Year releaseYear;
    private String path;
    private String title;


    public void list(){
        System.out.println("Title: " + title);
        System.out.println("Release Year: " + releaseYear);
        System.out.println("Path: " + path);
        SimpleDateFormat dt1 = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("Last Modified Date: " + dt1.format(lastModifiedDate));
        System.out.println("---------------------------------");
    }

    public abstract void play() throws IOException;

    public CatalogItem(String path,Year releaseYear) throws IOException {
        File file = new File(path);
        this.lastModifiedDate = new Date(file.lastModified());
        this.title = file.getName();
        this.releaseYear = releaseYear;
        this.path = path;
    }
}
