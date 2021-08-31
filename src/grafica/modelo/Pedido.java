package grafica.modelo;

import java.util.ArrayList;

public class Pedido {

	private static int controlePedidos= 0;

	private ArrayList<ItemPedido> itens;
	private String codigoPedido;

	public Pedido() {

		this.itens= new ArrayList<ItemPedido>();
		controlePedidos++;
		this.codigoPedido= "P"  + String.valueOf(controlePedidos);		
	}

	public static int getControlePedidos() {
		return controlePedidos;
	}

	public static void setControlePedidos(int controlePedidos) {
		Pedido.controlePedidos = controlePedidos;
	}

	public ArrayList<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(ArrayList<ItemPedido> itens) {
		this.itens = itens;
	}

	public int insereItem(ItemPedido itemPedido) {

		itens.add(itemPedido);

		return itens.size()-1;
	}

	public void retiraItem(int itemPedido) {

		itens.remove(itemPedido);
	}

	public String getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido(String codigoPedido) {
		this.codigoPedido = codigoPedido;
	}
	
	public double getTotal() {
		
		double total= 0.0;
		
		for(ItemPedido ip : itens)
			total= total + ip.getItem().getValor() * ip.getQuantidade();
		
		return total;
	}

	@Override
	public String toString() {

		String retorno= "---------------------------------------------------------\n" +
				"Pedido " + codigoPedido +				
				"\n---------------------------------------------------------\n";


		for(ItemPedido ip : itens)
			retorno= retorno + ip + "\n\n";

		retorno= retorno + "---------------------------------------------------------\n" +
					"Total= R$ " +  String.format("%.2f", getTotal()) + 
					"\n---------------------------------------------------------";

		return retorno;
	}
}
