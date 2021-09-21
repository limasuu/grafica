package grafica.modelo;

public enum ModeloImpressao {

	A3COR(TipoFormato.A3, TipoCor.COR, 3.80),
	A3PB(TipoFormato.A3, TipoCor.PB, 1.10),
	A4COR(TipoFormato.A4, TipoCor.COR, 1.90),	
	A4PB(TipoFormato.A4, TipoCor.PB, 0.50);

	private TipoFormato formato;
	private TipoCor cor;
	private double preco;

	private ModeloImpressao(TipoFormato formato, TipoCor cor, double preco) {

		this.formato = formato;
		this.cor = cor;
		this.preco = preco;
	}

	public TipoFormato getFormato() {
		return formato;
	}

	public TipoCor getCor() {
		return cor;
	}

	public double getPreco() {
		return preco;
	}	

	public String getModelo() {
		return formato.getFormato() + " | " + cor.getCor();
	}

	public static ModeloImpressao getValue(TipoFormato formato, TipoCor cor) {

		ModeloImpressao modelo= null;

		for(ModeloImpressao m : values()) 

			if(m.getFormato().equals(formato))			
				if(m.getCor().equals(cor)){
					modelo= m;
					break;
				}

		return modelo;
	}
}
