package com.demo.clientes.controllers;

import com.demo.clientes.entity.domain.KpiClientes;
import com.demo.clientes.entity.models.Cliente;
import com.demo.clientes.entity.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/clientes")
    public List<Cliente> getAllCustomers() {
        return clienteService.getAll();
    }

    @GetMapping("/clientes/{id}")
    public Cliente getOne(@PathVariable(value = "id") long id) {
        return clienteService.get(id);
    }

    @PostMapping("/clientes")
    public void add(Cliente clientes) {
        clienteService.post(clientes);
    }

    @PutMapping("/clientes/{id}")
    public void update(Cliente cliente, @PathVariable(value = "id") long id) {
        clienteService.put(cliente, id);
    }

    @DeleteMapping("/clientes/{id}")
    public void update(@PathVariable(value = "id") long id) {
        clienteService.delete(id);
    }

    @GetMapping("/kpideclientes")
    public KpiClientes getKpiCustomers() {
        return clienteService.getKpiAllCustomers();
    }
}
