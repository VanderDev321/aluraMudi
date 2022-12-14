package br.com.alura.mvc.mudi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.mvc.mudi.model.Perfil;

@Repository
public interface PerfiRepository extends JpaRepository<Perfil, Long>{
	

}
