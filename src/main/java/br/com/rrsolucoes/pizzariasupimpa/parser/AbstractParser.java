package br.com.rrsolucoes.pizzariasupimpa.parser;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public abstract class AbstractParser<DTO, ENTITY> {

	
	public abstract DTO toDTO(ENTITY entity);
	public abstract ENTITY toEntity(DTO dto);
	
	public List<DTO> toDTOList(List<ENTITY> entities) {
		return entities.stream().map(entity -> toDTO(entity)).collect(Collectors.toList());
	}
	
	
	
	public List<ENTITY> toEntityList(List<DTO> dtos) {
		return dtos.stream().map(dto -> toEntity(dto)).collect(Collectors.toList());
	}
	}

