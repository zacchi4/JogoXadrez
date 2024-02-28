package Tabuleiro;

public class Tabuleiro {

	private int linhas;
	private int colunas;
	
	private Peca[][] pecas;

	public Tabuleiro(int linhas, int colunas) {
		
		if(linhas < 1 || colunas < 1) {
			throw new TabuleiroException ("Atenção quantidade de linhas e colunas devem obrigatoriamente ser maior que zero !");
		}
		
		this.linhas = linhas;
		this.colunas = colunas;
		
		pecas = new Peca[linhas][colunas];
	}

	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}
	
	public Peca peca(int linha, int coluna) {
		
		if(!existePosicao(linha, coluna)) {
			throw new TabuleiroException ("Posição não existe no tabuleiro!");
		}
		
		return pecas[linha][coluna];		
	}
	
	public Peca peca(Posicao posicao) {
		
		if(!existePosicao(posicao)) {
			throw new TabuleiroException ("Posição não existe no tabuleiro!");
		}
		
		return pecas[posicao.getLinha()][posicao.getColuna()];
	}
	
	public void colocarPeca(Peca peca, Posicao posicao) {
		
		if(temUmaPeca(posicao)) {
			throw new TabuleiroException ("Já existe uma peça na posição: "+posicao);
		}
		
		pecas[posicao.getLinha()][posicao.getColuna()] = peca;
		peca.posicao = posicao;
	}
	
	private boolean existePosicao(int lin, int col) {		
		return lin >= 0 && lin < linhas && col >= 0 && col < colunas;
	}
	
	public boolean existePosicao(Posicao pos) {
		return existePosicao(pos.getLinha(), pos.getColuna());
	}
	
	public boolean temUmaPeca(Posicao pos) {
		
		if(!existePosicao(pos)) {
			throw new TabuleiroException ("Posição não existe no tabuleiro!");
		}
		
		return peca(pos) != null ; 
	}
	
	public Peca removePeca(Posicao pos) {
		if(!existePosicao(pos)) {
			throw new TabuleiroException ("Posição não existe no tabuleiro!");
		}
		
		if(peca(pos) == null) {
			return null;
		}
		
		Peca aux = peca(pos);
		aux.posicao = null;
		pecas[pos.getLinha()][pos.getColuna()] = null;
		
		return aux;
	}
}
