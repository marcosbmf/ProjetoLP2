package ClassesBase;

/**
 * Classe que representa um aluno. 
 * @author marcosbmf
 *
 */
public class Aluno{
	
	private String nome;
	private String matricula;
	private int codigoCurso;
	private String telefone;
	private String eMail;
	private double notaAvalicao;
	
	public Aluno(String matricula, String nome, int codigoCurso, String telefone,String eMail, double notaAvaliacao) {
		this.nome = nome;
		this.matricula = matricula;
		this.codigoCurso = codigoCurso;
		this.telefone = telefone;
		this.eMail = eMail;
		this.notaAvalicao = notaAvaliacao;
	}
	
	public Aluno(String matricula ,String nome, int codigoCurso, String telefone,String eMail) {
		this(matricula, nome, codigoCurso, telefone, eMail, 5.0);
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

	public String getNome() {
		return nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public int getCodigoCurso() {
		return codigoCurso;
	}

	public String getTelefone() {
		return telefone;
	}

	public String geteMail() {
		return eMail;
	}

	public double getNotaAvalicao() {
		return notaAvalicao;
	}	
	
}
