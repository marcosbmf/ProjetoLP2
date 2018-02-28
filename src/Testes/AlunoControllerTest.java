package Testes;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ClassesBase.Aluno;
import ClassesBase.AlunoController;

public class AlunoControllerTest {
	AlunoController ac ;
	


	@Before
	public void testConstructor() {
		ac = new AlunoController();
	}
	
	@Test
	public void testCadastraAluno() {
		ac.cadastrarAluno("livinho","666", 666, "666", "666@666.com");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraAlunoEmailInvalido() {
		ac.cadastrarAluno("livinho","666", 666, "666", "666@");	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraAlunoJaCadastrado() {
		ac.cadastrarAluno("livinho","666", 666, "666", "666@666.com");
		ac.cadastrarAluno("livinho","666", 666, "666", "666@666.com");
	}
	
	@Test
	public void testRecuperaAluno() {
		ac.cadastrarAluno("livinho","666", 666, "666", "666@666.com");
		Assert.assertEquals("666 - livinho - 666 - 666 - 666@666.com",ac.recuperaAluno("666"));
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testRecuperaAlunoInexistente() {
		ac.cadastrarAluno("livinho","666", 666, "666", "666@666.com");
		ac.recuperaAluno("69");
	}
	
	@Test
	public void testListarAlunos() {
		ac.cadastrarAluno("livinho","666", 666, "666", "666@666.com");
		ac.cadastrarAluno("clairo", "lovegalore", 666, "666", "666@666.com");
		Assert.assertEquals("lovegalore - clairo - 666 - 666 - 666@666.com, 666 - livinho - 666 - 666 - 666@666.com",ac.listarAlunos() );
	}
	@Test
	public void testGetInfoNome() {
		ac.cadastrarAluno("clairo", "lovegalore", 666, "666", "666@666.com");
		Assert.assertEquals("clairo",ac.getinfoAluno("lovegalore", "Nome"));
	}
	
	@Test
	public void testGetInfoFone() {
		ac.cadastrarAluno("clairo", "lovegalore", 666, "666", "666@666.com");
		Assert.assertEquals("666",ac.getinfoAluno("lovegalore", "Telefone"));
	}
	
	
	@Test
	public void testGetInfoCodigo() {
		ac.cadastrarAluno("clairo", "lovegalore", 666, "666", "666@666.com");
		Assert.assertEquals("666",ac.getinfoAluno("lovegalore", "CodigoCurso"));
		
	}
	
	@Test
	public void testGetInfoEmail() {
		ac.cadastrarAluno("clairo", "lovegalore", 666, "666", "666@666.com");
		Assert.assertEquals("666@666.com",ac.getinfoAluno("lovegalore", "Email"));
	}
	
	
	
	@Test
	public void testGetInfoAvaliacao() {
		ac.cadastrarAluno("clairo", "lovegalore", 666, "666", "666@666.com",5);
		Assert.assertEquals("5.0",ac.getinfoAluno("lovegalore", "Avaliacao"));

	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoInvalida() {
		ac.cadastrarAluno("clairo", "lovegalore", 666, "666", "666@666.com",5);
		ac.getinfoAluno("lovegalore","Olhos");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoMatriculaInvalida() {
		ac.cadastrarAluno("clairo", "lovegalore", 666, "666", "666@666.com",5);
		ac.getinfoAluno("invalida", "Nome");
	}
	
	@Test
	public void testSetAluno() {
		
		ac.cadastrarAluno("livinho","666", 666, "666", "666@666.com");
		ac.setAluno("666", new Aluno("clairo","666",666,"666","666@666.com",5));
		Assert.assertEquals("666 - clairo - 666 - 666 - 666@666.com", ac.recuperaAluno("666"));
	}
	
	
	
	
	
}
