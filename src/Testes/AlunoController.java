package Testes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ClassesBase.Aluno;

public class AlunoController {
	private Map<String, Aluno> alunos = new HashMap<String, Aluno>();

	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		if (!this.emailValido(email)) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: Email invalido");
		}

		if (alunos.containsKey(matricula)) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: Aluno de mesma matricula ja cadastrado");
		}
		alunos.put(matricula, new Aluno(nome, matricula, codigoCurso, telefone, email));

	}

	private boolean emailValido(String email) {
		if (email.trim().equals("")) {
			return false;
		}
		if (email == null) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: Email invalido");
		}
		if (!email.contains("@")) {
			return false;
		}

		String aux[] = new String[2];
		aux = email.split("@");

		if (aux.length != 2) {
			return false;
		}

		if (aux[0].equals("")) {
			return false;
		}

		if (aux[1].equals("")) {
			return false;
		}

		return true;
	}

	public String recuperaAluno(String matricula) {
		if (!this.alunos.containsKey(matricula)) {
			throw new IllegalArgumentException("Erro na busca por aluno: Aluno nao encontrado");
		}
		return alunos.get(matricula).toString();
	}

	public String listarAlunos() {
		List<Aluno> alunos = new ArrayList<Aluno>();
		alunos.addAll(this.alunos.values());
		Collections.sort(alunos);
		String aux = "";
		for (Aluno aluno : alunos) {
			aux += aluno.toString() + ", ";
		}
		return aux.substring(0, aux.length() - 2);
	}

	public String getinfoAluno(String matricula, String atributo) {
		if (!this.alunos.containsKey(matricula)) {
			throw new IllegalArgumentException("Erro na obtencao de informacao de aluno: Aluno nao encontrado");
		}
		switch (atributo) {
		case "Nome":
			return this.alunos.get(matricula).getNome();
		case "Telefone":
			return this.alunos.get(matricula).getTelefone();

		case "CodigoCurso":
			return "" + this.alunos.get(matricula).getCodigoCurso();
		case "Email":
			return this.alunos.get(matricula).geteMail();
		case "Avaliacao":
			return "" + this.alunos.get(matricula).getNotaAvalicao();

		default:
			throw new IllegalArgumentException();

		}
	}

	public Aluno getAluno(String matricula) {
		return this.alunos.get(matricula);
	}

	public void setAluno(String matricula, Aluno aluno) {
		this.alunos.remove(matricula);
		this.alunos.put(matricula, aluno);
	}

}
