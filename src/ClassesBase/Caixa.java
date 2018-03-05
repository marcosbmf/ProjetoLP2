package ClassesBase;

public class Caixa {

	private double dinheiro_sistema;

	public Caixa() {
		this.dinheiro_sistema = 0;
	}

	public void setDinheiro_sistema(double dinheiro_sistema) {
		this.dinheiro_sistema += dinheiro_sistema;
	}

	public double getDinheiro_sistema() {
		return dinheiro_sistema;
	}

}
