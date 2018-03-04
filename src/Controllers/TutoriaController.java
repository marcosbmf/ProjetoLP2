package Controllers;

import ClassesBase.Aluno;
import ClassesBase.Tutor;

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
	public void tornarTutor(Aluno aluno,String disciplina, int proficiencia) {
		tc.tornarTutor(aluno ,disciplina, proficiencia);
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

	
	public int pedirAjudaPresencial (String matrAluno, String disciplina, String horario, String dia, String localInteresse) {
		Tutor tutor = tc.getTutorDisponivel(disciplina, horario, dia, localInteresse);
		return ac.pedirAjudaPresencial(matrAluno, disciplina, horario, dia, localInteresse, tutor);
	}
	
	
	public int pedirAjudaOnline (String matrAluno, String disciplina) {
		Tutor tutor = tc.getTutorDisponivel(disciplina);
		return ac.pedirAjudaOnline(matrAluno, disciplina, tutor);
	}
	
	
	public String pegarTutor(int idAjuda) {
		return ac.pegarTutor(idAjuda);
	}
	
	
	public String getInfoAjuda(int idAjuda, String atributo) {
		return ac.getInfoAjuda(idAjuda, atributo);
	}

	public String avaliarTutor(int idAjuda, int nota) {
		return ac.avaliarTutor(idAjuda, nota);
	}

	public String pegarNota(String matriculaTutor) {
		return tc.pegarNota(matriculaTutor);
	}
	
	public String pegarNivel(String matriculaTutor) {
		return tc.pegarNivel(matriculaTutor);
	}
}
