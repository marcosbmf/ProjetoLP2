package ClassesBase;

import java.util.ArrayList;

 /**
 * 
 * @author Marcos Barros
 * 
 * 	Classe responsavel pela representacao de um Tutor, que guarda as disciplinas que ele presta tutoria, sua nota de avaliacao e
 *  sua proficiencia na mesma.
 *
 */
public class Tutor  implements Comparable<Tutor>{

	private ArrayList<Disciplina> disciplinas;
	private Aluno aluno;
	private double notaAvaliacao;
	private Agenda agenda;
	private int idCriacao;
	private String nivel ;
   
	
	/**
   * Constro� um tutor a partir do nome, da matricula, do c�digo do curso,  do telefone dele, do seu email, e da sua nota de avalia�ao,
   * a disciplina que ira prestar tutoria e sua proficiencia.
   * 
   *
   * @param nome
   * @param matricula
   * @param codigoCurso
   * @param telefone
   * @param eMail
   * @param notaAvaliacao
   * @param disciplina
   * @param proficiencia
   * 
   */
	public Tutor(Aluno aluno, String disciplina, int proficiencia, int idCriacao) {
		this.aluno = aluno ;
		this.disciplinas = new ArrayList<>();
		this.disciplinas.add(new Disciplina(disciplina, proficiencia));
		this.notaAvaliacao = 0.0;
		this.nivel = "Tutor";
		this.agenda = new Agenda();
		this.idCriacao = aluno.getIdCriacao();
	}
	
	/**
	 * @return A colecao de disciplinas o qual o tutor presta tutoria.
	 */
	public ArrayList<Disciplina> getDisciplina() {
		return disciplinas;
	}
	
	/**
	 * Metodo responsavel por verificar seu o tutor ja esta cadastrado como tutor em uma determinada disciplina
	 * 
	 * @param nome, da disciplina a ser verificada
	 * 
	 * @return Boolean, true caso o tuutor ja esteja prestando tutoria na disciplina, e false caso n�o esteja.
	 */
	public boolean consultaDisciplina(String nome) {
		for (Disciplina disciplina : disciplinas) {
			if (disciplina.getNome().equals(nome)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Metodo responsavel por acrescentar uma disciplina para o tutor. 
	 * 
	 * @param disciplna
	 * @param proficiencia
	 * 
	 */
	public void adicionaDisciplina(String disciplina, int proficiencia) {
		if(consultaDisciplina(disciplina)) {
			throw new IllegalArgumentException("Erro ao adicionar disciplina: Aluno já é tutor desta disciplina");
		}
		this.disciplinas.add(new Disciplina(disciplina, proficiencia));
	}
	
	/**
	 * @return A proficiencia do tutor na disciplina.
	 */
	public int getProficiencia(String disciplina) {
		for (Disciplina disci : disciplinas ) {
			if(disci.getNome().equals(disciplina)) {
				return disci.getProficiencia() ; 
			}
		}
		throw new IllegalArgumentException();
		
	}

	/**
	 * @return A nota de avaliacao do tutor.
	 */
	public double getNotaAvaliacao() {
		return notaAvaliacao;
	}
	
	/**
	 * Metodo responsavel por cadastrar um dia da semana e um horario para a
	 * tutoria.
	 * 
	 * @param horario
	 * @param dia
	 */
	public void cadastrarHorario(String horario, String dia) {
		this.agenda.cadastrarHorario(horario, dia);
	}

	
	/**
	 * Metodo responsavel por cadastrar um local para ocorrencia da tutoria .
	 * 
	 * @param local
	 */
	public void cadastrarLocalDeAtendimento(String local) {
		this.agenda.cadastrarLocalDeAtendimento(local);
	}

	/**
	 * Metodo responsavel por verificar se um determinado horario de um dia esta
	 * disponivel para a tutoria.
	 * 
	 * @param horario
	 * @param dia
	 * 
	 * @return Boolean afirmando disponibilidade de tutoria no dia / hora
	 */
	public boolean consultaHorario(String horario, String dia) {
		return this.agenda.consultaHorario(horario, dia);
	}

	/**
	 * Metodo responsavel por verificar se um determinado local esta cadastrado no
	 * tutor para a tutoria
	 * 
	 * @param local
	 * 
	 * @return Boolean afirmando disponibilidade de tutoria no local
	 */
	public boolean consultaLocal(String local) {
		return this.agenda.consultaLocal(local);
	}
	
	
	public String getNome() {
		return this.aluno.getNome() ;
	}
	
	
	public String getEmail() {
		return this.aluno.geteMail();
	}
	

	@Override
	public int compareTo(Tutor o) {
		return this.getNome().compareTo(o.getNome());
		
	}
	
	public String toString() {
		return this.aluno.toString();
	}

	public int getIdCriacao() {
		return this.idCriacao;
	}
	
	public String getMatricula() {
		return this.aluno.getMatricula();
	}

	public void setPontuacao(double pontuacaoFinal) {
		this.notaAvaliacao = pontuacaoFinal;
		
	}
	
	private void setNivel() {
		if(this.notaAvaliacao > 4.5) {
			this.nivel = "TOP";
		}
		else {
			if((this.notaAvaliacao > 3.0) && (this.notaAvaliacao <= 4.5)) {
				this.nivel = "Tutor";
			}
			else {
				if((this.notaAvaliacao <= 3.0) && (this.notaAvaliacao >0)) {
					this.nivel =  "Aprendiz";
				}
			}
		}
	} 
		
	
	public String getNivel() {
		this.setNivel();
		return this.nivel ;
	}
	
	public double getNota() {
		return this.notaAvaliacao; 
	}

	

}