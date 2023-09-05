package gleyser.aula1.dao;

import java.math.BigDecimal;
import java.util.Date;

import gleyser.aula1.model.Emprestimo;
import gleyser.aula1.model.Usuario;

public class EmprestimoDAO implements IEmprestimoDAO {

	public Long salvarEmprestimo(Emprestimo emprestimoAlterado) {
		return 1L;
	}

	public Emprestimo recuperaEmprestimo(Long id) {
		return new Emprestimo(new BigDecimal("3000"), new Usuario("Maria", new BigDecimal("4500"), new Date(2023, 1, 24)));
				
	}

	public void alterarEmprestimo(Emprestimo emprestimoAlterado) {
		// to do
		
	}

	public void excluirEmprestimo(Long id) {
		// to do
		
	}

}
