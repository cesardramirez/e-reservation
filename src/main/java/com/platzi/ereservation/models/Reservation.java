package com.platzi.ereservation.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Class representing the Reservation table.
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
    private String id;
    private Date admissionDate;
    private Date departureDate;
    private int amountPeople;
    private String description;
    @ManyToOne
    @JoinColumn(name = "id")
    private Client client;  // Nombre correspondiente a mappedBy de la clase Client.
}
