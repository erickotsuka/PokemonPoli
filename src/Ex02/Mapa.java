package Ex02;

import java.util.Random;

public class Mapa {
	private static final int LINHAS = 4;
	private static final int COLUNAS = 4;
	private char mapa[][];
	private int linha_atual;
	private int coluna_atual;
	public Mapa() {
		mapa = new char[LINHAS][COLUNAS]; //C significa que eh chao, G significa que eh grama e T significa que eh treinador adversario
		mapa[0][0] = 'C';
		mapa[0][1] = 'C';
		mapa[0][2] = 'T'; //treinador
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
		if (linha_atual == 0) {
			atual();
			return;
		}
		linha_atual--;
		atual();
	}
	public void para_baixo() {
		if (linha_atual == LINHAS - 1) {
			atual();
			return;
		}
		linha_atual++;
		atual();
	}
	public void para_direita() {
		if (coluna_atual == COLUNAS - 1){
			atual();
			return;
		}
		coluna_atual++;
		atual();
	}
	public void para_esquerda() {
		if (coluna_atual == 0) {
			atual();
			return;
		}
		coluna_atual--;
		atual();
	}
	public int getLinha() {
		return linha_atual;
	}
	public int getColuna() {
		return coluna_atual;
	}
	public void atual() {
		System.out.println ("Posicao atual do jogador:\n");
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				char c = ' ';
				if (mapa[i][j] == 'C') c = ' ';
				if (mapa[i][j] == 'T') c = 'R';
				if (mapa[i][j] == 'G') c = 'M';
				if (i == linha_atual && j == coluna_atual) c = 'X';
				System.out.print("[" + c + "] ");
			}
			System.out.print("\n");
		}
		System.out.println("\n");
	}
	public int check () { //se devolver 0, nao ha batalha, 1 quer dizer que ha batalha contra pokemon wild e 2 contra treinador
		if (mapa[linha_atual][coluna_atual] == 'G') {
			Random rand = new Random();
			int r = rand.nextInt(3); //2 nao ocorre a batalha, 0 e 1, sim
			if (r < 2) {
				return 1;
			}
		}
		if(mapa[linha_atual][coluna_atual] == 'T') {
			return 2;
		}
		return 0;
	}
}
