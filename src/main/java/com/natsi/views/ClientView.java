package com.natsi.views;

import java.util.List;

import com.natsi.entities.Client;

public class ClientView extends ViewImpl<Client> {
public ClientView() {

}
public Client saisie(){
    Client client = new Client();
    System.out.println("Entrer le surnom");
    client.setSurname(scanner.nextLine());
    System.out.println("Entrer le telephone");
    client.setTelephone(scanner.nextLine());
    System.out.println("Entrer l'adresse");
    client.setAdresse(scanner.nextLine());
    scanner.nextLine();
    return client;

}
public void afficher(List<Client> datas) {
        for (Client data : datas) {
            if(data==null){
                return;
            }
            System.out.println(data);
        }           
       
}


    
}
