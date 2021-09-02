package grafica.aplicacao;

import grafica.modelo.CartaoVisita;
import grafica.modelo.Copia;
import grafica.modelo.Encadernacao;
import grafica.modelo.Impressao;
import grafica.modelo.ItemPedido;
import grafica.modelo.ModeloCartaoVisita;
import grafica.modelo.ModeloCopia;
import grafica.modelo.ModeloEncadernacao;
import grafica.modelo.ModeloImpressao;
import grafica.modelo.ModeloPlastificacao;
import grafica.modelo.Pedido;
import grafica.modelo.Plastificacao;

public class Grafica {
	
	public static void main(String[] args) {
		
		Copia copia= new Copia(ModeloCopia.CORA4);
		Impressao impressao= new Impressao(ModeloImpressao.PBA3);
		CartaoVisita cartaoVisita= new CartaoVisita(ModeloCartaoVisita.FRENTE);
		Plastificacao plastificacao= new Plastificacao(ModeloPlastificacao.A4);
		Encadernacao encadernacao= new Encadernacao(ModeloEncadernacao.DURACOSTURA);
		
		ItemPedido itemPedido= new ItemPedido(copia, 3);
		ItemPedido itemPedido2= new ItemPedido(impressao, 2);
		ItemPedido itemPedido3= new ItemPedido(cartaoVisita, 2);
		ItemPedido itemPedido4= new ItemPedido(plastificacao, 1);
		ItemPedido itemPedido5= new ItemPedido(encadernacao, 1);
		
		Pedido pedido= new Pedido();
		pedido.insereItem(itemPedido);
		pedido.insereItem(itemPedido2);
		pedido.insereItem(itemPedido3);
		pedido.insereItem(itemPedido4);
		pedido.insereItem(itemPedido5);
		
		System.out.println(pedido);
	}

}
