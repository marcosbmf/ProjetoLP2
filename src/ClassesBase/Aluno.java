package ClassesBase;

public class Aluno{
	
	private String nome;
	private int matricula;
	private int codigoCurso;
	private String telefone;
	private String eMail;
	private double avaliacao;
	
	public Aluno(String nome, int matricula, int codigoCurso, String eMail) {
		this.nome = nome;
		this.matricula = matricula;
		this.codigoCurso = codigoCurso;
		this.telefone = "";
		this.eMail = eMail;
		this.avaliacao = 5;
	}


	public Aluno(String nome, int matricula, int codigoCurso, String telefone,String eMail) {
		
		this.nome = nome;
		this.matricula = matricula;
		this.codigoCurso = codigoCurso;
		this.telefone = telefone;
		this.eMail = eMail;
		this.avaliacao = 5;
	} 
	
	private String contato() {
		if(this.telefone.trim().equals("")) {
			return this.eMail;
		}
		return this.telefone + " - " + this.eMail;
	}
	
	public String toString() {
		return this.matricula + " - " + this.nome + " - " + this.codigoCurso + " - " + this.contato();
	}
	


	
	
	
	
	
	
	
	
}
