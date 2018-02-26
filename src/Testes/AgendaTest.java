package Testes;

import static org.junit.Assert.*;

import org.junit.Test;

import ClassesBase.Facade;
import ClassesBase.Sistema;
import ClassesBase.Tutor;

public class AgendaTest {

	@Test
	public void test() {
		Tutor  tutor = new  Tutor("nome", "matricula", 10 , "123123", "pica@gmai.com", 2 , "aaa", 2);
		tutor.cadastrarHorario("15:30", "seg");
		tutor.cadastrarHorario("15:00", "ter");

		assertEquals(true,tutor.consultaHorario("15:30", "seg"));
		assertEquals(true,tutor.consultaHorario("15:00", "ter"));	
		
	}
	
	@Test
	public void testconroller() {
		Sistema sis = new Sistema();
		sis.cadastrarAluno("nome", "matricula", 10 , "123123", "pica@gmai.com");
		sis.tornarTutor("matricula","engenharia da putaria", 1);
		sis.cadastrarHorario("pica@gmai.com", "15:00", "seg");
		assertEquals(true,sis.consultaHorario("pica@gmai.com", "15:00", "seg"));
	}
	 
	@Test
	public void testfacade() {
		Facade fac=  new Facade ();
		fac.cadastrarAluno("nome", "matricula", 10 , "123123", "pica@gmai.com");
		fac.tornarTutor("matricula","engenharia da putaria", 1);
		fac.cadastrarHorario("pica@gmai.com", "15:00", "seg");
		assertEquals(true,fac.consultaHorario("pica@gmai.com", "15:00", "seg"));
	}
	
	
	
	
	

}
