package br.com.rrsolucoes.pizzariasupimpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rrsolucoes.pizzariasupimpa.model.Cliente;

public interface ClienteDao extends JpaRepository<Cliente, Long> {


	List<Cliente> findByNomeContaining(String nome);
}
