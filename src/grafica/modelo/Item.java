package grafica.modelo;

public class Item {

	private String descricao;
	private String modelo;
	private int quantidadeAtacado;
	private double valor;

	public Item(String descricao, String modelo, int quantidadeAtacado, double valor) {

		this.descricao = descricao;
		this.modelo = modelo;
		this.quantidadeAtacado = quantidadeAtacado;
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getQuantidadeAtacado() {
		return quantidadeAtacado;
	}

	public void setQuantidadeAtacado(int quantidadeAtacado) {
		this.quantidadeAtacado = quantidadeAtacado;
	}

	public double getValor() {
		return valor;
	}
	
	public double getValorAtacado() {
		return valor-(valor*0.1);
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {

		return descricao + " | " +	modelo +
				 "\nValor unitário= R$ " + String.format("%.2f", valor) + 				
				" | Valor atacado= R$" + String.format("%.2f", getValorAtacado()) +
				" - " + quantidadeAtacado + " un.";
	}	
}
