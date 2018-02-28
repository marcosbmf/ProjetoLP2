package ClassesBase;

public class Sistema {

	AlunoController ac = new AlunoController();
	TutorController tc = new TutorController();

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
	 * @return String contendo a informacaoo desejada do aluno especificado por matricula.
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
	public void tornarTutor(String matricula, String disciplina, int proficiencia) {
		try {
			this.ac.recuperaAluno(matricula);
		} catch (Exception e) {
			throw new IllegalArgumentException("Erro na definicao de papel: Tutor nao encontrado");
		}
		Tutor tutor = tc.tornarTutor(ac.getinfoAluno(matricula, "Nome"), matricula,
				Integer.parseInt(ac.getinfoAluno(matricula, "CodigoCurso")), ac.getinfoAluno(matricula, "Telefone"),
				ac.getinfoAluno(matricula, "Email"), Double.parseDouble(ac.getinfoAluno(matricula, "Avaliacao")),
				disciplina, proficiencia);
		ac.setAluno(matricula, tutor);
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

	public void pagarTutor(String matricula, int quantidade) {
		tc.pagarTutor(matricula, quantidade);
	}

}
