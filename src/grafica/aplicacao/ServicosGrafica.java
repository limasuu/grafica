package grafica.aplicacao;

public enum ServicosGrafica {
	
	COPIA(1, "Cópia"),
	IMPRESSAO(2, "Impressão"),
	ENCADERNACAO(3, "Encadernação"),
	PLASTIFICACAO(4, "Plastificação"),
	CARTAOVISITA(5, "Cartão de Visita");
	
	private int id;
	private String servico;
	
	private ServicosGrafica(int id, String servico) {
		this.id = id;
		this.servico = servico;
	}
	
	public int getId() {
		return id;
	}

	public String getServico() {
		return servico;
	}
}
