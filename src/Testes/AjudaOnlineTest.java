package Testes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ClassesBase.Ajuda;
import ClassesBase.AjudaOnline;
import ClassesBase.Aluno;
import ClassesBase.Tutor;

/**
 * Classe de teste de AjudaOnline
 * @author marcosbmf
 *
 */
public class AjudaOnlineTest {

	Tutor tutor = new Tutor(new Aluno("Marcos", "111", 12, "83929292929", "joaizinhosexy@sexymail.com", 10), "LP2", 9001, 10);
	Ajuda ajuda;
	
	/**
	 * Inicializa uma ajuda.
	 */
	@Before
	public void testAjudaOnline() {
		ajuda = new AjudaOnline("6669", "LP2", tutor, 1);
	}
	
	
	/**
	 * Testa construtor de AjudaOnline.
	 */
	@Test
	public void testContrutorAjudaOnline() {
		ajuda = new AjudaOnline("6669", "LP2", tutor, 1);
	}
	
	/**
	 * Testa se construtor de AjudaOnline lança excessão quando matricula é nula.
	 */
	@Test(expected = NullPointerException.class)
	public void testAjudaOnlineInvalidoMatriculaNull() {
		ajuda = new AjudaOnline(null, "LP2", tutor, 1);
	}
	
	/**
	 * Testa se construtor de AjudaOnline lança excessão quando matricula é string vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAjudaOnlineInvalidoMatriculaVazio() {
		ajuda = new AjudaOnline("  ", "LP2", tutor, 1);
	}
	
	/**
	 * Testa se construtor de AjudaOnline lança excessão quando disciplina é nula.
	 */
	@Test(expected = NullPointerException.class)
	public void testAjudaOnlineInvalidoDisciplinaNull() {
		ajuda = new AjudaOnline("112312", null, tutor, 1);
	}
	
	/**
	 * Testa se construtor de AjudaOnline lança excessão quando disciplina é string vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAjudaOnlineInvalidoDisciplinaVazio() {
		ajuda = new AjudaOnline("112312", " ", tutor, 1);
	}
	
	/**
	 * Testa se a função pegarTutor funciona e retorna a forma correta em String.
	 */
	@Test
	public void testPegarTutor() {
		ajuda = new AjudaOnline("6669", "LP2", tutor, 1);
		Assert.assertEquals("Tutor - 111, disciplina - LP2", ajuda.pegarTutor());
	}

	/**
	 * Testa se getInfoAjuda funciona para o parametro "matricula"
	 */
	@Test
	public void testGetInfoAjudaMatricula() {
		Assert.assertEquals("6669", this.ajuda.getInfoAjuda("matricula"));
	}
	
	/**
	 * Testa se getInfoAJuda funciona para o parametro disciplina.
	 */
	@Test
	public void testGetInfoAjudaDisciplina() {
		Assert.assertEquals("LP2", this.ajuda.getInfoAjuda("disciplina"));
	}
	
	/**
	 * Testa se getInfoAJuda lança excessão para parametro inválido.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAjudaInvalido() {
		Assert.assertEquals("LP2", this.ajuda.getInfoAjuda("xxx"));
	}
	
	/**
	 * Testa se getInfoAJuda lança excessão para parametro nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testGetInfoAjudaInvalidoNull() {
		Assert.assertEquals("LP2", this.ajuda.getInfoAjuda(null));
	}
	
	/**
	 * Testa se getInfoAJuda lança excessão para parametro vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAjudaInvalidoVazio() {
		Assert.assertEquals("LP2", this.ajuda.getInfoAjuda("   "));
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
	 * Testa se calculaPontuacaoFInal lança excessão ao tentar atribuir nota abaixo do limite inferior.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCalculaPontuacaoFinalInvalidaNotaLimiteInferior() {
		ajuda.calculaPontuacaoFinal(-1);
	}
	
	/**
	 * Testa se calculaPontuacaoFInal lança excessão ao tentar atribuir nota acima do limite superior.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCalculaPontuacaoFinalInvalidaNotaLimiteSuperior() {
		ajuda.calculaPontuacaoFinal(6);
	}
	
	/**
	 * Verifica se é lançada uma excessão ao tentar avaliar um tutor pela mesma ajuda mais de uma vez.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testaCalculaPontuacaoFinalRepetidamente() {
		ajuda.calculaPontuacaoFinal(3);
		ajuda.calculaPontuacaoFinal(3);
	}
	
	/**
	 * Testa se ao atribuir uma pontuação ao tutor a nota dele é atualizada de acordo.
	 */
	@Test
	public void testaCalculaPontuacaoFinalValor() {
		ajuda.calculaPontuacaoFinal(2);
		Assert.assertTrue(tutor.getNotaAvaliacao() == 22.0/6);
	}
	
}
