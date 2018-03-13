package Comparators;

import java.util.Comparator;

import ClassesBase.Aluno;

public class AlunoComparatorMatricula implements Comparator<Aluno> {


	@Override
	public int compare(Aluno o1, Aluno o2) {
		
		return Integer.valueOf(o1.getMatricula()).compareTo(Integer.valueOf(o2.getMatricula())) ;
	}

}
