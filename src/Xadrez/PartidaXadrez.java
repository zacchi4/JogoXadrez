package Xadrez;

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
	
	private void colocandoNovaPeca(char col, int lin, PecaXadrez peca) {
		tabuleiro.colocarPeca(peca, new XadresPosicao(col, lin).qualPosicao());
	}
	
	private void iniciandoPartida() {
		//BRANCO		
		colocandoNovaPeca('a', 8, new Torre(tabuleiro, Color.WHITE));
		colocandoNovaPeca('h', 8, new Torre(tabuleiro, Color.WHITE));
		
		colocandoNovaPeca('e', 8, new King(tabuleiro, Color.WHITE));
		
		//PRETO
		colocandoNovaPeca('a', 1, new Torre(tabuleiro, Color.BLACK));
		colocandoNovaPeca('h', 1, new Torre(tabuleiro, Color.BLACK));
		
		colocandoNovaPeca('e', 1, new King(tabuleiro, Color.BLACK));

	}

}
