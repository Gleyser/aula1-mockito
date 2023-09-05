package gleyser.aula1.enums;
import java.math.BigDecimal;

public enum RiscoNegocial {
	
	ALTO(new BigDecimal("1.3")), MEDIO(new BigDecimal("1.2")), BAIXO(new BigDecimal("1.1"));
    
    private BigDecimal porcentagem;

	private RiscoNegocial(BigDecimal porcentagem) {
		this.porcentagem = porcentagem;
	}

	public BigDecimal getPorcentagem() {
		return porcentagem;
	}

	public void setPorcentagem(BigDecimal porcentagem) {
		this.porcentagem = porcentagem;
	}
    
    

}
