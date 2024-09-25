package com.natsi.entities;
import java.util.List;
import lombok.Data;
@Data
public class Medecin {
    private int id;
    private String nom;
    private String prenom;
    List<Rendezvous> rendezvouss;
    
}
