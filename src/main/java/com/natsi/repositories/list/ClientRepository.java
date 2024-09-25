package com.natsi.repositories.list;

import com.natsi.entities.Client;

public interface ClientRepository extends Repository<Client> {
    Client selectBytelephone(String telephone);
    
}
