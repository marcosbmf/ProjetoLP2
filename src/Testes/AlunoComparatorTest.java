package Testes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Controllers.Sistema;
/**
 * 
 * Classe responsavel por testar as funcionalidades da classe Aluno comparator
 *
 */
public class AlunoComparatorTest {

	Sistema sistema;
	
	@Before
	public void test() {
		sistema = new Sistema();
		sistema.cadastrarAluno("A", "15", 125, "(83) 3322-5544", "A@gmail.com");
		sistema.cadastrarAluno("B", "12", 125, "(83) 3322-5544", "C@gmail.com");
		sistema.cadastrarAluno("C", "5", 125, "(83) 3322-5544", "B@gmail.com");
	}
	
	/**
	 * Testa se ordena por email.
	 */
	@Test
	public void testaEmailComparator() {
		sistema.configurarOrdem("EMAIL");
		String esperado = sistema.recuperaAluno("15") + ", "+ sistema.recuperaAluno("5") + ", " + sistema.recuperaAluno("12");
		Assert.assertEquals(esperado, sistema.listarAlunos());
	}
	/**
	 * Testa se ordena nome.
	 */
	@Test
	public void testaNomeComparator() {
		sistema.configurarOrdem("NOME");
		String esperado = sistema.recuperaAluno("15") + ", "+ sistema.recuperaAluno("12") + ", " + sistema.recuperaAluno("5");
		Assert.assertEquals(esperado, sistema.listarAlunos());
	}
	/**
	 * Testa se ordena por matricula.
	 */
	@Test
	public void testaMatriculaComparator() {
		sistema.configurarOrdem("MATRICULA");
		String esperado = sistema.recuperaAluno("5") + ", "+ sistema.recuperaAluno("12") + ", " + sistema.recuperaAluno("15");
		Assert.assertEquals(esperado, sistema.listarAlunos());
	}
	
	
	

}
