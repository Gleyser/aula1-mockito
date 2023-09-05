package gleyser.aula1.service;

import java.math.BigDecimal;

import gleyser.aula1.dao.IEmprestimoDAO;
import gleyser.aula1.model.Emprestimo;

public class MesaDeNegociacaoAmortizacaoService {

	private IEmprestimoDAO emprestimoDAO;
	private RiscoNegocialService riscoNegocialService;		

	public MesaDeNegociacaoAmortizacaoService(IEmprestimoDAO emprestimoDAO, RiscoNegocialService riscoNegocialService) {		
		this.emprestimoDAO = emprestimoDAO;
		this.riscoNegocialService = riscoNegocialService;
	}

	public BigDecimal retornaRiscoPortabilidade(Long idDoEmprestimo) {
		
		Emprestimo emprestimo = this.emprestimoDAO.recuperaEmprestimo(idDoEmprestimo);
		
		BigDecimal risco = this.riscoNegocialService.retornaRisco(emprestimo.getId());
		
		BigDecimal parcela = emprestimo.getParcela();
		
		return parcela.multiply(risco);
		

	}
	
    public Emprestimo realizaAmortizacao(Long idDoEmprestimo, BigDecimal valorAmortizado) throws Exception {
		
    	Emprestimo emprestimo = this.emprestimoDAO.recuperaEmprestimo(idDoEmprestimo);
    	emprestimo.amortizar(valorAmortizado);    	
    	
    	return emprestimo;
    	
    	
	}	

}
