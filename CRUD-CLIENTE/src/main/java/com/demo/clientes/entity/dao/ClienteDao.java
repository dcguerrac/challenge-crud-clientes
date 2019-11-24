package com.demo.clientes.entity.dao;

import org.springframework.data.repository.CrudRepository;

import com.demo.clientes.entity.models.Cliente;

public interface ClienteDao extends CrudRepository<Cliente, Long> {
	
}
