package Testes;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ClassesBase.Aluno;
import Controllers.AlunoController;

public class AlunoControllerTest {
	AlunoController ac ;
	
	/**
	 * 
	* Testa O funcionamento do construtor de alunoController
	*  
	*/
	@Before
	public void testConstructor() {
		ac = new AlunoController();
	}
	
	/**
	 * 
	* Testa O funcionamento do metodo cadastra aluno
	*  
	*/
	@Test
	public void testCadastraAluno() {
		ac.cadastrarAluno("livinho","666", 666, "666", "666@666.com");
	}
	
	/**
	 * 
	* Testa se constroi com email invalido
	*  
	*/
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraAlunoEmailInvalido() {
		ac.cadastrarAluno("livinho","666", 666, "666", "666@");	}
	
	/**
	* 
	* Testa se constroi aluno ja cadastrado
	*  
	*/
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraAlunoJaCadastrado() {
		ac.cadastrarAluno("livinho","666", 666, "666", "666@666.com");
		ac.cadastrarAluno("livinho","666", 666, "666", "666@666.com");
	}
	
	/**
	 * 
	* Testa o funcionamento do metodo recupera aluno
	*  
	*/
	@Test
	public void testRecuperaAluno() {
		ac.cadastrarAluno("livinho","666", 666, "666", "666@666.com");
		Assert.assertEquals("666 - livinho - 666 - 666 - 666@666.com",ac.recuperaAluno("666"));
	}
	
	/**
	 * 
	* Testa se recupera aluno inexistente 
	*  
	*/
	@Test(expected = IllegalArgumentException.class)
	public void testRecuperaAlunoInexistente() {
		ac.cadastrarAluno("livinho","666", 666, "666", "666@666.com");
		ac.recuperaAluno("69");
	}
	
	/**
	 * 
	* Testa O funcionamento do metodo listar aluno
	*  
	*/
	@Test
	public void testListarAlunos() {
		ac.cadastrarAluno("livinho","666", 666, "666", "666@666.com");
		ac.cadastrarAluno("clairo", "lovegalore", 666, "666", "666@666.com");
		Assert.assertEquals("lovegalore - clairo - 666 - 666 - 666@666.com, 666 - livinho - 666 - 666 - 666@666.com",ac.listarAlunos() );
	}
	
	/**
	 * 
	* Testa O funcionamento do metodo getInfo para o atributo Nome
	*  
	*/
	@Test
	public void testGetInfoNome() {
		ac.cadastrarAluno("clairo", "lovegalore", 666, "666", "666@666.com");
		Assert.assertEquals("clairo",ac.getinfoAluno("lovegalore", "Nome"));
	}
	
	/**
	 * 
	* Testa O funcionamento do metodo getInfo para o atributo Fone
	*  
	*/
	@Test
	public void testGetInfoFone() {
		ac.cadastrarAluno("clairo", "lovegalore", 666, "666", "666@666.com");
		Assert.assertEquals("666",ac.getinfoAluno("lovegalore", "Telefone"));
	}
	
	/**
	 * 
	* Testa O funcionamento do metodo getInfo para o atributo Codigo de curso
	*  
	*/
	@Test
	public void testGetInfoCodigo() {
		ac.cadastrarAluno("clairo", "lovegalore", 666, "666", "666@666.com");
		Assert.assertEquals("666",ac.getinfoAluno("lovegalore", "CodigoCurso"));
		
	}
	
	/**
	 * 
	* Testa O funcionamento do metodo getInfo para o atributo Email
	*  
	*/
	@Test
	public void testGetInfoEmail() {
		ac.cadastrarAluno("clairo", "lovegalore", 666, "666", "666@666.com");
		Assert.assertEquals("666@666.com",ac.getinfoAluno("lovegalore", "Email"));
	}
	
	
	/**
	 * 
	* Testa O funcionamento do metodo getInfo para o atributo Avaliacao
	*  
	*/
	@Test
	public void testGetInfoAvaliacao() {
		ac.cadastrarAluno("clairo", "lovegalore", 666, "666", "666@666.com",5);
		Assert.assertEquals("5.0",ac.getinfoAluno("lovegalore", "Avaliacao"));

	}
	
	/**
	 * 
	* Testa O funcionamento do metodo getInfoInvalida
	*  
	*/
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoInvalida() {
		ac.cadastrarAluno("clairo", "lovegalore", 666, "666", "666@666.com",5);
		ac.getinfoAluno("lovegalore","Olhos");
	}
	
	/**
	 * 
	* Testa se pega a informacao com matricula invalida
	*  
	*/
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoMatriculaInvalida() {
		ac.cadastrarAluno("clairo", "lovegalore", 666, "666", "666@666.com",5);
		ac.getinfoAluno("invalida", "Nome");
	}
	
	/**
	 * 
	* Testa O funcionamento do metodo SetAluno
	*  
	*/
	@Test
	public void testSetAluno() {
		
		ac.cadastrarAluno("livinho","666", 666, "666", "666@666.com");
		ac.setAluno("666", new Aluno("clairo","666",666,"666","666@666.com",5));
		Assert.assertEquals("666 - clairo - 666 - 666 - 666@666.com", ac.recuperaAluno("666"));
	}
	
	
	
	
	
}
