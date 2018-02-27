package ClassesBase;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * 
 * @author Thyago Pereira da Silva - 117110164 Classe responsavel pela
 *         representacao de uma agenda com disponibilidade de horarios , locais
 *         e dias para tutoria .
 */
public class Agenda {

	private List<String> locais; 
	private Map<String, ArrayList<LocalTime>> horarios; 

	
	
	public Agenda() {
		
		this.locais = new ArrayList<String>();
		this.horarios = new HashMap<String, ArrayList<LocalTime>>();
	}
	
	/**
	 * Metodo responsavel por cadastrar um dia da semana e um horario para a
	 * tutoria.
	 * 
	 * @param horario
	 * @param dia
	 */
	public void cadastrarHorario(String horario, String dia) {
		if (stringVaziaOuNula(horario)) {
			throw new IllegalArgumentException("Erro no cadastrar horario: horario nao pode ser vazio ou em branco");
		}
		if (stringVaziaOuNula(dia)) {
			throw new IllegalArgumentException("Erro no cadastrar horario: dia nao pode ser vazio ou em branco");
		}

		LocalTime hora = this.converteLocalTime(horario);

		if (this.horarios.containsKey(dia)) {
			this.horarios.get(dia).add(hora);
		} else {
			ArrayList<LocalTime> aux = new ArrayList<LocalTime>();
			aux.add(hora);
			this.horarios.put(dia, aux);
		}

	}

	/**
	 * Metodo responsavel por converter uma String representado um horario no
	 * formato HH:MM para um objeto LocalTime da API de java 8
	 * 
	 * @param horario
	 * @return Objeto LocalTime associado ao tempo descrito em Horario .
	 */
	private LocalTime converteLocalTime(String horario) {
		String horaMin[] = new String[2];
		horaMin = horario.split(":");
		return LocalTime.of(Integer.valueOf(horaMin[0]), Integer.valueOf(horaMin[0]));
	}

	/**
	 * Metodo responsavel por cadastrar um local para ocorrencia da tutoria .
	 * 
	 * @param local
	 */
	public void cadastrarLocalDeAtendimento(String local) {
		if (stringVaziaOuNula(local)) {
			throw new IllegalArgumentException(
					"Erro no cadastrar local de atendimento: local nao pode ser vazio ou em branco");
		}
		this.locais.add(local);
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
		if (stringVaziaOuNula(horario)) {
			throw new IllegalArgumentException("Erro no cadastrar horario: horario nao pode ser vazio ou em branco");
		}
		if (stringVaziaOuNula(dia)) {
			throw new IllegalArgumentException("Erro no cadastrar horario: dia nao pode ser vazio ou em branco");
		}
		
		if (!this.horarios.containsKey(dia)) {
			return false;
		}
		if (this.horarios.get(dia).contains(this.converteLocalTime(horario))) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Metodo responsavel por verificar se um determinado local estah cadastrado no
	 * tutor para a tutoria
	 * 
	 * @param local
	 * 
	 * @return Boolean afirmando disponibilidade de tutoria no local
	 */
	public boolean consultaLocal(String local) {
		if (stringVaziaOuNula(local)) {
			throw new IllegalArgumentException(
					"Erro no consultar local de atendimento: local nao pode ser vazio ou em branco");
		}

		if (this.locais.contains(local)) {
			return true;
		} else {
			return false;
		}
	}
	
	private boolean stringVaziaOuNula(String texto) {
		if (texto.trim().equals("") || texto == null) {
			return true;
		}
		return false;
	}

}
