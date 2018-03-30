package br.emprestimo.testeUnitario;
import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.emprestimo.modelo.Emprestimo;
import br.emprestimo.modelo.Livro;
import br.emprestimo.modelo.Usuario;
import br.emprestimo.servico.ServicoEmprestimo;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class UC01RegistraEmprestimoDeLivro {
	static private Livro livro;
	static private Usuario usuario;
	static private ServicoEmprestimo servico;
	static private Emprestimo emprestimo;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//cenario
		livro = new Livro();
		livro.setIsbn("121212");
		livro.setTitulo("Engenharia de Software");
		livro.setAutor("Pressman");
		usuario = new Usuario();
		usuario.setRa("11111");
		usuario.setNome("Jose da Silva");
		servico = new ServicoEmprestimo();
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	@Test
	public void CT01UC01FB_registrar_emprestimo_com_sucesso() {
		assertNotNull(servico.empresta(livro, usuario));
	}
	@Test(expected = RuntimeException.class)
	public void CT02UC01FB_registrar_emprestimo_com_dados_invalidos() {
		assertNotNull(servico.empresta(null, usuario));
	}
	@Test
	public void CT03UC01FB_registrar_emprestimo_com_dados_invalidos() {
		try {
			servico.empresta(null, usuario);
			fail("deveria lançar uma exceção");
		} catch (RuntimeException e) {
			assertEquals("Dados inválidos.", e.getMessage());
		}
	}
	@Test
	public void CT02UC01FB_registra_emprestimo_com_sucesso_validacao_da_data() {
		// acao
		org.joda.time.format.DateTimeFormatter fmt = DateTimeFormat.forPattern("dd-MM-YYYY");
		String dataEsperada = new DateTime().plusDays(8).toString(fmt);
		emprestimo = servico.empresta(livro, usuario);
		String dataObtida = emprestimo.getDataDevolucao();
		// verificacao
		assertTrue(dataEsperada.equals(dataObtida));
	}


	
	//Usuario
	@Test
	public void CT09verificar_o_metodo_getUsuario() {
		assertEquals(null, emprestimo.getUsuario());
	}

	@Test
	public void CT11verificar_o_metodo_getRa() {
		assertEquals("123456789", usuario.getRa());
	}

	@Test
	public void CT12verificar_o_metodo_getNome() {
		assertEquals("joaozinho", usuario.getNome());
	}

	@Test
	public void CT13verificar_o_metodo_equals() {
		assertNotNull(usuario.equals(usuario));
	}

	@Test
	public void CT14verificar_o_metodo_equals() {
		assertNotNull(usuario.equals(null));
	}
	@Test
	public void CT15verificar_o_metodo_equals() {
		assertNotNull(usuario.equals(livro));
	}
	@Test
	public void CT16verificar_o_metodo_equals() {
		usuario.setRa(null);
		assertTrue(usuario.getRa().equals(null));
	}
	@Test
	public void CT17verificar_o_metodo_equals() {
		assertNotNull(livro.equals(usuario));
	}
	@Test
	public void CT18verificar_o_metodo_equals() {
		Usuario usr = new Usuario();
		assertFalse(usr.equals(usuario));
	}
	@Test
	public void CT19verificar_o_metodo_equals() {
		Usuario usr = new Usuario();
		usr.setNome(null);
		assertFalse(usr.equals(usuario));
	}
	@Test
	public void CT20verificar_o_metodo_equals() {
		Usuario usr = new Usuario();
		usr.setNome(null);
		usr.setRa(null);
		assertFalse(usr.equals(usuario));
	}
	@Test
	public void CT21verificar_o_metodo_equals() {
		Usuario usr = new Usuario();
		usr.setNome("Joao das couves");
		usr.setRa("123");
		assertFalse(usr.equals(usuario));
	}
	@Test
	public void CT22verificar_o_metodo_equals() {
		Usuario usr = new Usuario();
		usr.setNome("Joao das couves");
		usr.setRa("123");
		assertNotNull(usr.equals(usuario));
	}
	@Test
	public void CT23verificar_o_metodo_equals() {
		Usuario usr = new Usuario();
		usr.setNome("Joao das couves");
		usr.setRa("123");
		usuario.setRa(null);
		assertFalse(usr.equals(usuario));
	}
	@Test
	public void CT24verificar_o_metodo_equals() {
		Usuario usr = new Usuario();
		usr.setNome("Joao das couves");
		usuario.setNome(null);
		assertFalse(usr.equals(usuario));
	}
	@Test
	public void CT25verificar_o_metodo_equals() {
		Usuario usr = new Usuario();
		usr.setNome("Jose do Silva");
		assertFalse(usr.equals(usuario));
	}
	@Test
	public void CT26verificar_o_metodo_equals() {
		Usuario usr = new Usuario();
		usr.setRa("123");
		usuario.setRa(null);
		assertFalse(usr.equals(usuario));
	}
	@Test
	public void CT27verificar_o_metodo_equals() {
		Usuario usr = new Usuario();
		usr.setRa("123");
		assertFalse(usuario.equals(usr));
	}
	@Test
	public void CT28verificar_o_metodo_equals() {
		Usuario usr = new Usuario();
		usr.setNome("123");
		assertFalse(usuario.equals(usr));
	}

	
	
	@Test
	public void CT25testar_getLivro(){
		assertFalse(emprestimo.getLivro()==null);
	}
	
	

}
