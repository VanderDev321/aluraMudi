package br.com.alura.mvc.mudi.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;

public class PedidoDto {
	
	private Long id;
	private String nomeProduto;
	private BigDecimal valorProduto;
	private LocalDate dataDaEntrega;
	private String urlDoProduto;
	private String urlImagemProduto;
	private String descricao;
	private StatusPedido status;
	
	public PedidoDto(Pedido pedido) {
		
		this.id = pedido.getId();
		this.nomeProduto = pedido.getNomeProduto();
		this.dataDaEntrega = pedido.getDataDaEntrega();
		this.urlDoProduto = pedido.getUrlDoProduto();
		this.urlImagemProduto = pedido.getUrlImagemProduto();
		this.descricao = pedido.getDescricao();
		this.status = pedido.getStatusPedido();
		
	}

	public Long getId() {
		return id;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public BigDecimal getValorProduto() {
		return valorProduto;
	}

	public LocalDate getDataDaEntrega() {
		return dataDaEntrega;
	}

	public String getUrlDoProduto() {
		return urlDoProduto;
	}

	public String getUrlImagemProduto() {
		return urlImagemProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public static List<PedidoDto> listar(List<Pedido> pedidos) {
		
		return pedidos.stream().map(PedidoDto::new).collect(Collectors.toList());
		
	}
	
	

}
