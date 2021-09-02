package grafica.modelo;

public class CartaoVisita extends Item{

	public CartaoVisita(ModeloCartaoVisita modelo) {
		
		super("Cartão de Visita - Lote com 10\n" +
				"Em papel Couché c/ brilho, 300 g", 
				modelo.getModelo(), 10, modelo.getPreco());		
	}
}
