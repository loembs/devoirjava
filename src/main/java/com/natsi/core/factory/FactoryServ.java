package com.natsi.core.factory;

import com.natsi.services.MedecinService;
import com.natsi.services.Impl.MedecinServiceImpl;
import com.natsi.services.Impl.RdvServiceImpl;

public class FactoryServ {

        MedecinServiceImpl medServiceImpl= null;
        RdvServiceImpl rdServiceImpl= null;
        MedecinService mdServiceImpl= null;
        RdvServiceImpl rdvServiceImpl=null;
        FactoryRepo factoryrepo = new FactoryRepo();
        
    public MedecinService  getInstanceMedService(){
        if(mdServiceImpl==null){
            mdServiceImpl= new MedecinServiceImpl(medServiceImpl);
        }
        return  mdServiceImpl;
    }
    public    RdvServiceImpl getInstanceRdvServiceImpl(){
        if(rdvServiceImpl==null){
            rdvServiceImpl= new RdvServiceImpl(rdServiceImpl);
        }
        return  rdvServiceImpl;
    }
}
