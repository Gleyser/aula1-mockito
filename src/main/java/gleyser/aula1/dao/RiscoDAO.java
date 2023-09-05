package gleyser.aula1.dao;

import java.math.BigDecimal;
import java.util.Random;

import gleyser.aula1.enums.RiscoNegocial;

public class RiscoDAO implements IRiscoDAO {

	public BigDecimal recuperaRisco(Long id) {
		
		Random random = new Random();
		
		int numero = random.nextInt(2);
		
		if (numero == 0) {
			return RiscoNegocial.ALTO.getPorcentagem();
		}
		
		else if (numero == 1) {
			return RiscoNegocial.MEDIO.getPorcentagem();
		}
		
		return RiscoNegocial.BAIXO.getPorcentagem();
		
	}

	
	

}
