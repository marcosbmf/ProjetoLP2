package Testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ClassesBase.Aluno;
import ClassesBase.Tutor;
import Controllers.AjudaController;
import junit.framework.Assert;

public class AjudaControllerTest {
	
	Aluno aluno = new Aluno("MARCOS", "117110596", 6669, "838383838383", "mbf@ccc.ufcg.edu.br" ,1);
	Tutor tutor = new Tutor(aluno,  "lp2",5, 10);
	AjudaController  ac ;
	
	@Before
	public void testConstrutor() {
		ac = new AjudaController();
	}
	
	
	
	@Test
	public void testPedidoAjudaPresencial() {
		Assert.assertEquals(1, ac.pedirAjudaPresencial("666", "666", "10:15", "20", "Hell", tutor));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPedidoAjudaPresencialMatrAlunoVazia() {
		ac.pedirAjudaPresencial("", "666", "10:15", "20", "Hell", tutor);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPedidoAjudaPresencialMatrAlunoBranco() {
		ac.pedirAjudaPresencial("    ", "666", "10:15", "20", "Hell", tutor);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testPedidoAjudaPresencialMatrAlunoNull() {
		ac.pedirAjudaPresencial(null, "666", "10:15", "20", "Hell", tutor);

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPedidoAjudaPresencialDisciplinaNull() {
		ac.pedirAjudaPresencial("666", null, "10:15", "20", "Hell", tutor);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPedidoAjudaPresencialDisciplinaVazia() {
		ac.pedirAjudaPresencial("666", "", "10:15", "20", "Hell", tutor);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPedidoAjudaPresencialDisciplinaBranco() {
		ac.pedirAjudaPresencial("666", "     ", "10:15", "20", "Hell", tutor);
	}
	
	

	@Test(expected = IllegalArgumentException.class)
	public void testPedidoAjudaPresencialDiaNull() {
		ac.pedirAjudaPresencial("666", "666", "10:15", null, "Hell", tutor);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testPedidoAjudaPresencialDiaVazio() {
		ac.pedirAjudaPresencial("666", "666", "10:15", "", "Hell", tutor);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPedidoAjudaPresencialDiaBranco() { 
		ac.pedirAjudaPresencial("666", "666", "10:15", "    ", "Hell", tutor);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPedidoAjudaPresencialLocalNull() {
		ac.pedirAjudaPresencial("666", "666", "10:15", "20", null , tutor);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPedidoAjudaPresencialLocalVazio() {
		ac.pedirAjudaPresencial("666", "666", "10:15", "20","", tutor);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPedidoAjudaPresencialLocalBranco() {
		ac.pedirAjudaPresencial("666", "666", "10:15", "20","", tutor);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testPedidoAjudaPresencialHorarioVazio() {
		ac.pedirAjudaPresencial("666", "666", "10:15", "20","", tutor);

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPedidoAjudaPresencialHorarioNull() {
		ac.pedirAjudaPresencial("666", "666", "10:15", "20",null, tutor);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPedidoAjudaPresencialHorarioBranco() {
		ac.pedirAjudaPresencial("666", "666", "10:15", "20","     ", tutor);
	}
	
	@Test
	public void testPedidoAjudaOnline() {
		Assert.assertEquals(1, ac.pedirAjudaOnline("666", "666", tutor));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPedidoAjudaOnlineMatrAlunoNull() {
		ac.pedirAjudaOnline(null, "666", tutor);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPedidoAjudaOnlineMatrAlunoVazia() {
		ac.pedirAjudaOnline("", "666", tutor);
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPedidoAjudaOnlineMatrAlunoBranco() {
		ac.pedirAjudaOnline("   ", "666", tutor);
		
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testPedidoAjudaOnlineDisciplinaNull() {
		ac.pedirAjudaOnline("666", null, tutor);
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPedidoAjudaOnlineDisciplinaBranco() {
		ac.pedirAjudaOnline("666", "     ", tutor);
		
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testPedidoAjudaOnlineDisciplinaVazia() {
		ac.pedirAjudaOnline("666", "", tutor);
		
	}
	
	
	
	
	
	

}
