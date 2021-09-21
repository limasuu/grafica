package grafica.modelo;

import grafica.aplicacao.Grafica;

public enum TipoServico implements Servico{

	COPIA("Cópia"){

		@Override
		public Item prestarServico() {
			
			int escolha= Grafica.solicitarFormato();	
			TipoFormato formato= TipoFormato.getValue(escolha);					
			
			escolha= Grafica.solicitarCor();
			TipoCor cor= TipoCor.getValue(escolha);	
			
			ModeloCopia modelo= ModeloCopia.getValue(formato, cor);

			return new Copia(modelo);
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
			
			System.out.println("...................");
			for(ModeloPlastificacao modelo : ModeloPlastificacao.values()) 
				System.out.println("." + (modelo.ordinal()+1) + " " + modelo.getModelo() + ".");
			System.out.println("...................");

			System.out.println(". Informe o modelo: ");
			int escolha= Grafica.lerInteiroTeclado(1, ModeloPlastificacao.values().length)-1;		
			ModeloPlastificacao modelo= ModeloPlastificacao.getValue(escolha);

			return new Plastificacao(modelo);	
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
