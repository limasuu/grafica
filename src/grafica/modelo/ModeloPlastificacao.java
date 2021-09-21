package grafica.modelo;

public enum ModeloPlastificacao {
	
	CRACHA("Crachá/documentos", 2.00),
	A5("A5", 2.80),
	A4("A4", 3.20),
	A3("A3", 6.40);	
	
	private String modelo;
	private double preco;
	
	private ModeloPlastificacao(String modelo, double preco) {
		this.modelo = modelo;
		this.preco = preco;
	}

	public String getModelo() {
		return modelo;
	}

	public double getPreco() {
		return preco;
	}
	
	public static ModeloPlastificacao getValue(int tipo) {
		return values()[tipo];
	}
}
