package ClassesBase;

public class Facade {
	private Sistema sistema = new Sistema();

	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		sistema.cadastrarAluno(nome, matricula, codigoCurso, telefone, email);
	}

	public String recuperaAluno(String matricula) {
		return sistema.recuperaAluno(matricula);
	}

	public String listarAlunos() {
		return sistema.listarAlunos();
	}

	public String getInfoAluno(String matricula, String atributo) {
		return sistema.getInfoAluno(matricula, atributo);
	}

	public void tornarTutor(String matricula, String disciplina, int proficiencia) {
		sistema.tornarTutor(matricula, disciplina, proficiencia);
	}

	public String recuperaTutor(String matricula) {
		return sistema.recuperaTutor(matricula);
	}

	public String listarTutores() {
		return sistema.listarTutores();
	}

	public void cadastrarHorario(String email, String horario, String dia) {
		sistema.cadastrarHorario(email, horario, dia);
	}

	public void cadastrarLocalDeAtendimento(String email, String local) {
		sistema.cadastrarLocalDeAtendimento(email, local);
	}

	public boolean consultaHorario(String email, String horario, String dia) {
		return sistema.consultaHorario(email, horario, dia);
	}

	public boolean consultaLocal(String email, String local) {
		return sistema.consultaLocal(email, local);
	}
}
