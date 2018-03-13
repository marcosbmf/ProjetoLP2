package Comparators;

import java.util.Comparator;

import ClassesBase.Aluno;

public class AlunoComparatorNome implements Comparator<Aluno> {

	AlunoComparatorMatricula comparador = new AlunoComparatorMatricula();
	
	@Override
	public int compare(Aluno o1, Aluno o2) {
		if(o1.getNome().compareTo(o2.getNome()) == 0) {
			return comparador.compare(o1, o2);
		}
		else {
			return o1.getNome().compareTo(o2.getNome());
		}
	}

}
