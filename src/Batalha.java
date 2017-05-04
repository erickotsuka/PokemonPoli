
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
