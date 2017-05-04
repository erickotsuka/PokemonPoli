
public class Pokemon {
	private static final int tam = 4;
	private double maxHP;
	private String nome;
	private double hp;
	private String tipo;
	private Ataque[] att = new Ataque[tam];
	private boolean ativo = false;
	public Pokemon (String nome, double hp, String tipo, double maxHP) {
		this.maxHP = maxHP;
		this.nome = nome;
		this.hp = hp;
		this.tipo = tipo;
	}
	public void calcHP (double dano) { //dano negativo significa cura
		if (hp - dano  <= maxHP) hp -= dano;
		else
			hp = maxHP;
	}
	public double getHP () {
		return hp;
	}
	public void desativar () {
		ativo = false;
	}
	public void ativar () {
		ativo = true;
	}
	public boolean ativo () {
		return this.ativo;
	}
	public String getNome () {
		return nome;
	}
	public double getMaxHP () {
		return maxHP;
	}
	public String getTipo () {
		return tipo;
	}
	public Ataque getAtaque (int a) {
		return att[a];
	}
	public void setAtaque (Ataque atk, int i) {
		att[i] = atk;
	}
}
