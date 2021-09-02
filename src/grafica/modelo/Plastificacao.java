package grafica.modelo;

public class Plastificacao extends Item{	

	public Plastificacao(ModeloPlastificacao modelo) {
		super("Plastificação", modelo.getModelo(), 20, modelo.getPreco());
	}
}
