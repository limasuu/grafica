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

		System.out.println("-------------------------------------------------");
		System.out.println("-------------------- GRÁFICA --------------------");		

		Entrada.iniciar();

		boolean novosAtendimentos= true;
		while(novosAtendimentos) {

			Pedido pedido= realizarAtendimento();
			if(pedido != null && pedido.getItens().size() != 0)
				Saida.gerarRecibo(pedido);

			System.out.println("\n\n\n\n");
			System.out.println(".Realizar novo atendimento?");
			System.out.println(".1. Sim");
			System.out.println(".2. Não");

			int escolha= Entrada.lerInteiroTeclado(1, 2);			
			if(escolha == 2)
				novosAtendimentos= false;
		}

		Entrada.finalizar();
	}	

	private static Pedido realizarAtendimento() {

		boolean atendimentoConcluido= false;
		Pedido pedido= new Pedido();	
		int escolha;

		System.out.println("-------------------------------------------------");

		while(!atendimentoConcluido) {

			System.out.println(".");

			if(pedido.getItens().size() != 0) {
				apresentarOpcoesAtendimento();
				escolha= Entrada.lerInteiroTeclado(1, 4);	
				
			}else {
				apresentarOpcoesAtendimentoVazio();
				escolha= Entrada.lerInteiroTeclado(1, 2);	
			}

			switch(escolha) {

			case 1:		
				atendimentoConcluido= true;
				pedido= null;				
				Pedido.setControlePedidos(Pedido.getControlePedidos()-1);
				break;

			case 2:
				prestarServico(pedido);									
				break;
			
			case 3:
				removerServico(pedido);	
				break;

			default:
				atendimentoConcluido= true;
			}
		}		

		System.out.println("-------------------------------------------------");
		System.out.println("------------- Atendimento concluído -------------");

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

		System.out.println(".\n.1. Cancelar pedido");
		System.out.println(".2. Registrar um serviço");
		System.out.println(".3. Remover um serviço");
		System.out.println(".4. Encerrar pedido");		
	}
	
	private static void apresentarOpcoesAtendimentoVazio() {

		System.out.println(".\n.1. Cancelar pedido");
		System.out.println(".2. Registrar um serviço");
	}
}