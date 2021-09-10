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

	public String getCapa() {
		return capa.getCapa();
	}

	public String getAcabamento() {
		return acabamento.getAcabamento();
	}

	public double getPreco() {
		return preco;
	}
	
	public String getModelo() {
		return getCapa() + " | " + getAcabamento();
	}
}
