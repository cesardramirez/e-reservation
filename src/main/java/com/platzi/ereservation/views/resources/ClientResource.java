package com.platzi.ereservation.views.resources;

import com.platzi.ereservation.business.service.ClientService;
import com.platzi.ereservation.models.Client;
import com.platzi.ereservation.views.resources.vo.ClientVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class representing the Client web service.
 */
@RestController
@RequestMapping("/api/client")
@Api(tags = "client")
public class ClientResource {

    private final ClientService clientService;

    public ClientResource(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    @ApiOperation(value = "Create client", notes = "Service to create a new client.")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Client created successfully."),
        @ApiResponse(code = 400, message = "Invalid request.")
    })
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
    @ApiOperation(value = "Update client", notes = "Service to update a client.")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Client successfully updated."),
        @ApiResponse(code = 404, message = "Client not found.")
    })
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
    @ApiOperation(value = "Delete client", notes = "Service to delete a client.")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Client successfully removed."),
        @ApiResponse(code = 404, message = "Client not found.")
    })
    public void removeClient(@PathVariable("id") String identification) {
        Client client = clientService.findByIdentification(identification);

        if (client != null) {
            clientService.delete(client);
        }
    }

    @GetMapping
    @ApiOperation(value = "List all clients.", notes = "Service to list all clients.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Clients found."),
            @ApiResponse(code = 404, message = "Clients not found.")
    })
    public ResponseEntity<List<Client>> findAllClient() {
        return ResponseEntity.ok(clientService.findAll());
    }
}
