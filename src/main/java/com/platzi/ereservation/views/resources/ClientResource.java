package com.platzi.ereservation.views.resources;

import com.platzi.ereservation.business.service.ClientService;
import com.platzi.ereservation.models.Client;
import com.platzi.ereservation.views.resources.vo.ClientVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class representing the Client web service.
 */
@RestController
@RequestMapping("/api/client")
public class ClientResource {

    private final ClientService clientService;

    public ClientResource(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody ClientVO clientVO) {
        Client client = new Client();
        client.setName(clientVO.getName());
        client.setLastName(clientVO.getLastName());
        client.setIdentification(clientVO.getIdentification());
        client.setAddress(clientVO.getAddress());
        client.setPhone(clientVO.getPhone());
        client.setEmail(clientVO.getEmail());

        return new ResponseEntity<>(clientService.create(client), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable("id") String identification, @RequestBody ClientVO clientVO) {
        Client client = clientService.findByIdentification(identification);

        if (client == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            client.setName(clientVO.getName());
            client.setLastName(clientVO.getLastName());
            client.setIdentification(clientVO.getIdentification());
            client.setAddress(clientVO.getAddress());
            client.setPhone(clientVO.getPhone());
            client.setEmail(clientVO.getEmail());
        }

        return new ResponseEntity<>(clientService.update(client), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void removeClient(@PathVariable("id") String identification) {
        Client client = clientService.findByIdentification(identification);

        if (client != null) {
            clientService.delete(client);
        }
    }

    @GetMapping
    public ResponseEntity<List<Client>> findAllClient() {
        return ResponseEntity.ok(clientService.findAll());
    }
}
