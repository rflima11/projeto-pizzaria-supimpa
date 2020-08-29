package br.com.rrsolucoes.pizzariasupimpa.parser;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.rrsolucoes.pizzariasupimpa.dto.EnderecoDto;
import br.com.rrsolucoes.pizzariasupimpa.model.Endereco;

@Component
public class EnderecoParserDTO extends AbstractParser<EnderecoDto, Endereco>{

	@Override
	public EnderecoDto toDTO(Endereco entity) {
		EnderecoDto dto = new EnderecoDto();
		dto.setBairro(entity.getBairro());
		dto.setCep(entity.getCep());
		dto.setComplemento(entity.getComplemento());
		dto.setId(entity.getId());
		dto.setLocalidade(entity.getLocalidade());
		dto.setLogradouro(entity.getLogradouro());
		dto.setUf(entity.getUf());
		return dto;
	}

	@Override
	public Endereco toEntity(EnderecoDto dto) {
		Endereco endereco = new Endereco();
		endereco.setBairro(dto.getBairro());
		endereco.setCep(dto.getCep());
		endereco.setComplemento(dto.getComplemento());
		endereco.setId(dto.getId());
		endereco.setLocalidade(dto.getLocalidade());
		endereco.setLogradouro(dto.getLogradouro());
		endereco.setUf(dto.getUf());
		return endereco;
	}
	

	public Set<EnderecoDto> toDTOList(Set<Endereco> enderecos){
		return enderecos.stream().map(endereco -> toDTO(endereco)).collect(Collectors.toSet());	
	}
	
	public Set<Endereco> toEntityList(Set<EnderecoDto> enderecosDto) {
		return enderecosDto.stream().map(enderecoDto -> toEntity(enderecoDto)).collect(Collectors.toSet());
	}

}
