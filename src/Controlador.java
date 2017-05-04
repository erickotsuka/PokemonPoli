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
}

public class Controlador {
	private ConjuntoEventos ce = new ConjuntoEventos();
	public void adicionarEvento(Evento c) {ce.add(c); }
	public void executar() {
		Evento e;
		while((e = ce.pegaProximo()) != null) {
			e.acao();
			System.out.println(e.descricao());
			ce.removeAtual();
		}
	}
}
