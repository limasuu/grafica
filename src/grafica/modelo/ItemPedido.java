package grafica.modelo;

public class ItemPedido {
	
	private Item item;
	private int quantidade;
			
	public ItemPedido(Item item, int quantidade) {
		this.item = item;
		this.quantidade = quantidade;
	}
	
	public Item getItem() {
		return item;
	}
	
	public void setItem(Item item) {
		this.item = item;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public double getValor() {
		
		double valor= item.getValor();
		
		if(quantidade >= item.getQuantidadeAtacado())
			valor= item.getValorAtacado();
				
		return valor * quantidade;
	}

	@Override
	public String toString() {
		return item + "\n" + quantidade + " unidade(s)" +
				" | Valor item= R$ " + String.format("%.2f", getValor()) +" <=";
	}
}
