package xadrez;

import tabuleiro.Peca;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;

public abstract class PecaXadrez extends Peca{
	
	private Color color;
	private int contadorMovimento;

	public PecaXadrez(Tabuleiro tabuleiro, Color color) {
		super(tabuleiro);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	
	public void aumentandoMov() {
		contadorMovimento++;
	}
	
	public void dmininuindoMov() {
		contadorMovimento--;
	}
	
	public int getContadorMovimento() {
		return contadorMovimento;
	}

	protected boolean pecaOponentePosicao(Posicao pos){
		PecaXadrez pec = (PecaXadrez) getTabuleiro().peca(pos);	
		return pec != null && pec.getColor() != color;
	}
	
	public XadrezPosicao getXadrezPosicao() {
		return XadrezPosicao.paraPosicao(posicao);
	}

}
