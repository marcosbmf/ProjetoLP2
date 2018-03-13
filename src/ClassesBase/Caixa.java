package ClassesBase;

import java.io.Serializable;
/**
 * 
 * Classe responsavel pela representação do caixa do sistema.
 * Aqui ficara guardado o dinheiro designado ao sistema.
 */
public class Caixa implements Serializable{

	private static final long serialVersionUID = 1L;
	private double dinheiro_sistema;

	/**
	 * Construtor do caixa do sistema, inicalizando o valor do caixa com zero.
	 * 
	 */
	public Caixa() {
		this.dinheiro_sistema = 0;
	}
	/**
	 * Metodo responsável por incrementar mais dinheiro ao caixa do sistema.
	 * 
	 * @param dinheiro_sistema 
	 * 		- valor a ser incrementado
	 */
	public void setDinheiro_sistema(double dinheiro_sistema) {
		this.dinheiro_sistema += dinheiro_sistema;
	}
	/**
	 * Metodo responsável por retornar o dinheiro do sistema.
	 */
	public double getDinheiro_sistema() {
		return dinheiro_sistema;
	}

}
