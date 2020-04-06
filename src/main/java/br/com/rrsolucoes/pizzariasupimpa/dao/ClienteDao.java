package br.com.rrsolucoes.pizzariasupimpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rrsolucoes.pizzariasupimpa.model.Cliente;

public interface ClienteDao extends JpaRepository<Cliente, Long> {

	
}
