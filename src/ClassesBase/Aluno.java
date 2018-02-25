package ClassesBase;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um aluno.
 * 
 * Além das informações do aluno, é possível mudar sua avaliação e ele se
 * compara com outros pela ordem alfabética do nome.
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

	public Aluno(String nome, String matricula, int codigoCurso, String telefone, String eMail, double notaAvaliacao) {
		if (nome.trim().equals("") || nome == null) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: Nome nao pode ser vazio ou nulo");
		} else if (eMail.trim().equals("") || eMail == null) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: Email invalido");
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

}
