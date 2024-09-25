package com.natsi.services.Impl;

import java.util.List;

import com.natsi.entities.Rendezvous;
import com.natsi.repositories.RdvRepository;
import com.natsi.services.RdService;

public class RdvServiceImpl implements RdService {
    
    private RdvRepository rdvRepository;

    public RdvServiceImpl(RdvServiceImpl rdvRepository) {
        this.rdvRepository = (RdvRepository) rdvRepository;
    }
     public void create(Rendezvous med){
       rdvRepository.insert(med);    
    }
    public List<Rendezvous>findAll(){
        return rdvRepository.selectAll();
    } 

    public Rendezvous searchBydate(String date){
        return rdvRepository.selectBydate(date);
    }
    @Override
    public Rendezvous searchById(int id) {
        return rdvRepository.selectById(id);
    }
    
}
