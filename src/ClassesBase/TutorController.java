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
		
		if(this.tutores.containsKey(matricula) && this.tutores.get(matricula).getDisciplina().trim().equals(disciplina)) {
			throw new IllegalArgumentException("Erro na definicao de papel: Ja eh tutor dessa disciplina");
		}
		else if (proficiencia < 0) {
			throw new IllegalArgumentException("Erro na definicao de papel: Proficiencia invalida");
		}

		
		Tutor novoTutor = new Tutor(nome, matricula, codigoCurso, telefone, email, notaAvaliacao, disciplina, proficiencia);
		
		tutores.put(matricula, novoTutor);
		
		return novoTutor;
	}
	
	public String recuperaTutor(String matricula) {
		if(!this.tutores.containsKey(matricula)) {
			throw new IllegalArgumentException("Erro na busca por tutor: Tutor nao encontrado");
		}
		return tutores.get(matricula).toString();
	}
	
	public String listarTutores()  {

		List<Tutor> tutores = new ArrayList<Tutor>();
		tutores.addAll(this.tutores.values());
		Collections.sort(tutores);
		String aux = "" ;
		for( Tutor tutor : tutores) {
			aux += tutor.toString() + ", " ;
		}
		return aux.substring(0, aux.length()-2) ; 
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
		boolean existe = true;
		for (String key : tutores.keySet()) {
			if(tutores.get(key).geteMail() == email) {
				matricula = tutores.get(key).getMatricula();
				existe = false;
			}
		}
		
		return matricula;
	}
	
	
	

}
