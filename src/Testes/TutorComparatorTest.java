package Testes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Controllers.Sistema;

public class TutorComparatorTest {

	Sistema sistema;
	
	@Before
	public void test() {
		sistema = new Sistema();
		sistema.cadastrarAluno("A", "15", 125, "(83) 3322-5544", "A@gmail.com");
		sistema.cadastrarAluno("B", "12", 125, "(83) 3322-5544", "C@gmail.com");
		sistema.cadastrarAluno("C", "5", 125, "(83) 3322-5544", "B@gmail.com");
		sistema.tornarTutor("15", "LP2", 10);
		sistema.tornarTutor("12", "LP2", 10);
		sistema.tornarTutor("5", "LP2", 10);
	}
	
	@Test
	public void testaEmailComparator() {
		sistema.configurarOrdem("EMAIL");
		String esperado = sistema.recuperaAluno("15") + ", "+ sistema.recuperaAluno("5") + ", " + sistema.recuperaAluno("12");
		Assert.assertEquals(esperado, sistema.listarTutores());
	}
	
	@Test
	public void testaNomeComparator() {
		sistema.configurarOrdem("NOME");
		String esperado = sistema.recuperaAluno("15") + ", "+ sistema.recuperaAluno("12") + ", " + sistema.recuperaAluno("5");
		Assert.assertEquals(esperado, sistema.listarTutores());
	}
	
	@Test
	public void testaMatriculaComparator() {
		sistema.configurarOrdem("MATRICULA");
		String esperado = sistema.recuperaAluno("5") + ", "+ sistema.recuperaAluno("12") + ", " + sistema.recuperaAluno("15");
		Assert.assertEquals(esperado, sistema.listarTutores());
	}

}
