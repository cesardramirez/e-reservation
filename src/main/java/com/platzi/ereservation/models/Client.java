package com.platzi.ereservation.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * Note: Install Lombok plugin en IntelliJ IDEA to make it work.
 *
 * Class representing the Client table.
 * @NoArgsConstructor: Crea un constructor sin argumentos.
 * @AllArgsConstructor: Crea un constructor con argumentos, con todos los campos de la clase.
 * @Data:
 *   Es un acceso directo para @ToString, @EqualsAndHashCode, @Getter, @Setter y @RequiredArgsConstructor
 *   Funciona bien para las clases o beans, pero si desea agregar esto en una entidad administrada,
 *     la anotación de cadena genera problemas con las relaciones, puede usarse,
 *     pero tiene que excluir cualquier relación que tenga la entidad para evitar que cualquier referencia
 *     sea considerada por el gerente de la entidad y cause un caos con la entidad.
 * @Entity: Permite relacionar una clase de Java con una entidad en la base de datos y será administrada por el EntityManager de JPA.
 * @Table: Define a qué tabla va a mapearse la entidad.
 * @GeneratedValue: Define la forma de autogenerar el valor, en este caso, el propio de Postgresql.
 * Si un campo no tiene una anotación, el nombre por defecto será el mismo del campo.
 * @GenericGenerator: Anotación de Hibernate. Hace un match con el name y con el generator de la anotación anterior.
 *
 * Si la relación de 1 se define el atributo como un objeto.
 * Si la relación es de muchos se define el atributo como una colección.
 * Las relaciones en JPA se deben mapear birideccionalmente, a diferencia en BD que en las tablas se hacen en un solo lado.
 *
 ** Un cliente puede tener muchas reservaciones.
 */
@Data
@Entity
@Table(name = "client")
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String idCli;
    private String name;
    private String lastName;
    private String address;
    private String phone;
    private String email;
    @OneToMany(mappedBy = "client")
    private Set<Reservation> bookings;  // Un Cliente tiene muchas Reservas.
}
