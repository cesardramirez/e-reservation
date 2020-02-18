package com.platzi.ereservation.business.repository;

import com.platzi.ereservation.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * Interface to define BD operations related to the Reservation.
 * JpaRepository<ClassBD, idClassBD>
 *
 * En JpaRepository.class ya están definidos los métodos CRUD para manipular la BD.
 */
public interface ReservationRepository extends JpaRepository<Reservation, String> {

    @Query(value = "SELECT r FROM Reservation r WHERE r.admissionDate = :startDate AND r.departureDate = :endDate", nativeQuery = true)
    List<Reservation> find(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
