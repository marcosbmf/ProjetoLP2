package Testes;


import org.junit.Test;
import org.junit.Assert;

import ClassesBase.Ajuda;
import ClassesBase.AjudaOnline;
import ClassesBase.Aluno;
import ClassesBase.Tutor;

public class AjudaTest {
	/**
	 * Apenas verificando se a avaliacao chega at� o tutor por meio da referencia ou
	 * se seria necessario reescrev�-lo;
	 */
	Tutor tutor = new Tutor(new Aluno("Cloe", "1234", 10, "1230", "aaa@bbb", 4), "Life is Strange", 5, 1);
	Ajuda ajuda;
	Aluno aluno = new Aluno("Max", "12345", 10, "1230", "ccc@bbb", 4);

	@Test
	public void testAjuda() {
		ajuda = new AjudaOnline("12345", "Life is Strange", tutor, 1);
		ajuda.calculaPontuacaoFinal(4);
	}

	@Test
	public void testNivel() {
		ajuda = new AjudaOnline("12345", "Life is Strange", tutor, 1);
		ajuda.calculaPontuacaoFinal(4);
		Assert.assertEquals("Tutor", tutor.getNivel());
	}
}
