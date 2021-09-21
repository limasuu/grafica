package grafica.modelo;

public enum ModeloCopia {
	
	A3COR(TipoFormato.A3, TipoCor.COR, 3.60),
	A3PB(TipoFormato.A3, TipoCor.PB, 0.65),
	A4COR(TipoFormato.A4, TipoCor.COR, 1.80),	
	A4PB(TipoFormato.A4, TipoCor.PB, 0.30);
	
	private TipoFormato formato;	
	private TipoCor cor;
	private double preco;
	
	private ModeloCopia(TipoFormato formato, TipoCor cor, double preco) {
		
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
	
	public static ModeloCopia getValue(TipoFormato formato, TipoCor cor) {
		
		ModeloCopia modelo= null;
		
		for(ModeloCopia m : values()) 
			
			if(m.getFormato().equals(formato))			
				if(m.getCor().equals(cor)){
					modelo= m;
					break;
				}
		
		return modelo;
	}
}
