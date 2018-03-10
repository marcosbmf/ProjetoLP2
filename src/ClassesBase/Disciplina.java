package ClassesBase;

import java.io.Serializable;

/**
 * 
 * @author Marcos Barros
 * 
 *         Classe que representa uma disciplina, tendo um nome e a proficiencia.
 *
 */
public class Disciplina implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private int proficiencia;

	/**
	 * 
	 * Constro� uma disciplina a partir do nome a da proficiencia nela.
	 * 
	 * @param nome
	 * @param proficiencia.
	 *
	 */
	public Disciplina(String nome, int proficiencia) {
		if (this.stringVaziaOuNula(nome)) {
			throw new IllegalArgumentException(
					"Erro no cadastro de disciplina: Nome da disciplina não pode ser vazia ou nula.");
		} else if (proficiencia <= 0) {
			throw new IllegalArgumentException(
					"Erro no cadastro de disciplina: proficiencia não pode ser igual ou menor a 0.");
		}
		this.nome = nome;
		this.proficiencia = proficiencia;
	}

	/**
	 * @return O nome da disciplina
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @return A proficiencia nela
	 */
	public int getProficiencia() {
		return proficiencia;
	}

	/**
	 * Este m�todo retorna a String que representa uma disciplina No formato: nome -
	 * proficiencia
	 * 
	 * @return representa��o em String de uma disciplina
	 */
	@Override
	public String toString() {
		return this.nome + " - " + this.proficiencia;
	}

	/**
	 * Metodo responsavel por verificar se uma string recebida como parametro, �
	 * vazia ou nula.
	 * 
	 * @param texto
	 */
	private boolean stringVaziaOuNula(String texto) {
		if (texto.trim().equals("") || texto == null) {
			return true;
		}
		return false;
	}
}
