package Testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ClassesBase.Aluno;
import ClassesBase.Tutor;
import junit.framework.Assert;

public class TutorTest {
	
	Tutor tutor;
	
	/**
	 * 
	* Testa O funcionamento do construtor de TutorController
	*  
	*/
	@Before
	public void testConstrutor() {
		tutor = new Tutor("MARCOS", "117110596", 6669, "838383838383", "mbf@ccc.ufcg.edu.br",5,"lp2" ,10);
	}
	
	/**
	 * 
	* Testa se constroi com disciplina vazia
	*  
	*/
	@Test(expected = IllegalArgumentException.class)
	public void testDisciplinaNomeVazio() {
		tutor = new Tutor("MARCOS", "117110596", 6669, "838383838383", "mbf@ccc.ufcg.edu.br",5,"" ,10);
	}
	
	/**
	 * 
	* Testa se constroi com disciplina nula
	*  
	*/
	@Test(expected = NullPointerException.class)
	public void testDisciplinaNomeNull() {
		tutor = new Tutor("MARCOS", "117110596", 6669, "838383838383", "mbf@ccc.ufcg.edu.br",5,null ,10);
	}
	
	/**
	 * 
	* Testa se constroi com proficiencia zerada
	*  
	*/
	@Test(expected = IllegalArgumentException.class)
	public void testProfZero() {
		tutor = new Tutor("MARCOS", "117110596", 6669, "838383838383", "mbf@ccc.ufcg.edu.br",5,"lp2" ,0);
	}
	
	/**
	 * 
	* Testa se constroi com proficiencia negativa
	*  
	*/
	@Test(expected = IllegalArgumentException.class)
	public void testProfNegativa() {
		tutor = new Tutor("MARCOS", "117110596", 6669, "838383838383", "mbf@ccc.ufcg.edu.br",5,"lp2" ,-666);
	}
	
	/**
	 * 
	* Testa o funcionamento do metodo AddDisciplina que já existe
	*  
	*/
	@Test(expected = IllegalArgumentException.class)
	public void testAddDisciplinaJaExistente() {
		tutor.adicionaDisciplina("lp2", 666);
	}
	
	/**
	 * 
	* Testa o funcionamento do metodo AddDisciplina
	*  
	*/
	@Test
	public void testAddDisciplina() {
		tutor.adicionaDisciplina("the cure", 10);
	}
	
	/**
	 * 
	* Testa o funcionamento do metodo cadastraHorario
	*  
	*/
	@Test
	public void testAddHorario() {
		tutor.cadastrarHorario("15:30", "seg");
	}
	
	/**
	 * 
	* Testa o funcionamento do metodo consultaHorario
	*  
	*/
	@Test
	public void testConsultaHorarioInvalido() {
		tutor.cadastrarHorario("15:30", "seg");
		Assert.assertEquals(false ,tutor.consultaHorario("15:30", "ter"));
	}
	
	/**
	 * 
	* Testa o funcionamento do metodo cadastraLocalDeAtendimento
	*  
	*/
	@Test
	public void testCadastraLocal() {
		tutor.cadastrarLocalDeAtendimento("Hollywood Bow");
	}
	
	/**
	 * 
	* Testa o funcionamento do metodo consultaLocal
	*  
	*/
	@Test
	public void testConsultaLocalInvalido() {
		tutor.cadastrarLocalDeAtendimento("Hollywood Bow");
		Assert.assertEquals(false, tutor.consultaLocal("Quebrada"));
	}
	
	
	
	
	
}
