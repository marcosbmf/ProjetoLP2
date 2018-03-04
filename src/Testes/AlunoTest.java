package Testes;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import ClassesBase.Aluno;

public class AlunoTest {

	Aluno aluno;

	/**
	 * Testa O funcionamento do construtor de aluno
	 */
	@Before
	public void testaCriacaoAlunoValido() {
		aluno = new Aluno("MARCOS", "117110596", 6669, "838383838383", "mbf@ccc.ufcg.edu.br");
	}

	/**
	 * Testa se constroi aluno com avaliacao
	 */
	@Test
	public void testaCriacaoAlunoValidoComAvaliacao() {
		aluno = new Aluno("MARCOS", "117110596", 6669, "838383838383", "mbf@ccc.ufcg.edu.br", 4.4);
	}

	/**
	 * Testa se constroi com avaliacao zerada
	 */
	@Test
	public void testaCriacaoAlunoComAvaliacaoZero() {
		aluno = new Aluno("MARCOS", "117110596", 6669, "838383838383", "mbf@ccc.ufcg.edu.br", 0);
	}

	/**
	 * Testa se constroi com avaliacao negativa
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testaCriacaoAlunoComAvaliacaoNegativa() {
		aluno = new Aluno("MARCOS", "117110596", 6669, "838383838383", "mbf@ccc.ufcg.edu.br", -5);
	}

	/**
	 * Testa se constroi com avaliacao cinco.
	 */
	@Test
	public void testaCriacaoAlunoComAvaliacaoCinco() {
		aluno = new Aluno("MARCOS", "117110596", 6669, "838383838383", "mbf@ccc.ufcg.edu.br", 5);
	}

	/**
	 * Testa se constroi com avaliacao maior que cinco
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testaCriacaoAlunoComAvaliacaoMaiorQueCinco() {
		aluno = new Aluno("MARCOS", "117110596", 6669, "838383838383", "mbf@ccc.ufcg.edu.br", 6);
	}

	/**
	 * Testa se constroi com nome nulo
	 */
	@Test(expected = NullPointerException.class)
	public void testaCriacaoAlunoNomeNull() {
		aluno = new Aluno(null, "117110596", 6669, "838383838383", "mbf@ccc.ufcg.edu.br");
	}

	/**
	 * Testa se constroi com nome vazio
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testaCriacaoAlunoNomeVazio() {
		aluno = new Aluno("   ", "117110596", 6669, "838383838383", "mbf@ccc.ufcg.edu.br");
	}

	/**
	 * Testa se constroi com codigo de curso zerado
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testaCriacaoAlunoCodigoCursoZero() {
		aluno = new Aluno("   ", "117110596", 0, "838383838383", "mbf@ccc.ufcg.edu.br");
	}

	/**
	 * Testa se constroi com codigo de curso negativo
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testaCriacaoAlunoCodigoCursoNegativo() {
		aluno = new Aluno("   ", "117110596", -9000, "838383838383", "mbf@ccc.ufcg.edu.br");
	}

	/**
	 * Testa se constroi com matricula nula
	 */
	@Test(expected = NullPointerException.class)
	public void testaCriacaoAlunoMatriculaNull() {
		aluno = new Aluno("Marcos", null, 6669, "838383838383", "mbf@ccc.ufcg.edu.br");
	}

	/**
	 * Testa se constroi com matricula vazia
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testaCriacaoAlunoMatriculaVazio() {
		aluno = new Aluno("Marcos", "   ", 6669, "838383838383", "mbf@ccc.ufcg.edu.br");
	}

	/**
	 * Testa se constroi com telefone nulo
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testaCriacaoAlunoTelefoneNull() {
		aluno = new Aluno("Marcos", "89898989", 696969, null, "mbf@ccc.ufcg.edu.br");
	}

	/**
	 * Testa se constroi com telefone vazio
	 */
	@Test
	public void testaCriacaoAlunoTelefoneVazio() {
		aluno = new Aluno("Marcos", "8989", 6669, "", "mbf@ccc.ufcg.edu.br");
	}

	/**
	 * Testa se constroi com email nulo
	 */
	@Test(expected = NullPointerException.class)
	public void testaCriacaoAlunoEmailNull() {
		aluno = new Aluno("Marcos", "8989", 6669, "", null);
	}

	/**
	 * Testa se constroi com email vazio
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testaCriacaoAlunoeMailVazio() {
		aluno = new Aluno("Marcos", "89898", 6669, "838383838383", "   ");
	}

	/**
	 * Testa o ToString de aluno com telefone
	 */
	@Test
	public void testaToStringALunoCOmTelefone() {
		aluno = new Aluno("MARCOS", "117110596", 6669, "(83)9996-6699", "mbf@ccc.ufcg.edu.br");
		Assert.assertEquals("117110596 - MARCOS - 6669 - (83)9996-6699 - mbf@ccc.ufcg.edu.br", aluno.toString());
	}

	/**
	 * Testa o ToString de aluno sem telefone
	 */
	@Test
	public void testaToStringALunoSemTelefone() {
		aluno = new Aluno("MARCOS", "117110596", 6669, "", "mbf@ccc.ufcg.edu.br");
		Assert.assertEquals("117110596 - MARCOS - 6669 - mbf@ccc.ufcg.edu.br", aluno.toString());
	}

}
