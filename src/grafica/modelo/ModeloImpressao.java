package grafica.modelo;

public enum ModeloImpressao {
	
	CORA3("Colorida", "A3", 3.80),
	CORA4("Colorida", "A4", 1.90),
	PBA3("Preto e branco", "A3", 1.10),
	PBA4("Preto e branco", "A4", 0.50);

	private String cor, formato;
	private double preco;
	
	private ModeloImpressao(String cor, String formato, double preco) {
		
		this.cor = cor;
		this.formato = formato;
		this.preco = preco;
	}

	public String getCor() {
		return cor;
	}

	public String getFormato() {
		return formato;
	}

	public double getPreco() {
		return preco;
	}	
	
	public String getModelo() {
		return cor + " | " + formato;
	}
}
