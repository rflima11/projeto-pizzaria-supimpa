package br.com.rrsolucoes.pizzariasupimpa.parser;

import org.springframework.stereotype.Component;

import br.com.rrsolucoes.pizzariasupimpa.dto.AutoCompleteDto;
import br.com.rrsolucoes.pizzariasupimpa.model.Cliente;

@Component
public class AutoCompleteParserDTO extends AbstractParser<AutoCompleteDto, Cliente> {

	@Override
	public AutoCompleteDto toDTO(Cliente entity) {
		AutoCompleteDto dto = new AutoCompleteDto();
		dto.setId(entity.getId());
		dto.setNome(entity.getNome());
		return dto;
	}

	@Override
	public Cliente toEntity(AutoCompleteDto dto) {
		Cliente cliente = new Cliente();
		cliente.setId(dto.getId());
		cliente.setNome(dto.getNome());
		return cliente;
	}

}
