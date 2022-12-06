package br.com.alura.mvc.mudi.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "users")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class User implements UserDetails {

	private static final long serialVersionUID = 1L;
	@Id
	private String username;
	private String password;
	private boolean enabled;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<Pedido> pedidos;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List <Perfil> perfis = new ArrayList<>();
	
	
	public List<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<Perfil>perfis) {
		
		this.perfis = perfis;
	}

	public String getUsername() {
		return username;
	}

	
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return this.perfis;
	}


	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}


}
