package Controllers;

import java.io.IOException;

/**
 * 
 * @author Victor Ribeiro Miranda - 116211361 Classe responsavel por gerenciar e
 *         delegar funcoes para outras classes - Sistema
 *
 */

public class Facade {

	Sistema sistema = new Sistema();
	ArquivosController ac = new ArquivosController();

	/**
	 * Metodo responsavel por cadastrar um aluno no sistema.
	 * 
	 * @param nome
	 * @param matricula
	 * @param codigoCurso
	 * @param telefone
	 * @param email
	 */
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		sistema.cadastrarAluno(nome, matricula, codigoCurso, telefone, email);
	}

	/**
	 * Metodo responsavel por recuperar um aluno por meio da matricula na
	 * colecaoo.
	 * 
	 * @param matricula
	 * @return Representacao em String de um determinado aluno por meio de sua
	 *         matricula .
	 */
	public String recuperaAluno(String matricula) {
		return sistema.recuperaAluno(matricula);
	}

	/**
	 * Metodo responsavel por listar os tutores.
	 * 
	 * @return String contendo a representando de todos os alunos cadastrados .
	 */
	public String listarAlunos() {
		return sistema.listarAlunos();
	}

	/**
	 * Recupera a informacaoo solicitada do aluno , por meio da matricula
	 * 
	 * @param matricula
	 * @param atributo
	 * @return String contendo a informacaoo desejada do aluno especificado por
	 *         matricula.
	 */
	public String getInfoAluno(String matricula, String atributo) {
		return sistema.getInfoAluno(matricula, atributo);
	}

	/**
	 * Metodo responsavel por cadastrar um tutor no sistema.
	 * 
	 * @param matricula
	 * @param disciplina
	 * @param proficiencia
	 */
	public void tornarTutor(String matricula, String disciplina, int proficiencia) {
		sistema.tornarTutor(matricula, disciplina, proficiencia);

	}

	/**
	 * Metodo responsavel por recuperar um tutor por meio da matricula na
	 * colecaoo.
	 * 
	 * @param matricula
	 * 
	 * @return Representacao em String de um determinado tutor por meio de sua
	 *         matricula.
	 */
	public String recuperaTutor(String matricula) {
		return sistema.recuperaTutor(matricula);
	}

	/**
	 * Metodo responsavel por listar os tutores.
	 * 
	 * @return String contendo a representando de todos os alunos cadastrados .
	 */
	public String listarTutores() {
		return sistema.listarTutores();
	}

	/**
	 * Metodo responsavel por cadastrar um dia da semana e um horario para a
	 * tutoria.
	 * 
	 * @param horario
	 * @param dia
	 */

	public void cadastrarHorario(String email, String horario, String dia) {
		sistema.cadastrarHorario(email, horario, dia);
	}

	/**
	 * Metodo responsavel por cadastrar um local para ocorrencia da tutoria .
	 * 
	 * @param local
	 */
	public void cadastrarLocalDeAtendimento(String email, String local) {
		sistema.cadastrarLocalDeAtendimento(email, local);
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
	public boolean consultaHorario(String email, String horario, String dia) {
		return sistema.consultaHorario(email, horario, dia);
	}

	/**
	 * Metodo responsavel por verificar se um determinado local esta cadastrado
	 * no tutor para a tutoria
	 * 
	 * @param local
	 * 
	 * @return Boolean afirmando disponibilidade de tutoria no local
	 */
	public boolean consultaLocal(String email, String local) {
		return sistema.consultaLocal(email, local);
	}

	/**
	 * Metodo responsavel por requisitar uma ajuda presencial .
	 * 
	 * @param matrAluno
	 *            - Matricula do aluno que deseja ajuda.
	 * @param disciplina
	 *            - Disciplina na qual a ajuda deve ser ministrada
	 * @param horario
	 *            - Horario na qual a ajuda deve ocorrer.
	 * @param dia
	 *            - Dia no qual a ajuda deve ocorrer
	 * @param localInteresse
	 *            - local onde deve ocorrer a ajuda.
	 * @return Numero de ajudas j� cadastradas no sistema.
	 */
	public int pedirAjudaPresencial(String matrAluno, String disciplina, String horario, String dia,
			String localInteresse) {
		return sistema.pedirAjudaPresencial(matrAluno, disciplina, horario, dia, localInteresse);
	}

	/**
	 * Metodo responsavel por verificar uma ajuda online
	 * 
	 * @param matrAluno
	 *            - Matricula do aluno que deseja ajuda.
	 * @param disciplina
	 *            - Disciplina qual a ajuda deve ser ministrada
	 * @return numero de ajudas ja cadastradas no sistema.
	 */
	public int pedirAjudaOnline(String matrAluno, String disciplina) {
		return sistema.pedirAjudaOnline(matrAluno, disciplina);
	}

	/**
	 * Metodo responsavel por retornar uma representacao em string do tutor
	 * responsavel pela ajuda bem como com informa��es da ajuda.
	 * 
	 * @param idAjuda
	 *            - identificador unico da ajuda.
	 * @return Representacao textual do tutor e da ajuda.
	 */
	public String pegarTutor(int idAjuda) {
		return sistema.pegarTutor(idAjuda);
	}

	/**
	 * 
	 * @param idAjuda
	 *            - Identificador unico da ajuda.
	 * @param atributo
	 *            - Atributo da ajuda ao qual deseja-se recuperar
	 * @return Informacao desejada sobre a ajuda.
	 */
	public String getInfoAjuda(int idAjuda, String atributo) {
		return sistema.getInfoAjuda(idAjuda, atributo);
	}

	/**
	 * Metodo responsavel por estabelecer uma avaliacao ao tutor responsavel por
	 * determinada ajuda
	 * 
	 * @param idAjuda
	 *            - Identificador unico da ajuda.
	 * @param nota
	 *            - Nota dada ao tutor 0-5 .
	 */
	public void avaliarTutor(int idAjuda, int nota) {
		sistema.avaliarTutor(idAjuda, nota);
	}

	/**
	 * Metodo responsavel por retornar a nota de avalicao atual de um
	 * determinado tutor .
	 * 
	 * @param matriculaTutor
	 *            - Matricula do tutor
	 * @return Nota de avalicao geral do tutor .
	 */
	public String pegarNota(String matriculaTutor) {
		return sistema.pegarNota(matriculaTutor);
	}

	/**
	 * 
	 * Metodo responsavel por retornar o nivel de um determinado tutor
	 * cadastrado no sistema.
	 * 
	 * @param matriculaTutor
	 *            - Matricula do tutor.
	 * @return Nivel de habilidade do tutor .
	 */
	public String pegarNivel(String matriculaTutor) {
		return sistema.pegarNivel(matriculaTutor);
	}

	/**
	 * 
	 * Metodo responsavel por possibilitar a doacao para um tutor.
	 * 
	 * @param matriculaTutor
	 *            - Matricula do tutor.
	 * @param totalCentavos
	 *            - Dinheiro doado em centavos.
	 * 
	 */

	public void doar(String matriculaTutor, int totalCentavos) {
		sistema.doar(matriculaTutor, totalCentavos);

	}

	/**
	 * 
	 * Metodo responsavel por retornar o dinheiro total de um tutor.
	 * 
	 * @param emailTutor
	 *            - Email do tutor.
	 * @return totalDinheiroTutor - Dinheiro total de um tutor especifico.
	 * 
	 */

	public int totalDinheiroTutor(String emailTutor) {
		return sistema.totalDinheiroTutor(emailTutor);
	}

	/**
	 * 
	 * Metodo responsavel por retornar o dinheiro total de sistema.
	 * 
	 * @return totalDinheiroTutor - Dinheiro total do sistema.
	 * 
	 */

	public int totalDinheiroSistema() {
		return sistema.totalDinheiroSistema();
	}
	
	public void salvar() throws IOException {
		ac.salvaObjeto("Sistema.txt", this.sistema);
	}
	
	public void carregar() throws IOException {
		Sistema sistemaCarregado = (Sistema) ac.carregaObjeto("Sistema.txt");
		this.sistema = sistemaCarregado;
		this.sistema.limparOrdem();
	}
	
	public void limpar() {
		String ordem = this.sistema.getOrdenacaoAtual();
		this.sistema = new Sistema();
		this.sistema.configurarOrdem(ordem);
	}
	
	
	public void configurarOrdem(String atributo) {
		sistema.configurarOrdem(atributo);
	}
	
}
