package gleyser.aula1.service;

import java.math.BigDecimal;

import gleyser.aula1.dao.IRiscoDAO;
import gleyser.aula1.dao.RiscoDAO;
import gleyser.aula1.model.Emprestimo;

public class RiscoNegocialService {
	
	private IRiscoDAO riscoDAO;

	public RiscoNegocialService(IRiscoDAO riscoDAO) {		
		this.riscoDAO = riscoDAO;
		
	}
	
	public BigDecimal retornaRisco(Long idEmprestimo) {	
		
		BigDecimal risco = this.riscoDAO.recuperaRisco(idEmprestimo);
		
		return risco;
		
	}

}
