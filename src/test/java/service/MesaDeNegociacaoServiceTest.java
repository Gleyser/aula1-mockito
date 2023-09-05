package service;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import gleyser.aula1.dao.IEmprestimoDAO;
import gleyser.aula1.enums.RiscoNegocial;
import gleyser.aula1.model.Emprestimo;
import gleyser.aula1.model.Usuario;
import gleyser.aula1.service.MesaDeNegociacaoAmortizacaoService;
import gleyser.aula1.service.RiscoNegocialService;

@RunWith(MockitoJUnitRunner.class)
public class MesaDeNegociacaoServiceTest {
	
	@Mock
	IEmprestimoDAO emprestimoDAO;
	
	@Mock
	RiscoNegocialService riscoNegocialService;
	
	@InjectMocks
	MesaDeNegociacaoAmortizacaoService mesaDeNegociacaoAmortizacaoService;
	
	@Test
	public void testaRetornaRiscoPortabilidade() {
		
		Usuario mutuario = new Usuario("Jose", new BigDecimal("4500"));
		Emprestimo emprestimo = new Emprestimo(new BigDecimal("2000"), mutuario);
		
		// Definindo o comportamento do Mock emprestimoDAO
		Mockito.when(emprestimoDAO.recuperaEmprestimo(Mockito.anyLong())).thenReturn(emprestimo);
		
		// Definindo o comportamento do Mock riscoNegocialService
		RiscoNegocial risco = RiscoNegocial.ALTO;		
		Mockito.when(riscoNegocialService.retornaRisco(Mockito.anyLong())).thenReturn(risco.getPorcentagem());
		
		// Garantindo que o Valor da parcela eh 200
		Assert.assertEquals(new BigDecimal("200"), emprestimo.getParcela());
		
		// Garantindo que o risco retornado eh Alto
		Assert.assertEquals(risco.getPorcentagem(), riscoNegocialService.retornaRisco(1L));
		
		// 1.3 * 200 = 2'0
		// When/Act: rodar a aplicação
		// Then: verificando o comportamento desejado
		
		BigDecimal valorEsperado = new BigDecimal("260.0");
		
		Assert.assertEquals(valorEsperado, mesaDeNegociacaoAmortizacaoService.retornaRiscoPortabilidade(1L));
		
	}
	
	@Test(expected=Exception.class)
	public void testaRealizaAmortizacao() throws Exception {
		
		Usuario mutuario = new Usuario("Jose", new BigDecimal("4500"));
		Emprestimo emprestimo = new Emprestimo(new BigDecimal("2000"), mutuario);
		
		// Definindo o comportamento do Mock emprestimoDAO
		Mockito.when(emprestimoDAO.recuperaEmprestimo(Mockito.anyLong())).thenReturn(emprestimo);
		
		mesaDeNegociacaoAmortizacaoService.realizaAmortizacao(1L, new BigDecimal("2001"));
	}
	

}
