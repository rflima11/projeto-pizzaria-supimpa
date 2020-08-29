package br.com.rrsolucoes.pizzariasupimpa.parser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.rrsolucoes.pizzariasupimpa.dto.PedidoDto;
import br.com.rrsolucoes.pizzariasupimpa.model.Pedido;
import br.com.rrsolucoes.pizzariasupimpa.model.Pizza;

@Component
public class PedidoParserDTO extends AbstractParser<PedidoDto, Pedido> {

	@Autowired
	private ClienteParserDTO parserCliente;
	
	
	public int calculaValorPedido(List<Pizza> listaPizza) {
		int pedido = 0;
		for (Pizza pizza : listaPizza) {
			pedido += pizza.getPreco();
		}
		return pedido;
	}
	
	@Override
	public PedidoDto toDTO(Pedido entity) {
		PedidoDto dto = new PedidoDto();
		dto.setId(entity.getId());
		dto.setCliente(parserCliente.toDTO(entity.getCliente()));;
		dto.setPizzas(entity.getPizzas());
		dto.setValorTotal(entity.getValorTotal());
		return dto;
	}

	@Override
	public Pedido toEntity(PedidoDto dto) {
		Pedido pedido = new Pedido();
		pedido.setCliente(parserCliente.toEntity(dto.getCliente()));
		pedido.setId(dto.getId());
		pedido.setPizzas(dto.getPizzas());
		pedido.setValorTotal(calculaValorPedido(dto.getPizzas()));
		return pedido;
	}

}
