package grafica.aplicacao;

import grafica.es.Entrada;
import grafica.modelo.Item;
import grafica.modelo.ItemPedido;
import grafica.modelo.Pedido;
import grafica.modelo.Servico;
import grafica.modelo.TipoServico;

public class Grafica {

	public static void main(String[] args) {
	
		Entrada.iniciar();

		Pedido pedido= realizarAtendimento();
		//gerarRecibo(pedido);

		Entrada.finalizar();
	}	

	private static Pedido realizarAtendimento() {

		boolean atendimentoConcluido= false;
		Pedido pedido= new Pedido();

		System.out.println("-------------------------------------------------");
		System.out.println("-------------------- GRÁFICA --------------------");
		System.out.println("-------------------------------------------------");

		while(!atendimentoConcluido) {
			prestarServico(pedido);	
			
			int escolha;
			System.out.println(".\n. Há outro o serviço a ser registrado? ");
			System.out.println( ".1. Sim .......... 2. Não");
			escolha= Entrada.lerInteiroTeclado(1, 2);

			if(escolha == 1)
				System.out.println(".");
			else
				atendimentoConcluido= true;
		}		

		System.out.println("-------------------------------------------------");
		System.out.println("------------- Atendimento concluído -------------");
		System.out.println(pedido);
		
		return pedido;
	}

	private static void prestarServico(Pedido pedido) {

		System.out.println("...................");
		for(TipoServico servico : TipoServico.values())
			System.out.println("." + (servico.ordinal()+1) + " " + servico.getServico());
		System.out.println("...................");

		int escolha;
		System.out.println(". Informe o serviço prestado: ");
		escolha= Entrada.lerInteiroTeclado(1, TipoServico.values().length)-1;

		Servico servico= TipoServico.getValue(escolha);
		Item item= servico.prestarServico();
		
		ItemPedido itemPedido= registrarQuantidadeItem(item);		
		pedido.insereItem(itemPedido);
	}

	private static ItemPedido registrarQuantidadeItem(Item item) {

		System.out.println(". Informe a quantidade: ");		
		int quantidade= Entrada.lerInteiroTeclado(1, 99999999);

		return new ItemPedido(item, quantidade);
	}
}