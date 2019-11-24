package com.demo.clientes.entity.services;

import com.demo.clientes.entity.domain.KpiClientes;
import com.demo.clientes.entity.models.Cliente;

import java.util.List;

public interface ClienteService {
     Cliente get(long id);

     KpiClientes getKpiAllCustomers();

     List<Cliente> getAll();

     void post(Cliente cliente);

     void put(Cliente cliente, long id);

     void delete(long id);
}
