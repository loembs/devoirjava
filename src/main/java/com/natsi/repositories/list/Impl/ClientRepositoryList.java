package com.natsi.repositories.list.Impl;
import com.natsi.entities.Client;
import com.natsi.repositories.list.ClientRepository;

public class ClientRepositoryList extends RepositoryImpl<Client> implements ClientRepository {
    
    public  Client selectBytelephone(String telephone){
        return list.stream()
                .filter(client ->client.getTelephone().equals(telephone))
                .findFirst()
                .orElse(null);
    }
    
}
