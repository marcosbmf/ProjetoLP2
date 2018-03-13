package Comparators;

import java.util.Comparator;

import ClassesBase.Tutor;

/**
 * Classe responsavel por controlar o comparador de um tutor a partir da
 * matricula.
 *
 */
public class TutorComparatorMatricula implements Comparator<Tutor> {

	@Override
	public int compare(Tutor o1, Tutor o2) {
		return Integer.valueOf(o1.getMatricula()).compareTo(Integer.valueOf(o2.getMatricula()));
	}

}
