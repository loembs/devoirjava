package com.natsi.services;

import java.util.List;


import com.natsi.entities.Rendezvous;

public interface RdService {
    void create(Rendezvous rd);
    List<Rendezvous>findAll();
    Rendezvous searchById(int id);
    Rendezvous searchBydate(String date);
    
}
