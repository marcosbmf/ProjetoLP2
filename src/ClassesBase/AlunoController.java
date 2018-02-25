package ClassesBase;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlunoController {
	private Map<String,Aluno> alunos = new HashMap<String,Aluno> ();	
	
	public void cadastrarAluno(String nome , String matricula , int codigoCurso , String telefone, String email) {
		if (alunos.containsKey(matricula)) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: Aluno de mesma matricula ja cadastrado");
		}
		alunos.put(matricula , new Aluno(nome , matricula , codigoCurso , telefone, email)) ; 
		
	}
	
	public String recuperaAluno(String matricula) {
		return alunos.get(matricula).toString() ;
	}
	
	public String listarAlunos() {
		List<Aluno> alunos = new ArrayList<Aluno>();
		alunos.addAll(this.alunos.values());
		Collections.sort(alunos);
		String aux = "" ;
		for( Aluno aluno : alunos) {
			aux += aluno.toString() + ", " ;
		}
		return aux.substring(0, aux.length()-2) ; 
	}
	
	public String getinfoAluno(String matricula, String atributo) {
			switch(atributo) {
			case "Nome": 
				return this.alunos.get(matricula).getNome();
			case "Telefone":
				return this.alunos.get(matricula).getTelefone();
			
			case "CodigoCurso":
				return "" +  this.alunos.get(matricula).getCodigoCurso();
			case "Email":
				return this.alunos.get(matricula).geteMail();
			case"Avaliacao":
				return ""  +  this.alunos.get(matricula).getNotaAvalicao();
			
			default:
				throw new IllegalArgumentException();
			
			}
			
	}
	
	public Aluno getAluno(String matricula) {
		return this.alunos.get(matricula) ;
	}
	
	public void setAluno(String matricula , Aluno aluno) {
		this.alunos.remove(matricula);
		this.alunos.put(matricula, aluno) ; 
	}
	
	
	
	
	
}
