package gleyser.aula1.model;

import java.math.BigDecimal;
import java.util.Date;

public class Usuario {
	
	private String nome;
	private BigDecimal salario;
	private Date dataDeNascimento;
	
	public Usuario() {}		
	
	public Usuario(String nome, BigDecimal salario, Date dataDeNascimento) {		
		this.nome = nome;
		
		verificaSalario(salario);
		
		this.dataDeNascimento = dataDeNascimento;
	}
	
	public Usuario(String nome, BigDecimal salario) {		
		this.nome = nome;
					
		verificaSalario(salario);	
		
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public BigDecimal getSalario() {
		return salario;
	}
	
	public void setSalario(BigDecimal salario) {
		// validao de salario
		this.salario = salario;
	}
	
	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}
	
	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	
	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", salario=" + salario + ", dataDeNascimento=" + dataDeNascimento + "]";
	}
	
	private void verificaSalario(BigDecimal salario) {
		BigDecimal minimo = new BigDecimal("1200");
		
		int comparaSalario = salario.compareTo(minimo);
				
		if (comparaSalario == 1) {
			this.salario = salario;
		}		
		
	}
	
}
