package exercicio_2;

class ConjuntoEventos {
	private static final int MAX_EVENTOS = 100;
	private Evento[] eventos = new Evento[MAX_EVENTOS];
	private int indice = 0;
	private int proximo = 0;
	public void add(Evento e) {
		if(indice >= eventos.length)
			return;
		eventos[indice++] = e;
	}
	public Evento pegaProximo() {
		boolean looped = false;
		int inicio = proximo;
		do {
			proximo = (proximo + 1) % eventos.length;
			if (inicio == proximo)
				looped = true;
			if ((proximo == (inicio + 1) % eventos.length) && looped)
				return null;
		} while (eventos[proximo] == null);
		return eventos[proximo];
	}
	public void removeAtual() {
		eventos[proximo] = null;
	}
	public int getIndice () {
		return indice;
	}
	public Evento[] getEnd() {
		return eventos;
	}
	public void checkPrioridade () {
		Evento temp;
		if (eventos[proximo + 1].getPrioridade() > eventos[proximo + 2].getPrioridade()) {
		}
		if (eventos[proximo + 1].getPrioridade() < eventos[proximo + 2].getPrioridade()) {
			temp = eventos[proximo + 1];
			eventos[proximo + 1] = eventos[proximo + 2];
			eventos[proximo + 2] = temp;
		}
		if (eventos[proximo + 1].getPrioridade() == 4 && eventos[proximo + 2].getPrioridade() == 4) { //os dois sao ataques
			if (eventos[proximo + 1].getAtacante().getPokemon(0).getAtaque(eventos[proximo + 1].getA()).getPrioridade() < eventos[proximo + 2].getAtacante().getPokemon(0).getAtaque(eventos[proximo + 2].getA()).getPrioridade()) {
				temp = eventos[proximo + 1];
				eventos[proximo + 1] = eventos[proximo + 2];
				eventos[proximo + 2] = temp;
			}
		}
	}
}

public class Controlador {
	private static boolean finalizou = false;
	private ConjuntoEventos ce = new ConjuntoEventos();
	public void adicionarEvento(Evento c) {ce.add(c); }
	public boolean nenhum_vivo(Trainer treinador) {
		for (int i = 0; i < 6; i++) {
			if (treinador.getPokemon(i).getHP() > 0)
				return false;
		}
		finalizou = true;
		return true;
	}
	public void trocaPokemon (Trainer treinador) { //troca o pokemon caso o atual morra (o substituto executa a acao que o falecido executaria)
		Pokemon temp;
		if (treinador.getPokemon(0).getHP() <= 0) {
			for (int i = 1; i < 6; i++) {
				if (treinador.getPokemon(i).getHP() > 0) {
					temp = treinador.getPokemon(0);
					treinador.setPokemon(treinador.getPokemon(i), 0);
					treinador.setPokemon(temp, i);
					break;
				}
			}
		}
	}
	public boolean finalizou () {
		return finalizou;
	}
	public void executar(Trainer treinador_1, Trainer treinador_2, Item potion) {
		int i = 0;
		Evento e;
		while((e = ce.pegaProximo()) != null) {
			if (!finalizou) {
				if (treinador_1.getFinalizou() || treinador_2.getFinalizou()) {
					treinador_1.finalizouFalse();
					treinador_2.finalizouFalse();
					break;
				}
				e.acao();
				System.out.println(e.descricao());
				ce.removeAtual();
				trocaPokemon(treinador_1);
				trocaPokemon(treinador_2);
				if (nenhum_vivo(treinador_1)) {
					System.out.println ("Vitoria do treinador " + treinador_2.getNome());
				}
				if (nenhum_vivo(treinador_2)) {
					System.out.println ("Vitoria do treinador " + treinador_1.getNome());
				}
			} else {
				break;
			}
			if (++i % 2 != 0 && !finalizou) {
				ce.checkPrioridade ();
			}
		}
	}
}