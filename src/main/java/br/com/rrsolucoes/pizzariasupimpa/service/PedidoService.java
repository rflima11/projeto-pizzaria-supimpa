package br.com.rrsolucoes.pizzariasupimpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rrsolucoes.pizzariasupimpa.dao.PedidoDao;
import br.com.rrsolucoes.pizzariasupimpa.dao.PizzaDao;
import br.com.rrsolucoes.pizzariasupimpa.dto.PedidoDto;
import br.com.rrsolucoes.pizzariasupimpa.model.Pedido;
import br.com.rrsolucoes.pizzariasupimpa.parser.ClienteParserDTO;
import br.com.rrsolucoes.pizzariasupimpa.parser.PedidoParserDTO;

@Service
public class PedidoService {

	
	@Autowired
	private PedidoDao dao;
	
	@Autowired
	private PizzaDao daoPizza;
	
	@Autowired
	private PizzaService servicePizza;
	
	@Autowired
	private ClienteParserDTO parserCliente;
	
	@Autowired
	private PedidoParserDTO parserPedido;
	

	public void save(Pedido pedido) {
		dao.save(pedido);
	}
	
	public List<PedidoDto> listarPedidos(){
		return parserPedido.toDTOList(dao.findAll());
	}
	
	public Optional<Pedido> encontrarPedido(Long id) {
		return dao.findById(id);
	}
	
	public void deletarPedido(Long id) {
		dao.deleteById(id);
	}
	
	public void atualizarPedido() {
		
	}
	

}
