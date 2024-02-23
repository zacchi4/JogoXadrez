package Principal;

import Xadrez.PartidaXadrez;

public class Principal {

	public static void main(String[] args) {
		
		PartidaXadrez partida = new PartidaXadrez();
		
		UI.imprimirTabuleiro(partida.getPecas());
		
	}

}
