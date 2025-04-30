package com.Cep.projetoCep.service.impl;

import com.Cep.projetoCep.model.Address;
import com.Cep.projetoCep.model.Client;
import com.Cep.projetoCep.repository.AddressRepository;
import com.Cep.projetoCep.repository.ClientRepository;
import com.Cep.projetoCep.service.ClientService;
import com.Cep.projetoCep.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.isPresent() ? client.get() : null;
    }

    @Override
    public void save(Client client) {
        String cep = client.getAddress().getCep();
        Address address = addressRepository.findById(Long.valueOf(cep)).orElseGet(() -> {
            Address newAddress = viaCepService.queryCep(cep);
            addressRepository.save(newAddress);
            return newAddress; });
        client.setAddress(address);
        clientRepository.save(client);
    }

    @Override
    public void update(Long id, Client client) {
        Optional<Client> client1 = clientRepository.findById(id);
        if (client1.isPresent()){
            String cep = client.getAddress().getCep();
            Address address = addressRepository.findById(Long.valueOf(cep)).orElseGet(() -> {
                Address newAddress = viaCepService.queryCep(cep);
                addressRepository.save(newAddress);
                return newAddress; });
            client.setAddress(address);
            clientRepository.save(client);
        }
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }
}
