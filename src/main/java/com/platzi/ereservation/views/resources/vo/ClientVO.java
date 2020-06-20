package com.platzi.ereservation.views.resources.vo;

import lombok.Data;

/**
 * VO: Virtual Object.
 * Free class that does not depend on a technology.
 */
@Data
public class ClientVO {

    private String idCli;
    private String name;
    private String lastName;
    private String identification;
    private String address;
    private String phone;
    private String email;
}
