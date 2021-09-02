package grafica.modelo;

public enum ModeloEncadernacao {
	
	SIMPLESESPIRAL("Capa simples", "Espiral", 6.00),
	SIMPLESGRAMPO("Capa simples", "Grampo/Canoa", 12.00),
	SIMPLESCOLA("Capa simples", "Colado", 25.00),
	DURACOSTURA("Capa dura", "Costurado", 50.00),
	DURAWIREO("Capa dura", "Wire-o", 35.00);
	
	private String capa, acabamento;
	private double preco;
	
	private ModeloEncadernacao(String capa, String acabamento, double preco) {
		this.capa = capa;
		this.acabamento = acabamento;
		this.preco = preco;
	}

	public String getCapa() {
		return capa;
	}

	public String getAcabamento() {
		return acabamento;
	}

	public double getPreco() {
		return preco;
	}
	
	public String getModelo() {
		return capa + " | " + acabamento;
	}
}
