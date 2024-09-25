package com.natsi.services;

import java.util.List;

import com.natsi.entities.Medecin;

public interface MedecinService {
    void create(Medecin med);
    List<Medecin>findAll();
    Medecin search();
    Medecin searchById(int id);
    
}
