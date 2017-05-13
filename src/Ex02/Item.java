package Ex02;

public class Item {
	private double cura;
	private String nome;
	public Item(String nome, double cura) {
		this.nome = nome;
		this.cura = cura;
	}
	public double getCura() {
		return this.cura;
	}
	public String getNome() {
		return this.nome;
	}
}
