package Ex01;

public class Batalha extends Controlador {
	private class Atacar extends Evento {
		private Trainer atacante, defesa;
		private int a;
		private static final int prioridade = 4;
		public int getPrioridade() {
			return prioridade;
		}
		public Atacar (Trainer atacante, Trainer defesa, int a) {
			this.atacante = atacante;
			this.defesa = defesa;
			this.a = a;
		}
		public Trainer getAtacante() {
			return atacante;
		}
		public Trainer getDefesa() {
			return defesa;
		}
		public int getA() {
			return a;
		}
		public void acao() {
			defesa.getPokemon(0).calcHP (atacante.getPokemon(0).getAtaque(a).getDano(), atacante.getPokemon(0).getTipo());
		}
		public String descricao () {
			String msg;
			msg = "Pokemon " + atacante.getPokemon(0).getNome() + " usou " + atacante.getPokemon(0).getAtaque(a).getNome() + " no Pokemon " + defesa.getPokemon(0).getNome();
			msg += "\n";
			msg += defesa.getPokemon(0).getNome() + ": HP: " + defesa.getPokemon(0).getHP() + "/" + defesa.getPokemon(0).getMaxHP();
			return msg;
		}
	}
	private class Trocar extends Evento {
		private int t;
		private static final int prioridade = 6;
		private Trainer ativo;
		public Trocar (int t, Trainer ativo) {
			this.t = t;
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
		public Trainer getAtacante() {
			Trainer temp = new Trainer("p");
			return temp;
		}
		public Trainer getDefesa() {
			Trainer temp = new Trainer("p");
			return temp;
		}
		public int getA() {
			return 0;
		}
	}
	private class UsarItem extends Evento {
		private Trainer ativo;
		private Item item;
		private static final int prioridade = 5;
		public UsarItem(Trainer ativo, Item item) {
			this.ativo = ativo;
			this.item = item;
		}
		public void acao () {
			ativo.getPokemon(0).calcHP(item.getCura(), "Item");
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
		public Trainer getAtacante() {
			Trainer temp = new Trainer("p");
			return temp;
		}
		public Trainer getDefesa() {
			Trainer temp = new Trainer("p");
			return temp;
		}
		public int getA() {
			return 0;
		}
	}
	private class Fugir extends Evento {
		private Trainer ativo;
		private static final int prioridade = 7;
		public Fugir(Trainer ativo) {
			this.ativo = ativo;
		}
		public void acao () {
			ativo.finalizouTrue();
		}
		public String descricao () {
			return ativo.getNome() + " fugiu da batalha.";
		}
		public int getPrioridade() {
			return prioridade;
		}
		public Trainer getAtacante() {
			Trainer temp = new Trainer("p");
			return temp;
		}
		public Trainer getDefesa() {
			Trainer temp = new Trainer("p");
			return temp;
		}
		public int getA() {
			return 0;
		}
	}
	private class Iniciar extends Evento {
		private Trainer treinador_1;
		private Trainer treinador_2;
		private Pokemon[] pokes_t1;
		private Pokemon[] pokes_t2;
		private Item item;
		public Iniciar(Trainer treinador_1, Trainer treinador_2, Pokemon[] pokes_t1, Pokemon[] pokes_t2, Item item) {
			this.treinador_1 = treinador_1;
			this.treinador_2 = treinador_2;
			this.pokes_t1 = pokes_t1;
			this.pokes_t2 = pokes_t2;
			this.item = item;
		}
		public void acao () {
			//TODO adicionar eventos
				adicionarEvento (new Atacar(treinador_1, treinador_2, 1));
				adicionarEvento(new Atacar(treinador_2, treinador_1, 0));
				adicionarEvento (new Atacar(treinador_1, treinador_2, 0));
				adicionarEvento(new Atacar(treinador_2, treinador_1, 2));
				adicionarEvento (new UsarItem(treinador_1, item));
				adicionarEvento(new Atacar(treinador_2, treinador_1, 3));
				adicionarEvento(new Atacar(treinador_1, treinador_2, 3));
				adicionarEvento (new UsarItem(treinador_2, item));
				adicionarEvento(new Atacar(treinador_1, treinador_2, 3));
				adicionarEvento(new Atacar(treinador_2, treinador_1, 3));
				adicionarEvento(new Atacar(treinador_1, treinador_2, 0));
				adicionarEvento(new Atacar(treinador_2, treinador_1, 2));
				//adicionarEvento(new Fugir (treinador_1));
				adicionarEvento(new Atacar(treinador_1, treinador_2, 3));
				adicionarEvento(new UsarItem(treinador_2, item));
				adicionarEvento(new Atacar(treinador_1, treinador_2, 3));
				adicionarEvento(new UsarItem(treinador_2, item));
				adicionarEvento(new Atacar(treinador_1, treinador_2, 3));
				adicionarEvento(new UsarItem(treinador_2, item));
				adicionarEvento(new Atacar(treinador_1, treinador_2, 3));
				adicionarEvento(new UsarItem(treinador_2, item));
				adicionarEvento(new Atacar(treinador_1, treinador_2, 3));
				adicionarEvento(new UsarItem(treinador_2, item));
				adicionarEvento(new Atacar(treinador_1, treinador_2, 3));
				adicionarEvento(new UsarItem(treinador_2, item));
				adicionarEvento(new Atacar(treinador_1, treinador_2, 3));
				adicionarEvento(new UsarItem(treinador_2, item));
				adicionarEvento(new Atacar(treinador_1, treinador_2, 3));
				adicionarEvento(new UsarItem(treinador_2, item));
				adicionarEvento(new Atacar(treinador_1, treinador_2, 3));
				adicionarEvento(new UsarItem(treinador_2, item));
				adicionarEvento(new Atacar(treinador_1, treinador_2, 3));
				adicionarEvento(new UsarItem(treinador_2, item));
				adicionarEvento(new Atacar(treinador_1, treinador_2, 3));
				adicionarEvento(new UsarItem(treinador_2, item));
				adicionarEvento(new Atacar(treinador_1, treinador_2, 3));
				adicionarEvento(new UsarItem(treinador_2, item));
				adicionarEvento(new Atacar(treinador_1, treinador_2, 3));
				adicionarEvento(new UsarItem(treinador_2, item));
				adicionarEvento(new Atacar(treinador_1, treinador_2, 3));
				adicionarEvento(new UsarItem(treinador_2, item));
				adicionarEvento(new Atacar(treinador_1, treinador_2, 3));
				adicionarEvento(new UsarItem(treinador_2, item));
				adicionarEvento(new Atacar(treinador_1, treinador_2, 3));
				adicionarEvento(new UsarItem(treinador_2, item));
				adicionarEvento(new Atacar(treinador_1, treinador_2, 3));
				adicionarEvento(new UsarItem(treinador_2, item));
				adicionarEvento(new Atacar(treinador_1, treinador_2, 3));
				adicionarEvento(new UsarItem(treinador_2, item));
				adicionarEvento(new Atacar(treinador_1, treinador_2, 3));
				adicionarEvento(new UsarItem(treinador_2, item));
				adicionarEvento(new Atacar(treinador_1, treinador_2, 3));
				adicionarEvento(new UsarItem(treinador_2, item));
				adicionarEvento(new Atacar(treinador_1, treinador_2, 3));
				adicionarEvento(new UsarItem(treinador_2, item));
				adicionarEvento(new Atacar(treinador_1, treinador_2, 3));
				adicionarEvento(new UsarItem(treinador_2, item));
				adicionarEvento(new Atacar(treinador_1, treinador_2, 3));
				adicionarEvento(new UsarItem(treinador_2, item));
				adicionarEvento(new Atacar(treinador_1, treinador_2, 3));
				adicionarEvento(new UsarItem(treinador_2, item));
				adicionarEvento(new Atacar(treinador_1, treinador_2, 3));
				adicionarEvento(new UsarItem(treinador_2, item));
				adicionarEvento(new Atacar(treinador_1, treinador_2, 3));
				adicionarEvento(new UsarItem(treinador_2, item));
				adicionarEvento(new Atacar(treinador_1, treinador_2, 3));
				adicionarEvento(new UsarItem(treinador_2, item));
				adicionarEvento(new Atacar(treinador_1, treinador_2, 3));
				adicionarEvento(new UsarItem(treinador_2, item));
				adicionarEvento(new Atacar(treinador_1, treinador_2, 3));
				adicionarEvento(new UsarItem(treinador_2, item));
				adicionarEvento(new Atacar(treinador_1, treinador_2, 3));
				adicionarEvento(new UsarItem(treinador_2, item));
				adicionarEvento(new Atacar(treinador_1, treinador_2, 3));
				adicionarEvento(new UsarItem(treinador_2, item));
				adicionarEvento(new Atacar(treinador_1, treinador_2, 3));
				adicionarEvento(new UsarItem(treinador_2, item));
				adicionarEvento(new Atacar(treinador_1, treinador_2, 3));
				adicionarEvento(new UsarItem(treinador_2, item));
				adicionarEvento(new Atacar(treinador_1, treinador_2, 3));
				adicionarEvento(new UsarItem(treinador_2, item));
				adicionarEvento(new Atacar(treinador_1, treinador_2, 3));
				adicionarEvento(new UsarItem(treinador_2, item));
				adicionarEvento(new Atacar(treinador_1, treinador_2, 3));
				adicionarEvento(new UsarItem(treinador_2, item));
				adicionarEvento(new Atacar(treinador_1, treinador_2, 3));
				adicionarEvento(new UsarItem(treinador_2, item));
				adicionarEvento(new Atacar(treinador_1, treinador_2, 3));
				adicionarEvento(new UsarItem(treinador_2, item));
				adicionarEvento(new Atacar(treinador_1, treinador_2, 3));
				adicionarEvento(new UsarItem(treinador_2, item));
				adicionarEvento(new Atacar(treinador_1, treinador_2, 3));
				adicionarEvento(new UsarItem(treinador_2, item));
				
				
		}
		public String descricao () {
			return "Iniciando batalha\n";
		}
		public int getPrioridade() {
			return 0;
		}
		public Trainer getAtacante() {
			Trainer temp = new Trainer("p");
			return temp;
		}
		public Trainer getDefesa() {
			Trainer temp = new Trainer("p");
			return temp;
		}
		public int getA() {
			return 0;
		}
		public Trainer[] getTrainers() {
			Trainer t[] = new Trainer[2]; 
			t[0] = treinador_1;
			t[1] = treinador_2;
			return t;
		}
	}
	public static void main(String[] args) {
		Item potion = new Item("Potion", -50);
		Trainer treinador_1 = new Trainer("Erick");
		Trainer treinador_2 = new Trainer("Helio");
		Pokemon[] pokes_t1 = new Pokemon[6];
		Pokemon[] pokes_t2 = new Pokemon[6];
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
		Batalha b = new Batalha();
		b.adicionarEvento(b.new Iniciar(treinador_1, treinador_2, pokes_t1, pokes_t2, potion));
		b.executar(treinador_1, treinador_2, potion);
	}
}

