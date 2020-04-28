package com.platzi.ereservation.business.service;

import com.platzi.ereservation.business.repository.ClientRepository;
import com.platzi.ereservation.models.Client;
import org.springframework.stereotype.Service;
/**
 * Class that define services (operations) of the Client class.
 *
 * @Component y @Service tienen un comportamiento similar. El primero es global y el segundo más específico.
 *
 * En CrudRepository.class existen los métodos de save(), findById(), deleteById(), etc.
 * Estos serán los servicios que serán llamados y utilizados por el Front-end.
 */
@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    /**
     * Service to save a client.
     * @param client
     * @return Client
     */
    public Client create(Client client) {
        return clientRepository.save(client);
    }

    /**
     * Service to update a client.
     * @param client
     * @return Client
     */
    public Client update(Client client) {
        return clientRepository.save(client);
    }

    /**
     * Service to delete a client.
     * @param client
     */
    public void delete(Client client) {
        clientRepository.delete(client);
    }

    /**
     * Service to find a client by ID.
     * @param identification
     */
    public Client findByIdentification(String identification) {
        return clientRepository.findByIdentification(identification);
    }
}
