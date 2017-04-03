package modelo;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class InteligenciaArtificial extends Participante implements Runnable {

	private boolean dificil;
	// aqui a IA guarda a contagem das pe�as, o ID significa o valor da pe�a
	private int[] contagemPecasTotal; // = new int[]{0,0,0,0,0,0,0};
	private int[] contagemPecasMao; // = new int[]{0,0,0,0,0,0,0};
	private Set<String> pecasConhecidas = new HashSet<String>();
	// aqui a IA lembra as pe�as que o seu alvo (jogador q joga depois dele) n�o possui
	// de princ�pio, a IA sup�e que o jogador possui todos os valores
	private boolean[] alvoPossui = new boolean[]{true, true, true, true, true, true, true};

	public InteligenciaArtificial(String nome, String icone, boolean dificil) {
		super();
		super.setNome(nome);
		super.setIcone(icone);
		
		this.dificil = dificil;
	}

	public boolean isDificil() {
		return dificil;
	}
	public void setDificil(boolean dificil) {
		this.dificil = dificil;
	}
	public Peca jogarPecaPensada(Partida part){
		// atualiza os conhecimentos antes de pensar numa jogada
		atualizaConhecimento(part);
		
		// todas as pe�as que a IA pode jogar, levando em considera��o as extremidades
		ArrayList<Peca> possiveisEscolhas = new ArrayList<Peca>();
		for (Peca p: super.getPecas()){
			if (p.getValor1() == part.extremidade1 || p.getValor1() == part.extremidade2 ||
				p.getValor2() == part.extremidade1 || p.getValor2() == part.extremidade2){
				
				possiveisEscolhas.add(p);
			}
		}
		// a prioridade ser� fazer o alvo passar a vez
		for (Peca p: possiveisEscolhas){
			// se alvo n�o possui nenhuma pe�a com os valores das duas extremidades
			if (!alvoPossui[part.extremidade1] && !alvoPossui[part.extremidade2]){
				if (p.getValor1() == part.extremidade1 && p.getValor2() == part.extremidade2 ||
					p.getValor2() == part.extremidade1 && p.getValor1() == part.extremidade2) {
					
					return p;
				}
			// se alvo possui apenas uma das extremidades
			} else if (!alvoPossui[part.extremidade1] && alvoPossui[part.extremidade2] ||
					   !alvoPossui[part.extremidade2] && alvoPossui[part.extremidade1]) {
				if (p.getValor1() == part.extremidade2 && p.getValor2() == part.extremidade1 ||
					p.getValor2() == part.extremidade2 && p.getValor1() == part.extremidade1){
					
					return p;
				}
			}
		}
		// se alvo possui pe�as com as duas extremidades, vai fazer contagem planejada
		for (Peca p: possiveisEscolhas){
			if ((contagemPecasMao[part.extremidade1] + contagemPecasTotal[part.extremidade1]) == 7){
				if (contagemPecasMao[part.extremidade1] > 0 && contagemPecasTotal[part.extremidade1] > 0){
					return p;
				}
			} else if ((contagemPecasMao[part.extremidade2] + contagemPecasTotal[part.extremidade2]) == 7){
				if (contagemPecasMao[part.extremidade2] > 0 && contagemPecasTotal[part.extremidade2] > 0){
					return p;
				}
			}
		}
		// vai jogar a pe�a com maior valor, mas ir� ignorar as pe�as que poderiam fechar o alvo nas pr�ximas jogadas
		Peca maiorValor = null;
		for (Peca p: possiveisEscolhas){
			if (maiorValor == null){
				maiorValor = p;
			} else {
				if (!alvoPossui[p.getValor1()] || !alvoPossui[p.getValor2()]){
					int somaP = p.getValor1() + p.getValor2();
					int somaM = maiorValor.getValor1() + maiorValor.getValor2();
					if (somaP > somaM){
						maiorValor = p;
					}
				}
			}
		}
		// caso nenhuma das op��es acima deram certo, jogar� a pe�a com maior valor n�merico
		if (maiorValor == null){
			for (Peca p: possiveisEscolhas){
				if (maiorValor == null){
					maiorValor = p;
				} else {
					int somaP = p.getValor1() + p.getValor2();
					int somaM = maiorValor.getValor1() + maiorValor.getValor2();
					if (somaP > somaM){
						maiorValor = p;
					}
				}
			}
		}
		return maiorValor;
	}
	
	public void atualizaConhecimento(Partida part){
		contagemPecasMao = new int[]{0,0,0,0,0,0,0};
		contagemPecasTotal = new int[]{0,0,0,0,0,0,0};




		// atualiza conhecimento das pe�as na m�o
		for (Peca p: super.getPecas()){
			String peca = "" + p.getValor1() + p.getValor2();
			contagemPecasMao[p.getValor1()]++;
			contagemPecasMao[p.getValor2()]++;
			contagemPecasTotal[p.getValor1()]++;
			contagemPecasTotal[p.getValor2()]++;
			pecasConhecidas.add(peca);
		}
		
		// atualiza conhecimento das pe�as no campo
		for (Peca p: part.pecas_campo){
			String peca = "" + p.getValor1() + p.getValor2();
			contagemPecasTotal[p.getValor1()]++;
			contagemPecasTotal[p.getValor2()]++;
			pecasConhecidas.add(peca);
		}
	}
	
	public void alvoPassouVez(int extremidade1, int extremidade2){
		alvoPossui[extremidade1] = true;
		alvoPossui[extremidade2] = true;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}



