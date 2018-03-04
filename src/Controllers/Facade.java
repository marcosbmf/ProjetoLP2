package Controllers;

/**
 * 
 * @author Victor Ribeiro Miranda - 116211361 Classe responsavel por gerenciar e
 *         delegar funcoes para outras classes - Sistema
 *
 */

public class Facade {

	AlunoController ac = new AlunoController();
	TutoriaController tc = new TutoriaController();

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
		ac.cadastrarAluno(nome, matricula, codigoCurso, telefone, email);
	}

	/**
	 * Metodo responsavel por recuperar um aluno por meio da matricula na colecaoo.
	 * 
	 * @param matricula
	 * @return Representacao em String de um determinado aluno por meio de sua
	 *         matricula .
	 */
	public String recuperaAluno(String matricula) {
		return ac.recuperaAluno(matricula);
	}

	/**
	 * Metodo responsavel por listar os tutores.
	 * 
	 * @return String contendo a representando de todos os alunos cadastrados .
	 */
	public String listarAlunos() {
		return ac.listarAlunos();
	}

	/**
	 * Recupera a informacaoo solicitada do aluno , por meio da matricula
	 * 
	 * @param matricula
	 * @param atributo
	 * @return String contendo a informacaoo desejada do aluno especificado por
	 *         matricula.
	 */
	public String getInfoAluno(String matricula, String atributo) {
		return ac.getinfoAluno(matricula, atributo);
	}

	/**
	 * Metodo responsavel por cadastrar um tutor no sistema.
	 * 
	 * @param matricula
	 * @param disciplina
	 * @param proficiencia
	 */
	public void tornarTutor(String matricula,String disciplina, int proficiencia) {
		tc.tornarTutor(ac.getAluno(matricula),disciplina, proficiencia);

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
		return tc.pedirAjudaPresencial(matrAluno, disciplina, horario, dia, localInteresse);
	}
	
	
	public int pedirAjudaOnline (String matrAluno, String disciplina) {
		return tc.pedirAjudaOnline(matrAluno, disciplina);
	}
	
	
	public String pegarTutor(int idAjuda) {
		return tc.pegarTutor(idAjuda);
	}
	
	
	public String getInfoAjuda(int idAjuda, String atributo) {
		return tc.getInfoAjuda(idAjuda, atributo);
	}
	
	
	public String avaliarTutor(int idAjuda , int nota) {
		return tc.avaliarTutor(idAjuda,nota);
	}
	
	public String pegarNota(String matriculaTutor) {
		return tc.pegarNota(matriculaTutor);
	}
	
	public String pegarNivel(String matriculaTutor) {
		return tc.pegarNivel(matriculaTutor);
	}

}
