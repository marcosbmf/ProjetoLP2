package ClassesBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TutorController {

	private Map<String, Tutor> tutores = new HashMap<String, Tutor>();

	public Tutor tornarTutor(String nome, String matricula, int codigoCurso, String telefone,
			String email, double notaAvaliacao, String disciplina, int proficiencia) {
		
		Tutor novoTutor = new Tutor(matricula, nome, codigoCurso, telefone, 
				email, notaAvaliacao, disciplina, proficiencia);
		
		tutores.put(matricula, novoTutor);
		
		return novoTutor;
	}
	
	public String recuperaTutor(String matricula) {
		return tutores.get(matricula).toString();
	}
	
	public String listarTutores()  {

		List<Tutor> tutores =  (List<Tutor>) this.tutores.values() ;
		String aux = "" ;
		Collections.sort(tutores);
		for(Tutor tutor : tutores) {
			aux += tutor.toString() + System.lineSeparator() ;
		}		
		return aux;
		
	}
	
	public void cadastrarHorario(String email, String horario, String dia) {
		this.tutores.get(procuraTutor(email)).cadastrarHorario(horario, dia);
	}
	
	public void cadastrarLocalDeAtendimento(String email, String local)  {
		this.tutores.get(procuraTutor(email)).cadastrarLocalDeAtendimento(local);
	}
	
	public boolean consultaHorario(String email, String horario, String dia) {
		return this.tutores.get(procuraTutor(email)).consultaHorario(horario, dia);
	}
	
	public boolean consultaLocal(String email, String local)  {
		return 	this.tutores.get(procuraTutor(email)).consultaLocal(local);
	}
	
	public void pagarTutor(String matricula, int quantidade) {
		
	}

	
	private String procuraTutor(String email) {
		String matricula = "";
		for (String key : tutores.keySet()) {
			if(tutores.get(key).geteMail() == email) {
				matricula = tutores.get(key).getMatricula();
			}
					
		}
		return matricula;
	}
	

}
