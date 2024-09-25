package com.natsi.services;

import com.natsi.entities.Client;
import java.util.List;

public interface ClientService {
    void create(Client client);
    List<Client>findAll();
    Client search(String teletphone);
}
