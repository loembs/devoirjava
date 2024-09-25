package com.natsi.views;

import java.util.ArrayList;
import java.util.List;

import com.natsi.entities.Client;
import com.natsi.entities.Etat;
import com.natsi.entities.Role;
import com.natsi.entities.User;
import com.natsi.services.Impl.ClientServiceImpl;

public class UserView extends ViewImpl<User> {
    //ClientServiceImpl clientServiceImpl=new ClientServiceImpl();
    Client cl1 ;
    public UserView(){

    }
    public User saisie(){
                    User user = new User();
                    int role;
                    System.out.println("Choisissez votre profil");
                    System.out.println("1-Creer un compte pour un client");
                    System.out.println("2-Creer un compte");
                    int choix1=scanner.nextInt();
                    scanner.nextLine();
                    switch (choix1) {
                        case 1: 
                            System.out.println("Entrer votre numero");
                            String numero=scanner.nextLine();
                           // cl1=clientServiceImpl.search(numero); 
                            System.out.println(cl1);
                            System.out.println("Entrer votre login");
                            user.setLogin(scanner.nextLine());
                            System.out.println("Entrer le nom");
                            user.setNom(scanner.nextLine());
                            System.out.println("Entrer le prenom");
                            user.setPrenom(scanner.nextLine());
                            System.out.println("Entrer le password");
                            user.setPassword(scanner.nextLine());
                            user.setClient(cl1);
                            user.setRole(Role.values()[1]);
                            if (cl1==null) {
                                System.out.println("Client est null");    
                            }
                                cl1.setUser(user);
                            break;
                        case 2:
                                System.out.println("Entrer votre login");
                                user.setLogin(scanner.nextLine());
                                System.out.println("Entrer le nom");
                                user.setNom(scanner.nextLine());
                                System.out.println("Entrer le prenom");
                                user.setPrenom(scanner.nextLine());
                                System.out.println("Entrer le password");
                                user.setPassword(scanner.nextLine());
                                System.out.println("Entrer votre status");
                                user.setRole(saisietype());
                                user.setEtat(Etat.values()[1]);
                                break;
                        default:
                            break;
                    }
        return user;
    }
    public static Role saisietype() {
        int type;
        do {
           System.out.println("1-Boutiquier");
           System.out.println("2-Client");
           System.out.println("3-Admin");
           type = scanner.nextInt();
        } while(type < 1 || type >4);
  
        return Role.values()[type - 1];
     }
     /*public List<User>  afficher(List<User> datas) {
        for (User data : datas) {
            if(data==null){
                return;
            }
            System.out.println(data);
        }           
       
}*/
    
}
