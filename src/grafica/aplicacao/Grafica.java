package grafica.aplicacao;

import java.util.InputMismatchException;
import java.util.Scanner;

import grafica.modelo.Copia;
import grafica.modelo.Item;
import grafica.modelo.ItemPedido;
import grafica.modelo.ModeloCopia;
import grafica.modelo.Pedido;
import grafica.modelo.TipoCor;
import grafica.modelo.TipoFormato;

public class Grafica {

	private static Scanner entrada;

	public static void main(String[] args) {
		/*	
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

		System.out.println(pedido);*/

		entrada= new Scanner(System.in);

		Pedido pedido= realizarAtendimento();
		//gerarRecibo(pedido);

		entrada.close();
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
			escolha= lerInteiroTeclado(1, 2);

			if(escolha == 1)
				System.out.println(".");
			else
				atendimentoConcluido= true;
		}		

		System.out.println("-------------------------------------------------");
		System.out.println("------------- Atendimento concluído -------------");

		return pedido;
	}

	private static void prestarServico(Pedido pedido) {

		ItemPedido itemPedido= null;

		System.out.println("...................");
		for(ServicosGrafica servico : ServicosGrafica.values())
			System.out.println("." + (servico.ordinal()+1) + " " + servico.getServico());
		System.out.println("...................");

		int escolha;
		System.out.println(". Informe o serviço prestado: ");
		escolha= lerInteiroTeclado(1, ServicosGrafica.values().length);

		switch(escolha) {

		case 1:			
			itemPedido= prestarServicoCopia();
			break;

		case 2:			
			itemPedido= prestarServicoImpressao();
			break;

		case 3:			
			itemPedido= prestarServicoEncadernacao();
			break;

		case 4:			
			itemPedido= prestarServicoPlastificacao();
			break;

		case 5:			
			itemPedido= prestarServicoCartaoVisita();
			break;
		}		

		pedido.insereItem(itemPedido);
	}

	private static ItemPedido prestarServicoCopia() {

		ModeloCopia[][] modelo= new ModeloCopia[4][2];
		modelo[0][0]= ModeloCopia.CORA3;
		modelo[0][1]= ModeloCopia.PBA3;		
		modelo[1][0]= ModeloCopia.CORA4;
		modelo[1][1]= ModeloCopia.PBA4;		

		Copia copia= null;


		System.out.println("...................");
		for(TipoFormato tipoFormato : TipoFormato.values()) 
			System.out.println("." + (tipoFormato.ordinal()+1) + " " + tipoFormato.getFormato() + ".");
		System.out.println("...................");

		int formato;
		System.out.println(". Informe o formato: ");
		formato= lerInteiroTeclado(1, TipoFormato.values().length)-1;


		System.out.println("...................");
		for(TipoCor tipoCor : TipoCor.values())
			System.out.println("." + (tipoCor.ordinal()+1) + " " + tipoCor.getCor());
		System.out.println("...................");

		int cor;
		System.out.println(". Informe a cor: ");
		cor= lerInteiroTeclado(1, TipoCor.values().length)-1;

		copia= new Copia(modelo[formato][cor]);		
		return registrarQuantidadeItem(copia);	
	}


	private static ItemPedido prestarServicoImpressao() {
		// TODO Auto-generated method stub
		return null;
	}

	private static ItemPedido prestarServicoEncadernacao() {
		// TODO Auto-generated method stub
		return null;
	}

	private static ItemPedido prestarServicoPlastificacao() {
		// TODO Auto-generated method stub
		return null;
	}

	private static ItemPedido prestarServicoCartaoVisita() {
		// TODO Auto-generated method stub
		return null;
	}

	private static ItemPedido registrarQuantidadeItem(Item item) {

		System.out.println(". Informe a quantidade: ");		
		int quantidade= lerInteiroTeclado(1, 99999999);

		return new ItemPedido(item, quantidade);
	}

	private static int lerInteiroTeclado(int opcaoInicial, int opcaoFinal) {

		int numero= 0;
		boolean leitura= true;

		while(leitura) {
			try {
				System.out.print(".> ");
				numero= entrada.nextInt(); 

				if(numero >= opcaoInicial && numero <= opcaoFinal)
					leitura= false;
				else
					System.err.print(".Informe um valor válido!\n");

			}catch (InputMismatchException e) {
				System.err.print(".Informe um valor válido!\n");

			}finally {
				if(entrada.hasNextLine())
					entrada.nextLine();	
			}
		}

		return numero;
	}
}
