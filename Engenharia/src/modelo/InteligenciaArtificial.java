package modelo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class InteligenciaArtificial extends Participante {

	private boolean dificil;
	// aqui a IA guarda a contagem das peças, o ID significa o valor da peça
	private int[] contagemPecasTotal; // = new int[]{0,0,0,0,0,0,0};
	private int[] contagemPecasMao; // = new int[]{0,0,0,0,0,0,0};
	private Set<String> pecasConhecidas = new HashSet<String>();
	// aqui a IA lembra as peças que o seu alvo (jogador q joga depois dele) não possui
	// de princípio, a IA supõe que o jogador possui todos os valores
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
		
		// todas as peças que a IA pode jogar, levando em consideração as extremidades
		ArrayList<Peca> possiveisEscolhas = new ArrayList<Peca>();
		for (Peca p: super.getPecas()){
			if (p.getValor1() == part.extremidade1 || p.getValor1() == part.extremidade2 ||
				p.getValor2() == part.extremidade1 || p.getValor2() == part.extremidade2){
				
				possiveisEscolhas.add(p);
			}
		}
		// a prioridade será fazer o alvo passar a vez
		for (Peca p: possiveisEscolhas){
			// se alvo não possui nenhuma peça com os valores das duas extremidades
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
		// se alvo possui peças com as duas extremidades, vai fazer contagem planejada
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
		// vai jogar a peça com maior valor, mas irá ignorar as peças que poderiam fechar o alvo nas próximas jogadas
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
		// caso nenhuma das opções acima deram certo, jogará a peça com maior valor númerico
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

		// atualiza conhecimento das peças na mão
		for (Peca p: super.getPecas()){
			String peca = "" + p.getValor1() + p.getValor2();
			contagemPecasMao[p.getValor1()]++;
			contagemPecasMao[p.getValor2()]++;
			contagemPecasTotal[p.getValor1()]++;
			contagemPecasTotal[p.getValor2()]++;
			pecasConhecidas.add(peca);
		}
		
		// atualiza conhecimento das peças no campo
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
}



