package ClassesBase;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * 
 * @author cyberia
 *
 */
public class Agenda {

	private List<String> locais = new ArrayList<String>();
	private Map<String, ArrayList<LocalTime>> horarios = new HashMap<String, ArrayList<LocalTime>>();

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

	private LocalTime converteLocalTime(String horario) {
		String horaMin[] = new String[2];
		horaMin = horario.split(":");
		return LocalTime.of(Integer.valueOf(horaMin[0]), Integer.valueOf(horaMin[0]));
	}

	public void cadastrarLocalDeAtendimento(String local) {
		if (local.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro no cadastrar local de atendimento: local nao pode ser vazio ou em branco");
		}
		this.locais.add(local);
	}

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
