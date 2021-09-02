package grafica.modelo;

public class Encadernacao extends Item{

	public Encadernacao(ModeloEncadernacao modelo) {
		super("Encadernação em formato A4", modelo.getModelo(), 3, modelo.getPreco());
	}
}
