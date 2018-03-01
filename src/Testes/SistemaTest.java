package Testes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ClassesBase.Facade;

public class SistemaTest {

	Facade sistema;
	
	/**
	* Testa O funcionamento do construtor de Sistema
	*/

	@Before
	public void testConstructor() {
		sistema = new Facade();
	}

	/**
	* Testa o funcionamento do metodo que cadastra alunos
	*/
	
	@Test
	public void testCadastraAluno() {
		sistema.cadastrarAluno("nome", "111111111", 123456789, "(83)9999999", "email@email.com");
	}
	
	/**
	* Testa o funcionamento do metodo recupera aluno
	*/

	@Test
	public void testRecuperaAluno() {
		sistema.cadastrarAluno("nome", "111111111", 123456789, "(83)9999999", "email@email.com");
		Assert.assertEquals("111111111 - nome - 123456789 - (83)9999999 - email@email.com",
				sistema.recuperaAluno("111111111"));
	}
	
	/**
	* Testa o funcionamento do metodo listar alunos
	*/
	
	@Test
	public void testListarAlunos() {
		sistema.cadastrarAluno("nome", "111111111", 123456789, "(83)9999999", "email@email.com");
		sistema.cadastrarAluno("nome2", "211111111", 223456789, "1(83)9999999", "2email@email.com");
		Assert.assertEquals(
				"111111111 - nome - 123456789 - (83)9999999 - email@email.com, 211111111 - nome2 - 223456789 - 1(83)9999999 - 2email@email.com",
				sistema.listarAlunos());
	}
	
	/**
	* Testa o funcionamento do metodo getInfoAluno, verifica se o metodo retorna o nome
	*/

	@Test
	public void testGetInfoNome() {
		sistema.cadastrarAluno("nome", "111111111", 123456789, "(83)9999999", "email@email.com");
		Assert.assertEquals("nome", sistema.getInfoAluno("111111111", "Nome"));
	}
	/**
	* Testa o funcionamento do metodo getInfoAluno, verifica se o metodo retorna o telefone
	*/

	@Test
	public void testGetInfoFone() {
		sistema.cadastrarAluno("nome", "111111111", 123456789, "(83)9999999", "email@email.com");
		Assert.assertEquals("(83)9999999", sistema.getInfoAluno("111111111", "Telefone"));
	}
	/**
	* Testa o funcionamento do metodo getInfoAluno, verifica se o metodo retorna o Codigo de curso
	*/

	@Test
	public void testGetInfoCodigo() {
		sistema.cadastrarAluno("nome", "111111111", 123456789, "(83)9999999", "email@email.com");
		Assert.assertEquals("123456789", sistema.getInfoAluno("111111111", "CodigoCurso"));

	}

	/**
	* Testa o funcionamento do metodo getInfoAluno, verifica se o metodo retorna o email
	*/
	
	@Test
	public void testGetInfoEmail() {
		sistema.cadastrarAluno("nome", "111111111", 123456789, "(83)9999999", "email@email.com");
		Assert.assertEquals("email@email.com", sistema.getInfoAluno("111111111", "Email"));
	}
	
	/**
	* Testa o funcionamento do metodo getInfoAluno, verifica se o metodo retorna a avaliacao
	*/

	@Test
	public void testGetInfoAvaliacao() {
		sistema.cadastrarAluno("nome", "111111111", 123456789, "(83)9999999", "email@email.com");
		Assert.assertEquals("5.0", sistema.getInfoAluno("111111111", "Avaliacao"));

	}
	/**
	* Testa o funcionamento do metodo tornar tutor
	*/

	@Test
	public void testTornarTutor() {
		sistema.cadastrarAluno("nome", "111111111", 123456789, "(83)9999999", "email@email.com");
		sistema.tornarTutor("111111111", "disciplina", 1);
	}
	/**
	* Testa o funcionamento do metodo recupera tutor
	*/

	@Test
	public void testRecuperaTutor() {
		sistema.cadastrarAluno("nome", "111111111", 123456789, "(83)9999999", "email@email.com");
		sistema.tornarTutor("111111111", "disciplina", 1);
		Assert.assertEquals("111111111 - nome - 123456789 - (83)9999999 - email@email.com",
				sistema.recuperaTutor("111111111"));
	}
	/**
	* Testa o funcionamento do metodo listar tutores
	*/

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
	/**
	* Testa o funcionamento do metodo cadastrar horario
	*/

	@Test
	public void testCadastrarHorario() {
		sistema.cadastrarAluno("nome", "111111111", 123456789, "(83)9999999", "email@email.com");
		sistema.tornarTutor("111111111", "disciplina", 1);
		sistema.cadastrarHorario("email@email.com", "00:00", "01/01");
	}
	/**
	* Testa o funcionamento do metodo cadastrar local de atendimento
	*/

	@Test
	public void testCadastrarLocalDeAtendimento() {
		sistema.cadastrarAluno("nome", "111111111", 123456789, "(83)9999999", "email@email.com");
		sistema.tornarTutor("111111111", "disciplina", 1);
		sistema.cadastrarLocalDeAtendimento("email@email.com", "local");
	}
	/**
	* Testa o funcionamento do metodo consultar horario
	*/

	@Test
	public void testConsultaHorario() {
		sistema.cadastrarAluno("nome", "111111111", 123456789, "(83)9999999", "email@email.com");
		sistema.tornarTutor("111111111", "disciplina", 1);
		sistema.cadastrarHorario("email@email.com", "00:00", "01/01");
		Assert.assertEquals(true, sistema.consultaHorario("email@email.com", "00:00", "01/01"));
	}
	/**
	* Testa o funcionamento do metodo consultar local
	*/

	@Test
	public void testConsultaLocal() {
		sistema.cadastrarAluno("nome", "111111111", 123456789, "(83)9999999", "email@email.com");
		sistema.tornarTutor("111111111", "disciplina", 1);
		sistema.cadastrarLocalDeAtendimento("email@email.com", "local");
		Assert.assertEquals(true, sistema.consultaLocal("email@email.com", "local"));
	}
	/**
	* Testa o funcionamento do metodo pagar tutor
	*/

	@Test
	public void testPagarTutor() {
		sistema.cadastrarAluno("nome", "111111111", 123456789, "(83)9999999", "email@email.com");
		sistema.tornarTutor("111111111", "disciplina", 1);
		sistema.pagarTutor("111111111", 1);
	}
}
