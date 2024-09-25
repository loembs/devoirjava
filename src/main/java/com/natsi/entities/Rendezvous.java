package com.natsi.entities;
import lombok.Data;
@Data
public class Rendezvous {
    private int id;
    private String date;
    private String heure;
    private Medecin med;
    
}
