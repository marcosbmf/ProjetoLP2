package ClassesBase;

public class Sistema {

	AlunoController ac = new AlunoController();
	TutorController tc = new TutorController();

	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		ac.cadastrarAluno(nome, matricula, codigoCurso, telefone, email);
	}

	public String recuperaAluno(String matricula) {
		return ac.recuperaAluno(matricula);
	}

	public String listarAlunos() {
		return ac.listarAlunos();
	}

	public String getInfoAluno(String matricula, String atributo) {
		return ac.getinfoAluno(matricula, atributo);
	}

	public void tornarTutor(String matricula, String disciplina, int proficiencia) {
		Tutor tutor = tc.tornarTutor(ac.getinfoAluno(matricula, "nome"), matricula,
				Integer.parseInt(ac.getinfoAluno(matricula, "codigoCurso")), ac.getinfoAluno(matricula, "telefone"),
				ac.getinfoAluno(matricula, "email"), Double.parseDouble(ac.getinfoAluno(matricula, "avalicao")),
				disciplina, proficiencia);
	}

	public String recuperaTutor(String matricula) {
		return tc.recuperaTutor(matricula);
	}

	public String listarTutores() {
		return tc.listarTutores();
	}

	public void cadastrarHorario(String email, String horario, String dia) {
		tc.cadastrarHorario(email, horario, dia);
	}

	public void cadastrarLocalDeAtendimento(String email, String local) {
		tc.cadastrarLocalDeAtendimento(email, local);
	}

	public boolean consultaHorario(String email, String horario, String dia) {
		return tc.consultaHorario(email, horario, dia);
	}

	public boolean consultaLocal(String email, String local) {
		return tc.consultaLocal(email, local);
	}

	public void pagarTutor(String matricula, int quantidade) {
		tc.pagarTutor(matricula, quantidade);
	}

	public void mudaAvaliacao(String matricula, double nota) {
		tc.mudaAvaliacao(matricula, nota);
	}

}
