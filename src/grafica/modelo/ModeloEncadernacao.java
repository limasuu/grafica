package grafica.modelo;

public enum ModeloEncadernacao {
	
	SIMPLESESPIRAL(TipoCapa.SIMPLES, TipoAcabamento.ESPIRAL, 6.00),
	SIMPLESGRAMPO(TipoCapa.SIMPLES, TipoAcabamento.GRAMPO, 12.00),
	SIMPLESCOLA(TipoCapa.SIMPLES, TipoAcabamento.COLA, 25.00),
	DURACOSTURA(TipoCapa.DURA, TipoAcabamento.COSTURA, 50.00),
	DURAWIREO(TipoCapa.DURA, TipoAcabamento.WIREO, 35.00);
	
	private TipoCapa capa;
	private TipoAcabamento acabamento;
	private double preco;
	
	private ModeloEncadernacao(TipoCapa capa, TipoAcabamento acabamento, double preco) {
		this.capa = capa;
		this.acabamento = acabamento;
		this.preco = preco;
	}

	public TipoCapa getCapa() {
		return capa;
	}

	public TipoAcabamento getAcabamento() {
		return acabamento;
	}

	public double getPreco() {
		return preco;
	}
	
	public String getModelo() {
		return capa.getCapa() + " | " + acabamento.getAcabamento();
	}
	
	public static ModeloEncadernacao getValue(TipoCapa capa, TipoAcabamento acabamento) {

		ModeloEncadernacao modelo= null;

		for(ModeloEncadernacao m : values()) 

			if(m.getCapa().equals(capa))			
				if(m.getAcabamento().equals(acabamento)){
					modelo= m;
					break;
				}

		return modelo;
	}
}
