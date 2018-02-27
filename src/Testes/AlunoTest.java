package Testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ClassesBase.Aluno;

public class AlunoTest {

	Aluno aluno;
	
	@Before
	public void testaCriacaoAlunoValido() {
		aluno = new Aluno("MARCOS", "117110596", 6669, "838383838383", "mbf@ccc.ufcg.edu.br");
	}

}
