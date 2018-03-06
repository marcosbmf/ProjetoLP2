package Testes;

import static org.junit.Assert.*;

import org.junit.Test;

import ClassesBase.Ajuda;
import ClassesBase.AjudaOnline;
import ClassesBase.Aluno;
import ClassesBase.Tutor;

public class AjudaOnlineTest {

	Tutor tutor = new Tutor(new Aluno("Marcos", "111", 12, "83929292929", "joaizinhosexy@sexymail.com", 10), "LP2", 9001, 10);
	Ajuda ajuda;
	
	@Test
	public void testAjudaOnline() {
		ajuda = new AjudaOnline("6669", "LP2", tutor, 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAjudaOnlineInvalidoMatriculaNull() {
		ajuda = new AjudaOnline(null, "LP2", tutor, 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAjudaOnlineInvalidoMatriculaVazio() {
		ajuda = new AjudaOnline("  ", "LP2", tutor, 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAjudaOnlineInvalidoDisciplinaNull() {
		ajuda = new AjudaOnline("112312", null, tutor, 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAjudaOnlineInvalidoDisciplinaVazio() {
		ajuda = new AjudaOnline("112312", " ", tutor, 1);
	}
	
	@Test
	public void testPegarTutor() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetInfoAjuda() {
		fail("Not yet implemented");
	}


	@Test
	public void testCalculaPontuacaoFinal() {
		fail("Not yet implemented");
	}

}
