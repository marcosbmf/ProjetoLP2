package Testes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ClassesBase.Aluno;
import ClassesBase.Tutor;
import Controllers.AjudaController;


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
	
	
	@Test(expected = NullPointerException.class)
	public void testPedidoAjudaPresencialMatrAlunoNull() {
		ac.pedirAjudaPresencial(null, "666", "10:15", "20", "Hell", tutor);

	}
	
	@Test(expected = NullPointerException.class)
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
	
	

	@Test(expected = NullPointerException.class)
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
	
	@Test(expected = NullPointerException.class)
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
	
	@Test(expected = NullPointerException.class)
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
	
	@Test(expected = NullPointerException.class)
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
	
	
	@Test(expected = NullPointerException.class)
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
	
	
	@Test
	public void testPegarTutor(){
		ac.pedirAjudaOnline("666","666",tutor);
		Assert.assertEquals("Tutor - 117110596, disciplina - 666",ac.pegarTutor(1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPegarTutorNegativo(){
		ac.pedirAjudaOnline("666","666",tutor);
		ac.pegarTutor(-666);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPegarTutorInexistente(){
		ac.pedirAjudaOnline("666","666",tutor);
		ac.pegarTutor(666);
	}
	
	@Test
	public void testGetInfoAjudaMatricula(){
		ac.pedirAjudaPresencial("666", "666", "10:00", "22", "Hell", tutor);
		Assert.assertEquals("666", ac.getInfoAjuda(1,"matricula"));
	}
	
	
	@Test
	public void testGetInfoAjudaDisciplina(){
		ac.pedirAjudaPresencial("666", "666", "10:00", "22", "Hell", tutor);
		Assert.assertEquals("666", ac.getInfoAjuda(1,"disciplina"));
	}
	
	@Test
	public void testGetInfoAjudaHorario(){
		ac.pedirAjudaPresencial("666", "666", "10:00", "22", "Hell", tutor);
		Assert.assertEquals("666", ac.getInfoAjuda(1,"disciplina"));
	}
	
	

	@Test
	public void testGetInfoAjudaDia(){
		ac.pedirAjudaPresencial("666", "666", "10:00", "22", "Hell", tutor);
		Assert.assertEquals("22", ac.getInfoAjuda(1,"dia"));
	}
	
	@Test
	public void testGetInfoAjudaLocal(){
		ac.pedirAjudaPresencial("666", "666", "10:00", "22", "Hell", tutor);
		Assert.assertEquals("Hell", ac.getInfoAjuda(1,"localInteresse"));
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAjudaNegativa(){
		ac.pedirAjudaPresencial("666", "666", "10:00", "22", "Hell", tutor);
		ac.getInfoAjuda(-666,"localInteresse");
		
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAjudaInexistente(){
		ac.pedirAjudaPresencial("666", "666", "10:00", "22", "Hell", tutor);
		ac.getInfoAjuda(666,"localInteresse");
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAjudaInvalida(){
		ac.pedirAjudaPresencial("666", "666", "10:00", "22", "Hell", tutor);
		ac.getInfoAjuda(666,"666");
		
	}
	
	@Test
	public void testAvaliarTutor(){
		ac.pedirAjudaPresencial("666", "666", "10:00", "22", "Hell", tutor);
		ac.avaliarTutor(1, 5);
		Assert.assertEquals("4,17",String.format("%.2f", tutor.getNotaAvaliacao()));
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testAvaliarTutorNegativo(){
		ac.pedirAjudaPresencial("666", "666", "10:00", "22", "Hell", tutor);
		ac.avaliarTutor(1, -9);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAvaliarTutorNotaInvalida(){
		ac.pedirAjudaPresencial("666", "666", "10:00", "22", "Hell", tutor);
		ac.avaliarTutor(1, 9);
	}
	
	
	
	

}
