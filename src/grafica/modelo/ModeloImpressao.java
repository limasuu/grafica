package grafica.modelo;

public enum ModeloImpressao {
	
	CORA3(TipoCor.COR, TipoFormato.A3, 3.80),
	PBA3(TipoCor.PB, TipoFormato.A3, 1.10),
	CORA4(TipoCor.COR, TipoFormato.A4, 1.90),	
	PBA4(TipoCor.PB, TipoFormato.A4, 0.50);

	private TipoCor cor;
	private TipoFormato formato;
	private double preco;
	
	private ModeloImpressao(TipoCor cor, TipoFormato formato, double preco) {
		
		this.cor = cor;
		this.formato = formato;
		this.preco = preco;
	}

	public String getCor() {
		return cor.getCor();
	}

	public String getFormato() {
		return formato.getFormato();
	}

	public double getPreco() {
		return preco;
	}	
	
	public String getModelo() {
		return getCor() + " | " + getFormato();
	}
}
