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
	
	
	
	
	
	
	

}
