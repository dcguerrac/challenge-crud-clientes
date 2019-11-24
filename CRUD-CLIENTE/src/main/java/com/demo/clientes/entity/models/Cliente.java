package com.demo.clientes.entity.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "clientes")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String lastname;

    @NotNull
    private String birthdate;

    private Integer age;

    public Cliente(@NotEmpty String name, @NotEmpty String lastname, @NotNull String birthdate,  Integer age) {
        this.name = name;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.age = age;
    }

    public Cliente() {
    }
}
