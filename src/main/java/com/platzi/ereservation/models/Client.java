package com.platzi.ereservation.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    private String name;
    private String lastName;
}
