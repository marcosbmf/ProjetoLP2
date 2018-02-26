package ClassesBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Thyago Pereira da Silva - 117110164 Classe responsável por controlar
 *         as funções relativas a aluno - AlunoCOntroller
 *
 */
public class AlunoController {
	private Map<String, Aluno> alunos = new HashMap<String, Aluno>();

	/**
	 * Metodo responsável por cadastrar um aluno no sistema.
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
		alunos.put(matricula, new Aluno(nome, matricula, codigoCurso, telefone, email));

	}

	/**
	 * Metodo responsável por verificar se o email fornecido é valido no formado
	 * XXXXX.XXXXX@#########
	 * 
	 * @param email
	 * @return Boolean afirmando a se o email fornecido é valido
	 */
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

	/**
	 * Metodo responsável por recuperar um aluno por meio da matricula na coleção.
	 * 
	 * @param matricula
	 * @return Representação em String de um determinado aluno por meio de sua
	 *         matricula .
	 */
	public String recuperaAluno(String matricula) {
		if (!this.alunos.containsKey(matricula)) {
			throw new IllegalArgumentException("Erro na busca por aluno: Aluno nao encontrado");
		}
		return alunos.get(matricula).toString();
	}

	/**
	 * 
	 * @return String contendo a representação de todos os alunos cadastrados .
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
	 * Recupera a informação solicitada do aluno , por meio da matricula
	 * 
	 * @param matricula
	 * @param atributo
	 * @return String contendo a informação desejada do aluno especificado por
	 *         matricula.
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
	 * @return Retorna o Objeto Aluno associado a esta matricula na coleção .
	 */
	public Aluno getAluno(String matricula) {
		return this.alunos.get(matricula);
	}

	/**
	 * Metodo responsável por subistituir o objeto aluno associado a determinada
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
