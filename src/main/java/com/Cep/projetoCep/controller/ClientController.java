package com.Cep.projetoCep.controller;

import com.Cep.projetoCep.model.Client;
import com.Cep.projetoCep.service.ClientService;
import com.Cep.projetoCep.service.impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("client")
public class ClientController {

    @Autowired
    private ClientServiceImpl clientService;

    @GetMapping
    public ResponseEntity<Iterable<Client>> findAll(){
        return ResponseEntity.ok(clientService.findAll());
    }
    @GetMapping("client/find/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id){
        return ResponseEntity.ok(clientService.findById(id));
    }

    @PostMapping("/register")
    public ResponseEntity<Client> addClient(@RequestBody Client client) {
        clientService.save(client);
        return ResponseEntity.ok(client);
    }

    @PutMapping("/updateClient/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client client) {
        clientService.update(id, client);
        return ResponseEntity.ok(client);
    }

    @DeleteMapping("/deleteClient/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        clientService.delete(id);
        return ResponseEntity.ok().build();
    }
}
