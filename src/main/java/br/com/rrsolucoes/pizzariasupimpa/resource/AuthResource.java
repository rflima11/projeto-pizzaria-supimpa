package br.com.rrsolucoes.pizzariasupimpa.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.rrsolucoes.pizzariasupimpa.auth.model.AuthRequest;
import br.com.rrsolucoes.pizzariasupimpa.auth.model.AuthResponse;
import br.com.rrsolucoes.pizzariasupimpa.security.jwt.JwtUtil;
import br.com.rrsolucoes.pizzariasupimpa.service.CustomUserDetailService;

@RestController
public class AuthResource {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	@Autowired
	private JwtUtil jwtTokenUtil;
	
	
	@PostMapping(value="/auth")
	public ResponseEntity<?> createAuthToken(@RequestBody AuthRequest authRequest) throws Exception {
		try {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Senha ou usuário incorreta", e);
		}
		
		final UserDetails userDetail = customUserDetailService.loadUserByUsername(authRequest.getUsername());
		final String jwt = jwtTokenUtil.generateToken(userDetail);
		return ResponseEntity.ok(new AuthResponse(jwt));
	}
	
	

}
