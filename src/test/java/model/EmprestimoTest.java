package model;

import static org.mockito.Mockito.mock;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import gleyser.aula1.model.Emprestimo;
import gleyser.aula1.model.Usuario;

public class EmprestimoTest {
	
	@Test
	public void testaGetComprometimentoSalarial() {		
		
	    // Given: promovendo o estado sob teste / definir um estado conhecido
		
		// Inicializando os mocks que serao utilizados na classe a ser testada
		Usuario mutuario = mock(Usuario.class);
		
		// Definindo o comportamento do Mock
		BigDecimal salario = new BigDecimal("4500");
		Mockito.when(mutuario.getSalario()).thenReturn(salario);
		
		// Definindo a classe a ser testada
		BigDecimal valorTotalDoEmprestimo = new BigDecimal("2000");			
		Emprestimo emprestimo;
		
		// Incluindo os mocks na classe a ser testada 
		emprestimo = new Emprestimo(valorTotalDoEmprestimo, mutuario);
		
		// When/Act: rodar a aplicação
		// Then: verificando o comportamento desejado
		Assert.assertEquals(10, emprestimo.getParcelas());
		Assert.assertEquals(new BigDecimal("200"), emprestimo.getParcela());
		Assert.assertEquals(new BigDecimal("4300"), emprestimo.getComprometimentoSalarial());
		
	}

}
