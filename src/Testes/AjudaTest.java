package Testes;

import static org.junit.Assert.*;

import org.junit.Test;

import ClassesBase.Ajuda;
import ClassesBase.AjudaOnline;
import ClassesBase.Aluno;
import ClassesBase.Tutor;
import junit.framework.Assert;

public class AjudaTest {
	/**
	 * Apenas verificando se a avaliacao chega até o tutor por meio da referencia ou
	 * se seria necessario reescrevê-lo;
	 */
	Tutor tutor = new Tutor(new Aluno("Cloe", "1234", 10, "1230", "aaa@bbb", 4.6), "Life is Strange", 5, 1);
	Ajuda ajuda;
	Aluno aluno = new Aluno("Max", "12345", 10, "1230", "ccc@bbb", 4.6);

	@Test
	public void testAjuda() {
		ajuda = new AjudaOnline("12345", "Life is Strange", tutor, 1);
		ajuda.calculaPontuacaoFinal(4);
		Assert.assertEquals(4.0, tutor.getNotaAvaliacao());
	}
	
	
	@Test
	public void testNivel() {
		ajuda = new AjudaOnline("12345", "Life is Strange", tutor, 1);
		ajuda.calculaPontuacaoFinal(4);
		Assert.assertEquals("Tutor", tutor.getNivel());
	}
}
