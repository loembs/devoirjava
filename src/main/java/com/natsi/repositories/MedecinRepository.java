package com.natsi.repositories;

import com.natsi.entities.Medecin;

public interface MedecinRepository extends Repository<Medecin>{
    Medecin selectById(int id);
    Medecin selectByName(String name);
    
}
