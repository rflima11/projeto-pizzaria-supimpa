package br.com.rrsolucoes.pizzariasupimpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.rrsolucoes.pizzariasupimpa.dao.UserRepository;
import br.com.rrsolucoes.pizzariasupimpa.model.FuncUser;

@Component
public class CustomUserDetailService implements UserDetailsService{

	private final UserRepository userRepository;
	
	@Autowired
	public CustomUserDetailService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		FuncUser user = Optional.ofNullable(userRepository.findByUsername(username))
								.orElseThrow(() -> new UsernameNotFoundException("User not found"));
		List<GrantedAuthority> authorityListAdmin = AuthorityUtils.createAuthorityList("ROLE_ADMIN", "ROLE_ADMIN");
		List<GrantedAuthority> authorityListUser = AuthorityUtils.createAuthorityList("ROLE_USER");
		return new User(user.getUsername(), user.getPassword(), user.isAdmin() ? authorityListAdmin : authorityListUser);
	}

}
