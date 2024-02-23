package Xadrez.peca;

import Tabuleiro.Tabuleiro;
import Xadrez.Color;
import Xadrez.PecaXadrez;

public class King extends PecaXadrez{

	public King(Tabuleiro tabuleiro, Color color) {
		super(tabuleiro, color);
	}

	@Override
	public String toString() {
		return "K";
	}

}
