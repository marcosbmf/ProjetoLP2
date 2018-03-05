package Controllers;

import java.util.ArrayList;
import java.util.List;

import ClassesBase.Ajuda;
import ClassesBase.AjudaOnline;
import ClassesBase.AjudaPresencial;
import ClassesBase.Tutor;

/**
 * 
 * @author Marcos Barros Classe responsavel por implementar um controllador do
 *         sistema de ajudas entre tutores e alunos .
 *
 */
public class AjudaController {

	private List<Ajuda> ajudas;

	/**
	 * Construtor de AjudaConstroller
	 */
	public AjudaController() {
		this.ajudas = new ArrayList<Ajuda>();
	}

	/**
	 * Metodo responsavel por requisitar um pedido de ajuda presencial no sistema.
	 * 
	 * @param matrAluno
	 *            - Matricula do aluno que deseja receber ajuda
	 * @param disciplina
	 *            -Disciplina na qual o aluno deseja receber ajuda
	 * @param horario
	 *            - Horario na qual a ajuda deve ser ministrada
	 * @param dia
	 *            - Dia no qual a ajuda deve ser ministrada
	 * @param localInteresse
	 *            - local onde a ajuda deve ocorrer
	 * @param tutor
	 *            - Tutor responsavel pela ajuda.
	 * @return quantidade de ajudas ja cadastradas no sistema .
	 */
	public int pedirAjudaPresencial(String matrAluno, String disciplina, String horario, String dia,
			String localInteresse, Tutor tutor) {
		if (stringVaziaOuNula(matrAluno)) {
			throw new IllegalArgumentException(
					"Erro no pedido de ajuda presencial: matricula de aluno nao pode ser vazio ou em branco");
		} else if (stringVaziaOuNula(disciplina)) {
			throw new IllegalArgumentException(
					"Erro no pedido de ajuda presencial: disciplina nao pode ser vazio ou em branco");
		} else if (stringVaziaOuNula(dia)) {
			throw new IllegalArgumentException(
					"Erro no pedido de ajuda presencial: dia nao pode ser vazio ou em branco");
		} else if (stringVaziaOuNula(localInteresse)) {
			throw new IllegalArgumentException(
					"Erro no pedido de ajuda presencial: local de interesse nao pode ser vazio ou em branco");
		} else if (stringVaziaOuNula(horario)) {
			throw new IllegalArgumentException(
					"Erro no pedido de ajuda presencial: horario nao pode ser vazio ou em branco");
		}
		this.ajudas.add(new AjudaPresencial(matrAluno, disciplina, horario, dia, localInteresse, tutor,
				this.ajudas.size() + 1));
		return this.ajudas.size();
	}

	/**
	 * Metodo responsavel por requisitar um pedido de ajuda online.
	 * 
	 * @param matrAluno
	 *            - matricula do aluno que deseja receber a ajuda
	 * @param disciplina
	 *            - disciplina na qual o aluno deseja receber ajuda.
	 * @param tutor
	 *            - tutor responsavel pela ajuda
	 * @return Quantidade de ajudas ja cadastradas
	 */
	public int pedirAjudaOnline(String matrAluno, String disciplina, Tutor tutor) {
		if (stringVaziaOuNula(matrAluno)) {
			throw new IllegalArgumentException(
					"Erro no pedido de ajuda online: matricula de aluno nao pode ser vazio ou em branco");
		} else if (stringVaziaOuNula(disciplina)) {
			throw new IllegalArgumentException(
					"Erro no pedido de ajuda online: disciplina nao pode ser vazio ou em branco");
		}
		this.ajudas.add(new AjudaOnline(matrAluno, disciplina, tutor, (this.ajudas.size() + 1)));
		return this.ajudas.size();
	}

	/**
	 * 
	 * @param idAjuda
	 * @return Descricao em string do tutor responsável pela ajuda , bem como com
	 *         informacoes relacionadas a ajuda.
	 * 
	 */
	public String pegarTutor(int idAjuda) {
		if (idAjuda <= 0) {
			throw new IllegalArgumentException("Erro ao tentar recuperar tutor : id nao pode menor que zero ");
		} else if (idAjuda > ajudas.size()) {
			throw new IllegalArgumentException("Erro ao tentar recuperar tutor : id nao encontrado ");
		}
		return this.ajudas.get(idAjuda - 1).pegarTutor();
	}
	
	/**
	 * 
	 * @param idAjuda - identificador unico da ajuda 
	 * @param atributo -  O atributo no qual deseja-se recuperar a ajuda.
	 * @return Informacao da ajuda especificada pelo atributo , por meio de uma String .,
	 */
	public String getInfoAjuda(int idAjuda, String atributo) {
		if (idAjuda <= 0) {
			throw new IllegalArgumentException("Erro ao tentar recuperar info da ajuda : id nao pode menor que zero ");
		} else if (idAjuda > ajudas.size()) {
			throw new IllegalArgumentException("Erro ao tentar recuperar info da ajuda : id nao encontrado ");
		} else if (stringVaziaOuNula(atributo)) {
			throw new IllegalArgumentException(
					"Erro ao tentar recuperar info da ajuda : atributo nao pode ser vazio ou em branco");
		}
		return this.ajudas.get(idAjuda - 1).getInfoAjuda(atributo);
	}
	
	/**
	 * Metodo responsavel por verificar se uma String é vazia ou null 
	 * @param texto
	 * @return Boolean afirmando se a string é vazia ou null
	 */
	private boolean stringVaziaOuNula(String texto) {
		if (texto.trim().equals("") || texto == null) {
			return true;
		}
		return false;
	}
	
	/**
	 * Metodo responsável por avaliar um tutor de uma ajuda , por meio de uma nota especificada . 
	 * @param idAjuda Identificador unico da ajuda. 
	 * @param nota de avaliacao do tutor responsavel pela ajuda entre  0 - 5 
	 */
	public void avaliarTutor(int idAjuda, int nota) {
		if (nota < 0) {
			throw new IllegalArgumentException("Erro na avaliacao de tutor: nota nao pode ser menor que 0");
		}
		if (nota > 5) {
			throw new IllegalArgumentException("Erro na avaliacao de tutor: nota nao pode ser maior que 5");
		}

		if (this.ajudas.size() < idAjuda) {
			throw new IllegalArgumentException("Erro na avaliacao de tutor: id nao encontrado ");
		}

		if (!this.ajudas.get(idAjuda - 1).getAvaliada()) {
			this.ajudas.get(idAjuda - 1).calculaPontuacaoFinal(nota);
		} else {
			throw new IllegalArgumentException("Erro na avaliacao de tutor: Ajuda ja avaliada");
		}

	}
}
