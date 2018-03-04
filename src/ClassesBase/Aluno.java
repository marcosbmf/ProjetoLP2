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
	private int idCriacao;




	/**
   * Constro� um aluno a partir do nome, da matricula, do c�digo do curso,  do telefone dele, do seu email, e da sua nota de avalia�ao.
   * 
   *
   * @param nome
   * @param matricula
   * @param codigoCurso
   * @param telefone
   * @param eMail
   * @param notaAvaliacao
   * 
   */
	public Aluno(String nome, String matricula, int codigoCurso, String telefone, String eMail, int idCriacao) {
		if (stringVaziaOuNula(nome)) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: Nome nao pode ser vazio ou nulo");
		} else if (stringVaziaOuNula(eMail)) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: Email invalido");
		} else if (stringVaziaOuNula(matricula)) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: Matricula invalida");
		} else if (telefone == null) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: Telefone invalido");
		} else if (codigoCurso <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: Codigo de Curso invalido");
		}
		
		this.nome = nome;
		this.matricula = matricula;
		this.codigoCurso = codigoCurso;
		this.telefone = telefone;
		this.eMail = eMail;
		this.notaAvalicao = 5;
		this.idCriacao = idCriacao;
	}
	
	/**
	 * Metodo responsavel por organizar as informa��es de contato do aluno.
	 * 
	 * @return String contendo apenas o email ou o email + telefone.
	 */
	public  String contato() {
		if (this.telefone.trim().equals("")) {
			return this.eMail;
		}
		return this.telefone + " - " + this.eMail;
	}
	
	/**
	 * Este m�todo retorna a String que representa um aluno 
	 * No formato: matricula - nome - codigocurso - telefone (se tiver) - email 
	 * 	
	 * @return representa��o em String de um aluno.
	 */
	public String toString() {
		return this.matricula + " - " + this.nome + " - " + this.codigoCurso + " - " + this.contato();
	}

	/**
	 * @return O nome do aluno.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @return O numero da matricula do aluno
	 */
	public String getMatricula() {
		return matricula;
	}
	
    public int getIdCriacao() {
		return idCriacao;
	}

	/**
	 * @return O codigo do curso.
	 */
	public int getCodigoCurso() {
		return codigoCurso;
	}

	/**
	 * @return O telefone de contato do aluno
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * @return O email
	 */
	public String geteMail() {
		return eMail;
	}

	/**
	 * @return A nota de avaliacao do aluno
	 */
	public double getNotaAvalicao() {
		return notaAvalicao;
	}

	 /**
	 * Metodo responsavel por atualizar a nota de avaliacao do aluno para uma nova.
	 *
	 *@param novaAvaliacao, nova nota a ser atribuida
	 */
	public void mudaAvaliacao(double novaAvaliacao) {
		this.notaAvalicao = novaAvaliacao;
	}
	
	 /**
	 * Metodo responsavel comparar os nomes dos alunos.
	 *
	 *@param Aluno, outro aluno.
	 */
	public int compareTo(Aluno o) {
		return this.nome.compareTo(o.nome);
	}
	
	/**
	 * Metodo responsavel por verificar se uma string recebida como parametro, � vazia ou nula.
	 * 
	 * @param texto
	 */
	private boolean stringVaziaOuNula(String texto) {
		if (texto.trim().equals("") || texto == null) {
			return true;
		}
		return false;
	}

}
