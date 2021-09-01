package grafica.modelo;

public class Plastificacao extends Item{	

	public Plastificacao(ModeloPlastificacao modelo) {
		super("Plastificação", modelo.getModelo(), 50, modelo.getPreco());
	}
}
