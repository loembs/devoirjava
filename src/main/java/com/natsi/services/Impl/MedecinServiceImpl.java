package com.natsi.services.Impl;

import java.util.List;

import com.mysql.cj.xdevapi.Client;
import com.natsi.entities.Medecin;
import com.natsi.repositories.MedecinRepository;
import com.natsi.services.MedecinService;

public class MedecinServiceImpl implements MedecinService {
     MedecinRepository medecinRepository;

   public MedecinServiceImpl(MedecinServiceImpl medecinRepository) {
        this.medecinRepository = (MedecinRepository) medecinRepository;
    }
     public void create(Medecin med){
        medecinRepository.insert(med);    
    }
    public List<Medecin>findAll(){
        return medecinRepository.selectAll();
    } 
    public Medecin search(String name){
        return medecinRepository.selectByName(name);
    }
    public Medecin searchById(int id){
        return medecinRepository.selectById(id);
    }
    @Override
    public Medecin search() {

        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }
  
}
