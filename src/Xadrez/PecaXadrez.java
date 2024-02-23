package xadrez;

import tabuleiro.Peca;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;

public abstract class PecaXadrez extends Peca{
	
	private Color color;

	public PecaXadrez(Tabuleiro tabuleiro, Color color) {
		super(tabuleiro);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	
	protected boolean pecaOponentePosicao(Posicao pos){
		
		PecaXadrez pec = (PecaXadrez) getTabuleiro().peca(pos);
		
		return pec != null && pec.getColor() != color;
	}

}
