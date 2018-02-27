package Testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ClassesBase.Agenda;
import ClassesBase.Facade;
import ClassesBase.Sistema;
import ClassesBase.Tutor;

public class AgendaTest {
	
	Agenda agenda;
	
	@Before
	public void testConstrutor() {
		agenda = new Agenda();	
	}
	
	@Test
	public void testCadastraHorario() {
		agenda.cadastrarHorario("15:00","ter");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraHorarioVazio() {
		agenda.cadastrarHorario("","ter");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraHorarioBranco() {
		agenda.cadastrarHorario("   ", "dia");
	}
	
	@Test(expected = NullPointerException.class)
	public void testCadastraHorarioNull() {
		agenda.cadastrarHorario(null,"dia");
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraHoraioDiaVazio() {
		agenda.cadastrarHorario("15:00", "");
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrahorarioDiaBranco() {
		agenda.cadastrarHorario("15:00","  ");
	}
	
	@Test(expected = NullPointerException.class)
	public void testCadastraDiaNull() {
		agenda.cadastrarHorario("15:00", null);
	}
	
	
	@Test
	public void testConsultaHorarioTrue() {
		agenda.cadastrarHorario("15:00", "seg");
		assertEquals(true,agenda.consultaHorario("15:00", "seg"));
		
	}
	
	@Test
	public void testConsultaHorarioFalse() {
		agenda.cadastrarHorario("15:00", "ter");
		assertEquals(false,agenda.consultaHorario("15:00", "seg"));
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testConsultaHorarioHoraVazia() {
		agenda.cadastrarHorario("15:00","seg");
		agenda.consultaHorario("", "seg");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConsultaHorarioHoraBranco() {
		agenda.cadastrarHorario("15:00","ter");
		agenda.consultaHorario("  ", "ter");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConsultaHorarioDiaVazio() {
		agenda.cadastrarHorario("15:00","ter");
		agenda.consultaHorario("15:00", "");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConsultaHorarioDiaBranco() {
		agenda.cadastrarHorario("15:00","ter");
		agenda.consultaHorario("15:00", "    ");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConsultaHorarioDiaNull() {
		agenda.cadastrarHorario("15:00","ter");
		agenda.consultaHorario("15:00", null);
	}
	
	@Test
	public void testCadastraLocal() {
		agenda.cadastrarLocalDeAtendimento("place");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraLocalVazio() {
		agenda.cadastrarLocalDeAtendimento("");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraLocalBranco() {
		agenda.cadastrarLocalDeAtendimento("    ");
	}
	
	@Test(expected = NullPointerException.class)
	public void testCadastraLocalNull() {
		agenda.cadastrarLocalDeAtendimento(null);
	}
	
	@Test
	public void testConsultaLocal() {
		agenda.cadastrarLocalDeAtendimento("place");
		assertEquals(true,agenda.consultaLocal("place"));
	}
	

}
