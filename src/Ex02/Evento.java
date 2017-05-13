package Ex02;

abstract public class Evento {
	abstract public void acao();
	abstract public String descricao();
	abstract public int getPrioridade();
	abstract public Trainer getAtacante();
	abstract public Trainer getDefesa();
	abstract public int getA();
}