package Controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ClassesBase.Aluno;
import ClassesBase.Tutor;

/**
 * 
 * @author Jonathan Lucas - 116210084
 * 
 *         Classe responsavel por controla as funcoes relativas a Tutor -
 *         TutorController
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
	public void tornarTutor(Aluno aluno, String disciplina, int proficiencia) {

		if (proficiencia < 0) {
			throw new IllegalArgumentException("Erro na definicao de papel: Proficiencia invalida");
		}

		if (this.tutores.containsKey(aluno.getMatricula())) {
			if (this.tutores.get(aluno.getMatricula()).consultaDisciplina(disciplina)) {
				throw new IllegalArgumentException("Erro na definicao de papel: Ja eh tutor dessa disciplina");
			} else {
				this.tutores.get(aluno.getMatricula()).adicionaDisciplina(disciplina, proficiencia);
			}
		} else {
			Tutor novoTutor = new Tutor(aluno, disciplina, proficiencia, this.tutores.size());
			tutores.put(aluno.getMatricula(), novoTutor);
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

	/**
	 * Metodo responsavel por procurar a matricula de um tutor a partir do seu
	 * Email.
	 * 
	 * @param email
	 *            a ser procurado
	 * 
	 * @return A matricula do tutor
	 */
	private String procuraTutor(String email) {
		for (String matricula : this.tutores.keySet()) {
			Tutor tutor = this.tutores.get(matricula);
			if (tutor.getEmail().equals(email)) {
				return matricula;
			}
		}
		return "";
	}

	/**
	 * Metodo responsavel por verificar se uma string recebida como parametro, ï¿½
	 * vazia ou nula.
	 * 
	 * @param texto
	 */
	private boolean vaziaOuNula(String texto) {
		if (texto.trim().equals("") || texto == null) {
			return true;
		}
		return false;
	}

	/**
	 * Método que retorna o melhor tutor disponível nas condições repassadas, sendo
	 * o id de criação do tutor um método de desempate.
	 * 
	 * @param disciplina
	 * @param horario
	 * @param dia
	 * @param localInteresse
	 * @return Objeto do tipo tutor.
	 */
	public Tutor getTutorDisponivel(String disciplina, String horario, String dia, String localInteresse) {
		Tutor tutorDisponivel = null;
		for (Tutor tutor : this.listaTutores()) {
			if (tutor.consultaDisciplina(disciplina) && tutor.consultaHorario(horario, dia)
					&& tutor.consultaLocal(localInteresse)) {
				if (tutorDisponivel != null) {
					tutorDisponivel = this.comparaTutores(tutorDisponivel, tutor, disciplina);
				} else {
					tutorDisponivel = tutor;
				}
			}
		}
		return tutorDisponivel;
	}

	/**
	 * Método que retorna o melhor tutor disponível nas condições repassadas, sendo
	 * o id de criação do tutor um método de desempate.
	 * 
	 * @param disciplina
	 * @return Objeto do tipo tutor.
	 */
	public Tutor getTutorDisponivel(String disciplina) {
		Tutor tutorDisponivel = null;
		for (Tutor tutor : this.listaTutores()) {
			if (tutor.consultaDisciplina(disciplina)) {
				if (tutorDisponivel != null) {
					tutorDisponivel = this.comparaTutores(tutorDisponivel, tutor, disciplina);
				} else {
					tutorDisponivel = tutor;
				}
			}
		}
		return tutorDisponivel;
	}

	/**
	 * Método privado que retorna a lista de iterável de todos os tutores.
	 * @return
	 */
	private List<Tutor> listaTutores() {
		List<Tutor> tutores = new ArrayList<Tutor>();
		tutores.addAll(this.tutores.values());
		return tutores;
	}
	
	/**
	 * Método que compara dois tutores pela sua proficiência em uma disciplina e usa a ordem de criação como critério de desempate.
	 * 
	 * @param t1
	 * @param t2
	 * @param disciplina
	 * @return
	 */
	private Tutor comparaTutores(Tutor t1, Tutor t2, String disciplina) {
		if (t1.getProficiencia(disciplina) > t2.getProficiencia(disciplina)) {
			return t1;
		} else if (t2.getProficiencia(disciplina) > t1.getProficiencia(disciplina)) {
			return t2;
		} else {
			if (t1.getIdCriacao() > t2.getIdCriacao()) {
				return t1;
			} else {
				return t2;
			}
		}
	}
}
