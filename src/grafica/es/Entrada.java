package grafica.es;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import grafica.modelo.Pedido;
import grafica.modelo.TipoAcabamento;
import grafica.modelo.TipoCapa;
import grafica.modelo.TipoCor;
import grafica.modelo.TipoFormato;

public class Entrada {

	private static final String PASTA_RECIBOS= "recibos";
	private static final String ARQUIVO_CONTROLE= "./" + PASTA_RECIBOS + "/controle.txt";

	private static File pasta= new File(PASTA_RECIBOS);
	private static File file= new File(ARQUIVO_CONTROLE);	
	private static FileReader fileReader;
	private static BufferedReader bufferedReader;

	private static Scanner entrada;	

	public static void iniciar() {

		entrada= new Scanner(System.in);

		if(!pasta.exists()) 
			pasta.mkdirs();

		if(file.exists()) {
			try {
				fileReader= new FileReader(file);
				bufferedReader= new BufferedReader(fileReader);

				int controlePedidos= Integer.parseInt(bufferedReader.readLine());	
				Pedido.setControlePedidos(controlePedidos);

			} catch (FileNotFoundException e) {			
				System.err.println("Arquivo não encontrado.");
			} catch (NumberFormatException e) {
				System.err.println("Não há um valor numérico armazenado no arquivo.");
			} catch (IOException e) {
				System.err.println("Este arquivo não existe ou não pode ser utilizado.");
			}

			try {
				bufferedReader.close();
			} catch (IOException e) {
				System.err.println("Este arquivo não existe ou não pode ser utilizado.");
			}
		}
	}

	public static void finalizar() {

		entrada.close();
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

	public static int solicitarFormato() {

		System.out.println("...................");
		for(TipoFormato formato : TipoFormato.values()) 
			System.out.println("." + (formato.ordinal()+1) + " " + formato.getFormato() + ".");
		System.out.println("...................");

		System.out.println(". Informe o formato: ");
		return Entrada.lerInteiroTeclado(1, TipoFormato.values().length)-1;
	}

	public static int solicitarCor() {

		System.out.println("...................");
		for(TipoCor cor : TipoCor.values())
			System.out.println("." + (cor.ordinal()+1) + " " + cor.getCor() + ".");
		System.out.println("...................");

		System.out.println(". Informe a cor: ");
		return Entrada.lerInteiroTeclado(1, TipoCor.values().length)-1;		 
	}

	public static int solicitarCapa() {

		System.out.println("...................");
		for(TipoCapa capa : TipoCapa.values()) 
			System.out.println("." + (capa.ordinal()+1) + " " + capa.getCapa() + ".");
		System.out.println("...................");

		System.out.println(". Informe a capa: ");
		return Entrada.lerInteiroTeclado(1, TipoCapa.values().length)-1; 
	}

	public static int solicitarAcabamento(TipoCapa capa) {

		int min= TipoAcabamento.values(capa)[0].ordinal() + 1;
		int max= min-1 + TipoAcabamento.values(capa).length;

		System.out.println("...................");
		for(TipoAcabamento acabamento : TipoAcabamento.values(capa)) 
			System.out.println("." + (acabamento.ordinal()+1) + " " + acabamento.getAcabamento() + ".");
		System.out.println("...................");

		System.out.println(". Informe o acabamento: ");		
		return Entrada.lerInteiroTeclado(min, max)-1;  
	}	
}
