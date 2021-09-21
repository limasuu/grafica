package grafica.modelo;

import grafica.aplicacao.Grafica;

public enum TipoServico implements Servico{

	COPIA("Cópia"){

		@Override
		public Item prestarServico() {
			ModeloCopia[][] modelo= new ModeloCopia[2][2];
			modelo[0][0]= ModeloCopia.CORA3;
			modelo[0][1]= ModeloCopia.PBA3;		
			modelo[1][0]= ModeloCopia.CORA4;
			modelo[1][1]= ModeloCopia.PBA4;		

			int formato= Grafica.solicitarFormato();		
			int cor= Grafica.solicitarCor();

			return new Copia(modelo[formato][cor]);
		}


	},
	IMPRESSAO("Impressão"){

		@Override
		public Item prestarServico() {
			ModeloImpressao[][] modelo= new ModeloImpressao[2][2];
			modelo[0][0]= ModeloImpressao.CORA3;
			modelo[0][1]= ModeloImpressao.PBA3;		
			modelo[1][0]= ModeloImpressao.CORA4;
			modelo[1][1]= ModeloImpressao.PBA4;		

			int formato= Grafica.solicitarFormato();		
			int cor=  Grafica.solicitarCor();

			return new Impressao(modelo[formato][cor]);
		}

	},
	ENCADERNACAO("Encadernação"){

		@Override
		public Item prestarServico() {
			ModeloEncadernacao[][] modelo= new ModeloEncadernacao[2][5];
			modelo[0][0]= ModeloEncadernacao.SIMPLESESPIRAL;
			modelo[0][1]= ModeloEncadernacao.SIMPLESGRAMPO;	
			modelo[0][2]= ModeloEncadernacao.SIMPLESCOLA;	
			modelo[1][3]= ModeloEncadernacao.DURACOSTURA;
			modelo[1][4]= ModeloEncadernacao.DURAWIREO;		

			int capa= Grafica.solicitarCapa();		
			int acabamento=  Grafica.solicitarAcabamento(capa);

			return new Encadernacao(modelo[capa][acabamento]);	
		}


	},
	PLASTIFICACAO("Plastificação"){

		@Override
		public Item prestarServico() {
			ModeloPlastificacao[] modelos= new ModeloPlastificacao[4];
			modelos[0]= ModeloPlastificacao.CRACHA;
			modelos[1]= ModeloPlastificacao.A5;	
			modelos[2]= ModeloPlastificacao.A4;	
			modelos[3]= ModeloPlastificacao.A3;

			System.out.println("...................");
			for(ModeloPlastificacao modelo : ModeloPlastificacao.values()) 
				System.out.println("." + (modelo.ordinal()+1) + " " + modelo.getModelo() + ".");
			System.out.println("...................");

			System.out.println(". Informe o modelo: ");
			int escolha= Grafica.lerInteiroTeclado(1, ModeloPlastificacao.values().length)-1;		

			return new Plastificacao(modelos[escolha]);	
		}

	},
	CARTAOVISITA("Cartão de Visita"){

		@Override
		public Item prestarServico() {

			System.out.println("...................");
			for(ModeloCartaoVisita modelo : ModeloCartaoVisita.values()) 
				System.out.println("." + (modelo.ordinal()+1) + " " + modelo.getModelo() + ".");
			System.out.println("...................");

			System.out.println(". Informe o modelo: ");
			int escolha= Grafica.lerInteiroTeclado(1, ModeloCartaoVisita.values().length)-1;		
			ModeloCartaoVisita modelo= ModeloCartaoVisita.getValue(escolha);
			
			return new CartaoVisita(modelo);		
		}

	};

	private String servico;

	private TipoServico(String servico) {
		this.servico= servico;
	}

	public String getServico() {
		return servico;
	}

	public static TipoServico getValue(int tipo) {
		return values()[tipo];
	}
}
