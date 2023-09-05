package service;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import gleyser.aula1.dao.RiscoDAO;
import gleyser.aula1.enums.RiscoNegocial;
import gleyser.aula1.service.RiscoNegocialService;

@RunWith(MockitoJUnitRunner.class)
public class RiscoNegocialServiceTest {

	@Mock
	RiscoDAO riscoDAO;

	@InjectMocks
	RiscoNegocialService riscoNegocialService;

	@Test
	public void testaRetornaRisco() {

		// Given: promovendo o estado sob teste / definir um estado conhecido

		// Inicializando os mocks que serao utilizados na classe a ser testada
		// Feito pelo uso da anotacao @Mock

		// Definindo o comportamento do Mock
		// Mockito ArgumentMatchers
		BigDecimal risco = RiscoNegocial.ALTO.getPorcentagem();
		Mockito.when(riscoDAO.recuperaRisco(Mockito.anyLong())).thenReturn(risco);

		// When/Act: rodar a aplicação
		// Then: verificando o comportamento desejado
		Assert.assertEquals(risco, riscoNegocialService.retornaRisco(1L));
		
		// Definindo o comportamento do Mock
		risco = RiscoNegocial.MEDIO.getPorcentagem();
		Mockito.when(riscoDAO.recuperaRisco(Mockito.anyLong())).thenReturn(risco);

		// When/Act: rodar a aplicação
		// Then: verificando o comportamento desejado
		Assert.assertEquals(risco, riscoNegocialService.retornaRisco(2L));

		// Definindo o comportamento do Mock
		risco = RiscoNegocial.BAIXO.getPorcentagem();
		Mockito.when(riscoDAO.recuperaRisco(Mockito.any(Long.class))).thenReturn(risco);

		// When/Act: rodar a aplicação
		// Then: verificando o comportamento desejado
		Assert.assertEquals(risco, riscoNegocialService.retornaRisco(3L));

	}

}
