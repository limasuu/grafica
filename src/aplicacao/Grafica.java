package aplicacao;

import grafica.modelo.CartaoVisita;
import grafica.modelo.Item;
import grafica.modelo.ItemPedido;
import grafica.modelo.ModeloCartaoVisita;
import grafica.modelo.Pedido;

public class Grafica {
	
	public static void main(String[] args) {
		
		Item item= new Item("Cópia em papel Sulfite 75g", "Cor A4", 50, 1.8);
		Item item2= new Item("Impressão em papel Sulfite 75g", "PB A4", 50, 0.5);
		CartaoVisita cartaoVisita= new CartaoVisita(ModeloCartaoVisita.FRENTE);
		
		ItemPedido itemPedido= new ItemPedido(item, 3);
		ItemPedido itemPedido2= new ItemPedido(item2, 2);
		ItemPedido itemPedido3= new ItemPedido(cartaoVisita, 2);
				
		Pedido pedido= new Pedido();
		pedido.insereItem(itemPedido);
		pedido.insereItem(itemPedido2);
		pedido.insereItem(itemPedido3);
		
		System.out.println(pedido);
	}

}
