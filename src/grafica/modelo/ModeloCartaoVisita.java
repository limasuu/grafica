package grafica.modelo;

public enum ModeloCartaoVisita{

	FRENTE("Frente", 25.00),
	FRENTEVERSO("Frente e Verso", 50.00);

	private String modelo;
	private double preco;

	private ModeloCartaoVisita(String modelo, double preco) {
		this.modelo= modelo;
		this.preco= preco;
	}

	public String getModelo() {
		return modelo;
	}

	public double getPreco(){
		return this.preco;
	}
}
