package ClassesBase;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlunoController {
	private Map<String,Aluno> alunos = new HashMap<String,Aluno> ();	
	
	public void cadastrarAluno(String nome , String matricula , int codigoCurso , String telefone, String email) {
		alunos.put(matricula , new Aluno(nome , matricula , codigoCurso , telefone, email)) ; 
		
	}
	
	public String recuperaAluno(String matricula) {
		return alunos.get(matricula).toString() ;
	}
	
	public String listarAlunos() {
		List<Aluno> alunos =  (List<Aluno>) this.alunos.values() ;
		String aux = "" ;
		Collections.sort(alunos);
		for( Aluno aluno : alunos) {
			aux += aluno.toString() + System.lineSeparator() ;
		}
		
		return aux ; 
	}
	
	public String   getinfoAluno(String matricula, String atributo) {
			switch(atributo) {
			case "nome": 
				return this.alunos.get(matricula).getNome();
			
			case "telefone":
				return this.alunos.get(matricula).getTelefone();
			
			case "codigoCurso":
				return "" +  this.alunos.get(matricula).getCodigoCurso();
			case "email":
				return this.alunos.get(matricula).geteMail();
			case"avaliacao":
				return ""  +  this.alunos.get(matricula).getNotaAvalicao();
			
			default:
				throw new IllegalArgumentException();
			
	}
			
			
			
	
}
}
