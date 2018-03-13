package Comparators;

import java.util.Comparator;

import ClassesBase.Tutor;

public class TutorComparatorMatricula implements Comparator<Tutor> {

	@Override
	public int compare(Tutor o1, Tutor o2) {
		return Integer.valueOf(o1.getMatricula()).compareTo(Integer.valueOf(o2.getMatricula())) ;
	}

}
