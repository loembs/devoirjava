package com.natsi.core.factory;

import com.natsi.views.MedecinView;
import com.natsi.views.RdViews;

public class FactoryView {
        MedecinView medView= null;
        RdViews rdvView= null;
        
    public  MedecinView getInstanceMedecinView(){
        if(medView==null){
            medView=new MedecinView();
        }
        return medView;
    }
    public  RdViews getInstanceArticleView(){
        if(rdvView==null){
            rdvView=new  RdViews();
        }
        return rdvView;
    }
    
}
