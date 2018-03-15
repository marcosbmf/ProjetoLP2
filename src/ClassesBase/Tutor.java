package ClassesBase;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * @author Marcos Barros
 * 
 *         Classe responsavel pela representacao de um Tutor, que guarda as
 *         disciplinas que ele presta tutoria, sua nota de avaliacao e sua
 *         proficiencia na mesma.
 *
 */
public class Tutor implements Comparable<Tutor>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Disciplina> disciplinas;
	private Aluno aluno;
	private double notaAvaliacao;
	private Agenda agenda;
	private int idCriacao;
	private String nivel;
	private int dinheiro;

	/**
	 * Constro� um tutor a partir do nome, da matricula, do c�digo do curso, do
	 * telefone dele, do seu email, e da sua nota de avalia�ao, a disciplina que
	 * ira prestar tutoria e sua proficiencia.
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
	 * @param idCriacao
	 * 
	 */
	public Tutor(Aluno aluno, String disciplina, int proficiencia, int idCriacao) {
		this.aluno = aluno;
		this.disciplinas = new ArrayList<>();
		this.disciplinas.add(new Disciplina(disciplina, proficiencia));
		this.notaAvaliacao = 4.00;
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
	 * Metodo responsavel por verificar seu o tutor ja esta cadastrado como tutor em
	 * uma determinada disciplina
	 * 
	 * @param nome,
	 *            da disciplina a ser verificada
	 * 
	 * @return Boolean, true caso o tuutor ja esteja prestando tutoria na
	 *         disciplina, e false caso n�o esteja.
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
		if (consultaDisciplina(disciplina)) {
			throw new IllegalArgumentException("Erro ao adicionar disciplina: Aluno já é tutor desta disciplina");
		}
		this.disciplinas.add(new Disciplina(disciplina, proficiencia));
	}

	/**
	 * @return A proficiencia do tutor na disciplina.
	 */
	public int getProficiencia(String disciplina) {
		for (Disciplina disci : disciplinas) {
			if (disci.getNome().equals(disciplina)) {
				return disci.getProficiencia();
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

	public void setNotaAvaliacao(double nota) {
		this.notaAvaliacao = nota;
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

	/**
	 * Metodo responsavel por retornar o nome do tutor.
	 * 
	 * @return O nome do aluno .
	 */
	public String getNome() {
		return this.aluno.getNome();
	}

	/**
	 * Metodo responsavel por retornar o email do tutor.
	 * 
	 * @return O email do aluno no formato xxxx@xxx.com
	 */
	public String getEmail() {
		return this.aluno.geteMail();
	}

	/**
	 * Metodo compareTo , responsavel por realizar a comparacao entre um tutor e
	 * outro com base no nome.
	 */
	@Override
	public int compareTo(Tutor o) {
		return this.getNome().compareTo(o.getNome());

	}

	/**
	 * Metodo responsavel por retornar uma representacao em String do tutor
	 * 
	 * @return Representacao em String do tutor
	 */
	public String toString() {
		return this.aluno.toString();
	}

	/**
	 * Metodo responsavel por retornar o identificador do tutor
	 * 
	 * @return inteiro representado o identificador unico do tutor .
	 */
	public int getIdCriacao() {
		return this.idCriacao;
	}

	/**
	 * Metodo responsavel por retornar a matricula do tutor
	 * 
	 * @return String com a matricula do tutor
	 */
	public String getMatricula() {
		return this.aluno.getMatricula();
	}

	/**
	 * Metodo responsavel por calcular o nivel do tutor baseado na nota de avalicao
	 */
	private void setNivel() {
		if (this.notaAvaliacao > 4.5) {
			this.nivel = "TOP";
		} else {
			if ((this.notaAvaliacao > 3.0) && (this.notaAvaliacao <= 4.5)) {
				this.nivel = "Tutor";
			} else {
				if ((this.notaAvaliacao <= 3.0) && (this.notaAvaliacao > 0)) {
					this.nivel = "Aprendiz";
				}
			}
		}
	}

	/**
	 * Metodo responsavel por retornar uma string com o nivel do tutor
	 * 
	 * @return String com o nivel do tutor .
	 */
	public String getNivel() {
		this.setNivel();
		return this.nivel;
	}

	/**
	 * Metodo responsavel por retornar um double com a quantidade de dinheiro do
	 * tutor
	 * 
	 * @return Double com a quantidade de dinheiro associada ao tutor
	 */
	public double getDinheiro() {
		return dinheiro;
	}

	/**
	 * Metodo responsavel por setar o dinheiro de um determinado tutor .
	 * 
	 * @param dinheiro
	 */
	public void setDinheiro(double dinheiro) {
		this.dinheiro += (int) dinheiro;
	}

}