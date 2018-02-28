package ClassesBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Jonathan Lucas - 116210084
 * 
 * Classe responsavel por controla as funcoes relativas a Tutor - TutorController
 *
 */
public class TutorController {

	private Map<String, Tutor> tutores;

	/**
	 * Contrutor de TutorController
	 * 
	 * Inicializa a colecao de tutores.
	 */
	public TutorController() {
		this.tutores = new HashMap<String, Tutor>();
	}

	/**
	 * Metodo responsavel por cadastrar um tutor no sistema.
	 * 
	 * @param nome
	 * @param matricula
	 * @param codigoCurso
	 * @param telefone
	 * @param email
	 * @param notaAvaliacao
	 * @param disciplina
	 * @param proficiencia
	 */
	public Tutor tornarTutor(String nome, String matricula, int codigoCurso, String telefone, String email,
			double notaAvaliacao, String disciplina, int proficiencia) {

		if (proficiencia < 0) {
			throw new IllegalArgumentException("Erro na definicao de papel: Proficiencia invalida");
		}

		if (this.tutores.containsKey(matricula)) {
			if (this.tutores.get(matricula).consultaDisciplina(disciplina)) {
				throw new IllegalArgumentException("Erro na definicao de papel: Ja eh tutor dessa disciplina");
			} else {
				this.tutores.get(matricula).adicionaDisciplina(disciplina, proficiencia);
				return tutores.get(matricula);
			}
		} else {

			Tutor novoTutor = new Tutor(nome, matricula, codigoCurso, telefone, email, notaAvaliacao, disciplina,
					proficiencia);

			tutores.put(matricula, novoTutor);

			return novoTutor;
		}
	}

	/**
	 * Metodo responsavel por recuperar um tutor por meio da matricula na colecaoo.
	 * 
	 * @param matricula
	 * 
	 * @return Representacao em String de um determinado tutor por meio de sua
	 *         matricula.
	 */
	public String recuperaTutor(String matricula) {
		if (!this.tutores.containsKey(matricula)) {
			throw new IllegalArgumentException("Erro na busca por tutor: Tutor nao encontrado");
		}
		return tutores.get(matricula).toString();
	}

	/**
	 * Metodo responsavel por listar os tutores.
	 * 
	 * @return String contendo a representando de todos os alunos cadastrados .
	 */
	public String listarTutores() {

		List<Tutor> tutores = new ArrayList<Tutor>();
		tutores.addAll(this.tutores.values());
		Collections.sort(tutores);
		String aux = "";
		for (Tutor tutor : tutores) {
			aux += tutor.toString() + ", ";
		}
		return aux.substring(0, aux.length() - 2);
	}

	
	/**
	 * Metodo responsavel por cadastrar um dia da semana e um horario para a
	 * tutoria.
	 * 
	 * @param horario
	 * @param dia
	 */
	public void cadastrarHorario(String email, String horario, String dia) {
		if (vaziaOuNula(email)) {
			throw new IllegalArgumentException("Erro no cadastrar horario: email nao pode ser vazio ou em branco");
		}
		if (procuraTutor(email).equals("")) {
			throw new IllegalArgumentException("Erro no cadastrar horario: tutor nao cadastrado");
		}
		this.tutores.get(procuraTutor(email)).cadastrarHorario(horario, dia);
	}

	/**
	 * Metodo responsavel por cadastrar um local para ocorrencia da tutoria .
	 * 
	 * @param local
	 */
	public void cadastrarLocalDeAtendimento(String email, String local) {
		if (vaziaOuNula(local)) {
			throw new IllegalArgumentException(
					"Erro no cadastrar local de atendimento: local nao pode ser vazio ou em branco");
		}
		if (vaziaOuNula(email)) {
			throw new IllegalArgumentException(
					"Erro no cadastrar local de atendimento: email nao pode ser vazio ou em branco");
		}
		if (procuraTutor(email).equals("")) {
			throw new IllegalArgumentException("Erro no cadastrar local de atendimento: tutor nao cadastrado");
		}
		this.tutores.get(procuraTutor(email)).cadastrarLocalDeAtendimento(local);
	}

	
	/**
	 * Metodo responsavel por verificar se um determinado horario de um dia esta
	 * disponivel para a tutoria.
	 * 
	 * @param horario
	 * @param dia
	 * 
	 * @return Boolean afirmando disponibilidade de tutoria no dia / hora
	 */
	public boolean consultaHorario(String email, String horario, String dia) {
		if (vaziaOuNula(email)) {
			throw new IllegalArgumentException("Erro no cadastrar horario: email nao pode ser vazio ou em branco");
		}
		if (procuraTutor(email).equals("")) {
			return false;
		}
		return this.tutores.get(procuraTutor(email)).consultaHorario(horario, dia);
	}

	/**
	 * Metodo responsavel por verificar se um determinado local esta cadastrado no
	 * tutor para a tutoria
	 * 
	 * @param local
	 * 
	 * @return Boolean afirmando disponibilidade de tutoria no local
	 */
	public boolean consultaLocal(String email, String local) {
		if (procuraTutor(email).equals("")) {
			return false;
		}
		return this.tutores.get(procuraTutor(email)).consultaLocal(local);
	}

	public void pagarTutor(String matricula, int quantidade) {

	}
	/**
	 * Metodo responsavel por procurar a matricula de um tutor a partir do seu Email.
	 * 
	 * @param email a ser procurado
	 * 
	 * @return A matricula do tutor 
	 */
	private String procuraTutor(String email) {
		for (String matricula : this.tutores.keySet()) {
			Tutor tutor = this.tutores.get(matricula);
			if (tutor.geteMail().equals(email)) {
				return matricula;
			}
		}
		return "";
	}
	
	/**
	 * Metodo responsavel por verificar se uma string recebida como parametro, é vazia ou nula.
	 * 
	 * @param texto
	 */
	private boolean vaziaOuNula(String texto) {
		if (texto.trim().equals("") || texto == null) {
			return true;
		}
		return false;
	}

}
