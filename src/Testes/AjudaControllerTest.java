package Testes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ClassesBase.Aluno;
import ClassesBase.Tutor;
import Controllers.AjudaController;

/**
 * 
 * Classe responsavel por testar as funcionalidades da classe Ajuda.
 *
 */
public class AjudaControllerTest {
	
	Aluno aluno = new Aluno("MARCOS", "117110596", 6669, "838383838383", "mbf@ccc.ufcg.edu.br" ,1);
	Tutor tutor = new Tutor(aluno,  "lp2",5, 10);
	AjudaController  ac ;
	
	/**
	 * Testa O funcionamento do construtor de ajuda
	 */
	@Before
	public void testConstrutor() {
		ac = new AjudaController();
	}
	
	/**
	 * Testa o funcionamento da funcionalidade de pedir ajuda presencial. 
	 *  
	 */
	@Test
	public void testPedidoAjudaPresencial() {
		Assert.assertEquals(1, ac.pedirAjudaPresencial("666", "666", "10:15", "20", "Hell", tutor));
	}

	/**
	 * Testa se pede ajuda com a matricula vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedidoAjudaPresencialMatrAlunoVazia() {
		ac.pedirAjudaPresencial("", "666", "10:15", "20", "Hell", tutor);
	}
	/**
	 * Testa se pede ajuda com a matricula branca.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedidoAjudaPresencialMatrAlunoBranco() {
		ac.pedirAjudaPresencial("    ", "666", "10:15", "20", "Hell", tutor);
	}
	
	/**
	 * Testa se pede ajuda com a matricula nula.
	 */
	@Test(expected = NullPointerException.class)
	public void testPedidoAjudaPresencialMatrAlunoNull() {
		ac.pedirAjudaPresencial(null, "666", "10:15", "20", "Hell", tutor);

	}
	
	/**
	 * Testa se pede ajuda com a disciplina nula.
	 */
	@Test(expected = NullPointerException.class)
	public void testPedidoAjudaPresencialDisciplinaNull() {
		ac.pedirAjudaPresencial("666", null, "10:15", "20", "Hell", tutor);
	}
	
	/**
	 * Testa se pede ajuda com a disciplina vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedidoAjudaPresencialDisciplinaVazia() {
		ac.pedirAjudaPresencial("666", "", "10:15", "20", "Hell", tutor);
	}
	/**
	 * Testa se pede ajuda com a disciplina branca.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedidoAjudaPresencialDisciplinaBranco() {
		ac.pedirAjudaPresencial("666", "     ", "10:15", "20", "Hell", tutor);
	}	
	/**
	 * Testa se pede ajuda com a dia nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testPedidoAjudaPresencialDiaNull() {
		ac.pedirAjudaPresencial("666", "666", "10:15", null, "Hell", tutor);
	}
	
	/**
	 * Testa se pede ajuda com o dia vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedidoAjudaPresencialDiaVazio() {
		ac.pedirAjudaPresencial("666", "666", "10:15", "", "Hell", tutor);
	}
	/**
	 * Testa se pede ajuda com o dia branco.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedidoAjudaPresencialDiaBranco() { 
		ac.pedirAjudaPresencial("666", "666", "10:15", "    ", "Hell", tutor);
	}
	/**
	 * Testa se pede ajuda com o local nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testPedidoAjudaPresencialLocalNull() {
		ac.pedirAjudaPresencial("666", "666", "10:15", "20", null , tutor);
	}
	/**
	 * Testa se pede ajuda com o local vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedidoAjudaPresencialLocalVazio() {
		ac.pedirAjudaPresencial("666", "666", "10:15", "20","", tutor);
	}
	/**
	 * Testa se pede ajuda com o local branco.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedidoAjudaPresencialLocalBranco() {
		ac.pedirAjudaPresencial("666", "666", "10:15", "20","", tutor);
	}
	
	/**
	 * Testa se pede ajuda com o horario vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedidoAjudaPresencialHorarioVazio() {
		ac.pedirAjudaPresencial("666", "666", "10:15", "20","", tutor);

	}
	/**
	 * Testa se pede ajuda com o horario nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testPedidoAjudaPresencialHorarioNull() {
		ac.pedirAjudaPresencial("666", "666", "10:15", "20",null, tutor);
	}
	/**
	 * Testa se pede ajuda com o horario branco.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedidoAjudaPresencialHorarioBranco() {
		ac.pedirAjudaPresencial("666", "666", "10:15", "20","     ", tutor);
	}
	/**
	 * Testa se pede ajuda online. 
	 */
	@Test
	public void testPedidoAjudaOnline() {
		Assert.assertEquals(1, ac.pedirAjudaOnline("666", "666", tutor));
	}
	/**
	 * Testa se pede ajuda online com matricula nula.
	 */
	@Test(expected = NullPointerException.class)
	public void testPedidoAjudaOnlineMatrAlunoNull() {
		ac.pedirAjudaOnline(null, "666", tutor);
	}
	/**
	 * Testa se pede ajuda online com matricula vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedidoAjudaOnlineMatrAlunoVazia() {
		ac.pedirAjudaOnline("", "666", tutor);
		
	}
	/**
	 * Testa se pede ajuda online com matricula branca.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedidoAjudaOnlineMatrAlunoBranco() {
		ac.pedirAjudaOnline("   ", "666", tutor);
		
	}
	
	/**
	 * Testa se pede ajuda online com disciplina nula.
	 */
	@Test(expected = NullPointerException.class)
	public void testPedidoAjudaOnlineDisciplinaNull() {
		ac.pedirAjudaOnline("666", null, tutor);
		
	}
	/**
	 * Testa se pede ajuda online com disciplina branca.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedidoAjudaOnlineDisciplinaBranco() {
		ac.pedirAjudaOnline("666", "     ", tutor);
		
	}
	
	/**
	 * Testa se pede ajuda online com disciplina vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedidoAjudaOnlineDisciplinaVazia() {
		ac.pedirAjudaOnline("666", "", tutor);
		
	}
	/**
	 * Testa se pega o tutor.
	 */
	@Test
	public void testPegarTutor(){
		ac.pedirAjudaOnline("666","666",tutor);
		Assert.assertEquals("Tutor - 117110596, disciplina - 666",ac.pegarTutor(1));
	}
	/**
	 * Testa se pega o tutor com matricula negativa.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPegarTutorNegativo(){
		ac.pedirAjudaOnline("666","666",tutor);
		ac.pegarTutor(-666);
	}
	/**
	 * Testa se pega o tutor com matricula inexistente.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPegarTutorInexistente(){
		ac.pedirAjudaOnline("666","666",tutor);
		ac.pegarTutor(666);
	}
	/**
	 * Testa se pega informacao da ajuda.(matricula)
	 */
	@Test
	public void testGetInfoAjudaMatricula(){
		ac.pedirAjudaPresencial("666", "666", "10:00", "22", "Hell", tutor);
		Assert.assertEquals("666", ac.getInfoAjuda(1,"matricula"));
	}
	
	/**
	 * Testa se pega informacao da ajuda(disciplina)
	 */
	@Test
	public void testGetInfoAjudaDisciplina(){
		ac.pedirAjudaPresencial("666", "666", "10:00", "22", "Hell", tutor);
		Assert.assertEquals("666", ac.getInfoAjuda(1,"disciplina"));
	}
	/**
	 * Testa se pega informacao da ajuda.(horario)
	 */
	@Test
	public void testGetInfoAjudaHorario(){
		ac.pedirAjudaPresencial("666", "666", "10:00", "22", "Hell", tutor);
		Assert.assertEquals("666", ac.getInfoAjuda(1,"horario"));
	}
	
	/**
	 * Testa se pega informacao da ajuda.(dia)
	 */
	@Test
	public void testGetInfoAjudaDia(){
		ac.pedirAjudaPresencial("666", "666", "10:00", "22", "Hell", tutor);
		Assert.assertEquals("22", ac.getInfoAjuda(1,"dia"));
	}
	/**
	 * Testa se pega informacao do local de interesse
	 *
	 * */
	@Test
	public void testGetInfoAjudaLocal(){
		ac.pedirAjudaPresencial("666", "666", "10:00", "22", "Hell", tutor);
		Assert.assertEquals("Hell", ac.getInfoAjuda(1,"localInteresse"));
	}
	
	/**
	 * Testa se pega informação da ajuda negativa.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAjudaNegativa(){
		ac.pedirAjudaPresencial("666", "666", "10:00", "22", "Hell", tutor);
		ac.getInfoAjuda(-666,"localInteresse");
		
	}
	/**
	 * Testa se pega informação de ajuda inexistente.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAjudaInexistente(){
		ac.pedirAjudaPresencial("666", "666", "10:00", "22", "Hell", tutor);
		ac.getInfoAjuda(666,"localInteresse");
		
	}
	/**
	 * Testa se pega informação de ajuda invalida.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAjudaInvalida(){
		ac.pedirAjudaPresencial("666", "666", "10:00", "22", "Hell", tutor);
		ac.getInfoAjuda(666,"666");
		
	}
	/**
	 * Testa se avalia o tutor.
	 */
	@Test
	public void testAvaliarTutor(){
		ac.pedirAjudaPresencial("666", "666", "10:00", "22", "Hell", tutor);
		ac.avaliarTutor(1, 5);
		Assert.assertEquals("4,17",String.format("%.2f", tutor.getNotaAvaliacao()));
	}
	
	/**
	 * Testa se avalia o tutor com matricula negativa.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAvaliarTutorNegativo(){
		ac.pedirAjudaPresencial("666", "666", "10:00", "22", "Hell", tutor);
		ac.avaliarTutor(1, -9);
	}
	/**
	 * Testa se avalia o tutor passando nota negativa.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAvaliarTutorNotaInvalida(){
		ac.pedirAjudaPresencial("666", "666", "10:00", "22", "Hell", tutor);
		ac.avaliarTutor(1, 9);
	}
	
	
	
	

}
