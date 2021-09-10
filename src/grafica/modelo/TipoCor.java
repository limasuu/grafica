package grafica.modelo;

public enum TipoCor {
	
	COR("Colorido"),
	PB("Preto e branco");
	
	private String cor;	
	
	private TipoCor(String cor) {
		this.cor = cor;
	}

	public String getCor() {
		return cor;
	}
}
