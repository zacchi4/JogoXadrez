package Xadrez;

import Tabuleiro.Posicao;
import Tabuleiro.Tabuleiro;
import Xadrez.peca.King;
import Xadrez.peca.Torre;

public class PartidaXadrez {
	
	private Tabuleiro tabuleiro;
	
	public PartidaXadrez() {
		tabuleiro = new Tabuleiro(8, 8);
		iniciandoPartida();
	}
	
	public PecaXadrez[][] getPecas(){
		
		PecaXadrez[][] mat = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		
		for (int i = 0; i<tabuleiro.getLinhas();i++) {
			for (int j = 0; j<tabuleiro.getColunas();j++) {
				mat[i][j] = (PecaXadrez) tabuleiro.peca(i,j);
			}
		}
		
		return mat;
	}
	
	private void iniciandoPartida() {
		//BRANCO
		tabuleiro.colocarPeca(new Torre(tabuleiro, Color.WHITE), new Posicao(0, 0));
		tabuleiro.colocarPeca(new Torre(tabuleiro, Color.WHITE), new Posicao(0, 7));
		
		tabuleiro.colocarPeca(new King(tabuleiro, Color.WHITE), new Posicao(0, 4));
		
		//PRETO
		tabuleiro.colocarPeca(new Torre(tabuleiro, Color.BLACK), new Posicao(7, 0));
		tabuleiro.colocarPeca(new Torre(tabuleiro, Color.BLACK), new Posicao(7, 7));
		
		tabuleiro.colocarPeca(new King(tabuleiro, Color.BLACK), new Posicao(7, 4));
	}

}
