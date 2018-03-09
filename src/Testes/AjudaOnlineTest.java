package Testes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ClassesBase.Ajuda;
import ClassesBase.AjudaOnline;
import ClassesBase.Aluno;
import ClassesBase.Tutor;

public class AjudaOnlineTest {

	Tutor tutor = new Tutor(new Aluno("Marcos", "111", 12, "83929292929", "joaizinhosexy@sexymail.com", 10), "LP2", 9001, 10);
	Ajuda ajuda;
	
	@Before
	public void testAjudaOnline() {
		ajuda = new AjudaOnline("6669", "LP2", tutor, 1);
	}
	
	@Test
	public void testContrutorAjudaOnline() {
		ajuda = new AjudaOnline("6669", "LP2", tutor, 1);
	}
	
	@Test(expected = NullPointerException.class)
	public void testAjudaOnlineInvalidoMatriculaNull() {
		ajuda = new AjudaOnline(null, "LP2", tutor, 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAjudaOnlineInvalidoMatriculaVazio() {
		ajuda = new AjudaOnline("  ", "LP2", tutor, 1);
	}
	
	@Test(expected = NullPointerException.class)
	public void testAjudaOnlineInvalidoDisciplinaNull() {
		ajuda = new AjudaOnline("112312", null, tutor, 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAjudaOnlineInvalidoDisciplinaVazio() {
		ajuda = new AjudaOnline("112312", " ", tutor, 1);
	}
	
	@Test
	public void testPegarTutor() {
		ajuda = new AjudaOnline("6669", "LP2", tutor, 1);
		Assert.assertEquals("Tutor - 111, disciplina - LP2", ajuda.pegarTutor());
	}

	@Test
	public void testGetInfoAjudaMatricula() {
		Assert.assertEquals("6669", this.ajuda.getInfoAjuda("matricula"));
	}
	
	@Test
	public void testGetInfoAjudaDisciplina() {
		Assert.assertEquals("LP2", this.ajuda.getInfoAjuda("disciplina"));
	}


	@Test
	public void testCalculaPontuacaoFinalNotaLimiteInferior() {
		ajuda.calculaPontuacaoFinal(0);
	}
	
	@Test
	public void testCalculaPontuacaoFinalNotaLimiteSuperior() {
		ajuda.calculaPontuacaoFinal(5);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCalculaPontuacaoFinalInvalidaNotaLimiteInferior() {
		ajuda.calculaPontuacaoFinal(-1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCalculaPontuacaoFinalInvalidaNotaLimiteSuperior() {
		ajuda.calculaPontuacaoFinal(6);
	}
	
	@Test
	public void testaCalculaPontuacaoFinalValor() {
		ajuda.calculaPontuacaoFinal(2);
		Assert.assertTrue(tutor.getNotaAvaliacao() == 22.0/6);
	}
	
}
