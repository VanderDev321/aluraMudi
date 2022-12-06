package br.com.alura.mvc.mudi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.mudi.dto.RequisicaoNovoUsuario;
import br.com.alura.mvc.mudi.model.User;
import br.com.alura.mvc.mudi.repository.PerfiRepository;
import br.com.alura.mvc.mudi.repository.UserRepository;

@Controller
@RequestMapping("cadastro")
public class CadastroController {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PerfiRepository perfilRepository;
	
	@GetMapping("/formulario")
	public String formulario(RequisicaoNovoUsuario novoUser) {
		return "cadastro/formulario";
	}
	@PostMapping("/novo")
	
	public String novo( @Valid RequisicaoNovoUsuario novoUser ,  BindingResult result) {
		
		if(result.hasErrors()) {
			return "cadastro/formulario";
		}
		
		User novo = novoUser.toUsuario(perfilRepository);
		userRepository.save(novo);
		
		return "redirect:/home";
	}

}
