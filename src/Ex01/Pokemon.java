package Ex01;

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
	public void calcHP (double dano, String tipoA) { //dano negativo significa cura
		double m = 1;
		if (tipoA == "Normal") {
			if (tipo == "Rock" || tipo == "Steel") {
				m = m/2;
			}
			if (tipo == "Ghost") {
				m = 0;
			}
		}
		if (tipoA == "Fighting") {
			if (tipo == "Normal" || tipo == "Rock" || tipo == "Steel" || tipo == "Ice" || tipo == "Dark") {
				m = 2;
			}
			if (tipo == "Flying" || tipo == "Poison" || tipo == "Bug" || tipo == "Psychic" || tipo == "Fairy") {
				m = m/2;
			}
			if (tipo == "Ghost") {
				m = 0;
			}
		}
		if (tipoA == "Flying") {
			if (tipo == "Fighting" || tipo == "Bug" || tipo == "Grass") {
				m = 2;
			}
			if (tipo == "Rock" || tipo == "Steel" || tipo == "Electric") {
				m = m/2;
			}
		}
		if (tipoA == "Poison") {
			if (tipo == "Grass" || tipo == "Fairy") {
				m = 2;
			}
			if (tipo == "Poison" || tipo == "Ground" || tipo == "Rock" || tipo == "Ghost") {
				m = m/2;
			}
			if (tipo == "Steel") {
				m = 0;
			}
		}
		if (tipoA == "Ground") {
			if (tipo == "Poison" || tipo == "Rock" || tipo == "Steel" || tipo == "Fire" || tipo == "Electric") {
				m = 2;
			}
			if (tipo == "Bug" || tipo == "Grass") {
				m = m/2;
			}
			if (tipo == "Flying") {
				m = 0;
			}
		}
		if (tipoA == "Rock") {
			if (tipo == "Flying" || tipo == "Bug" || tipo == "Fire" || tipo == "Ice") {
				m = 2;
			}
			if (tipo == "Fighting" || tipo == "Ground" || tipo == "Steel") {
				m = m/2;
			}
		}
		if (tipoA == "Bug") {
			if (tipo == "Grass" || tipo == "Psychic" || tipo == "Dark") {
				m = 2;
			}
			if (tipo == "Fighting" || tipo == "Flying" || tipo == "Poison" || tipo == "Ghost" || tipo == "Steel" || tipo == "Fire" || tipo == "Fairy") {
				m = m/2;
			}
		}
		if (tipoA == "Ghost") {
			if (tipo == "Ghost" || tipo == "Psychic") {
				m = 2;
			}
			if (tipo == "Dark") {
				m = m/2;
			}
			if (tipo == "Normal") {
				m = 0;
			}
		}
		if (tipoA == "Steel") {
			if (tipo == "Rock" || tipo == "Ice" || tipo == "Fairy") {
				m = 2;
			}
			if (tipo == "Steel" || tipo == "Fire" || tipo == "Water" || tipo == "Electric")
				m = m/2;
		}
		if (tipoA == "Fire") {
			if (tipo == "Bug" || tipo == "Steel" || tipo == "Grass" || tipo == "Ice") {
				m = 2;
			}
			if (tipo == "Rock" || tipo == "Fire" || tipo == "Water" || tipo == "Dragon") {
				m = m/2;
			}
		}
		if (tipoA == "Water") {
			if (tipo == "Ground" || tipo == "Rock" || tipo == "Fire") {
				m = 2;
			}
			if (tipo == "Water" || tipo == "Grass" || tipo == "Dragon") {
				m = m/2;
			}
		}
		if (tipoA == "Grass") {
			if (tipo == "Ground" || tipo == "Rock" || tipo == "Water") {
				m = 2;
			}
			if(tipo == "Flying" || tipo == "Poison" || tipo == "Bug" || tipo == "Steel" || tipo == "Fire" || tipo == "Grass" || tipo == "Dragon") {
				m = m/2;
			}
		}
		if (tipoA == "Electric") {
			if (tipo == "Flying" || tipo == "Water") {
				m = 2;
			}
			if (tipo == "Grass" || tipo == "Electric" || tipo == "Dragon") {
				m = m/2;
			}
			if (tipo == "Ground") {
				m = 0;
			}
		}
		if (tipoA == "Psychic") {
			if (tipo == "Fighting" || tipo == "Poison") {
				m = 2;
			}
			if (tipo == "Steel" || tipo == "Psychic") {
				m = m/2;
			}
			if (tipo == "Dark") {
				m = 0;
			}
		}
		if (tipoA == "Ice") {
			if (tipo == "Flying" || tipo == "Ground" || tipo == "Grass" || tipo == "Dragon") {
				m = 2;
			}
			if (tipo == "Steel" || tipo == "Fire" || tipo == "Water" || tipo == "Ice") {
				m = m/2;
			}
		}
		if (tipoA == "Dragon") {
			if (tipo == "Dragon") {
				m = 2;
			}
			if (tipo == "Steel") {
				m = m/2;
			}
			if (tipo == "Fairy") {
				m = 0;
			}
		}
		if (tipoA == "Dark") {
			if (tipo == "Ghost" || tipo == "Psychic") {
				m = 2;
			}
			if (tipo == "Fighting" || tipo == "Dark" || tipo == "Fairy") {
				m = m/2;
			}
		}
		if (tipoA == "Fairy") {
			if (tipo == "Fighting" || tipo == "Dragon" || tipo == "Dark") {
				m = 2;
			}
			if (tipo == "Poison" || tipo == "Steel" || tipo == "Fire") {
				m = m/2;
			}
		}
		if (m == 2) {
			System.out.println(">Os golpes de pokemons do tipo " + tipoA + " sao super efetivos em pokemons do tipo " + tipo + "!");
		}
		if (m == 0.5) {
			System.out.println(">Os golpes de pokemons do tipo " + tipoA + " nao sao muito efetivos em pokemons do tipo " + tipo + "...");
		}
		if (m == 0) {
			System.out.println(">Os golpes de pokemons do tipo " + tipoA + " nao funcionam em pokemons do tipo " + tipo + "...");
		}
		if (hp - dano  <= maxHP) hp -= (m * dano);
		else
			hp = maxHP;
		if (hp < 0) hp = 0;
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
