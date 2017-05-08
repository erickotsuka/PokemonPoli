
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
		private Trainer treinador_1 = new Trainer("Erick");
		private Trainer treinador_2 = new Trainer("Helio");
		private Pokemon[] pokes_t1 = new Pokemon[6];
		private Pokemon[] pokes_t2 = new Pokemon[6];
		public Iniciar() {
			pokes_t1[0] = new Pokemon("Blissey", 714, "Normal", 714);
			pokes_t1[1] = new Pokemon("Aegislash", 324, "Steel", 324);
			pokes_t1[2] = new Pokemon("Kyogre", 404, "Water", 404);
			pokes_t1[3] = new Pokemon("Altaria", 354, "Dragon", 354);
			pokes_t1[4] = new Pokemon("Mega Mewtwo X", 416, "Psychic", 416);
			pokes_t1[5] = new Pokemon("Forretress", 354, "Bug", 354);
			pokes_t2[0] = new Pokemon("Pikachu", 274, "Electric", 274);
			pokes_t2[1] = new Pokemon("Venusaur", 364, "Grass", 364);
			pokes_t2[2] = new Pokemon("Charizard", 360, "Fire", 360);
			pokes_t2[3] = new Pokemon("Blastoise", 362, "Water", 362);
			pokes_t2[4] = new Pokemon("Lapras", 464, "Water", 464);
			pokes_t2[5] = new Pokemon("Snorlax", 524, "Normal", 524);
			Ataque att = new Ataque("Pound", 40, 1);
			pokes_t1[0].setAtaque(att, 0);
			att = new Ataque("Take Down", 90, 2);
			pokes_t1[0].setAtaque(att, 1);
			att = new Ataque("Double Slap", 15, 3);
			pokes_t1[0].setAtaque(att, 2);
			att = new Ataque("Earthquake", 100, 4);
			pokes_t1[0].setAtaque(att, 3);
			att = new Ataque("Iron Head", 80, 1);
			pokes_t1[1].setAtaque(att, 0);
			att = new Ataque("Flash Cannon", 80, 2);
			pokes_t1[1].setAtaque(att, 1);
			att = new Ataque("Shadow Ball", 80, 3);
			pokes_t1[1].setAtaque(att, 2);
			att = new Ataque("Head Smash", 150, 4);
			pokes_t1[1].setAtaque(att, 3);
			att = new Ataque("Water Pulse", 60, 1);
			pokes_t1[2].setAtaque(att, 0);
			att = new Ataque("Aqua Tail", 90, 2);
			pokes_t1[2].setAtaque(att, 1);
			att = new Ataque("Origin Pulse", 110, 3);
			pokes_t1[2].setAtaque(att, 2);
			att = new Ataque("Water Spout", 150, 4);
			pokes_t1[2].setAtaque(att, 3);
			att = new Ataque("Dragon Breath", 60, 1);
			pokes_t1[3].setAtaque(att, 0);
			att = new Ataque("Dragon Pulse", 85, 2);
			pokes_t1[3].setAtaque(att, 1);
			att = new Ataque("Dragon Rush", 100, 3);
			pokes_t1[3].setAtaque(att, 2);
			att = new Ataque("Sky Attack", 140, 4);
			pokes_t1[3].setAtaque(att, 3);
			att = new Ataque("Confusion", 50, 1);
			pokes_t1[4].setAtaque(att, 0);
			att = new Ataque("Psycho Cut", 70, 2);
			pokes_t1[4].setAtaque(att, 1);
			att = new Ataque("Psychic", 90, 3);
			pokes_t1[4].setAtaque(att, 2);
			att = new Ataque("Future Sight", 120, 4);
			pokes_t1[4].setAtaque(att, 3);
			att = new Ataque("Bug Bite", 60, 1);
			pokes_t1[5].setAtaque(att, 0);
			att = new Ataque("Flash Cannon", 80, 2);
			pokes_t1[5].setAtaque(att, 1);
			att = new Ataque("Zap Cannon", 120, 3);
			pokes_t1[5].setAtaque(att, 2);
			att = new Ataque("Hyper Beam", 150, 4);
			pokes_t1[5].setAtaque(att, 3);
			att = new Ataque("Volt Tackle", 120, 1); //Pikachu
			pokes_t2[0].setAtaque(att, 0);
			att = new Ataque("Iron Tail", 100, 2);
			pokes_t2[0].setAtaque(att, 1);
			att = new Ataque("Quick Attack", 40, 3);
			pokes_t2[0].setAtaque(att, 2);
			att = new Ataque("Thunderbolt", 90, 4);
			pokes_t2[0].setAtaque(att, 3);
			att = new Ataque("Sludge Bomb", 90, 1); //Venusaur
			pokes_t2[1].setAtaque(att, 0);
			att = new Ataque("Giga Drain", 75, 2);
			pokes_t2[1].setAtaque(att, 1);
			att = new Ataque("Sleep Powder", 0, 3);
			pokes_t2[1].setAtaque(att, 2);
			att = new Ataque("Frenzy Plant", 150, 4);
			pokes_t2[1].setAtaque(att, 3);
			att = new Ataque("Flare Blitz", 120, 1); //Charizard
			pokes_t2[2].setAtaque(att, 0);
			att = new Ataque("Air Slash", 75, 2);
			pokes_t2[2].setAtaque(att, 1);
			att = new Ataque("Blast Burn", 150, 3);
			pokes_t2[2].setAtaque(att, 2);
			att = new Ataque("Dragon Pulse", 85, 4);
			pokes_t2[2].setAtaque(att, 3);
			att = new Ataque("Focus Blast", 120, 1); //Blastoise
			pokes_t2[3].setAtaque(att, 0);
			att = new Ataque("Hydro Cannon", 150, 2);
			pokes_t2[3].setAtaque(att, 1);
			att = new Ataque("Blizzard", 110, 3);
			pokes_t2[3].setAtaque(att, 2);
			att = new Ataque("Flash Cannon", 80, 4);
			pokes_t2[3].setAtaque(att, 3);
			att = new Ataque("Blizzard", 110, 1); //Lapras
			pokes_t2[4].setAtaque(att, 0);
			att = new Ataque("Brine", 65, 2);
			pokes_t2[4].setAtaque(att, 1);
			att = new Ataque("Psychic", 90, 3);
			pokes_t2[4].setAtaque(att, 2);
			att = new Ataque("Body Slam", 85, 4);
			pokes_t2[4].setAtaque(att, 3);
			att = new Ataque("Shadow Ball", 80, 1); //Snorlax
			pokes_t2[5].setAtaque(att, 0);
			att = new Ataque("Crunch", 80, 2);
			pokes_t2[5].setAtaque(att, 1);
			att = new Ataque("Blizzard", 110, 3);
			pokes_t2[5].setAtaque(att, 2);
			att = new Ataque("Giga Impact", 150, 4);
			pokes_t2[5].setAtaque(att, 3);
			for (int i = 0; i < 6; i++)
				treinador_1.setPokemon(pokes_t1[i], i);
			for (int i = 0; i < 6; i++)
				treinador_2.setPokemon(pokes_t2[i], i);
			treinador_1.getPokemon(0).ativar();
			treinador_2.getPokemon(0).ativar();	
		}
		//TODO prioridades, verificar pokemons vivos, se finalizou batalha
		public boolean nenhum_vivo(Trainer treinador) {
			for (int i = 0; i < 6; i++) {
				if (treinador.getPokemon(i).getHP() >= 0)
					return false;
			}
			return true;
		}
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
