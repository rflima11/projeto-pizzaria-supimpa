package br.com.rrsolucoes.pizzariasupimpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rrsolucoes.pizzariasupimpa.model.Endereco;

public interface EnderecoDao extends JpaRepository<Endereco, Long> {

}

