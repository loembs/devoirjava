package com.natsi.entities;

import java.util.List;
import lombok.Data;
@Data

public class Article {
    private int id;
    private String ref;
    private String libelle;
    private int prix;
    private int qtestock;
    List<Detail> details;
    private static int nbr;

    public Article() {
        this.id =nbr++;
        int size=String.valueOf(id).length();
        this.ref ="A"+"O".repeat(size>4?0:4-size)+id; 
    }
    public Article(String ref ) {
        this.id =nbr++;
        this.ref=ref;
    }
    
}
