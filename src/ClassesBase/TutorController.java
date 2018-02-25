package ClassesBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TutorController {
	
	private Map<String, Tutor> tutores = new HashMap<String, Tutor>();
	

	public void tornarTutor(Aluno aluno, String disciplina, int proficiencia) {
		Tutor novoTutor = new Tutor(aluno.getMatricula(), aluno.getNome(), aluno.getCodigoCurso(), aluno.getTelefone(), aluno.geteMail(), aluno.getNotaAvalicao(), disciplina, proficiencia);
		
		tutores.put(aluno.getMatricula(), novoTutor);
		
	}
	
	public String recuperaTutor(String matricula)  {
		return tutores.get(matricula).toString();
	} 
	
	public String listarTutores()  {
		
		List<Tutor> tutores =  (List<Tutor>) this.tutores.values() ;
		String aux = "" ;
		
		//Collections.sort((List<T>) tutores);
		for( Aluno aluno : tutores) {
			aux += tutores.toString() + System.lineSeparator() ;
		}
		
		return aux ; 
	}
	
	public void cadastrarHorario(String email, String horario, String dia)  {
		
	}
	
	public void cadastrarLocalDeAtendimento(String email, String local)  {
		
	}
	
	public boolean consultaHorario(String email, String horario, String dia) {
		return true;
	}
	
	public boolean consultaLocal(String email, String local)  {
		return false;
	}




}
