package grafica.modelo;

public class Impressao extends Item{

	public Impressao(ModeloImpressao modelo) {
		super("Impressão em papel sulfite, 75g", modelo.getModelo(), 50, modelo.getPreco());
	}

}
