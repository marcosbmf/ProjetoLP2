package Testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ClassesBase.Tutor;
import ClassesBase.TutorController;
import junit.framework.Assert;

public class TutorControllerTest {
	
	TutorController tc ;
	
	
	@Before
	public void testConstrutor() {
		tc = new TutorController();
	}
	
	@Test
	public void testTornarTutor() {
	 tc.tornarTutor("clairo", "666", 666, "666", "666@666.com", 4.5, "lofi", 10);
		
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testTornarTutorProfzero() {
		tc.tornarTutor("clairo", "666", 666, "666", "666@666.com", 4.5, "lofi", 0);

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTornarTutorProfNegativa() {
		tc.tornarTutor("clairo", "666", 666, "666", "666@666.com", 4.5, "lofi", -10);

	}
	
	
	@Test
	public void TestCadastraHorario() {
		tc.tornarTutor("clairo", "666", 666, "666", "666@666.com", 4.5, "lofi",10);
		tc.cadastrarHorario("666@666.com","15:30","seg");
	}
	
	
	@Test
	public void testRecuperaTutor() {
		tc.tornarTutor("clairo", "666", 666, "666", "666@666.com", 4.5, "lofi",10);
		Assert.assertEquals("666 - clairo - 666 - 666 - 666@666.com",tc.recuperaTutor("666"));
	}
	
	@Test
	public void testListarTutor() {
		tc.tornarTutor("clairo", "666", 666, "666", "666@666.com", 4.5, "lofi",10);
		tc.tornarTutor("Naruto", "uchiha", 666, "666", "sad@666.com", 4.5, "lofi", 10);
		Assert.assertEquals("uchiha - Naruto - 666 - 666 - sad@666.com, 666 - clairo - 666 - 666 - 666@666.com", tc.listarTutores());
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void TestCadastraHorarioEmailVazio() {
		tc.tornarTutor("clairo", "666", 666, "666", "666@666.com", 4.5, "lofi",10);
		tc.cadastrarHorario("","15:30","seg");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void TestCadastraHorarioEmailInvalido() {
		tc.tornarTutor("clairo", "666", 666, "666", "666@666.com", 4.5, "lofi",10);
		tc.cadastrarHorario("666@","15:30","seg");
	}
	
	
	@Test
	public void TestConsultaHorario() {
		tc.tornarTutor("clairo", "666", 666, "666", "666@666.com", 4.5, "lofi",10);
		tc.cadastrarHorario("666@666.com","15:30","seg");
		Assert.assertEquals(true, tc.consultaHorario("666@666.com", "15:30", "seg"));
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void TestConsultaHorarioEmailVazio() {
		tc.tornarTutor("clairo", "666", 666, "666", "666@666.com", 4.5, "lofi",10);
		tc.cadastrarHorario(" ","15:30","seg");
		Assert.assertEquals(true, tc.consultaHorario("666@666.com", "15:30", "seg"));
	}
	
	
	
	@Test
	public void testCadastraLocal() {
		tc.tornarTutor("clairo", "666", 666, "666", "666@666.com", 4.5, "lofi",10);
		tc.cadastrarLocalDeAtendimento("666@666.com", "hell");
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraLocalEmailVazio() {
		tc.tornarTutor("clairo", "666", 666, "666", "666@666.com", 4.5, "lofi",10);
		tc.cadastrarLocalDeAtendimento(" ", "hell");
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraLocalEmailInvalido() {
		tc.tornarTutor("clairo", "666", 666, "666", "666@666.com", 4.5, "lofi",10);
		tc.cadastrarLocalDeAtendimento("666@", "hell");
	}
	
	
	
	@Test
	public void testConsultaLocalEmail() {
		tc.tornarTutor("clairo", "666", 666, "666", "666@666.com", 4.5, "lofi",10);
		tc.cadastrarLocalDeAtendimento("666@666.com", "hell");
		Assert.assertEquals(true, tc.consultaLocal("666@666.com", "hell"));
		
	}
	
	
	
	

	
	
	
	
	
	
}
