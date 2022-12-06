package br.com.alura.mvc.mudi.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.alura.mvc.mudi.model.User;
import br.com.alura.mvc.mudi.repository.UserRepository;

@Service
public class AutenticacaoService implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> usuario = userRepository.findById(username);
		if(!usuario.isPresent()) {
			throw new UsernameNotFoundException("Dados inválidos");
		}
		return usuario.get();
	}

}
