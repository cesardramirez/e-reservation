package com.platzi.ereservation.business.service;

import com.platzi.ereservation.business.repository.ClientRepository;
import com.platzi.ereservation.models.Client;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Class that define services (operations) of the Client class.
 *
 * @Component y @Service tienen un comportamiento similar. El primero es global y el segundo más específico.
 *
 * En CrudRepository.class existen los métodos de save(), findById(), deleteById(), etc.
 * Estos serán los servicios que serán llamados y utilizados por el Front-end.
 *
 * @Transactional : Si se define a nivel de clase, todos los métodos serán tratados como transaccionales
 *   (que afectan a la base de datos). Si se le añade <p>readOnly = true</p> será tratado únicamente como modo lectura.
 *
 * rollbackFor = Exception.class : Cualquier método que arroje una excepción no verificada (RuntimeException o Error)
 *   activará el rollback automáticamente, pero, cualquier excepción de verificación no activará el rollback a menos
 *   que se le indique.
 */
@Service
//@Transactional(readOnly = true, rollbackFor = Exception.class)
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
    @Transactional
    public Client create(Client client) {
        return clientRepository.save(client);
    }

    /**
     * Service to update a client.
     * @param client
     * @return Client
     */
    @Transactional
    public Client update(Client client) {
        return clientRepository.save(client);
    }

    /**
     * Service to delete a client.
     * @param client
     */
    @Transactional
    public void delete(Client client) {
        clientRepository.delete(client);
    }

    /**
     * Service to find a client by ID.
     * @param identification
     */
    @Transactional(readOnly = true)
    public Client findByIdentification(String identification) {
        return clientRepository.findByIdentification(identification);
    }
}
