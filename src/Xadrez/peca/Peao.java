
package Xadrez.peca;

import Tabuleiro.Posicao;
import Tabuleiro.Tabuleiro;
import Xadrez.Color;
import Xadrez.PartidaXadrez;
import Xadrez.PecaXadrez;

public class Peao extends PecaXadrez {
	
	private PartidaXadrez partidaX;

	public Peao(Tabuleiro tabuleiro, Color color, PartidaXadrez partida) {
		super(tabuleiro, color);
		partidaX = partida;
	}

	private boolean podeMoverDiagonal(Posicao pos) {

		PecaXadrez pec = (PecaXadrez) getTabuleiro().peca(pos);

		return pec != null && pec.getColor() != getColor();
	}

	private boolean podeMoverNormal(Posicao pos) {

		PecaXadrez pec = (PecaXadrez) getTabuleiro().peca(pos);

		return pec == null;
	}

	@Override
	public boolean[][] movimentosPossiveis() {

		boolean mat[][] = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];

		Posicao p = new Posicao(0, 0);

		if (((PecaXadrez) getTabuleiro().peca(posicao)).getColor() == Color.WHITE) {
			
			// ACIMA
			p.setValor(posicao.getLinha() - 1, posicao.getColuna());

			if (getTabuleiro().existePosicao(p) && podeMoverNormal(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			
			// DIAGONAL ACIMA ESQUERDA
			p.setValor(posicao.getLinha() - 1, posicao.getColuna() - 1);

			if (getTabuleiro().existePosicao(p) && podeMoverDiagonal(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}

			// DIAGONAL ACIMA DIREITA
			p.setValor(posicao.getLinha() - 1, posicao.getColuna() + 1);

			if (getTabuleiro().existePosicao(p) && podeMoverDiagonal(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			
			//ACIMA PRIMEIRA JOGADA
			if(posicao.getLinha() == 6) {
				p.setValor(posicao.getLinha() - 2, posicao.getColuna());

				if (getTabuleiro().existePosicao(p) && podeMoverNormal(p)) {
					mat[p.getLinha()][p.getColuna()] = true;
				}
			}
			
			//enPassant
			if((posicao.getLinha() == 3)){
				Posicao esquerda = new Posicao(posicao.getLinha(), posicao.getColuna() - 1);
				if((getTabuleiro().existePosicao(esquerda))&&(getTabuleiro().peca(esquerda) == partidaX.getEnPassantVulneravel())) {
					mat[esquerda.getLinha() - 1][esquerda.getColuna()]  =  true;
				}
				
				Posicao direita = new Posicao(posicao.getLinha(), posicao.getColuna() + 1);
				if((getTabuleiro().existePosicao(direita))&&(getTabuleiro().peca(direita) == partidaX.getEnPassantVulneravel())) {
					mat[direita.getLinha() - 1][direita.getColuna()]  =  true;
				}
			}
			
		} else {
			
			// ABAIXO
			p.setValor(posicao.getLinha() + 1, posicao.getColuna());

			if (getTabuleiro().existePosicao(p) && podeMoverNormal(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			
			// DIAGONA ABAIXO ESQUERDA
			p.setValor(posicao.getLinha() + 1, posicao.getColuna() - 1);
			
			if (getTabuleiro().existePosicao(p) && podeMoverDiagonal(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			
			// DIAGONAL ABAIXO DIREITA
			p.setValor(posicao.getLinha() + 1, posicao.getColuna() + 1);
			
			if (getTabuleiro().existePosicao(p) && podeMoverDiagonal(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			
			// ABAIXO PRIMEIRA JOGADA
			if(posicao.getLinha() == 1) {
				p.setValor(posicao.getLinha() + 2, posicao.getColuna());

				if (getTabuleiro().existePosicao(p) && podeMoverNormal(p)) {
					mat[p.getLinha()][p.getColuna()] = true;
				}
				
			}
			
			//enPassant
			if((posicao.getLinha() == 4)){
				Posicao esquerda = new Posicao(posicao.getLinha(), posicao.getColuna() - 1);
				if((getTabuleiro().existePosicao(esquerda))&&(getTabuleiro().peca(esquerda) == partidaX.getEnPassantVulneravel())) {
					mat[esquerda.getLinha() + 1][esquerda.getColuna()]  =  true;
				}
				
				Posicao direita = new Posicao(posicao.getLinha(), posicao.getColuna() + 1);
				if((getTabuleiro().existePosicao(direita))&&(getTabuleiro().peca(direita) == partidaX.getEnPassantVulneravel())) {
					mat[direita.getLinha() + 1][direita.getColuna()]  =  true;
				}
			}

		}

		return mat;
	}

	@Override
	public String toString() {
		return "P";
	}

}
