package Controllers;

import java.util.ArrayList;
import java.util.List;

import ClassesBase.Ajuda;
import ClassesBase.AjudaOnline;
import ClassesBase.AjudaPresencial;
import ClassesBase.Tutor;

public class AjudaController {

	private List<Ajuda> ajudas;
	
	public AjudaController() {
		this.ajudas = new ArrayList<Ajuda>();
	}
	
	public int pedirAjudaPresencial (String matrAluno, String disciplina, String horario, String dia, String localInteresse, Tutor tutor) {
		if (stringVaziaOuNula(matrAluno)) {
			throw new IllegalArgumentException("Erro no pedido de ajuda presencial: matricula de aluno nao pode ser vazio ou em branco");
		} else if (stringVaziaOuNula(disciplina)) {
			throw new IllegalArgumentException("Erro no pedido de ajuda presencial: disciplina nao pode ser vazio ou em branco");
		} else if (stringVaziaOuNula(dia)) {
			throw new IllegalArgumentException("Erro no pedido de ajuda presencial: dia nao pode ser vazio ou em branco");
		} else if (stringVaziaOuNula(localInteresse)) {
			throw new IllegalArgumentException("Erro no pedido de ajuda presencial: local de interesse nao pode ser vazio ou em branco");
		} else if (stringVaziaOuNula(horario)) {
			throw new IllegalArgumentException("Erro no pedido de ajuda presencial: horario nao pode ser vazio ou em branco");
		}
		this.ajudas.add(new AjudaPresencial(matrAluno, disciplina, horario, dia, localInteresse, tutor, this.ajudas.size() + 1));
		return this.ajudas.size();
	}
	
	
	public int pedirAjudaOnline (String matrAluno, String disciplina, Tutor tutor) {
		if (stringVaziaOuNula(matrAluno)) {
			throw new IllegalArgumentException("Erro no pedido de ajuda online: matricula de aluno nao pode ser vazio ou em branco");
		} else if (stringVaziaOuNula(disciplina)) {
			throw new IllegalArgumentException("Erro no pedido de ajuda online: disciplina nao pode ser vazio ou em branco");
		}
		this.ajudas.add(new AjudaOnline(matrAluno, disciplina, tutor , (this.ajudas.size() + 1)));
		return this.ajudas.size();
	}
	
	
	public String pegarTutor(int idAjuda) {
		if (idAjuda <= 0) {
			throw new IllegalArgumentException("Erro ao tentar recuperar tutor : id nao pode menor que zero ");
		} else if (idAjuda > ajudas.size()) {
			throw new IllegalArgumentException("Erro ao tentar recuperar tutor : id nao encontrado ");
		}
		return this.ajudas.get(idAjuda - 1).pegarTutor();
	}
	

	public String getInfoAjuda(int idAjuda, String atributo) {
		if (idAjuda <= 0) {
			throw new IllegalArgumentException("Erro ao tentar recuperar info da ajuda : id nao pode menor que zero ");
		} else if (idAjuda > ajudas.size()) {
			throw new IllegalArgumentException("Erro ao tentar recuperar info da ajuda : id nao encontrado ");
		} else if (stringVaziaOuNula(atributo)) {
			throw new IllegalArgumentException("Erro ao tentar recuperar info da ajuda : atributo nao pode ser vazio ou em branco");
		}
		return this.ajudas.get(idAjuda - 1).getInfoAjuda(atributo);
	}
	
	private boolean stringVaziaOuNula(String texto) {
		if (texto.trim().equals("") || texto == null) {
			return true;
		}
		return false;
	}

	public String avaliarTutor(int idAjuda, int nota) {
		if(this.ajudas.size() < idAjuda -1 ) {
			throw new IllegalArgumentException("Erro na avaliacao de tutor: id nao encontrado ");
		}
		if(nota < 0) {
			throw new IllegalArgumentException("Erro na avaliacao de tutor: nota nao pode ser menor que 0");
		}
		if(nota > 5) {
			throw new IllegalArgumentException("Erro na avaliacao de tutor: nota nao pode ser maior que 5");
		}
		if(!this.ajudas.get(idAjuda - 1 ).getAvaliada()) {
			return  this.ajudas.get(idAjuda - 1 ).calculaPontuacaoFinal(nota);
			
		}
		else {
			throw new IllegalArgumentException("Erro na avaliacao de tutor: Ajuda ja avaliada");
		}
		
		
	}
}
