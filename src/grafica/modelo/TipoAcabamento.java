package grafica.modelo;

public enum TipoAcabamento {
	
	ESPIRAL("Espiral"),
	GRAMPO("Grampo/Canoa"),
	COLA("Colado"),
	COSTURA("Costurado"),
	WIREO("Wire-o");
	
	private String acabamento;

	private TipoAcabamento(String acabamento) {
		this.acabamento = acabamento;
	}

	public String getAcabamento() {
		return acabamento;
	}
	
	public static TipoAcabamento getValue(int tipo) {
		return values()[tipo];
	}
	
	public static TipoAcabamento[] values(TipoCapa capa) {
		
		TipoAcabamento[] acabamentos; 
		int tamanho;
		
		if(capa.equals(TipoCapa.SIMPLES)) {
			tamanho= 3;
			acabamentos= new TipoAcabamento[tamanho];
			System.arraycopy(values(), 0, acabamentos, 0, tamanho);
			
		}else {
			tamanho= 2;
			acabamentos= new TipoAcabamento[tamanho];
			System.arraycopy(values(), 3, acabamentos, 0, tamanho);	
		}
		
		return acabamentos;
	}
	
}
