package ClassesBase;

import java.util.HashMap;
import java.util.Map;

public class TutorController {
	
	private Map<String, Tutor> tutores = new HashMap<String, Tutor>();
	

	public void tornarTutor(String matricula, String nome, int codigoCurso, String telefone, String eMail, double notaAvaliacao, String disciplina, int proficiencia) {
		Tutor novoTutor = new Tutor(matricula, nome, codigoCurso, telefone, eMail, notaAvaliacao, disciplina, proficiencia);
		tutores.put(matricula, novoTutor);
		
	}
	
	public String recuperaTutor(String matricula)  {
		return tutores.get(matricula).toString();
	} 
	
	public String listarTutores()  {
		String aux = "";
		
		return "";
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
