package ClassesBase;

public class Sistema {
	
	AlunoController alunocontroller = new AlunoController();
	TutorController tutorcontroller = new TutorController();
	
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		alunocontroller.cadastrarAluno(nome,matricula,codigoCurso,telefone,email);
	}
	public String recuperaAluno(String matricula) {
		return alunocontroller.recuperaAluno(matricula);
	}
	public String listarAlunos() {
		return alunocontroller.listarAlunos();
	}
	public String getInfoAluno(String matricula, String atributo) {
		return alunocontroller.getinfoAluno(matricula,atributo);
	}
	public void tornarTutor(Aluno matricula, String disciplina, int proficiencia) {
		tutorcontroller.tornarTutor(alunocontroller.getAluno(),disciplina,proficiencia);
	}
	public String recuperaTutor(String matricula) {
		return tutorcontroller.recuperaTutor(matricula);
	}
	public String listarTutores() {
		return tutorcontroller.listarTutores();
	}
	public void cadastrarHorario(String email, String horario, String dia) {
		tutorcontroller.cadastrarHorario(email,horario,dia);
	}
	public void cadastrarLocalDeAtendimento(String email, String local) {
		tutorcontroller.cadastrarLocalDeAtendimento(email,local);
	}
	public boolean consultaHorario(String email, String horario, String dia) {
		return tutorcontroller.consultaHorario(email,horario,dia);
	}
	public boolean consultaLocal(String email, String local) {
		return tutorcontroller.consultaLocal(email,local);
	}
	
}
