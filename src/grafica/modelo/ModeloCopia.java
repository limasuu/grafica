package grafica.modelo;

public enum ModeloCopia {
	
	CORA3("Colorida", "A3", 3.60),
	CORA4("Colorida", "A4", 1.80),
	PBA3("Preto e branco", "A3", 0.65),
	PBA4("Preto e branco", "A4", 0.30);
	
	private String formato, cor;
	private double preco;
	
	private ModeloCopia(String cor, String formato, double preco) {
		
		this.cor = cor;
		this.formato = formato;
		this.preco = preco;
	}

	public String getFormato() {
		return formato;
	}

	public String getCor() {
		return cor;
	}

	public double getPreco() {
		return preco;
	}
	
	public String getModelo() {
		return cor + " | " + formato;
	}
}
