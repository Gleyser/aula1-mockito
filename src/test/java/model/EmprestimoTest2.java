package model;

// nao precisamos mais disso
import static org.mockito.Mockito.mock;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import gleyser.aula1.model.Emprestimo;
import gleyser.aula1.model.Usuario;

@RunWith(MockitoJUnitRunner.class)
public class EmprestimoTest2 {

	@Mock
	Usuario mutuario;

	@InjectMocks
	Emprestimo emprestimo;

	@Test
	public void testaGetComprometimentoSalarial() {

		// Given: promovendo o estado sob teste / definir um estado conhecido

		// Inicializando os mocks que serao utilizados na classe a ser testada
		// Feito pelo uso da anotacao @Mock
		
		// Definindo o comportamento do Mock
		BigDecimal salario = new BigDecimal("4500");
		Mockito.when(mutuario.getSalario()).thenReturn(salario);

		// Definindo a classe a ser testada
		BigDecimal valorTotalDoEmprestimo = new BigDecimal("2000");
		emprestimo.setValor(valorTotalDoEmprestimo);
		
		// When/Act: rodar a aplicação
		// Then: verificando o comportamento desejado
		Assert.assertEquals(10, emprestimo.getParcelas());
		Assert.assertEquals(new BigDecimal("200"), emprestimo.getParcela());
		Assert.assertEquals(new BigDecimal("4300"), emprestimo.getComprometimentoSalarial());

	}

}
