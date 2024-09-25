package com.natsi.views;

import java.util.List;

import com.natsi.entities.Medecin;
import com.natsi.entities.Rendezvous;

public class RdViews extends ViewImpl<Rendezvous>{
    public RdViews() {

}
public Rendezvous saisie(){
    Rendezvous rdv = new Rendezvous();
    System.out.println("Entrer date");
    rdv.setDate(scanner.nextLine());
    System.out.println("Entrer le heure");
    rdv.setHeure(scanner.nextLine());
    scanner.nextLine();
    return rdv;

}
public void afficher(List<Rendezvous> datas) {
        for (Rendezvous data : datas) {
            if(data==null){
                return;
            }
            System.out.println(data);
        }           
       
}
    
}
