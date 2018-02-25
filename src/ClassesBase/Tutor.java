package ClassesBase;

import java.util.ArrayList;

public class Tutor extends Aluno{
	
	private ArrayList<Disciplina> disciplinas;
	private int proficiencia;
	private double notaAvaliacao;
	private int dinheiroRecebido;
	private Agenda agenda;

	
	public Tutor(String nome, String matricula, int codigoCurso, String telefone, String eMail, double notaAvaliacao, String disciplina, int proficiencia) {
		super(nome, matricula, codigoCurso, telefone, eMail, notaAvaliacao);
		this.disciplinas = new ArrayList<>();
		this.disciplinas.add(new Disciplina(disciplina, proficiencia));
		this.notaAvaliacao = 4.0;
		this.dinheiroRecebido = 0;
		this.agenda = new Agenda();
	}


	public ArrayList<Disciplina> getDisciplina() {
		return disciplinas;
	}
	
	public boolean consultaDisciplina(String nome) {
		for(Disciplina disciplina : disciplinas) {
			if(disciplina.getNome().equals(nome)) {
				return true;
			}
		}
		return false;
	}

	public void adicionaDisciplina(String disciplina, int proficiencia) {
		this.disciplinas.add(new Disciplina(disciplina, proficiencia));
	}

	public int getProficiencia() {
		return proficiencia;
	}


	public double getNotaAvaliacao() {
		return notaAvaliacao;
	}
	
	public void mudaAvaliacao(double avaliacao) {
		this.notaAvaliacao = avaliacao;
	}


	public int getDinheiroRecebido() {
		return dinheiroRecebido;
	}		
	
	public void recebeDinheiro(int quantidade) {
		this.dinheiroRecebido += quantidade;
	}
	
	public void cadastrarHorario(String horario, String dia) {
		this.agenda.cadastrarHorario(horario, dia);
	}
	
	public void cadastrarLocalDeAtendimento(String local) {
		this.agenda.cadastrarLocalDeAtendimento(local);
	}
	
	public boolean consultaHorario(String horario, String dia) {
		return this.agenda.consultaHorario(horario, dia);
	}
	
	public boolean consultaLocal(String local) {
		return this.agenda.consultaLocal(local);
	}
	
	
}