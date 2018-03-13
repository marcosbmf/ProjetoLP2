package Comparators;

import java.util.Comparator;

import ClassesBase.Aluno;

/**
 * Classe responsavel por controlar o comparador de Aluno a partir da matricula.
 *
 */
public class AlunoComparatorMatricula implements Comparator<Aluno> {

	@Override
	public int compare(Aluno o1, Aluno o2) {

		return Integer.valueOf(o1.getMatricula()).compareTo(Integer.valueOf(o2.getMatricula()));
	}

}
