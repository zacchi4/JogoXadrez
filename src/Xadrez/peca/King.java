package xadrez.peca;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.Color;
import xadrez.PecaXadrez;

public class King extends PecaXadrez {

	public King(Tabuleiro tabuleiro, Color color) {
		super(tabuleiro, color);
	}

	@Override
	public String toString() {
		return "K";
	}

	private boolean podeMover(Posicao pos) {

		PecaXadrez pec = (PecaXadrez) getTabuleiro().peca(pos);

		return pec != null && pec.getColor() != getColor();
	}

	@Override
	public boolean[][] movimentosPossiveis() {

		boolean mat[][] = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		
		Posicao p = new Posicao(0, 0);

		// ACIMA
		p.setValor(posicao.getLinha() - 1, posicao.getColuna());
		
		if (getTabuleiro().existePosicao(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		// ABAIXO
		p.setValor(posicao.getLinha() + 1, posicao.getColuna());
		
		if (getTabuleiro().existePosicao(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// DIREITA
		p.setValor(posicao.getLinha(), posicao.getColuna() + 1);
		
		if (getTabuleiro().existePosicao(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// ESQUERDA
		p.setValor(posicao.getLinha(), posicao.getColuna() - 1);
		
		if (getTabuleiro().existePosicao(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// DIAGONAL ACIMA ESQUERDA
		p.setValor(posicao.getLinha() - 1, posicao.getColuna() - 1);
		
		if (getTabuleiro().existePosicao(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		// DIAGONAL ACIMA DIREITA
		p.setValor(posicao.getLinha() - 1, posicao.getColuna() + 1);
		
		if (getTabuleiro().existePosicao(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// DIAGONA ABAIXO ESQUERDA
		p.setValor(posicao.getLinha() + 1, posicao.getColuna() - 1);
		
		if (getTabuleiro().existePosicao(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		// DIAGONAL ABAIXO DIREITA
		p.setValor(posicao.getLinha() + 1, posicao.getColuna() + 1);
		
		if (getTabuleiro().existePosicao(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		return mat;
	}

}
