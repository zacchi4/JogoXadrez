package xadrez.peca;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.Color;
import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;

public class King extends PecaXadrez {

	private PartidaXadrez partida;

	public King(Tabuleiro tabuleiro, Color color, PartidaXadrez par) {
		super(tabuleiro, color);
		this.partida = par;
	}

	@Override
	public String toString() {
		return "K";
	}

	private boolean podeMover(Posicao pos) {

		PecaXadrez pec = (PecaXadrez) getTabuleiro().peca(pos);

		return pec == null || pec.getColor() != getColor();
	}

	private boolean testeTorreRoque(Posicao pos) {
		PecaXadrez peca = (PecaXadrez) getTabuleiro().peca(pos);
		return peca != null && peca instanceof Torre && peca.getColor() == getColor()
				&& peca.getContadorMovimento() == 0;
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

		// MOVIMENTO ROQUE
		if (getContadorMovimento() == 0 && !partida.isCheck()) {
			// Roque pequeno
			Posicao posT1 = new Posicao(posicao.getLinha(), posicao.getColuna() + 3);

			if (testeTorreRoque(posT1)) {
				Posicao posP1 = new Posicao(posicao.getLinha(), posicao.getColuna() + 1);
				Posicao posP2 = new Posicao(posicao.getLinha(), posicao.getColuna() + 2);

				if (getTabuleiro().peca(posP1) == null && getTabuleiro().peca(posP2) == null) {
					mat[posicao.getLinha()][posicao.getColuna() + 2] = true;
				}
			}

			// Roque grande
			Posicao posT2 = new Posicao(posicao.getLinha(), posicao.getColuna() - 4);

			if (testeTorreRoque(posT2)) {
				Posicao posP1 = new Posicao(posicao.getLinha(), posicao.getColuna() - 1);
				Posicao posP2 = new Posicao(posicao.getLinha(), posicao.getColuna() - 2);
				Posicao posP3 = new Posicao(posicao.getLinha(), posicao.getColuna() - 3);

				if (getTabuleiro().peca(posP1) == null && getTabuleiro().peca(posP2) == null
						&& getTabuleiro().peca(posP3) == null) {
					mat[posicao.getLinha()][posicao.getColuna() - 2] = true;
				}

			}
		}

		return mat;
	}

}
