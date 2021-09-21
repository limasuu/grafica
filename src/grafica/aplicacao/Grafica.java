package grafica.aplicacao;

import java.util.InputMismatchException;
import java.util.Scanner;

import grafica.modelo.Item;
import grafica.modelo.ItemPedido;
import grafica.modelo.Pedido;
import grafica.modelo.Servico;
import grafica.modelo.TipoAcabamento;
import grafica.modelo.TipoCapa;
import grafica.modelo.TipoCor;
import grafica.modelo.TipoFormato;
import grafica.modelo.TipoServico;

public class Grafica {

	private static Scanner entrada;

	public static void main(String[] args) {
	
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
		escolha= lerInteiroTeclado(1, TipoServico.values().length)-1;

		Servico servico= TipoServico.getValue(escolha);
		Item item= servico.prestarServico();
		
		ItemPedido itemPedido= registrarQuantidadeItem(item);		
		pedido.insereItem(itemPedido);
	}

	private static ItemPedido registrarQuantidadeItem(Item item) {

		System.out.println(". Informe a quantidade: ");		
		int quantidade= lerInteiroTeclado(1, 99999999);

		return new ItemPedido(item, quantidade);
	}

	public static int solicitarFormato() {

		System.out.println("...................");
		for(TipoFormato formato : TipoFormato.values()) 
			System.out.println("." + (formato.ordinal()+1) + " " + formato.getFormato() + ".");
		System.out.println("...................");

		System.out.println(". Informe o formato: ");
		return lerInteiroTeclado(1, TipoFormato.values().length)-1;
	}

	public static int solicitarCor() {

		System.out.println("...................");
		for(TipoCor cor : TipoCor.values())
			System.out.println("." + (cor.ordinal()+1) + " " + cor.getCor() + ".");
		System.out.println("...................");

		System.out.println(". Informe a cor: ");
		return lerInteiroTeclado(1, TipoCor.values().length)-1;		 
	}

	public static int solicitarCapa() {

		System.out.println("...................");
		for(TipoCapa capa : TipoCapa.values()) 
			System.out.println("." + (capa.ordinal()+1) + " " + capa.getCapa() + ".");
		System.out.println("...................");

		System.out.println(". Informe a capa: ");
		return lerInteiroTeclado(1, TipoCapa.values().length)-1; 
	}

	public static int solicitarAcabamento(int capa) {

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

	public static int lerInteiroTeclado(int opcaoInicial, int opcaoFinal) {

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
