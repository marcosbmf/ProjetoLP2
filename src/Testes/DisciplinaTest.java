package Testes;

import org.junit.Assert;
import org.junit.Test;

import ClassesBase.Disciplina;


public class DisciplinaTest {

	Disciplina disci;

	/**
	 * Testa O funcionamento do construtor de disciplina
	 */
	@Test
	public void testConstrutor() {
		disci = new Disciplina("Alcoolicos anonimos", 10);
	}

	/**
	 * Testa se constroi com nome vazio
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDisciplinaNomeVazio() {
		disci = new Disciplina("", 10);
	}

	/**
	 * Testa se constroi com nome nulo
	 */
	@Test(expected = NullPointerException.class)
	public void testDisciplinaNomeNull() {
		disci = new Disciplina(null, 10);
	}

	/**
	 * Testa se constroi com proficiencia zero
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDisciplinaProfZero() {
		disci = new Disciplina("Alcoolicos anonimos", 0);
	}

	/**
	 * Testa se constroi com proficiencia negativa
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDisciplinaProfNegativo() {
		disci = new Disciplina("Alcoolicos anonimos", -10);
	}

	/**
	 * Testa o funcionamento do metodo ToString de disciplina
	 */
	@Test
	public void testDisciplinaToString() {
		disci = new Disciplina("Alcoolicos anonimos", 2);
		Assert.assertEquals("Alcoolicos anonimos - 2", disci.toString());
	}

}
