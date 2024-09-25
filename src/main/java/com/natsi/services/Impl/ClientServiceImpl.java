package com.natsi.services.Impl;

import com.natsi.entities.Client;
import com.natsi.entities.User;
import com.natsi.repositories.list.ClientRepository;
import com.natsi.repositories.list.Repository;
import com.natsi.repositories.list.Impl.ClientRepositoryList;
import com.natsi.services.ClientService;

import java.util.List;

public class ClientServiceImpl implements ClientService{
    Repository<User> userRepository;
    ClientRepository clientRepository;
    
    public ClientServiceImpl(Repository<User> userRepository, ClientRepository clientRepository) {
        this.userRepository = userRepository;
        this.clientRepository = clientRepository;
    }
    
    public void create(Client client){
        clientRepository.insert(client);    
    }
    public List<Client>findAll(){
        return clientRepository.selectAll();
    }
    public Client search(String teletphone){
        return clientRepository.selectBytelephone(teletphone);
    }
    
}
