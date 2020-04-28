package com.platzi.ereservation.business.repository;

import com.platzi.ereservation.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Interface to define BD operations related to the Client.
 * JpaRepository<ClassBD, idClassBD>
 *
 * En JpaRepository.class ya están definidos los métodos CRUD para manipular la BD.
 */
public interface ClientRepository extends JpaRepository<Client, String> {

    List<Client> findByLastName(String lastName);

    // @NamedQuery in Client class
    Client findByIdentification(String identification);
}
