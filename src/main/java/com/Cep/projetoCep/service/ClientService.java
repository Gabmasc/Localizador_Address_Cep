package com.Cep.projetoCep.service;

import com.Cep.projetoCep.model.Client;

public interface ClientService {

    Iterable<Client> findAll();

    Client findById(Long id);

    void save(Client client);

    void update(Long id, Client client);

    void delete(Long id);
}
