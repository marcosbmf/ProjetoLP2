package ClassesBase;

/**
 * 
 * @author Marcos Barros Classe responsavel pela representação de uma ajuda
 *         pedida por um aluno ao sistema , de distribuição de alunos e tutores.
 * 
 *
 */

public abstract class Ajuda {

	protected String matrAluno;
	protected String disciplina;
	protected Tutor tutor;
	protected int id;
	private boolean avaliada;

	/**
	 * Construtor de uma ajuda .
	 * 
	 * @param matrAluno
	 *            - Matricula do aluno
	 * @param disciplina
	 *            - Disciplina na qual o aluno deseja ajuda.
	 * @param tutor
	 *            - Tutor responsável por pela ajuda. Designado pelo sistema.
	 * @param id
	 *            - Identificador unico da ajuda no sistema.
	 */
	public Ajuda(String matrAluno, String disciplina, Tutor tutor, int id) {
		this.matrAluno = matrAluno;
		this.disciplina = disciplina;
		this.tutor = tutor;
		this.id = id;
		this.avaliada = false;
	}

	/**
	 * Metodo responsavel por retornar a matricula do aluno que esta recebendo
	 * ajuda.
	 * 
	 * @return Matricula do aluno que esta recebendo ajuda.
	 */
	public String getMatrAluno() {
		return matrAluno;
	}

	/**
	 * Metodo responsavel por retornar a disciplina na qual a ajuda esta sendo
	 * ministrada.
	 * 
	 * @return Disciplina na qual a ajuda esta sendo ministrada.
	 */
	public String getDisciplina() {
		return disciplina;
	}

	/**
	 * Metodo responsavel por retornar uma descricao do  tutor que esta ministrando a ajuda.
	 * 
	 * @return descricao do tutor, que está responsavel por ministrar a ajuda.
	 */
	public abstract String pegarTutor();

	/**
	 * 
	 * @param atributo
	 *            - Informacao da ajuda desejada
	 * @return Informacao desejada de acordo com o atributo - Com relacao a ajuda.
	 */
	public abstract String getInfoAjuda(String atributo);

	/**
	 * Metodo responsavel por calcular a pontuacao final do tutor , por meio de uma
	 * nota de avaliacao.
	 * 
	 * @param nota de avaliacao a qual o tutor recebe por realizar uma ajuda.
	 */
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

	/**
	 * Metodo responsavel por retornar o identificador unico da ajuda.
	 * @return identificador unico da ajuda.
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * Metodo responsavel por retornar um boolean avisando se ajuda foi ou nao avaliada, de modo a garantir avaliacao unica.
	 * @return boolean afirmando se ajuda ja foi ou nao avaliada 
	 */
	public boolean getAvaliada() {
		return this.avaliada;
	}

}
