package ClassesBase;

public class AjudaOnline extends Ajuda {

	public AjudaOnline(String matrAluno, String disciplina, Tutor tutor) {
		super(matrAluno, disciplina, tutor);
	}

	@Override
	public String getInfoAjuda(String atributo) {
		switch (atributo) {
		case "matricula":
			return this.matrAluno;
		case "disciplina":
			return this.disciplina;
		default:
			throw new IllegalArgumentException("Erro ao tentar recuperar info da ajuda : atributo nao encontrado");
		}
	}
	
	@Override
	public String pegarTutor() {
		return "Tutor - " + this.tutor.getMatricula()+ ", disciplina- " + this.disciplina;
	}

}
