package ClassesBase;


public abstract class Ajuda {

	protected String matrAluno;
	protected String disciplina;
	protected Tutor tutor;
	protected int id;
	private boolean avaliada;

	public Ajuda(String matrAluno, String disciplina, Tutor tutor, int id) {
		this.matrAluno = matrAluno;
		this.disciplina = disciplina;
		this.tutor = tutor;
		this.id = id;
		this.avaliada = false;
	}

	public String getMatrAluno() {
		return matrAluno;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public abstract String pegarTutor();

	public abstract String getInfoAjuda(String atributo);

	public void calculaPontuacaoFinal(int nota) {
		if ((nota > 5.0)) {
			throw new IllegalArgumentException();
		} else if (nota < 0) {
			throw new IllegalArgumentException();
		}
		this.avaliada = true;
		double pontuacaoFinal = (this.tutor.getNotaAvaliacao() * 5 + nota) / 6;
		this.tutor.setNotaAvaliacao(pontuacaoFinal);
	}

	public int getId() {
		return this.id;
	}

	public boolean getAvaliada() {
		return this.avaliada;
	}

}
