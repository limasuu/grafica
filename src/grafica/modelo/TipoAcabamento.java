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
}
