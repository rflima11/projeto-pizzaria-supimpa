package br.com.rrsolucoes.pizzariasupimpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rrsolucoes.pizzariasupimpa.model.Pedido;

public interface PedidoDao extends JpaRepository<Pedido, Long> {

}
