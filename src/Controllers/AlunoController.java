package Controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ClassesBase.Aluno;

 /**
 * 
 * @author Thyago Pereira da Silva - 117110164 Classe responsavel por controlar
 *         as funcoes relativas a aluno - AlunoController
 *
 */
public class AlunoController {
	private Map<String, Aluno> alunos;

	/**
	 * Contrutor de AlunoController
	 * 
	 * Inicializa a colecao de alunos;
	 */
	public AlunoController() {

		this.alunos = new HashMap<String, Aluno>();
	}

	/**
	 * Metodo responsavel por cadastrar um aluno no sistema.
	 * 
	 * @param nome
	 * @param matricula
	 * @param codigoCurso
	 * @param telefone
	 * @param email
	 */
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		if (!this.emailValido(email)) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: Email invalido");
		}

		if (alunos.containsKey(matricula)) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: Aluno de mesma matricula ja cadastrado");
		}
		alunos.put(matricula, new Aluno(nome, matricula, codigoCurso, telefone, email, alunos.size() + 1));
	}
	
	/**
	 * Metodo responsavel por verificar se o email fornecido eh valido no formato
	 * XXXXX.XXXXX@#########
	 * 
	 * @param email
	 * @return Boolean afirmando a se o email fornecido eh valido
	 */
	private boolean emailValido(String email) {
		if (email.trim().equals("")) {
			return false;
		}
		if (email == null) {
			throw new NullPointerException("Erro no cadastro de aluno: Email invalido");
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

	/**
	 * Metodo responsavel por recuperar um aluno por meio da matricula na colecaoo.
	 * 
	 * @param matricula
	 * @return Representacao em String de um determinado aluno por meio de sua
	 *         matricula .
	 */
	public String recuperaAluno(String matricula) {
		if (!this.alunos.containsKey(matricula)) {
			throw new IllegalArgumentException("Erro na busca por aluno: Aluno nao encontrado");
		}
		return alunos.get(matricula).toString();
	}

	/**
	 *  Metodo responsavel por listar os alunos.
	 * 
	 * @return String contendo a representando de todos os alunos cadastrados .
	 */
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

	/**
	* Recupera a informacaoo solicitada do aluno , por meio da matricula
	* 
	* @param matricula
	* @param atributo
	* @return String contendo a informacaoo desejada do aluno especificado por matricula.
	*/
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

	/**
	* 
	* @param matricula
	* @return Retorna o Objeto Aluno associado a esta matricula na colecao .
	*/
	public Aluno getAluno(String matricula) {
		try {
			this.recuperaAluno(matricula);
		} catch (Exception e) {
			throw new IllegalArgumentException("Erro na definicao de papel: Tutor nao encontrado");
		}
		return this.alunos.get(matricula);
	}

	/**
	 * Metodo responsavel por subistituir o objeto aluno associado a determinada
	 * matricula , por um novo aluno associado a mesma matricula.
	 * 
	 * @param matricula
	 * @param aluno
	 */
	public void setAluno(String matricula, Aluno aluno) {
		this.alunos.remove(matricula);
		this.alunos.put(matricula, aluno);
	}

}
