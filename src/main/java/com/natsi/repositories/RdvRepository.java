package com.natsi.repositories;

import com.natsi.entities.Rendezvous;

public interface RdvRepository extends Repository<Rendezvous>{
    Rendezvous selectById(int id);
    Rendezvous selectBydate(String date);
    
} 
