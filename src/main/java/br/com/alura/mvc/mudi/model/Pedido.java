package br.com.alura.mvc.mudi.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pedido {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nomeProduto;
	private BigDecimal valorProduto;
	private LocalDate dataDaEntrega;
	private String urlDoProduto;
	private String urlImagemProduto;
	private String descricao;
	@Enumerated(EnumType.STRING)
	private StatusPedido status;
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	@OneToMany(cascade = CascadeType.ALL , mappedBy = "pedido", fetch = FetchType.LAZY)
	private List<Oferta> ofertas ;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@JsonIgnore
	public List<Oferta> getOfertas() {
		return ofertas;
	}
	public void setOfertas(List<Oferta> ofertas) {
		this.ofertas = ofertas;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public BigDecimal getValorProduto() {
		return valorProduto;
	}
	public void setValorProduto(BigDecimal valorProduto) {
		this.valorProduto = valorProduto;
	}
	public LocalDate getDataDaEntrega() {
		return dataDaEntrega;
	}
	public void setDataDaEntrega(LocalDate dataDaEntrega) {
		this.dataDaEntrega = dataDaEntrega;
	}
	public String getUrlDoProduto() {
		return urlDoProduto;
	}
	public void setUrlDoProduto(String urlDoProduto) {
		this.urlDoProduto = urlDoProduto;
	}
	public String getUrlImagemProduto() {
		return urlImagemProduto;
	}
	public void setUrlImagemProduto(String urlImagemProduto) {
		this.urlImagemProduto = urlImagemProduto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public StatusPedido getStatusPedido() {
		return status;
	}
	public void setStatusPedido(StatusPedido statusPedido) {
		this.status = statusPedido;
	}
	@JsonManagedReference
	public User getUser() {
		return user;
	}
	public void setUser(User user2) {
		this.user = user2;
	}
	
	

	
}
