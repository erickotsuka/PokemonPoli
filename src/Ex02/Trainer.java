package Ex02;

public class Trainer {
	private boolean finalizou = false;
	private static final int tam = 6;
	private Pokemon[] pok = new Pokemon[tam];
	private String nome;
	public Trainer (String nome) {
		this.nome = nome;
	}
	public Pokemon getPokemon (int p) {
		return pok[p];
	}
	public void trocarPokemon (int t) {
		Pokemon p = new Pokemon ("prov1", 0, "prov2", 1);
		p = pok[0];
		pok[0] = pok[t];
		pok[t] = p;
	}
	public void setPokemon (Pokemon p, int i) {
		pok[i] = p;
	}
	public String getNome () {
		return nome;
	}
	public void finalizouFalse () {
		finalizou = false;
	}
	public void finalizouTrue () {
		finalizou = true;
	}
	public boolean getFinalizou () {
		return finalizou;
	}
} 

