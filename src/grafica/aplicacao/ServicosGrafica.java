package grafica.aplicacao;

public enum ServicosGrafica {
	
	COPIA("Cópia"),
	IMPRESSAO("Impressão"),
	ENCADERNACAO("Encadernação"),
	PLASTIFICACAO("Plastificação"),
	CARTAOVISITA("Cartão de Visita");

	private String servico;
	
	private ServicosGrafica(String servico) {
		this.servico = servico;
	}

	public String getServico() {
		return servico;
	}
}
