package ClassesBase;

import java.io.Serializable;

/**
 * 
 * @author Marcos Barros 
 * Classe responsavel por representar uma ajuda de modo presencial entre um tutor e um aluno em uma disciplina.
 *
 */

public class AjudaPresencial extends Ajuda implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String horario;
	String dia;
	String localInteresse;

	/**
	 * Construtor ajuda presencial.
	 * 
	 * @param matrAluno
	 *            - Matricula do aluno que deseja receber a ajuda.
	 * @param disciplina
	 *            - Disciplina na qual o aluno deseja receber ajuda.
	 * @param horario
	 *            - Horario de interesse para a ajuda presencial .
	 * @param dia
	 *            - Dia de interesse para a ajuda presencial ;
	 * @param localInteresse
	 *            - Lugar de interesse para a ajuda presencial ;
	 * @param tutor
	 *            - Tutor designado para ministrar a ajuda.
	 * @param id
	 *            - identificador unico da ajuda.
	 */
	public AjudaPresencial(String matrAluno, String disciplina, String horario, String dia, String localInteresse,
			Tutor tutor, int id) {
		super(matrAluno, disciplina, tutor, id);
		if (this.stringVaziaOuNula(horario)) {
			throw new IllegalArgumentException("Erro na criacao de ajuda: horario nao pode ser vazia ou nula");
		} else if (this.stringVaziaOuNula(dia)) {
			throw new IllegalArgumentException("Erro na criacao de ajuda: dia nao pode ser vazio ou nulo");
		} else if (this.stringVaziaOuNula(localInteresse)) {
			throw new IllegalArgumentException("Erro na criacao de ajuda: local nao pode ser vazio ou nulo");
		}
		
		this.horario = horario;
		this.dia = dia;
		this.localInteresse = localInteresse;
	}

	/**
	 * Metodo respons�vel por devolver no formato String a informa��o sobre a ajuda
	 * desejada pelo sistema.
	 */
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

	/**
	 * Retorna uma descricao da ajuda em String no formato "Tutor - matriculaTutor ,
	 * horario - HorarioDaAjuda , dia - Data da ajuda , local - localdaajuda ,
	 * disciplina - disciplinaAjuda .
	 */
	@Override
	public String pegarTutor() {
		return "Tutor - " + this.tutor.getMatricula() + ", horario - " + this.horario + ", dia - " + this.dia
				+ ", local - " + this.localInteresse + ", disciplina - " + this.disciplina;
	}
	
	private boolean stringVaziaOuNula(String texto) {
		if (texto.trim().equals("") || texto == null) {
			return true;
		}
		return false;
	}
	
}
