package grafica.modelo;

public enum TipoCapa {
	
	SIMPLES("Capa simples"),
	DURA("Capa dura");
	
	private String capa;

	private TipoCapa(String capa) {
		this.capa = capa;
	}

	public String getCapa() {
		return capa;
	}
	
	public static TipoCapa getValue(int tipo) {
		return values()[tipo];
	}
}
