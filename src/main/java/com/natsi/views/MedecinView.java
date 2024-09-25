package com.natsi.views;

import java.util.List;

import com.natsi.entities.Medecin;

public class MedecinView extends ViewImpl<Medecin> {
public MedecinView() {

}
public Medecin saisie(){
    Medecin med = new Medecin();
    System.out.println("Entrer le nom");
    med.setNom(scanner.nextLine());
    System.out.println("Entrer le prenom");
    med.setPrenom(scanner.nextLine());
    scanner.nextLine();
    return med;

}
public void afficher(List<Medecin> datas) {
        for (Medecin data : datas) {
            if(data==null){
                return;
            }
            System.out.println(data);
        }           
       
}


    
}
