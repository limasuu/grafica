package grafica.aplicacao;

import java.util.InputMismatchException;
import java.util.Scanner;

import grafica.modelo.Copia;
import grafica.modelo.Encadernacao;
import grafica.modelo.Impressao;
import grafica.modelo.Item;
import grafica.modelo.ItemPedido;
import grafica.modelo.ModeloCopia;
import grafica.modelo.ModeloEncadernacao;
import grafica.modelo.ModeloImpressao;
import grafica.modelo.Pedido;
import grafica.modelo.TipoAcabamento;
import grafica.modelo.TipoCapa;
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

		ModeloCopia[][] modelo= new ModeloCopia[2][2];
		modelo[0][0]= ModeloCopia.CORA3;
		modelo[0][1]= ModeloCopia.PBA3;		
		modelo[1][0]= ModeloCopia.CORA4;
		modelo[1][1]= ModeloCopia.PBA4;		

		int formato= solicitarFormato();		
		int cor= solicitarCor();

		Copia copia= new Copia(modelo[formato][cor]);		
		return registrarQuantidadeItem(copia);	
	}

	private static ItemPedido prestarServicoImpressao() {

		ModeloImpressao[][] modelo= new ModeloImpressao[2][2];
		modelo[0][0]= ModeloImpressao.CORA3;
		modelo[0][1]= ModeloImpressao.PBA3;		
		modelo[1][0]= ModeloImpressao.CORA4;
		modelo[1][1]= ModeloImpressao.PBA4;		

		int formato= solicitarFormato();		
		int cor= solicitarCor();

		Impressao impressao= new Impressao(modelo[formato][cor]);		
		return registrarQuantidadeItem(impressao);	
	}

	private static ItemPedido prestarServicoEncadernacao() {

		ModeloEncadernacao[][] modelo= new ModeloEncadernacao[2][5];
		modelo[0][0]= ModeloEncadernacao.SIMPLESESPIRAL;
		modelo[0][1]= ModeloEncadernacao.SIMPLESGRAMPO;	
		modelo[0][2]= ModeloEncadernacao.SIMPLESCOLA;	
		modelo[1][3]= ModeloEncadernacao.DURACOSTURA;
		modelo[1][4]= ModeloEncadernacao.DURAWIREO;		

		int capa= solicitarCapa();		
		int acabamento= solicitarAcabamento(capa);

		Encadernacao encadernacao= new Encadernacao(modelo[capa][acabamento]);		
		return registrarQuantidadeItem(encadernacao);
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

	private static int solicitarFormato() {

		System.out.println("...................");
		for(TipoFormato formato : TipoFormato.values()) 
			System.out.println("." + (formato.ordinal()+1) + " " + formato.getFormato() + ".");
		System.out.println("...................");

		System.out.println(". Informe o formato: ");
		return lerInteiroTeclado(1, TipoFormato.values().length)-1;
	}

	private static int solicitarCor() {

		System.out.println("...................");
		for(TipoCor cor : TipoCor.values())
			System.out.println("." + (cor.ordinal()+1) + " " + cor.getCor() + ".");
		System.out.println("...................");

		System.out.println(". Informe a cor: ");
		return lerInteiroTeclado(1, TipoCor.values().length)-1;		 
	}

	private static int solicitarCapa() {

		System.out.println("...................");
		for(TipoCapa capa : TipoCapa.values()) 
			System.out.println("." + (capa.ordinal()+1) + " " + capa.getCapa() + ".");
		System.out.println("...................");

		System.out.println(". Informe a capa: ");
		return lerInteiroTeclado(1, TipoCapa.values().length)-1; 
	}

	private static int solicitarAcabamento(int capa) {
		
		TipoAcabamento[] acabamentos; 
		int min, max;
		
		if(capa == 0) {
			acabamentos= new TipoAcabamento[3];
			System.arraycopy(TipoAcabamento.values(), 0, acabamentos, 0, acabamentos.length);
						
			min= 1;
			max= 3;

		}else {
			acabamentos= new TipoAcabamento[2];
			System.arraycopy(TipoAcabamento.values(), 3, acabamentos, 0, acabamentos.length);			
			
			min= 4;
			max= 5;
		}

		System.out.println("...................");
		for(TipoAcabamento acabamento : acabamentos) 
			System.out.println("." + (acabamento.ordinal()+1) + " " + acabamento.getAcabamento() + ".");
		System.out.println("...................");

		System.out.println(". Informe o acabamento: ");		
		return lerInteiroTeclado(min, max)-1;  
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
