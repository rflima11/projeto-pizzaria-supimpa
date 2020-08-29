package br.com.rrsolucoes.pizzariasupimpa.parser;

import org.springframework.stereotype.Component;

import br.com.rrsolucoes.pizzariasupimpa.dto.ListaPedidosDto;
import br.com.rrsolucoes.pizzariasupimpa.model.Pedido;

@Component
public class ListaPedidosParserDTO extends AbstractParser<ListaPedidosDto, Pedido> {

	@Override
	public ListaPedidosDto toDTO(Pedido entity) {
		ListaPedidosDto dto = new ListaPedidosDto();
		dto.setId(entity.getId());
		dto.setPizzas(entity.getPizzas());
		dto.setValorTotal(entity.getValorTotal());
		dto.setQuantidadePizzas(entity.getPizzas().size());
		dto.setHoraInsercao(entity.getDataInicio());
		return dto;
	}

	@Override
	public Pedido toEntity(ListaPedidosDto dto) {
		Pedido pedido = new Pedido();
		pedido.setId(dto.getId());
		pedido.setPizzas(dto.getPizzas());
		pedido.setValorTotal(dto.getValorTotal());
		pedido.setDataInicio(dto.getHoraInsercao());
		return pedido;
	}

}
