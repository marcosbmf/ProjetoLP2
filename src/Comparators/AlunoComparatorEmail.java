package Comparators;

import java.util.Comparator;

import ClassesBase.Aluno;

/**
 * Classe responsavel por controlar o comparador de Aluno a partir do email.
 *
 */
public class AlunoComparatorEmail implements Comparator<Aluno> {

	AlunoComparatorMatricula comparador  = new AlunoComparatorMatricula();
	@Override
	public int compare(Aluno o1, Aluno o2) {
		if(o1.geteMail().compareTo(o2.geteMail()) == 0) {
			return comparador.compare(o1, o2);
		}
		else {
			return o1.geteMail().compareTo(o2.geteMail());
		}
	}


}
