package com.demo.clientes.entity.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class KpiClientes implements Serializable {

    private double promedioEdad;
    private double desvEstandar;
}
