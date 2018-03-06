package Testes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Controllers.Facade;

public class FacadeTest {

	Facade facede;

	/**
	 * Testa O funcionamento do construtor de Sistema
	 */

	@Before
	public void testConstructor() {
		facede = new Facade();
	}

	/**
	 * Testa o funcionamento do metodo que cadastra alunos
	 */

	@Test
	public void testCadastraAluno() {
		facede.cadastrarAluno("nome", "111111111", 123456789, "(83)9999999", "email@email.com");
	}

	/**
	 * Testa o funcionamento do metodo recupera aluno
	 */

	@Test
	public void testRecuperaAluno() {
		facede.cadastrarAluno("nome", "111111111", 123456789, "(83)9999999", "email@email.com");
		Assert.assertEquals("111111111 - nome - 123456789 - (83)9999999 - email@email.com",
				facede.recuperaAluno("111111111"));
	}

	/**
	 * Testa o funcionamento do metodo listar alunos
	 */

	@Test
	public void testListarAlunos() {
		facede.cadastrarAluno("nome", "111111111", 123456789, "(83)9999999", "email@email.com");
		facede.cadastrarAluno("nome2", "211111111", 223456789, "1(83)9999999", "2email@email.com");
		Assert.assertEquals(
				"111111111 - nome - 123456789 - (83)9999999 - email@email.com, 211111111 - nome2 - 223456789 - 1(83)9999999 - 2email@email.com",
				facede.listarAlunos());
	}

	/**
	 * Testa o funcionamento do metodo getInfoAluno, verifica se o metodo retorna o
	 * nome
	 */

	@Test
	public void testGetInfoNome() {
		facede.cadastrarAluno("nome", "111111111", 123456789, "(83)9999999", "email@email.com");
		Assert.assertEquals("nome", facede.getInfoAluno("111111111", "Nome"));
	}

	/**
	 * Testa o funcionamento do metodo getInfoAluno, verifica se o metodo retorna o
	 * telefone
	 */

	@Test
	public void testGetInfoFone() {
		facede.cadastrarAluno("nome", "111111111", 123456789, "(83)9999999", "email@email.com");
		Assert.assertEquals("(83)9999999", facede.getInfoAluno("111111111", "Telefone"));
	}

	/**
	 * Testa o funcionamento do metodo getInfoAluno, verifica se o metodo retorna o
	 * Codigo de curso
	 */

	@Test
	public void testGetInfoCodigo() {
		facede.cadastrarAluno("nome", "111111111", 123456789, "(83)9999999", "email@email.com");
		Assert.assertEquals("123456789", facede.getInfoAluno("111111111", "CodigoCurso"));

	}

	/**
	 * Testa o funcionamento do metodo getInfoAluno, verifica se o metodo retorna o
	 * email
	 */

	@Test
	public void testGetInfoEmail() {
		facede.cadastrarAluno("nome", "111111111", 123456789, "(83)9999999", "email@email.com");
		Assert.assertEquals("email@email.com", facede.getInfoAluno("111111111", "Email"));
	}

	/**
	 * Testa o funcionamento do metodo getInfoAluno, verifica se o metodo retorna a
	 * avaliacao
	 */

	@Test
	public void testGetInfoAvaliacao() {
		facede.cadastrarAluno("nome", "111111111", 123456789, "(83)9999999", "email@email.com");
		Assert.assertEquals("5.0", facede.getInfoAluno("111111111", "Avaliacao"));

	}

	/**
	 * Testa o funcionamento do metodo tornar tutor
	 */

	@Test
	public void testTornarTutor() {
		facede.cadastrarAluno("nome", "111111111", 123456789, "(83)9999999", "email@email.com");
		facede.tornarTutor("111111111", "disciplina", 1);
	}

	/**
	 * Testa o funcionamento do metodo recupera tutor
	 */

	@Test
	public void testRecuperaTutor() {
		facede.cadastrarAluno("nome", "111111111", 123456789, "(83)9999999", "email@email.com");
		facede.tornarTutor("111111111", "disciplina", 1);
		Assert.assertEquals("111111111 - nome - 123456789 - (83)9999999 - email@email.com",
				facede.recuperaTutor("111111111"));
	}

	/**
	 * Testa o funcionamento do metodo listar tutores
	 */

	@Test
	public void testListarTutores() {
		facede.cadastrarAluno("nome", "111111111", 123456789, "(83)9999999", "email@email.com");
		facede.cadastrarAluno("nome2", "211111111", 223456789, "1(83)9999999", "2email@email.com");
		facede.tornarTutor("111111111", "disciplina", 1);
		facede.tornarTutor("211111111", "disciplina2", 2);
		Assert.assertEquals(
				"111111111 - nome - 123456789 - (83)9999999 - email@email.com, 211111111 - nome2 - 223456789 - 1(83)9999999 - 2email@email.com",
				facede.listarTutores());
	}

	/**
	 * Testa o funcionamento do metodo cadastrar horario
	 */

	@Test
	public void testCadastrarHorario() {
		facede.cadastrarAluno("nome", "111111111", 123456789, "(83)9999999", "email@email.com");
		facede.tornarTutor("111111111", "disciplina", 1);
		facede.cadastrarHorario("email@email.com", "00:00", "01/01");
	}

	/**
	 * Testa o funcionamento do metodo cadastrar local de atendimento
	 */

	@Test
	public void testCadastrarLocalDeAtendimento() {
		facede.cadastrarAluno("nome", "111111111", 123456789, "(83)9999999", "email@email.com");
		facede.tornarTutor("111111111", "disciplina", 1);
		facede.cadastrarLocalDeAtendimento("email@email.com", "local");
	}

	/**
	 * Testa o funcionamento do metodo consultar horario
	 */

	@Test
	public void testConsultaHorario() {
		facede.cadastrarAluno("nome", "111111111", 123456789, "(83)9999999", "email@email.com");
		facede.tornarTutor("111111111", "disciplina", 1);
		facede.cadastrarHorario("email@email.com", "00:00", "01/01");
		Assert.assertEquals(true, facede.consultaHorario("email@email.com", "00:00", "01/01"));
	}

	/**
	 * Testa o funcionamento do metodo consultar local
	 */

	@Test
	public void testConsultaLocal() {
		facede.cadastrarAluno("nome", "111111111", 123456789, "(83)9999999", "email@email.com");
		facede.tornarTutor("111111111", "disciplina", 1);
		facede.cadastrarLocalDeAtendimento("email@email.com", "local");
		Assert.assertEquals(true, facede.consultaLocal("email@email.com", "local"));
	}

}
