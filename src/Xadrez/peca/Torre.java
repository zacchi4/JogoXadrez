package Xadrez.peca;

import Tabuleiro.Tabuleiro;
import Xadrez.Color;
import Xadrez.PecaXadrez;

public class Torre extends  PecaXadrez{

	public Torre(Tabuleiro tabuleiro, Color color) {
		super(tabuleiro, color);
	}

	@Override
	public String toString() {
		return "T";
	}

}
