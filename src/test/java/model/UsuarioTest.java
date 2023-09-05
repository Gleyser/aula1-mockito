package model;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import gleyser.aula1.model.Usuario;

public class UsuarioTest {
	
	Usuario usuarioPadrao;
	Usuario usuarioLimite;

	@Before
	public void setup() {
		// inicializacao
		usuarioPadrao = new Usuario("Jose", new BigDecimal("4500"));

		// inicializacao
		usuarioLimite = new Usuario("Maria", new BigDecimal("1100"));

	}

	// @After
	// Executado apos cada teste
	

	@Test
	public void testaConstrutorSemDataDeNascimento() {
		
		// verificacao salario < 1200
		Assert.assertEquals("Jose", usuarioPadrao.getNome());		
		Assert.assertEquals(usuarioPadrao.getSalario(), new BigDecimal("4500"));
		Assert.assertNull(usuarioPadrao.getDataDeNascimento());
		
		// verificacao salario > 1200
		Assert.assertEquals("Maria", usuarioLimite.getNome());		
		Assert.assertNull(usuarioLimite.getSalario());
		Assert.assertNull(usuarioLimite.getDataDeNascimento());
		

	}

	@Test
	public void testaConstrutorCompleto() {

		// cenario
		Usuario usuario = new Usuario("Jose", new BigDecimal("4500"), new Date(2023, 1, 24));

		// acao

		// verificacao
		Assert.assertEquals("Jose", usuario.getNome());

		Assert.assertEquals(usuario.getSalario(), new BigDecimal("4500"));

		Assert.assertNotNull(usuario.getDataDeNascimento());

		Assert.assertEquals(new Date(2023, 1, 24), usuario.getDataDeNascimento());

	}

}
