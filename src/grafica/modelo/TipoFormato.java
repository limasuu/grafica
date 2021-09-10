package grafica.modelo;

public enum TipoFormato {
	
	A3("A3"),
	A4("A4");
	
	private String formato;

	private TipoFormato(String formato) {
		this.formato = formato;
	}

	public String getFormato() {
		return formato;
	} 
}
