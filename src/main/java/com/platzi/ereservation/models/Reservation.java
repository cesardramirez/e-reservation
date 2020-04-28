package com.platzi.ereservation.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Class representing the Reservation table.
 * @Temporal(TemporalType.DATE) : Acotara el campo solo a la Fecha, descartando la hora.
 */
@Data
@Entity
@Table(name = "reservation")
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String idRes;
    @Temporal(TemporalType.DATE)
    private Date admissionDate;
    @Temporal(TemporalType.DATE)
    private Date departureDate;
    private int amountPeople;
    private String description;
    @ManyToOne
    @JoinColumn(name = "idCli")
    private Client client;  // Nombre correspondiente a mappedBy de la clase Client.
}
