package br.com.rrsolucoes.pizzariasupimpa.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.rrsolucoes.pizzariasupimpa.model.FuncUser;

public interface UserRepository extends PagingAndSortingRepository<FuncUser, Long> {
	
	FuncUser findByUsername(String username);

}
