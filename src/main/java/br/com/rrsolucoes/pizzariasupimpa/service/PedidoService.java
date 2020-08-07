package br.com.rrsolucoes.pizzariasupimpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rrsolucoes.pizzariasupimpa.dao.PedidoDao;
import br.com.rrsolucoes.pizzariasupimpa.model.Pedido;

@Service
public class PedidoService {

	
	@Autowired
	private PedidoDao dao;
	
	

	public void save(Pedido pedido) {
		dao.save(pedido);
	}
	
	public List<Pedido> listarPizzas(){
		return dao.findAll();
	}
	
	public Optional<Pedido> encontrarPizza(Long id) {
		return dao.findById(id);
	}
	
	public void deletarPizza(Long id) {
		dao.deleteById(id);
	}
	
	public void atualizarPizza() {
		
	}
}
