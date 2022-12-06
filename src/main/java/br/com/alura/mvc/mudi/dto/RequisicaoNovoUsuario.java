package br.com.alura.mvc.mudi.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.alura.mvc.mudi.model.Perfil;
import br.com.alura.mvc.mudi.model.User;
import br.com.alura.mvc.mudi.repository.PerfiRepository;

public class RequisicaoNovoUsuario {
	@NotBlank 
	private String nomeUsuario;
	@NotBlank @Length(min = 4 , max = 8) 
	private String senha;
	
	private List<Perfil>listaPerfis = new ArrayList<>();

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		
		this.senha = senha;
	}

	public User toUsuario(PerfiRepository perfilRepository) {
		
		Optional<Perfil> perfis = perfilRepository.findById(Long.parseLong("2"));
		Perfil perfilResgatado = perfis.get();
		listaPerfis.add(perfilResgatado);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			User usuario = new User();
			usuario.setUsername(nomeUsuario);
			usuario.setPassword(encoder.encode(senha));
			usuario.setPerfis(listaPerfis);
			usuario.setEnabled(true);
			return usuario;
	}

}
