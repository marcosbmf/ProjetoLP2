package Controllers;

import ClassesBase.Aluno;
import ClassesBase.Tutor;

/**
 * Classe que controla funções referentes à tutoria como manuseio de tutores e
 * criação de pedidos de ajuda. Conversa com Tutor Controller e Ajuda
 * Controller.
 * 
 * @author Marcos Barros
 *
 */
public class TutoriaController {
	TutorController tc;
	AjudaController ac;

	public TutoriaController() {
		tc = new TutorController();
		ac = new AjudaController();
	}

	/**
	 * Metodo responsavel por cadastrar um tutor no sistema.
	 * 
	 * @param aluno
	 * @param disciplina
	 * @param proficiencia
	 */
	public void tornarTutor(Aluno aluno, String disciplina, int proficiencia) {
		tc.tornarTutor(aluno, disciplina, proficiencia);
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
		return tc.recuperaTutor(matricula);
	}

	/**
	 * Metodo responsavel por listar os tutores.
	 * 
	 * @return String contendo a representando de todos os alunos cadastrados .
	 */
	public String listarTutores() {
		return tc.listarTutores();
	}

	/**
	 * Metodo responsavel por cadastrar um dia da semana e um horario para a
	 * tutoria.
	 * 
	 * @param horario
	 * @param dia
	 */

	public void cadastrarHorario(String email, String horario, String dia) {
		tc.cadastrarHorario(email, horario, dia);
	}

	/**
	 * Metodo responsavel por cadastrar um local para ocorrencia da tutoria .
	 * 
	 * @param local
	 */
	public void cadastrarLocalDeAtendimento(String email, String local) {
		tc.cadastrarLocalDeAtendimento(email, local);
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
		return tc.consultaHorario(email, horario, dia);
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
		return tc.consultaLocal(email, local);
	}
	
	/**
	 * Metodo responsavel por requisitar uma ajuda presencial ao sistema. 
	 * @param matrAluno - Matricula do aluno que requisitou a ajuda. 
	 * @param disciplina - Disciplina na qual a ajuda deve ser ministrada. 
	 * @param horario - Horario de realizacao da ajuda.
	 * @param dia - Dia de realizacao da ajuda 
	 * @param localInteresse  - Local fisico de realizacao da ajuda.
	 * @return Numero de ajudas cadastradas no sistema. 
	 */
	public int pedirAjudaPresencial(String matrAluno, String disciplina, String horario, String dia,
			String localInteresse) {
		Tutor tutor = tc.getTutorDisponivel(disciplina, horario, dia, localInteresse);
		return ac.pedirAjudaPresencial(matrAluno, disciplina, horario, dia, localInteresse, tutor);
	}
	
	/**
	 * Metodo responsavel por pedir uma ajuda online. 
	 * @param matrAluno - Matricula do aluno que requisitou uma ajuda. 
	 * @param disciplina - Disciplina na qual a ajuda deve ser ministrada 
	 * @return Numero de ajudas cadastradas no sistema.
	 */
	public int pedirAjudaOnline(String matrAluno, String disciplina) {
		Tutor tutor = tc.getTutorDisponivel(disciplina);
		return ac.pedirAjudaOnline(matrAluno, disciplina, tutor);
	}
	
	/**
	 * Metodo responsavel por retornar uma representacao do tutor e da ajuda por meio de uma string 
	 * @param idAjuda - Identificador da ajuda. 
	 * @return  Representacao do tutor e da ajuda por meio de uma String 
	 */
	public String pegarTutor(int idAjuda) {
		return ac.pegarTutor(idAjuda);
	}
	
	/**
	 * 
	 * @param idAjuda - Identificador unico da ajuda. 
	 * @param atributo - Atributo da ajuda ao qual deseja-se recuperar 
	 * @return   Informacao desejada sobre a ajuda. 
	 */
	public String getInfoAjuda(int idAjuda, String atributo) {
		return ac.getInfoAjuda(idAjuda, atributo);
	}
	
	/**
	 * Metodo responsavel por estabelecer uma avaliacao ao tutor responsavel por determinada ajuda 
	 * @param idAjuda - Identificador unico da ajuda.
	 * @param nota - Nota dada ao tutor  0-5 .
	 */
	public void avaliarTutor(int idAjuda, int nota) {
		ac.avaliarTutor(idAjuda, nota);
	}

	/**
	 * Metodo responsavel por retornar a nota de avalicao atual de um determinado tutor . 
	 * @param matriculaTutor - Matricula do tutor 
	 * @return Nota de avalicao geral do tutor . 
	 */
	public String pegarNota(String matriculaTutor) {
		return String.format("%,.2f", tc.pegarNota(matriculaTutor));
	}

	
	/**
	 * 
	 * Metodo responsavel por retornar o nivel de um determinado tutor cadastrado no sistema.
	 * @param matriculaTutor - Matricula do tutor.
	 * @return Nivel de habilidade do tutor . 
	 */
	public String pegarNivel(String matriculaTutor) {
		return tc.pegarNivel(matriculaTutor);
	}

	public void doar(String matriculaTutor, int totalCentavos) {
		tc.doar(matriculaTutor, totalCentavos);

	}

	public int totalDinheiroTutor(String emailTutor) {
		return tc.totalDinheiroTutor(emailTutor);
	}

	public int totalDinheiroSistema() {
		return tc.totalDinheiroSistema();
	}
}
