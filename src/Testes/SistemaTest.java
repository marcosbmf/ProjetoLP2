package Testes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ClassesBase.Sistema;

public class SistemaTest {

	Sistema sistema;

	@Before
	public void testConstructor() {
		sistema = new Sistema();
	}

	@Test
	public void testCadastraAluno() {
		sistema.cadastrarAluno("nome", "111111111", 123456789, "(83)9999999", "email@email.com");
	}

	@Test
	public void testRecuperaAluno() {
		sistema.cadastrarAluno("nome", "111111111", 123456789, "(83)9999999", "email@email.com");
		Assert.assertEquals("111111111 - nome - 123456789 - (83)9999999 - email@email.com",
				sistema.recuperaAluno("111111111"));
	}

	@Test
	public void testListarAlunos() {
		sistema.cadastrarAluno("nome", "111111111", 123456789, "(83)9999999", "email@email.com");
		sistema.cadastrarAluno("nome2", "211111111", 223456789, "1(83)9999999", "2email@email.com");
		Assert.assertEquals(
				"111111111 - nome - 123456789 - (83)9999999 - email@email.com, 211111111 - nome2 - 223456789 - 1(83)9999999 - 2email@email.com",
				sistema.listarAlunos());
	}

	@Test
	public void testGetInfoNome() {
		sistema.cadastrarAluno("nome", "111111111", 123456789, "(83)9999999", "email@email.com");
		Assert.assertEquals("nome", sistema.getInfoAluno("111111111", "Nome"));
	}

	@Test
	public void testGetInfoFone() {
		sistema.cadastrarAluno("nome", "111111111", 123456789, "(83)9999999", "email@email.com");
		Assert.assertEquals("(83)9999999", sistema.getInfoAluno("111111111", "Telefone"));
	}

	@Test
	public void testGetInfoCodigo() {
		sistema.cadastrarAluno("nome", "111111111", 123456789, "(83)9999999", "email@email.com");
		Assert.assertEquals("123456789", sistema.getInfoAluno("111111111", "CodigoCurso"));

	}

	@Test
	public void testGetInfoEmail() {
		sistema.cadastrarAluno("nome", "111111111", 123456789, "(83)9999999", "email@email.com");
		Assert.assertEquals("email@email.com", sistema.getInfoAluno("111111111", "Email"));
	}

	@Test
	public void testGetInfoAvaliacao() {
		sistema.cadastrarAluno("nome", "111111111", 123456789, "(83)9999999", "email@email.com");
		Assert.assertEquals("5.0", sistema.getInfoAluno("111111111", "Avaliacao"));

	}

	@Test
	public void testTornarTutor() {
		sistema.cadastrarAluno("nome", "111111111", 123456789, "(83)9999999", "email@email.com");
		sistema.tornarTutor("111111111", "disciplina", 1);
	}

	@Test
	public void testRecuperaTutor() {
		sistema.cadastrarAluno("nome", "111111111", 123456789, "(83)9999999", "email@email.com");
		sistema.tornarTutor("111111111", "disciplina", 1);
		Assert.assertEquals("111111111 - nome - 123456789 - (83)9999999 - email@email.com",
				sistema.recuperaTutor("111111111"));
	}

	@Test
	public void testListarTutores() {
		sistema.cadastrarAluno("nome", "111111111", 123456789, "(83)9999999", "email@email.com");
		sistema.cadastrarAluno("nome2", "211111111", 223456789, "1(83)9999999", "2email@email.com");
		sistema.tornarTutor("111111111", "disciplina", 1);
		sistema.tornarTutor("211111111", "disciplina2", 2);
		Assert.assertEquals(
				"111111111 - nome - 123456789 - (83)9999999 - email@email.com, 211111111 - nome2 - 223456789 - 1(83)9999999 - 2email@email.com",
				sistema.listarTutores());
	}

	@Test
	public void testCadastrarHorario() {
		sistema.cadastrarAluno("nome", "111111111", 123456789, "(83)9999999", "email@email.com");
		sistema.tornarTutor("111111111", "disciplina", 1);
		sistema.cadastrarHorario("email@email.com", "00:00", "01/01");
	}

	@Test
	public void testCadastrarLocalDeAtendimento() {
		sistema.cadastrarAluno("nome", "111111111", 123456789, "(83)9999999", "email@email.com");
		sistema.tornarTutor("111111111", "disciplina", 1);
		sistema.cadastrarLocalDeAtendimento("email@email.com", "local");
	}

	@Test
	public void testConsultaHorario() {
		sistema.cadastrarAluno("nome", "111111111", 123456789, "(83)9999999", "email@email.com");
		sistema.tornarTutor("111111111", "disciplina", 1);
		sistema.cadastrarHorario("email@email.com", "00:00", "01/01");
		Assert.assertEquals(true, sistema.consultaHorario("email@email.com", "00:00", "01/01"));
	}

	@Test
	public void testConsultaLocal() {
		sistema.cadastrarAluno("nome", "111111111", 123456789, "(83)9999999", "email@email.com");
		sistema.tornarTutor("111111111", "disciplina", 1);
		sistema.cadastrarLocalDeAtendimento("email@email.com", "local");
		Assert.assertEquals(true, sistema.consultaLocal("email@email.com", "local"));
	}

	@Test
	public void testPagarTutor() {
		sistema.cadastrarAluno("nome", "111111111", 123456789, "(83)9999999", "email@email.com");
		sistema.tornarTutor("111111111", "disciplina", 1);
		sistema.pagarTutor("111111111", 1);
	}
}
