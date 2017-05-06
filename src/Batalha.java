
public class Batalha extends Controlador {
	private boolean finalizou = false;
	private class Atacar extends Evento {
		private Trainer atacante, defesa;
		private int a;
		public void setAtacante (Trainer atacante) {
			this.atacante = atacante;
		}
		public void setDefesa (Trainer defesa) {
			this.defesa = defesa;
		}
		public void seta (int a) {
			this.a = a;
		}
		public void acao() {
			defesa.getPokemon(0).calcHP (atacante.getPokemon(0).getAtaque(a).getDano());
		}
		public String descricao () {
			String msg;
			msg = "Pokemon " + atacante.getPokemon(0).getNome() + " usou " + atacante.getPokemon(0).getAtaque(a) + " no Pokemon " + defesa.getPokemon(0).getNome();
			msg += "\n";
			msg += defesa.getPokemon(0).getNome() + ": HP: " + defesa.getPokemon(0).getHP() + "/" + defesa.getPokemon(0).getMaxHP();
			return msg;
		}
	}
	private class Trocar extends Evento {
		private int t;
		private static final int prioridade = 6;
		public void setT (int t) {
			this.t = t;
		}
		private Trainer ativo;
		public void setAtivo (Trainer ativo) {
			this.ativo = ativo;
		}
		public void acao () {
			ativo.trocarPokemon(t);
		}
		public String descricao () {
			String msg;
			msg = "Pokemon " + ativo.getPokemon(0).getNome() + " trocado por " + ativo.getPokemon(t);
			return msg;
		}
		public int getPrioridade() {
			return prioridade;
		}
	}
	private class UsarItem extends Evento {
		private Trainer ativo;
		private Item item;
		private static final int prioridade = 5;
		public void setAtivo(Trainer ativo) {
			this.ativo = ativo;
		}
		public void acao () {
			ativo.getPokemon(0).calcHP(item.getCura());
		}
		public String descricao () {
			String msg;
			msg = ativo.getPokemon(0).getNome() + " usou " + item.getNome();
			msg += "\n";
			msg += ativo.getPokemon(0).getNome() + ": HP: " + ativo.getPokemon(0).getHP() + "/" + ativo.getPokemon(0).getMaxHP();
			return msg;
		}
		public int getPrioridade() {
			return prioridade;
		}
	}
	private class Fugir extends Evento {
		private Trainer ativo;
		private static final int prioridade = 7;
		public void setAtivo(Trainer ativo) {
			this.ativo = ativo;
		}
		public void acao () {
			finalizou = true;
		}
		public String descricao () {
			return ativo.getNome() + " fugiu da batalha.";
		}
		public int getPrioridade() {
			return prioridade;
		}
	}
	private class Iniciar extends Evento {
		private Trainer treinador_1 = new Trainer("Red");
		private Trainer treinador_2 = new Trainer("Blue");
		private Pokemon[] pokes_t1 = new Pokemon[6];
		private Pokemon[] pokes_t2 = new Pokemon[6];
		{
			pokes_t1[0] = new Pokemon("NOME", 130, "TIPO", 130);
			pokes_t1[1] = new Pokemon("NOME", 130, "TIPO", 130);
			pokes_t1[2] = new Pokemon("NOME", 130, "TIPO", 130);
			pokes_t1[3] = new Pokemon("NOME", 130, "TIPO", 130);
			pokes_t1[4] = new Pokemon("NOME", 130, "TIPO", 130);
			pokes_t1[5] = new Pokemon("NOME", 130, "TIPO", 130);
			pokes_t2[0] = new Pokemon("NOME", 130, "TIPO", 130);
			pokes_t2[1] = new Pokemon("NOME", 130, "TIPO", 130);
			pokes_t2[2] = new Pokemon("NOME", 130, "TIPO", 130);
			pokes_t2[3] = new Pokemon("NOME", 130, "TIPO", 130);
			pokes_t2[4] = new Pokemon("NOME", 130, "TIPO", 130);
			pokes_t2[5] = new Pokemon("NOME", 130, "TIPO", 130);
			Ataque att = new Ataque("Pound", 40, 1);
			pokes_t1[0].setAtaque(att, 0);
			att = new Ataque("Karate Chop", 50, 2);
			pokes_t1[0].setAtaque(att, 1);
			att = new Ataque("Double Slap", 15, 3);
			pokes_t1[0].setAtaque(att, 2);
			att = new Ataque("Comet Punch", 18, 4);
			pokes_t1[0].setAtaque(att, 3);
			att = new Ataque("Mega Punch", 80, 1);
			pokes_t1[1].setAtaque(att, 0);
			att = new Ataque("Pay Day", 40, 2);
			pokes_t1[1].setAtaque(att, 1);
			att = new Ataque("Fire Punch", 75, 3);
			pokes_t1[1].setAtaque(att, 2);
			att = new Ataque("Ice Punch", 75, 4);
			pokes_t1[1].setAtaque(att, 3);
			att = new Ataque("Thunder Punch", 75, 1);
			pokes_t1[2].setAtaque(att, 0);
			att = new Ataque("Scratch", 40, 2);
			pokes_t1[2].setAtaque(att, 1);
			att = new Ataque("Vice Grip", 55, 3);
			pokes_t1[2].setAtaque(att, 2);
			att = new Ataque("Guillotine", 100000, 4);
			pokes_t1[2].setAtaque(att, 3);
			att = new Ataque("Razor Wind", 80, 1);
			pokes_t1[3].setAtaque(att, 0);
			att = new Ataque("Swords Dance", 0, 2);
			pokes_t1[3].setAtaque(att, 1);
			att = new Ataque("Cut", 50, 3);
			pokes_t1[3].setAtaque(att, 2);
			att = new Ataque("Gust", 40, 4);
			pokes_t1[3].setAtaque(att, 3);
			att = new Ataque("Wing Attack", 60, 1);
			pokes_t1[4].setAtaque(att, 0);
			att = new Ataque("Whirlwind", 0, 2);
			pokes_t1[4].setAtaque(att, 1);
			att = new Ataque("Fly", 90, 3);
			pokes_t1[4].setAtaque(att, 2);
			att = new Ataque("Bind", 15, 4);
			pokes_t1[4].setAtaque(att, 3);
			att = new Ataque("Slam", 80, 1);
			pokes_t1[5].setAtaque(att, 0);
			att = new Ataque("Vine Whip", 45, 2);
			pokes_t1[5].setAtaque(att, 1);
			att = new Ataque("Stomp", 65, 3);
			pokes_t1[5].setAtaque(att, 2);
			att = new Ataque("Double Kick", 30, 4);
			pokes_t1[5].setAtaque(att, 3);
			att = new Ataque("Mega Kick", 120, 1);
			pokes_t2[0].setAtaque(att, 0);
			att = new Ataque("Jump Kick", 100, 2);
			pokes_t2[0].setAtaque(att, 1);
			att = new Ataque("Rolling Kick", 60, 3);
			pokes_t2[0].setAtaque(att, 2);
			att = new Ataque("Sand Attack", 0, 4);
			pokes_t2[0].setAtaque(att, 3);
			att = new Ataque("Headbutt", 70, 1);
			pokes_t2[1].setAtaque(att, 0);
			att = new Ataque("Horn Attack", 65, 2);
			pokes_t2[1].setAtaque(att, 1);
			att = new Ataque("Fury Attack", 15, 3);
			pokes_t2[1].setAtaque(att, 2);
			att = new Ataque("Horn Drill", 100000, 4);
			pokes_t2[1].setAtaque(att, 3);
			att = new Ataque("Tackle", 40, 1);
			pokes_t2[2].setAtaque(att, 0);
			att = new Ataque("Body Slam", 85, 2);
			pokes_t2[2].setAtaque(att, 1);
			att = new Ataque("Wrap", 15, 3);
			pokes_t2[2].setAtaque(att, 2);
			att = new Ataque("Take Down", 90, 4);
			pokes_t2[2].setAtaque(att, 3);
			att = new Ataque("Thrash", 120, 1);
			pokes_t2[3].setAtaque(att, 0);
			att = new Ataque("Double-Edge", 120, 2);
			pokes_t2[3].setAtaque(att, 1);
			att = new Ataque("Tail Whip", 0, 3);
			pokes_t2[3].setAtaque(att, 2);
			att = new Ataque("Poison Sting", 15, 4);
			pokes_t2[3].setAtaque(att, 3);
			att = new Ataque("Twineedle", 25, 1);
			pokes_t2[4].setAtaque(att, 0);
			att = new Ataque("Pin Missile", 25, 2);
			pokes_t2[4].setAtaque(att, 1);
			att = new Ataque("Leer", 0, 3);
			pokes_t2[4].setAtaque(att, 2);
			att = new Ataque("Bite", 60, 4);
			pokes_t2[4].setAtaque(att, 3);
			att = new Ataque("Growl", 0, 1);
			pokes_t2[5].setAtaque(att, 0);
			att = new Ataque("Roar", 0, 2);
			pokes_t2[5].setAtaque(att, 1);
			att = new Ataque("Sing", 0, 3);
			pokes_t2[5].setAtaque(att, 2);
			att = new Ataque("Supersonic", 0, 4);
			pokes_t2[5].setAtaque(att, 3);
		}
		//TODO prioridades, verificar pokemons vivos, se finalizou batalha
		public void acao () {
			//TODO adicionar eventos
		}
		public String descricao () {
			return "Iniciando batalha\n";
		}
	}
	public static void main(String[] args) {
		
	}
}
