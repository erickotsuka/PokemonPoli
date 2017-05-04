
public class Ataque {
	private String nome;
	private double dano;
	private int prioridade;
	public Ataque (String nome, double dano, int prioridade) {
		this.nome = nome;
		this.dano = dano;
		this.prioridade = prioridade; //ataque de prioridade 5 ataca antes do que o de 4
	}
}
