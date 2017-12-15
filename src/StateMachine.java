import java.util.ArrayList;

public class StateMachine {

	String nome;
	int num_estados;
	int num_transicoes;
	int est_final;
	int est_atual;
	int est_prox;
	int transicao_atual;
	Transicao transicoes[];
	
	public StateMachine() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean run(ArrayList<Token> tokens) {
		return true;
	}

}
