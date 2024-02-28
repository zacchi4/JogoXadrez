package Xadrez.peca;

import Tabuleiro.Posicao;
import Tabuleiro.Tabuleiro;
import Xadrez.Color;
import Xadrez.PecaXadrez;

public class Rainha extends PecaXadrez {

	public Rainha(Tabuleiro tabuleiro, Color color) {
		super(tabuleiro, color);
	}

	private boolean podeMover(Posicao pos) {

		PecaXadrez pec = (PecaXadrez) getTabuleiro().peca(pos);

		return pec == null || pec.getColor() != getColor();
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		boolean mat[][] = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];

		Posicao p = new Posicao(0, 0);

		// ACIMA DIREITA

		p.setValor(posicao.getLinha() - 1, posicao.getColuna() - 1);

		while (getTabuleiro().existePosicao(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setValor(p.getLinha() - 1, p.getColuna() - 1);
		}

		// ACIMA ESQUERDA

		p.setValor(posicao.getLinha() + 1, posicao.getColuna() + 1);

		while (getTabuleiro().existePosicao(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setValor(p.getLinha() + 1, p.getColuna() + 1);
		}

		// ABAIXO DIREITA

		p.setValor(posicao.getLinha() + 1, posicao.getColuna() - 1);

		while (getTabuleiro().existePosicao(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setValor(p.getLinha() + 1, p.getColuna() - 1);
		}

		// ABAIXO ESQUERDA

		p.setValor(posicao.getLinha() - 1, posicao.getColuna() + 1);

		while (getTabuleiro().existePosicao(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setValor(p.getLinha() - 1, p.getColuna() + 1);
		}

		// ACIMA

		p.setValor(posicao.getLinha() - 1, posicao.getColuna());

		while (getTabuleiro().existePosicao(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() - 1);
		}

		if (getTabuleiro().existePosicao(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// ABAIXO

		p.setValor(posicao.getLinha() + 1, posicao.getColuna());

		while (getTabuleiro().existePosicao(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() + 1);
		}

		if (getTabuleiro().existePosicao(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// DIREITA

		p.setValor(posicao.getLinha(), posicao.getColuna() + 1);

		while (getTabuleiro().existePosicao(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setColuna(p.getColuna() + 1);
		}

		if (getTabuleiro().existePosicao(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// ESQUERDA

		p.setValor(posicao.getLinha(), posicao.getColuna() - 1);

		while (getTabuleiro().existePosicao(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setColuna(p.getColuna() - 1);
		}

		if (getTabuleiro().existePosicao(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		return mat;
	}
	
	@Override
	public String toString() {
		return "Q";
	}

}
