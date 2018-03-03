package ClassesBase;

public class AjudaPresencial extends Ajuda {

	String horario;
	String dia;
	String localInteresse;

	public AjudaPresencial(String matrAluno, String disciplina, String horario, String dia,
			String localInteresse, Tutor tutor) {
		super(matrAluno, disciplina, tutor);
		this.horario = horario;
		this.dia = dia;
		this.localInteresse = localInteresse;
	}

	@Override
	public String getInfoAjuda(String atributo) {
		switch (atributo) {
		case "matricula":
			return this.matrAluno;
		case "disciplina":
			return this.disciplina;
		case "dia":
			return this.dia;
		case "horario":
			return this.horario;
		case "localInteresse":
			return this.localInteresse;
		default:
			throw new IllegalArgumentException("Erro ao tentar recuperar info da ajuda : atributo nao encontrado");
		}
	}
	
	@Override
	public String pegarTutor() {
		return "Tutor - " + this.tutor.getMatricula() + ", horario - " + this.horario + ", dia - " + this.dia + ", local - " + this.localInteresse + ", disciplina - " + this.disciplina;
	}
}
