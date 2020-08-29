package br.com.rrsolucoes.pizzariasupimpa.parser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.rrsolucoes.pizzariasupimpa.dto.ClienteDto;
import br.com.rrsolucoes.pizzariasupimpa.model.Cliente;

@Component
public class ClienteParserDTO extends AbstractParser<ClienteDto, Cliente>{

	@Autowired
	private ListaPedidosParserDTO parserPedidos;
	
	@Autowired
	private EnderecoParserDTO parserEnderecos;
	
	
	@Override
	public ClienteDto toDTO(Cliente entity) {
		ClienteDto dto = new ClienteDto();
		dto.setId(entity.getId());
		dto.setNome(entity.getNome());
		dto.setTelefone(entity.getTelefone());
		dto.setPedidoDto(parserPedidos.toDTOList(entity.getPedidos()));
		dto.setEnderecos(parserEnderecos.toDTOList(entity.getEnderecos()));
		return dto;
	}

	@Override
	public Cliente toEntity(ClienteDto dto) {
		Cliente cliente = new Cliente();
		cliente.setId(dto.getId());
		cliente.setNome(dto.getTelefone());
		cliente.setTelefone(dto.getTelefone());
		cliente.setPedidos(parserPedidos.toEntityList(dto.getPedidoDto()));
		return cliente;
	}	

}
