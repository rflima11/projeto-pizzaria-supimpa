package br.com.rrsolucoes.pizzariasupimpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rrsolucoes.pizzariasupimpa.model.Cliente;
import br.com.rrsolucoes.pizzariasupimpa.model.Pedido;

public interface PedidoDao extends JpaRepository<Pedido, Long> {

	public List<Pedido> findByCliente(Cliente cliente);
}
