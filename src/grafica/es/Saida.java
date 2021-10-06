package grafica.es;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import grafica.modelo.Pedido;

public class Saida {
	
	private static final String ERRO= "Este arquivo não pode ser utilizado.";
	private static final String ARQUIVO_CONTROLE= "./recibos/controle.txt";

	private static File file;
	private static FileWriter fileWriter;
	private static BufferedWriter bufferedWriter;

	public static void gerarRecibo(Pedido pedido) {

		iniciarEscritor("./recibos/" + pedido.getCodigoPedido() + ".txt");
		escrever(pedido.toString());
		fecharEscritor();
		
		iniciarEscritor(ARQUIVO_CONTROLE);
		escrever(Pedido.getControlePedidos() + "");
		fecharEscritor();
	}	

	private static void iniciarEscritor(String nomeArquivo) {

		file= new File(nomeArquivo);

		try {			
			if(!file.exists())
				file.createNewFile();

			fileWriter= new FileWriter(file);
			bufferedWriter= new BufferedWriter(fileWriter);

		} catch (IOException e) {			
			System.err.println(ERRO);
		}
	}

	private static void escrever(String texto) {

		try {
			bufferedWriter.write(texto);
		} catch (IOException e) {			
			System.err.println(ERRO);
		}
	}

	private static void fecharEscritor() {

		try {
			bufferedWriter.close();

		} catch (IOException e) {			
			System.err.println(ERRO);
		}
	}
}
