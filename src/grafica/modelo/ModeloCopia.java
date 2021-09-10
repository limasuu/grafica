package grafica.modelo;

public enum ModeloCopia {
	
	CORA3(TipoCor.COR, TipoFormato.A3, 3.60),
	PBA3(TipoCor.PB, TipoFormato.A3, 0.65),
	CORA4(TipoCor.COR, TipoFormato.A4, 1.80),	
	PBA4(TipoCor.PB, TipoFormato.A4, 0.30);
	
	private TipoCor cor;
	private TipoFormato formato;	
	private double preco;
	
	private ModeloCopia(TipoCor cor, TipoFormato formato, double preco) {
		
		this.cor = cor;
		this.formato = formato;
		this.preco = preco;
	}

	public String getFormato() {
		return formato.getFormato();
	}

	public String getCor() {
		return cor.getCor();
	}

	public double getPreco() {
		return preco;
	}
	
	public String getModelo() {
		return getCor() + " | " + getFormato();
	}
}
