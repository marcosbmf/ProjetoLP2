package ClassesBase;


/**
 * Classe que representa um aluno.
 * 
 * Alem das informacoes do aluno, eh possivel mudar sua avaliacao e ele se
 * compara com outros pela ordem alfabetica do nome.
 * 
 * @author marcosbmf
 *
 */
public class Aluno implements Comparable<Aluno> {

	private String nome;
	private String matricula;
	private int codigoCurso;
	private String telefone;
	private String eMail;
	private double notaAvalicao;


	/**
	 * Contrutor de Aluno.
	 * 
	 * Inicializa a colecao de alunos;
	 */
	public Aluno(String nome, String matricula, int codigoCurso, String telefone, String eMail, double notaAvaliacao) {
		if (stringVaziaOuNula(nome)) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: Nome nao pode ser vazio ou nulo");
		} else if (stringVaziaOuNula(eMail)) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: Email invalido");
		} else if (stringVaziaOuNula(matricula)) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: Matricula invalida");
		} else if (telefone == null) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: Telefone invalido");
		} else if (notaAvaliacao < 0 || notaAvaliacao > 5) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: Nota de Avalicao invalida");
		} else if (codigoCurso <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: Codigo de Curso invalido");
		}
		
		this.nome = nome;
		this.matricula = matricula;
		this.codigoCurso = codigoCurso;
		this.telefone = telefone;
		this.eMail = eMail;
		this.notaAvalicao = notaAvaliacao;
	}

	public Aluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		this(nome, matricula, codigoCurso, telefone, email, 5.0);
	}

	private String contato() {
		if (this.telefone.trim().equals("")) {
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

	public void mudaAvaliacao(double novaAvaliacao) {
		this.notaAvalicao = novaAvaliacao;
	}

	public int compareTo(Aluno o) {
		return this.nome.compareTo(o.nome);
	}
	
	private boolean stringVaziaOuNula(String texto) {
		if (texto.trim().equals("") || texto == null) {
			return true;
		}
		return false;
	}

}
