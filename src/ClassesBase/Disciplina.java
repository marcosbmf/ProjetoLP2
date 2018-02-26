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
		this.nome = nome;
		this.proficiencia = proficiencia;
	}

	public String getNome() {
		return nome;
	}

	public int getProficiencia() {
		return proficiencia;
	}
}
