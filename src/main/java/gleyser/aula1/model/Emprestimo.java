package gleyser.aula1.model;

import java.math.BigDecimal;

public class Emprestimo {

	private Long id;
	private BigDecimal valorTotal;
	private Usuario mutuario;
	private int parcelas;
	
	public Emprestimo() {
		
	}

	public Emprestimo(BigDecimal valor, Usuario mutuario) {

		this.valorTotal = valor;
		this.mutuario = mutuario;
		this.parcelas = 10;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valorTotal;
	}

	public void setValor(BigDecimal valor) {
		this.valorTotal = valor;
	}

	public Usuario getMutuario() {
		return mutuario;
	}

	public void setMutuario(Usuario mutuario) {
		this.mutuario = mutuario;
	}

	public int getParcelas() {
		return parcelas;
	}

	public BigDecimal getParcela() {
		return this.valorTotal.divide(new BigDecimal(parcelas));
	}
	
	public BigDecimal getComprometimentoSalarial() {
		BigDecimal valorParcela = getParcela();
		return this.mutuario.getSalario().subtract(getParcela());
	}

	public void amortizar(BigDecimal valorAmortizado) throws Exception {

		if (this.valorTotal.compareTo(valorAmortizado) < 0) {
			throw new Exception("Valor a amortizar maior que a divida");

		}
		
		this.valorTotal.subtract(valorAmortizado);
		atualizarParcelas();

	}
	
	private void atualizarParcelas() {
		this.parcelas = this.parcelas - 2;
	}

}
