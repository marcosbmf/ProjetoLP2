package Testes;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import ClassesBase.Agenda;

public class AgendaTest {

	Agenda agenda;

	/**
	 * Testa O funcionamento do construtor de agenda
	 */
	@Before
	public void testConstrutor() {
		agenda = new Agenda();
	}

	/**
	 * Testa o funcionamento do metodo cadastrar horario
	 */
	@Test
	public void testCadastraHorario() {
		agenda.cadastrarHorario("15:00", "ter");
	}

	/**
	 * Testa se cadastra com horario vazio
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraHorarioVazio() {
		agenda.cadastrarHorario("", "ter");
	}

	/**
	 * Testa se cadastra com horario branco
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraHorarioBranco() {
		agenda.cadastrarHorario("   ", "dia");
	}

	/**
	 * Testa se cadastra com horario nulo
	 */
	@Test(expected = NullPointerException.class)
	public void testCadastraHorarioNull() {
		agenda.cadastrarHorario(null, "dia");
	}

	/**
	 * Testa se cadastra com dia vazio
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraHoraioDiaVazio() {
		agenda.cadastrarHorario("15:00", "");
	}

	/**
	 * Testa se cadastra com dia branco
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrahorarioDiaBranco() {
		agenda.cadastrarHorario("15:00", "  ");
	}

	/**
	 * Testa se cadastra com dia nulo
	 */
	@Test(expected = NullPointerException.class)
	public void testCadastraDiaNull() {
		agenda.cadastrarHorario("15:00", null);
	}

	/**
	 * Testa o funcionamento do metodo consultar horario (caso haja horario)
	 */
	@Test
	public void testConsultaHorarioTrue() {
		agenda.cadastrarHorario("15:00", "seg");
		Assert.assertEquals(true, agenda.consultaHorario("15:00", "seg"));

	}

	/**
	 * Testa o funcionamento do metodo consultar horario (caso não haja horario)
	 */
	@Test
	public void testConsultaHorarioFalse() {
		agenda.cadastrarHorario("15:00", "ter");
		Assert.assertEquals(false, agenda.consultaHorario("15:00", "seg"));
	}

	/**
	 * Testa se consulta com hora vazia
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConsultaHorarioHoraVazia() {
		agenda.cadastrarHorario("15:00", "seg");
		agenda.consultaHorario("", "seg");
	}

	/**
	 * Testa se consulta com hora branca
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConsultaHorarioHoraBranco() {
		agenda.cadastrarHorario("15:00", "ter");
		agenda.consultaHorario("  ", "ter");
	}

	/**
	 * Testa se consulta com dia vazio
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConsultaHorarioDiaVazio() {
		agenda.cadastrarHorario("15:00", "ter");
		agenda.consultaHorario("15:00", "");
	}

	/**
	 * Testa se consulta com dia branco
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConsultaHorarioDiaBranco() {
		agenda.cadastrarHorario("15:00", "ter");
		agenda.consultaHorario("15:00", "    ");
	}

	/**
	 * Testa se consulta com dia nulo
	 */
	@Test(expected = NullPointerException.class)
	public void testConsultaHorarioDiaNull() {
		agenda.cadastrarHorario("15:00", "ter");
		agenda.consultaHorario("15:00", null);
	}

	/**
	 * Testa o funcionamento do metodo cadastrar local
	 */
	@Test
	public void testCadastraLocal() {
		agenda.cadastrarLocalDeAtendimento("place");
	}

	/**
	 * Testa se cadastra com local vazio
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraLocalVazio() {
		agenda.cadastrarLocalDeAtendimento("");
	}

	/**
	 * Testa se cadastra com local branco
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraLocalBranco() {
		agenda.cadastrarLocalDeAtendimento("    ");
	}

	/**
	 * Testa se cadastra com local nulo
	 */
	@Test(expected = NullPointerException.class)
	public void testCadastraLocalNull() {
		agenda.cadastrarLocalDeAtendimento(null);
	}

	/**
	 * Testa o funcionamento do metodo cadastrar local
	 */
	@Test
	public void testConsultaLocal() {
		agenda.cadastrarLocalDeAtendimento("place");
		Assert.assertEquals(true, agenda.consultaLocal("place"));
	}

}
