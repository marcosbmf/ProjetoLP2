package ClassesBase;

public class Tutor extends Aluno{
	
	private String disciplina;
	private int proficiencia;
	private double notaAvaliacao;
	private int dinheiroRecebido;

	
	public Tutor(String matricula, String nome, int codigoCurso, String telefone, String eMail, double notaAvaliacao, String disciplina, int proficiencia) {
		super(matricula, nome, codigoCurso, telefone, eMail, notaAvaliacao);
		this.disciplina = disciplina;
		this.proficiencia = proficiencia;
		this.notaAvaliacao = 4.0;
		this.dinheiroRecebido = 0;
	}


	public String getDisciplina() {
		return disciplina;
	}


	public int getProficiencia() {
		return proficiencia;
	}


	public double getNotaAvaliacao() {
		return notaAvaliacao;
	}


	public int getDinheiroRecebido() {
		return dinheiroRecebido;
	}		
}