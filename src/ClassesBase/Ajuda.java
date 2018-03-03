package ClassesBase;

public abstract class Ajuda {
	
	protected String matrAluno;
	protected String disciplina;
	protected Tutor tutor;
	
	public Ajuda(String matrAluno, String disciplina, Tutor tutor) {
		this.matrAluno = matrAluno;
		this.disciplina = disciplina;
		this.tutor = tutor;
	}

	public String getMatrAluno() {
		return matrAluno;
	}

	public String getDisciplina() {
		return disciplina;
	}
	
	public abstract String pegarTutor();
	
	public abstract String getInfoAjuda(String atributo);
	
}
