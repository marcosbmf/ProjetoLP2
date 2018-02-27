package Testes;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import ClassesBase.Disciplina;

public class DisciplinaTest {
	
	Disciplina disci ;
	
	@Test
	public void testConstrutor () {
		disci = new Disciplina("Alcoolicos anonimos",10);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDisciplinaNomeVazio() {
		disci =  new Disciplina("", 10);
	}
	
	@Test(expected = NullPointerException.class)
	public void testDisciplinaNomeNull() {
		disci = new Disciplina(null,10);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDisciplinaProfZero() {
		disci = new Disciplina( "Alcoolicos anonimos" , 0);
	}
	

	@Test(expected = IllegalArgumentException.class)
	public void testDisciplinaProfNegativo() {
		disci = new Disciplina( "Alcoolicos anonimos" , -10);
	}
	
	
	@Test
	public void testDiscipĺinaToString() {
		disci = new Disciplina("Alcoolicos anonimos" , 2);
		Assert.assertEquals("Alcoolicos anonimos - 2" , disci.toString());
	}

}
