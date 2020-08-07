package br.com.rrsolucoes.pizzariasupimpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rrsolucoes.pizzariasupimpa.model.Pizza;

public interface PizzaDao extends JpaRepository<Pizza, Long> {

}
