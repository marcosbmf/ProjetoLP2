package ClassesBase;

/**
 * 
 * @author Marcos Barros Classe responsavel representar uma ajuda que ocorre no
 *         ambito online por meio de um tutor e um aluno
 *
 */
public class AjudaOnline extends Ajuda {

	/**
	 * Construtor de uma ajuda online
	 * 
	 * @param matrAluno
	 *            - Matricula do aluno que deseja receber a ajuda.
	 * @param disciplina
	 *            - Disciplina na qual o aluno deseja receber a ajuda.
	 * @param tutor
	 *            - Tutor responsavel por ministrar a ajuda .
	 * @param id
	 *            - Identificador unico da ajuda.
	 */
	public AjudaOnline(String matrAluno, String disciplina, Tutor tutor, int id) {
		super(matrAluno, disciplina, tutor, id);
	}

	/**
	 * Sobreposicao do metodo getInfo , por meio de polimorfismo , garante que os
	 * atributos da ajuda sejam retornados ao usuario com sucesso .
	 * 
	 */
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

	/**
	 * Metodo responsável por retornar uma descricao no formato "Tutor - matricula ,
	 * disciplina - nomedisciplina "
	 */
	@Override
	public String pegarTutor() {
		return "Tutor - " + this.tutor.getMatricula() + ", disciplina - " + this.disciplina;
	}

}
