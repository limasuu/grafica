package grafica.aplicacao;

import grafica.es.Entrada;
import grafica.es.Saida;
import grafica.modelo.Item;
import grafica.modelo.ItemPedido;
import grafica.modelo.Pedido;
import grafica.modelo.Servico;
import grafica.modelo.TipoServico;

public class Grafica {

	public static void main(String[] args) {
	
		Entrada.iniciar();

		Pedido pedido= realizarAtendimento();
		Saida.gerarRecibo(pedido);

		Entrada.finalizar();
	}	

	private static Pedido realizarAtendimento() {

		boolean atendimentoConcluido= false;
		Pedido pedido= new Pedido();
		int escolha= 1;

		System.out.println("-------------------------------------------------");
		System.out.println("-------------------- GRÁFICA --------------------");
		System.out.println("-------------------------------------------------");

		while(!atendimentoConcluido) {

			System.out.println(".");
			switch(escolha) {
			
			case 1:				
				prestarServico(pedido);	
				apresentarOpcoesAtendimento();
				escolha= Entrada.lerInteiroTeclado(1, 3);
				break;
			
			case 2:
				removerServico(pedido);
				apresentarOpcoesAtendimento();
				escolha= Entrada.lerInteiroTeclado(1, 3);
				break;
				
			default:
				atendimentoConcluido= true;
			}
		}		

		System.out.println("-------------------------------------------------");
		System.out.println("------------- Atendimento concluído -------------");
		System.out.println(pedido);
		
		return pedido;
	}

	private static void removerServico(Pedido pedido) {
		
		System.out.println(pedido);
		
		int item;
		System.out.println(". Informe o serviço a ser removido: ");
		item= Entrada.lerInteiroTeclado(1, pedido.getItens().size()) -1;
		
		pedido.retiraItem(item);
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

	private static void apresentarOpcoesAtendimento() {
		
		System.out.println(".\n.1. Registrar outro serviço");
		System.out.println(".2. Remover um serviço");
		System.out.println(".3. Encerrar atendimento");
	}
}