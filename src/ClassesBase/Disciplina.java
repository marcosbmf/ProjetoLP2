package ClassesBase;

/**
 * 
 * @author Marcos Barros
 *
 */
public class Disciplina {
	private String nome;
	private int proficiencia;

	public Disciplina(String nome, int proficiencia) {
		if (this.stringVaziaOuNula(nome)) {
			throw new IllegalArgumentException("Erro no cadastro de disciplina: Nome da disciplina não pode ser vazia ou nula.");
		} else if (proficiencia <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de disciplina: proficiencia não pode ser igual ou menor a 0.");
		}
		this.nome = nome;
		this.proficiencia = proficiencia;
	}

	public String getNome() {
		return nome;
	}

	public int getProficiencia() {
		return proficiencia;
	}
	
	@Override
	public String toString() {
		return this.nome + " - " + this.proficiencia;
	}
	
	private boolean stringVaziaOuNula(String texto) {
		if (texto.trim().equals("") || texto == null) {
			return true;
		}
		return false;
	}
}
