package ClassesBase;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * 
 * @author Thyago Pereira da Silva - 117110164 Classe responsável pela
 *         representação de uma agenda com disponibilidade de horarios , locais
 *         e dias para tutoria .
 */
public class Agenda {

	private List<String> locais = new ArrayList<String>();
	private Map<String, ArrayList<LocalTime>> horarios = new HashMap<String, ArrayList<LocalTime>>();

	/**
	 * Metodo responsável por cadastrar um dia da semana e um horario para a
	 * tutoria.
	 * 
	 * @param horario
	 * @param dia
	 */
	public void cadastrarHorario(String horario, String dia) {
		if (horario.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastrar horario: horario nao pode ser vazio ou em branco");
		}
		if (dia.trim().equals("")) {
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
	 * Metodo responsável por converter uma String representado um horario no
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
	 * Metodo responsável por cadastrar um local para ocorrencia da tutoria .
	 * @param local
	 */
	public void cadastrarLocalDeAtendimento(String local) {
		if (local.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro no cadastrar local de atendimento: local nao pode ser vazio ou em branco");
		}
		this.locais.add(local);
	}
	
	
	/**
	 * Metodo responsável por verificar se um determinado  horario de um dia é disponivel para  a tutoria .
	 * @param horario
	 * @param dia
	 * @return Boolean afirmando disponibilidade de tutoria no dia / hora 
	 */
	public boolean consultaHorario(String horario, String dia) {
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
	 * Metodo responsável por verificar se um determinado local está cadastrado no tutor para a tutoria 
	 * @param local
	 * @return Boolean afirmando disponibilidade de tutoria no local 
	 */
	public boolean consultaLocal(String local) {
		if (local.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro no consultar local de atendimento: local nao pode ser vazio ou em branco");
		}

		if (this.locais.contains(local)) {
			return true;
		} else {
			return false;
		}
	}

}
