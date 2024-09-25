package com.natsi.views;

import com.google.cloud.storage.Acl.User;
import com.mysql.cj.xdevapi.Client;
import com.natsi.core.factory.FactoryServ;
import com.natsi.core.factory.FactoryView;
import com.natsi.entities.Medecin;
import com.natsi.entities.Rendezvous;

import java.util.List;
import java.util.Scanner;



public class Main {
    private static Scanner  scanner= new Scanner(System.in);
    public static void main(String[] args) {

        FactoryView factoryView=new FactoryView();
        FactoryServ factoryServ=new FactoryServ();

        int choix;
        int choix2;
        String phone;
        do {
            choix=menu();
            scanner.nextLine();
            switch (choix) {
                    
                case 1:

                    factoryServ.getInstanceMedService().create(factoryView.getInstanceMedecinView().saisie());

                    break;
                case 2:
                    Rendezvous rdv = new Rendezvous();
                    System.out.println("Entrer date");
                    rdv.setDate(scanner.nextLine());
                    System.out.println("Entrer le heure");
                    rdv.setHeure(scanner.nextLine());
                    System.out.println("Add med");
                    List<Medecin> listClients = factoryServ.getInstanceMedService().findAll();
                    listClients.forEach(System.out::println);
                    int idmed = scanner.nextInt();
                    rdv.setMed(factoryServ.getInstanceMedService().searchById(idmed));
                    scanner.nextLine();
                    
                    break;
                case 3:
                    
                break;
                
                        }
                        
                    break;
               
            
        } while (choix!=5);
       
        
    }
    public static int menu(){
            System.out.println("1-Enregistrer medecin");
            System.out.println("2-Enregistrer RV");
            System.out.println("3-Lister RV");
            System.out.println("4-filtrer par date");
            System.out.println("5-Quitter");
            return scanner.nextInt();
    }

    
    
}