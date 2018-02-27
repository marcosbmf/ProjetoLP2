package Testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ClassesBase.Aluno;
import ClassesBase.Tutor;
import junit.framework.Assert;

public class TutorTest {
	
	Tutor tutor;
	
	@Before
	public void testConstrutor() {
		tutor = new Tutor("MARCOS", "117110596", 6669, "838383838383", "mbf@ccc.ufcg.edu.br",5,"lp2" ,10);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDisciplinaNomeVazio() {
		tutor = new Tutor("MARCOS", "117110596", 6669, "838383838383", "mbf@ccc.ufcg.edu.br",5,"" ,10);
	}
	
	@Test(expected = NullPointerException.class)
	public void testDisciplinaNomeNull() {
		tutor = new Tutor("MARCOS", "117110596", 6669, "838383838383", "mbf@ccc.ufcg.edu.br",5,null ,10);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testProfZero() {
		tutor = new Tutor("MARCOS", "117110596", 6669, "838383838383", "mbf@ccc.ufcg.edu.br",5,"lp2" ,0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testProfNegativa() {
		tutor = new Tutor("MARCOS", "117110596", 6669, "838383838383", "mbf@ccc.ufcg.edu.br",5,"lp2" ,-666);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddDisciplinaJaExistente() {
		tutor.adicionaDisciplina("lp2", 666);
	}
	
	@Test
	public void testAddDisciplina() {
		tutor.adicionaDisciplina("the cure", 10);
	}
	
	
	@Test
	public void testAddHorario() {
		tutor.cadastrarHorario("15:30", "seg");
	}
	
	@Test
	public void testConsultaHorarioInvalido() {
		tutor.cadastrarHorario("15:30", "seg");
		Assert.assertEquals(false ,tutor.consultaHorario("15:30", "ter"));
	}
	
	
	@Test
	public void testCadastraLocal() {
		tutor.cadastrarLocalDeAtendimento("Hollywood Bow");
	}
	

	@Test
	public void testConsultaLocalInvalido() {
		tutor.cadastrarLocalDeAtendimento("Hollywood Bow");
		Assert.assertEquals(false, tutor.consultaLocal("Quebrada"));
	}
	
	
	
	
	
}
