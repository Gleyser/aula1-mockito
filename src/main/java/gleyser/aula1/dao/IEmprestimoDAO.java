package gleyser.aula1.dao;

import gleyser.aula1.model.Emprestimo;

public interface IEmprestimoDAO {
	
	public Long salvarEmprestimo(Emprestimo emprestimoAlterado);
	public Emprestimo recuperaEmprestimo(Long id);
	public void alterarEmprestimo(Emprestimo emprestimoAlterado);
	public void excluirEmprestimo(Long id);
	

}
