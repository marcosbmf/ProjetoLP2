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
		this.locais.add(local);
	}

	public boolean consultaHorario(String horario, String dia) {
		if (this.horarios.get(dia).contains(this.converteLocalTime(horario))) {
			return true;
		} else {
			return false;
		}
	}

	public boolean consultaLocal(String local) {
		if (this.locais.contains(local)) {
			return true;
		} else {
			return false;
		}
	}

}
