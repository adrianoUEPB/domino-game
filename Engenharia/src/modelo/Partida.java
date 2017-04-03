package modelo;

import java.util.ArrayList;

public class Partida {
	private int id_partida;
	public int id_lastWin; //flag para identificar ultimo participante ganhador
	public int[] pontuacao_jogadores;
	public ArrayList<Participante> participantes;
	public ArrayList<Peca> pecas_campo;
	public ArrayList<Peca> pecas_dormidas;
	public Peca primeiraPecaJogada;
	public int extremidade1;
	public Peca ext1Peca;
	public int extremidade2;
	public Peca ext2Peca;
	public int rodada;
	public int jogadorDaVez;
	private Peca ultima_peca;
	private boolean dificil;	
	public int tempoPartida; //teste

	public Partida(ArrayList<Participante> participantes, boolean dificil){
		this.participantes = participantes;
		pontuacao_jogadores = new int[]{0,0,0,0};
		rodada = 1;
		pecas_dormidas = new ArrayList<Peca>();
		pecas_campo = new ArrayList<Peca>();
		jogadorDaVez = 0;
		id_lastWin = -1;
		this.dificil = dificil;
	}
	
	public void criarPartida(){
		pecas_campo.clear();
		pecas_dormidas.clear();
		for (Participante p: participantes){
			p.setPecas(new ArrayList<Peca>());
		}
		
		for (int valor1 = 0; valor1 <= 6; valor1++) {
			for (int valor2 = valor1; valor2 <= 6; valor2++) {
				Peca peca = new Peca(valor1, valor2, false);
				pecas_dormidas.add(peca);
			}
		}
	}
	
	/**
	 * firstBegin() eh o metodo reponsavel pelo inicio do jogo sem pecas dormidas.
	 * O metodo ira verificar qual jogador que possui o carrocao de 6
	 * O jogador que possuir este carrocao ira comecar jogando
	 * @return Participante
	 */
	
	public Participante firstBegin() {
		for (Participante participante : participantes) {
			if(participante.verificaCarrocao()){
				return participante;
			}
			jogadorDaVez++;
		}
		return null;		
	}
	
	/**
	 * Verifica na lista de participantes o que nao possui pecas
	 * Aquele que nao possuir sera o vencedor
	 * Se ainda possuir pecas retorna null
	 * @param participantes
	 * @return Participante
	 * @return null
	 */
	
	public Participante checkWinner() {
		int id = 0;
		for (Participante participante : participantes) {
			if(participante.noHasPeca()) {
				int pontos = this.pontuacao();
				pontuacao_jogadores[id] += pontos;
				participante.setPontuacao(participante.getPontuacao() + pontos);
				participante.setPartidas_vencidas(1);
				rodada++;
				id_lastWin = id;
				return participante;
			}
			id++;
		}
		
		return null;		
	}
	
	public Participante checkEmpate() {
		
		int[] pontos = new int[]{0,0,0,0};
		int id = -1;
		int menorValor = 9999;
		int idVencedor = -1;
		Participante vencedor = null;
		
		for (Participante participante : participantes) {
			id++;
			for (Peca p : participante.getPecas()){
				pontos[id] += p.getValor1();
				pontos[id] += p.getValor2();
			}
			if (pontos[id] < menorValor){
				idVencedor = id;
				menorValor = pontos[id];
				vencedor = participante;
			}
		}
		
		pontuacao_jogadores[idVencedor] += 1;
		vencedor.setPontuacao(vencedor.getPontuacao() + 1);
		rodada++;
		id_lastWin = idVencedor;
		
		return vencedor;		
	}
	
	public int pontuacao() {
	//private int pontuacao() {
		
		// se venceu com carroção
		if (ultima_peca.getValor1() == ultima_peca.getValor2()){
			// cruzada
			if (extremidade1 == ultima_peca.getValor1() && extremidade2 == ultima_peca.getValor2()){
				return 6;
			}
			// batida carroção
			if (extremidade1 == ultima_peca.getValor1() && extremidade2 != ultima_peca.getValor2() ||
				extremidade1 != ultima_peca.getValor1() && extremidade2 == ultima_peca.getValor2()){
				return 2;
			}
		// se venceu com peça normal
		} else {
			// lá e ló
			if (extremidade1 == ultima_peca.getValor1() && extremidade2 == ultima_peca.getValor2() ||
				extremidade2 == ultima_peca.getValor1() && extremidade1 == ultima_peca.getValor2() ||
				extremidade1 == ultima_peca.getValor1() && extremidade2 == ultima_peca.getValor1() ||
				extremidade1 == ultima_peca.getValor2() && extremidade2 == ultima_peca.getValor2()){
				return 3;
			}
			// batida normal
			if (extremidade1 == ultima_peca.getValor1() && extremidade2 != ultima_peca.getValor2() ||
				extremidade1 != ultima_peca.getValor1() && extremidade2 == ultima_peca.getValor2() ||
				extremidade2 == ultima_peca.getValor1() && extremidade1 != ultima_peca.getValor2() ||
				extremidade2 != ultima_peca.getValor1() && extremidade1 == ultima_peca.getValor2()){
				return 1;
			}
		}		
		return 0;		
	}
	
	public int checkNext(int id) {
		if (id == 3)
			return 0;
		
		return ++id;
	}
	
	public void setUltima_peca(Peca peca) {
		this.ultima_peca = peca;
	}
	
	public boolean isDificil(){
		return dificil;
	}
	
	public int getId_partida() {
		return id_partida;
	}
	public void setId_partida(int id_partida) {
		this.id_partida = id_partida;
	}
}
