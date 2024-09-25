package com.natsi.core.factory;

import com.natsi.repositories.MedecinRepository;
import com.natsi.repositories.bd.MedecinRepositoryBD;
import com.natsi.repositories.bd.RendezVousRepositoryBD;

public class FactoryRepo {
     
        private  MedecinRepository medRepository=null;
        private  RendezVousRepositoryBD rdvRepo=null;
        
    public  MedecinRepository getInstanceMedecinRepository(){
        if(medRepository==null){
            medRepository=new MedecinRepositoryBD();
        }
        return medRepository;
    }
   
    public  RendezVousRepositoryBD  getInstanceRdvRepository(){
        if(rdvRepo==null){
            rdvRepo= new RendezVousRepositoryBD();
        }
        return  rdvRepo;
    }

    
}
