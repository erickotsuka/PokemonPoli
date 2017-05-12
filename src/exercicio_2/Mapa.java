package exercicio_2;

public class Mapa {
	private static final int LINHAS = 4;
	private static final int COLUNAS = 4;
	private char mapa[][];
	private int linha_atual;
	private int coluna_atual;
	public Mapa() {
		mapa = new char[LINHAS][COLUNAS];
		mapa[0][0] = 'C';
		mapa[0][1] = 'C';
		mapa[0][2] = 'G';
		mapa[0][3] = 'G';
		mapa[1][0] = 'C';
		mapa[1][1] = 'C';
		mapa[1][2] = 'G';
		mapa[1][3] = 'G';
		mapa[2][0] = 'G';
		mapa[2][1] = 'G';
		mapa[2][2] = 'C';
		mapa[2][3] = 'C';
		mapa[3][0] = 'G';
		mapa[3][1] = 'G';
		mapa[3][2] = 'C';
		mapa[3][3] = 'C';
		linha_atual = 0;
		coluna_atual = 0;
	}
	public void para_cima() {
		if (linha_atual == 0)
			return;
		linha_atual--;
	}
	public void para_baixo() {
		if (linha_atual == LINHAS - 1)
			return;
		linha_atual++;
	}
	public void para_direita() {
		if (coluna_atual == COLUNAS - 1)
			return;
		coluna_atual++;
	}
	public void para_esquerda() {
		if (coluna_atual == 0)
			return;
		coluna_atual--;
	}
	public int getLinha() {
		return linha_atual;
	}
	public int getColuna() {
		return coluna_atual;
	}
	public char getSuperficie() {
		return mapa[linha_atual][coluna_atual];
	}
}
