package Comparators;

import java.util.Comparator;

import ClassesBase.Tutor;

public class TutorComparatorNome implements Comparator<Tutor>{
	TutorComparatorMatricula comparador = new TutorComparatorMatricula();
	
	@Override
	public int compare(Tutor o1, Tutor o2) {
		if(o1.getNome().compareTo(o2.getNome()) == 0) {
			return comparador.compare(o1, o2);
		}
		else {
			return o1.getNome().compareTo(o2.getNome());
		}
	}

	
	
}
