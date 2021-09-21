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

			int escolha= Grafica.solicitarFormato();	
			TipoFormato formato= TipoFormato.getValue(escolha);	
			
			escolha=  Grafica.solicitarCor();
			TipoCor cor= TipoCor.getValue(escolha);	
			
			ModeloImpressao modelo= ModeloImpressao.getValue(formato, cor);

			return new Impressao(modelo);
		}

	},
	ENCADERNACAO("Encadernação"){

		@Override
		public Item prestarServico() {

			int escolha= Grafica.solicitarCapa();	
			TipoCapa capa= TipoCapa.getValue(escolha);
			
			escolha= Grafica.solicitarAcabamento(capa);
			TipoAcabamento acabamento= TipoAcabamento.getValue(escolha);
			
			ModeloEncadernacao modelo= ModeloEncadernacao.getValue(capa, acabamento);

			return new Encadernacao(modelo);	
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
