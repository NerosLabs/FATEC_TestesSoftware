package br.emprestimo.testeUnitario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.emprestimo.modelo.Emprestimo;
import br.emprestimo.modelo.Livro;
import br.emprestimo.modelo.Usuario;
import br.emprestimo.servico.ServicoEmprestimo;

public class UC06CadastrarLivro {
	static private Livro livro;
	static private Usuario usuario;
	static private ServicoEmprestimo servico;
	static private Emprestimo emprestimo;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// cenario
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
	public void CT05verificar_o_metodo_getIsbn() {
		assertEquals("121212", livro.getIsbn());
	}

	@Test
	public void CT01verificar_o_metodo_getIsbn() {
		assertFalse(usuario.equals(null));
	}

	@Test
	public void CT06verificar_o_metodo_getTitulo() {
		assertEquals("A revolução dos bichos", livro.getTitulo());
	}
	@Test
	public void CT07verificar_o_metodo_getAutor() {
		assertEquals("George Orwell", livro.getAutor());
	}

	@Test
	public void CT08verificar_o_metodo_getLivro() {
		assertEquals("teste", emprestimo.getLivro());
	}
	
}
