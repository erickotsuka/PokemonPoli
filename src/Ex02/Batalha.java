package Ex02;
import java.util.Random;

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
			return ativo.getNome() + " fugiu da batalha.\n";
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
	private class Capturar extends Evento {
		Trainer wildpok, treinador_1;
		Pokemon[]magikarp;
		private boolean capturou = false;
		private static final int prioridade = 8;
		public Capturar (Trainer treinador_1,Trainer wildpok, Pokemon[] magikarp) {
			this.wildpok = wildpok;
			this.treinador_1 = treinador_1;
			this.magikarp = magikarp;
		}
		public void acao () {
			double prob, f;
			int r, c;
			f = (wildpok.getPokemon(0).getMaxHP() * 255 * 4) / (wildpok.getPokemon(0).getHP() * 6); //utilizou-se uma formula parecia com a fornecida no site Bulbapedia. Adotou-se Ball para Pokebola == 6 
			double cr = 45; //catch rate. especifica para cada pokemon, no caso, magikarp, adotou-se que a sua catch rate e de 45
			prob = ((cr + 1) / 256) * ((f + 1) / 256);
			prob *= 100;
			c = (int)prob;
			Random rand = new Random();
			r = rand.nextInt(150) + 1;
			if (r < c) {
				capturou = true;
				treinador_1.finalizouTrue(); //indica que a batalha acabou
			}
		}
		public String descricao () {
			String msg;
			msg = treinador_1.getNome() + " jogou uma Pokebola em " + wildpok.getPokemon(0).getNome() + "!\n";
			if (capturou) {
				msg += wildpok.getPokemon(0).getNome() + " foi capturado com sucesso!\n";
			} else {
				msg += wildpok.getPokemon(0).getNome() + " nao foi capturado...\n";
			}
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
	private class Iniciar extends Evento { //batalha de TREINADOR X TREINADOR
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
				adicionarEvento(new Fugir (treinador_1)); //caso acabem os comandos e a batalha nao tenha acabado ainda...
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
	private class Iniciar2 extends Evento { //batalha de TREINADOR X MAGIKARP
		private Trainer treinador_1;
		private Trainer wildpok;
		private Pokemon[] pokes_t1;
		private Pokemon[] magikarp;
		private Item item;
		public Iniciar2(Trainer treinador_1, Trainer wildpok, Pokemon[] pokes_t1, Pokemon[] magikarp, Item item) {
			this.treinador_1 = treinador_1;
			this.wildpok = wildpok;
			this.pokes_t1 = pokes_t1;
			this.magikarp = magikarp;
			this.item = item;
		}
		public int randomMove() {
			Random rand = new Random();
			return rand.nextInt(4);
		}
		public void acao () {
			//TODO adicionar eventos
				adicionarEvento (new Atacar(treinador_1, wildpok, 1));
				adicionarEvento(new Atacar(wildpok, treinador_1, randomMove()));
				adicionarEvento (new Atacar(treinador_1, wildpok, 2));
				adicionarEvento(new Atacar(wildpok, treinador_1, randomMove()));
				adicionarEvento (new Capturar(treinador_1, wildpok, magikarp));
				adicionarEvento(new Atacar(wildpok, treinador_1, randomMove()));
				adicionarEvento (new Atacar(treinador_1, wildpok, 2));
				adicionarEvento(new Atacar(wildpok, treinador_1, randomMove()));
				adicionarEvento (new Capturar(treinador_1, wildpok, magikarp));
				adicionarEvento(new Atacar(wildpok, treinador_1, randomMove()));
				adicionarEvento (new Capturar(treinador_1, wildpok, magikarp));
				adicionarEvento(new Atacar(wildpok, treinador_1, randomMove()));
				adicionarEvento (new Atacar(treinador_1, wildpok, 2));
				adicionarEvento(new Atacar(wildpok, treinador_1, randomMove()));
				adicionarEvento (new Capturar(treinador_1, wildpok, magikarp));
				adicionarEvento(new Atacar(wildpok, treinador_1, randomMove()));
				adicionarEvento (new Atacar(treinador_1, wildpok, 2));
				adicionarEvento(new Atacar(wildpok, treinador_1, randomMove()));
				adicionarEvento (new Atacar(treinador_1, wildpok, 2));
				adicionarEvento(new Atacar(wildpok, treinador_1, randomMove()));
				adicionarEvento (new Atacar(treinador_1, wildpok, 2));
				adicionarEvento(new Atacar(wildpok, treinador_1, randomMove()));
				adicionarEvento (new Atacar(treinador_1, wildpok, 2));
				adicionarEvento(new Atacar(wildpok, treinador_1, randomMove()));
				adicionarEvento (new Atacar(treinador_1, wildpok, 2));
				adicionarEvento(new Atacar(wildpok, treinador_1, randomMove()));
				adicionarEvento (new Atacar(treinador_1, wildpok, 2));
				adicionarEvento(new Atacar(wildpok, treinador_1, randomMove()));
				adicionarEvento (new Atacar(treinador_1, wildpok, 2));
				adicionarEvento(new Atacar(wildpok, treinador_1, randomMove()));
				adicionarEvento (new Atacar(treinador_1, wildpok, 2));
				adicionarEvento(new Atacar(wildpok, treinador_1, randomMove()));
				adicionarEvento (new Atacar(treinador_1, wildpok, 2));
				adicionarEvento(new Atacar(wildpok, treinador_1, randomMove()));
				
				
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
			t[1] = wildpok;
			return t;
		}
	}
	public static void main(String[] args) {
		int a;
		Mapa mapa = new Mapa();
		Item item = new Item("Potion", -50);
		Trainer treinador_1 = new Trainer("Erick");
		Trainer treinador_2 = new Trainer("Helio");
		Trainer wildpok = new Trainer("Wild Pokemon");
		Pokemon[] pokes_t1 = new Pokemon[6];
		Pokemon[] pokes_t2 = new Pokemon[6];
		Pokemon[] magikarp = new Pokemon[6];
		magikarp[0] = new Pokemon("Magikarp", 175, "Water", 175); //nosso programa verifica se a batalha acabou ao ver que nao ha mais pokemons vivos, por isso criou-se um treinador que so tem 1 pokemon vivo, que e o proprio wild pokemon
		magikarp[1] = new Pokemon("---", 0, "---", 0);
		magikarp[2] = new Pokemon("---", 0, "---", 0);
		magikarp[3] = new Pokemon("---", 0, "---", 0);
		magikarp[4] = new Pokemon("---", 0, "---", 0);
		magikarp[5] = new Pokemon("---", 0, "---", 0);
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
		att = new Ataque("Splash", 0, 1); //magikarp
		magikarp[0].setAtaque(att, 0);
		att = new Ataque("Flail", 0, 2);
		magikarp[0].setAtaque(att, 1);
		att = new Ataque("Tackle", 40, 3);
		magikarp[0].setAtaque(att, 2);
		att = new Ataque("Hydro Pump", 110, 4);
		magikarp[0].setAtaque(att, 3);
		att = new Ataque("Splash", 0, 1); //pokemon 0 hp
		magikarp[1].setAtaque(att, 0);
		att = new Ataque("Flail", 0, 2);
		magikarp[1].setAtaque(att, 1);
		att = new Ataque("Tackle", 40, 3);
		magikarp[1].setAtaque(att, 2);
		att = new Ataque("Hydro Pump", 110, 4);
		magikarp[1].setAtaque(att, 3);
		att = new Ataque("Splash", 0, 1); //pokemon 0 hp
		magikarp[2].setAtaque(att, 0);
		att = new Ataque("Flail", 0, 2);
		magikarp[2].setAtaque(att, 1);
		att = new Ataque("Tackle", 40, 3);
		magikarp[2].setAtaque(att, 2);
		att = new Ataque("Hydro Pump", 110, 4);
		magikarp[2].setAtaque(att, 3);
		att = new Ataque("Splash", 0, 1); //pokemon 0 hp
		magikarp[3].setAtaque(att, 0);
		att = new Ataque("Flail", 0, 2);
		magikarp[3].setAtaque(att, 1);
		att = new Ataque("Tackle", 40, 3);
		magikarp[3].setAtaque(att, 2);
		att = new Ataque("Hydro Pump", 110, 4);
		magikarp[3].setAtaque(att, 3);
		att = new Ataque("Splash", 0, 1); //pokemon 0 hp
		magikarp[4].setAtaque(att, 0);
		att = new Ataque("Flail", 0, 2);
		magikarp[4].setAtaque(att, 1);
		att = new Ataque("Tackle", 40, 3);
		magikarp[4].setAtaque(att, 2);
		att = new Ataque("Hydro Pump", 110, 4);
		magikarp[4].setAtaque(att, 3);
		att = new Ataque("Splash", 0, 1); //pokemon 0 hp
		magikarp[5].setAtaque(att, 0);
		att = new Ataque("Flail", 0, 2);
		magikarp[5].setAtaque(att, 1);
		att = new Ataque("Tackle", 40, 3);
		magikarp[5].setAtaque(att, 2);
		att = new Ataque("Hydro Pump", 110, 4);
		magikarp[5].setAtaque(att, 3);
		for (int i = 0; i < 6; i++)
			treinador_1.setPokemon(pokes_t1[i], i);
		for (int i = 0; i < 6; i++)
			treinador_2.setPokemon(pokes_t2[i], i);
		for (int i = 0; i < 6; i++)
			wildpok.setPokemon(magikarp[i], i);
		treinador_1.getPokemon(0).ativar();
		treinador_2.getPokemon(0).ativar();
		wildpok.getPokemon(0).ativar();
		Batalha b = new Batalha();
		System.out.println("Consideracoes iniciais:\nNeste mapa, cada quadrado representa uma posicao no mapa.\nSe o quadrado nao tiver nada dentro dele, ele representa o chao.\nSe ele tiver M, ele representa um arbusto.\nSe ele tiver um R, representa que seu rival esta naquela posicao.\nFinalmente, sua posicao atual eh marcada com um X\n");
		mapa.para_baixo();
		a = mapa.check();
		if (a == 0);
		if (a == 1) { //batalha contra pokemon wild
			b.adicionarEvento(b.new Iniciar2(treinador_1, wildpok, pokes_t1, magikarp, item));
			b.executar(treinador_1, wildpok, item);
			wildpok.getPokemon(0).calcHP(-175, "Item"); //deve-se restaurar o HP do Magikarp ao final de cada batalha para que na proxima batalha ele inicie com HP maximo, como se nada tivesse acontecido
		}
		if (a == 2) { //batalha contra treinador
			b.adicionarEvento(b.new Iniciar(treinador_1, treinador_2, pokes_t1, pokes_t2, item));
			b.executar(treinador_1, treinador_2, item);
		}
		mapa.para_baixo();
		a = mapa.check();
		if (a == 0);
		if (a == 1) { //batalha contra pokemon wild
			b.adicionarEvento(b.new Iniciar2(treinador_1, wildpok, pokes_t1, magikarp, item));
			b.executar(treinador_1, wildpok, item);
			wildpok.getPokemon(0).calcHP(-175, "Item"); //deve-se restaurar o HP do Magikarp ao final de cada batalha para que na proxima batalha ele inicie com HP maximo, como se nada tivesse acontecido
		}
		if (a == 2) { //batalha contra treinador
			b.adicionarEvento(b.new Iniciar(treinador_1, treinador_2, pokes_t1, pokes_t2, item));
			b.executar(treinador_1, treinador_2, item);
		}
		mapa.para_baixo();
		a = mapa.check();
		if (a == 0);
		if (a == 1) { //batalha contra pokemon wild
			b.adicionarEvento(b.new Iniciar2(treinador_1, wildpok, pokes_t1, magikarp, item));
			b.executar(treinador_1, wildpok, item);
			wildpok.getPokemon(0).calcHP(-175, "Item"); //deve-se restaurar o HP do Magikarp ao final de cada batalha para que na proxima batalha ele inicie com HP maximo, como se nada tivesse acontecido
		}
		if (a == 2) { //batalha contra treinador
			b.adicionarEvento(b.new Iniciar(treinador_1, treinador_2, pokes_t1, pokes_t2, item));
			b.executar(treinador_1, treinador_2, item);
		}
		mapa.para_baixo();
		a = mapa.check();
		if (a == 0);
		if (a == 1) { //batalha contra pokemon wild
			b.adicionarEvento(b.new Iniciar2(treinador_1, wildpok, pokes_t1, magikarp, item));
			b.executar(treinador_1, wildpok, item);
			wildpok.getPokemon(0).calcHP(-175, "Item"); //deve-se restaurar o HP do Magikarp ao final de cada batalha para que na proxima batalha ele inicie com HP maximo, como se nada tivesse acontecido
		}
		if (a == 2) { //batalha contra treinador
			b.adicionarEvento(b.new Iniciar(treinador_1, treinador_2, pokes_t1, pokes_t2, item));
			b.executar(treinador_1, treinador_2, item);
		}
		mapa.para_direita();
		a = mapa.check();
		if (a == 0);
		if (a == 1) { //batalha contra pokemon wild
			b.adicionarEvento(b.new Iniciar2(treinador_1, wildpok, pokes_t1, magikarp, item));
			b.executar(treinador_1, wildpok, item);
			wildpok.getPokemon(0).calcHP(-175, "Item"); //deve-se restaurar o HP do Magikarp ao final de cada batalha para que na proxima batalha ele inicie com HP maximo, como se nada tivesse acontecido
		}
		if (a == 2) { //batalha contra treinador
			b.adicionarEvento(b.new Iniciar(treinador_1, treinador_2, pokes_t1, pokes_t2, item));
			b.executar(treinador_1, treinador_2, item);
		}
		mapa.para_cima();
		a = mapa.check();
		if (a == 0);
		if (a == 1) { //batalha contra pokemon wild
			b.adicionarEvento(b.new Iniciar2(treinador_1, wildpok, pokes_t1, magikarp, item));
			b.executar(treinador_1, wildpok, item);
			wildpok.getPokemon(0).calcHP(-175, "Item"); //deve-se restaurar o HP do Magikarp ao final de cada batalha para que na proxima batalha ele inicie com HP maximo, como se nada tivesse acontecido
		}
		if (a == 2) { //batalha contra treinador
			b.adicionarEvento(b.new Iniciar(treinador_1, treinador_2, pokes_t1, pokes_t2, item));
			b.executar(treinador_1, treinador_2, item);
		}
		mapa.para_cima();
		a = mapa.check();
		if (a == 0);
		if (a == 1) { //batalha contra pokemon wild
			b.adicionarEvento(b.new Iniciar2(treinador_1, wildpok, pokes_t1, magikarp, item));
			b.executar(treinador_1, wildpok, item);
			wildpok.getPokemon(0).calcHP(-175, "Item"); //deve-se restaurar o HP do Magikarp ao final de cada batalha para que na proxima batalha ele inicie com HP maximo, como se nada tivesse acontecido
		}
		if (a == 2) { //batalha contra treinador
			b.adicionarEvento(b.new Iniciar(treinador_1, treinador_2, pokes_t1, pokes_t2, item));
			b.executar(treinador_1, treinador_2, item);
		}
		mapa.para_direita();
		a = mapa.check();
		if (a == 0);
		if (a == 1) { //batalha contra pokemon wild
			b.adicionarEvento(b.new Iniciar2(treinador_1, wildpok, pokes_t1, magikarp, item));
			b.executar(treinador_1, wildpok, item);
			wildpok.getPokemon(0).calcHP(-175, "Item"); //deve-se restaurar o HP do Magikarp ao final de cada batalha para que na proxima batalha ele inicie com HP maximo, como se nada tivesse acontecido
		}
		if (a == 2) { //batalha contra treinador
			b.adicionarEvento(b.new Iniciar(treinador_1, treinador_2, pokes_t1, pokes_t2, item));
			b.executar(treinador_1, treinador_2, item);
		}
		mapa.para_direita();
		a = mapa.check();
		if (a == 0);
		if (a == 1) { //batalha contra pokemon wild
			b.adicionarEvento(b.new Iniciar2(treinador_1, wildpok, pokes_t1, magikarp, item));
			b.executar(treinador_1, wildpok, item);
			wildpok.getPokemon(0).calcHP(-175, "Item"); //deve-se restaurar o HP do Magikarp ao final de cada batalha para que na proxima batalha ele inicie com HP maximo, como se nada tivesse acontecido
		}
		if (a == 2) { //batalha contra treinador
			b.adicionarEvento(b.new Iniciar(treinador_1, treinador_2, pokes_t1, pokes_t2, item));
			b.executar(treinador_1, treinador_2, item);
		}
		mapa.para_cima();
		a = mapa.check();
		if (a == 0);
		if (a == 1) { //batalha contra pokemon wild
			b.adicionarEvento(b.new Iniciar2(treinador_1, wildpok, pokes_t1, magikarp, item));
			b.executar(treinador_1, wildpok, item);
			wildpok.getPokemon(0).calcHP(-175, "Item"); //deve-se restaurar o HP do Magikarp ao final de cada batalha para que na proxima batalha ele inicie com HP maximo, como se nada tivesse acontecido
		}
		if (a == 2) { //batalha contra treinador
			b.adicionarEvento(b.new Iniciar(treinador_1, treinador_2, pokes_t1, pokes_t2, item));
			b.executar(treinador_1, treinador_2, item);
		}
		mapa.para_esquerda();
		a = mapa.check();
		if (a == 0);
		if (a == 1) { //batalha contra pokemon wild
			b.adicionarEvento(b.new Iniciar2(treinador_1, wildpok, pokes_t1, magikarp, item));
			b.executar(treinador_1, wildpok, item);
			wildpok.getPokemon(0).calcHP(-175, "Item"); //deve-se restaurar o HP do Magikarp ao final de cada batalha para que na proxima batalha ele inicie com HP maximo, como se nada tivesse acontecido
		}
		if (a == 2) { //batalha contra treinador
			b.adicionarEvento(b.new Iniciar(treinador_1, treinador_2, pokes_t1, pokes_t2, item));
			b.executar(treinador_1, treinador_2, item);
		}
	}
}
