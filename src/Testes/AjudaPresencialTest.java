package Testes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ClassesBase.Ajuda;
import ClassesBase.AjudaPresencial;
import ClassesBase.Aluno;
import ClassesBase.Tutor;

public class AjudaPresencialTest {

	Aluno aluno = new Aluno("Marquinhos", "116111111", 13, "868686868686", "marquinhos@ccc.ufcg.edu.br", 2);
	Aluno alunotutor = new Aluno("MARCOS", "117110596", 14, "838383838383", "mbf@ccc.ufcg.edu.br", 1);
	Tutor tutor = new Tutor(alunotutor, "lp2", 5, 10);
	Ajuda ajuda;

	@Before
	public void testAjudaPresencial() {
		ajuda = new AjudaPresencial("116111111", "lp2", "00:00", "01/03", "local", tutor, 1);
	}

	/**
	 * Testa construtor de AjudaOnline.
	 */
	@Test
	public void testContrutorAjudaPresencial() {
		ajuda = new AjudaPresencial("13", "lp2", "00:00", "01/03", "local", tutor, 2);
	}

	/**
	 * Testa se construtor de AjudaPresencial lanca excessao quando matricula eh
	 * nula.
	 */
	@Test(expected = NullPointerException.class)
	public void testAjudaPresencialInvalidoMatriculaNull() {
		ajuda = new AjudaPresencial(null, "lp2", "00:00", "01/03", "local", tutor, 1);
	}

	/**
	 * Testa se construtor de AjudaPresencial lanca excessao quando matricula eh uma
	 * string vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAjudaPresencialInvalidoMatriculaVazio() {
		ajuda = new AjudaPresencial("  ", "lp2", "00:00", "01/03", "local", tutor, 1);
	}

	/**
	 * Testa se construtor de AjudaPresencial lanca excessao quando disciplina eh
	 * nula.
	 */
	@Test(expected = NullPointerException.class)
	public void testAjudaPresencialInvalidoDisciplinaNull() {
		ajuda = new AjudaPresencial("116111111", null, "00:00", "01/03", "local", tutor, 1);
	}

	/**
	 * Testa se construtor de AjudaPresencial lanca excessao quando disciplina eh
	 * uma string vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAjudaPresencialInvalidoDisciplinaVazio() {
		ajuda = new AjudaPresencial("116111111", "  ", "00:00", "01/03", "local", tutor, 1);
	}

	/**
	 * Testa se construtor de AjudaPresencial lanca excessao quando horario eh nula.
	 */

	@Test(expected = NullPointerException.class)
	public void testAjudaPresencialInvalidaHorarioNull() {
		ajuda = new AjudaPresencial("116111111", "lp2", null, "01/03", "local", tutor, 1);
	}

	/**
	 * Testa se construtor de AjudaPresencial lanca excessao quando horario eh uma
	 * string vazia.
	 */

	@Test(expected = IllegalArgumentException.class)
	public void testAjudaPresencialInvalidoHorarioVazio() {
		ajuda = new AjudaPresencial("116111111", "lp2", "  ", "01/03", "local", tutor, 1);
	}

	/**
	 * Testa se construtor de AjudaPresencial lanca excessao quando o dia eh nula.
	 */

	@Test(expected = NullPointerException.class)
	public void testAjudaPresencialInvalidaDiaNull() {
		ajuda = new AjudaPresencial("116111111", "lp2", "00:00", null, "local", tutor, 1);
	}

	/**
	 * Testa se construtor de AjudaPresencial lanca excessao quando dia eh string
	 * vazia.
	 */

	@Test(expected = IllegalArgumentException.class)
	public void testAjudaPresencialInvalidoDiaVazio() {
		ajuda = new AjudaPresencial("116111111", "lp2", "00:00", "  ", "local", tutor, 1);
	}

	/**
	 * Testa se construtor de AjudaPresencial lanca excessao quando local eh nula.
	 */

	@Test(expected = NullPointerException.class)
	public void testAjudaPresencialInvalidaLocalNull() {
		ajuda = new AjudaPresencial("116111111", "lp2", "00:00", "01/03", null, tutor, 1);
	}

	/**
	 * Testa se construtor de AjudaPresencial lanca excessao quando local eh uma
	 * string vazia.
	 */

	@Test(expected = IllegalArgumentException.class)
	public void testAjudaPresencialInvalidoLocalVazio() {
		ajuda = new AjudaPresencial("116111111", "lp2", "00:00", "01/03", "  ", tutor, 1);
	}

	/**
	 * Testa se a funcao pegarTutor funciona e retorna a forma correta em string.
	 */

	@Test
	public void testPegarTutor() {
		ajuda = new AjudaPresencial("116111111", "lp2", "00:00", "01/03", "local", tutor, 1);
		Assert.assertEquals("Tutor - 117110596, horario - 00:00, dia - 01/03, local - local, disciplina - lp2",
				ajuda.pegarTutor());
	}

	/**
	 * Testa se getInfoAjuda funciona para o parametro "matricula"
	 */
	@Test
	public void testGetInfoAjudaMatricula() {
		Assert.assertEquals("116111111", this.ajuda.getInfoAjuda("matricula"));
	}

	/**
	 * Testa se getInfoAJuda funciona para o parametro "disciplina".
	 */
	@Test
	public void testGetInfoAjudaDisciplina() {
		Assert.assertEquals("lp2", this.ajuda.getInfoAjuda("disciplina"));
	}

	/**
	 * Testa se getInfoAjuda funciona para o parametro "matricula"
	 */
	@Test
	public void testGetInfoAjudaDia() {
		Assert.assertEquals("01/03", this.ajuda.getInfoAjuda("dia"));
	}

	/**
	 * Testa se getInfoAJuda funciona para o parametro "horario".
	 */
	@Test
	public void testGetInfoAjudaHorario() {
		Assert.assertEquals("00:00", this.ajuda.getInfoAjuda("horario"));
	}

	/**
	 * Testa se getInfoAJuda funciona para o parametro "local".
	 */
	@Test
	public void testGetInfoAjudaLocal() {
		Assert.assertEquals("local", this.ajuda.getInfoAjuda("localInteresse"));
	}

	/**
	 * Testa se getInfoAJuda lanca excessao para parametro invalido.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAjudaInvalido() {
		Assert.assertEquals("lp2", this.ajuda.getInfoAjuda("invalido"));
	}

	/**
	 * Testa se getInfoAJuda lanca excessao para parametro nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testGetInfoAjudaInvalidoNull() {
		Assert.assertEquals("lp2", this.ajuda.getInfoAjuda(null));
	}

	/**
	 * Testa se getInfoAJuda lança excessão para parametro vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAjudaInvalidoVazio() {
		Assert.assertEquals("lp2", this.ajuda.getInfoAjuda("   "));
	}

	/**
	 * Testa se calculaPontuacaoFInal funciona no parametro minimo.
	 */
	@Test
	public void testCalculaPontuacaoFinalNotaLimiteInferior() {
		ajuda.calculaPontuacaoFinal(0);
	}

	/**
	 * Testa se calculaPontuacaoFInal funciona no parametro maximo.
	 */
	@Test
	public void testCalculaPontuacaoFinalNotaLimiteSuperior() {
		ajuda.calculaPontuacaoFinal(5);
	}

	/**
	 * Testa se calculaPontuacaoFInal lanca excessao ao tentar atribuir nota abaixo
	 * do limite inferior.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCalculaPontuacaoFinalInvalidaNotaLimiteInferior() {
		ajuda.calculaPontuacaoFinal(-1);
	}

	/**
	 * Testa se calculaPontuacaoFInal lanca excessao ao tentar atribuir nota acima
	 * do limite superior.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCalculaPontuacaoFinalInvalidaNotaLimiteSuperior() {
		ajuda.calculaPontuacaoFinal(6);
	}

	/**
	 * Verifica se eh lancada uma excessao ao tentar avaliar um tutor pela mesma
	 * ajuda mais de uma vez.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testaCalculaPontuacaoFinalRepetidamente() {
		ajuda.calculaPontuacaoFinal(3);
		ajuda.calculaPontuacaoFinal(3);
	}

	/**
	 * Testa se ao atribuir uma pontuacao ao tutor a nota dele eh atualizada de
	 * acordo.
	 */
	@Test
	public void testaCalculaPontuacaoFinalValor() {
		ajuda.calculaPontuacaoFinal(2);
		Assert.assertTrue(tutor.getNotaAvaliacao() == 22.0 / 6);
	}

}
