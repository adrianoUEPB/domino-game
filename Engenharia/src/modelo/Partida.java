package modelo;

import java.util.ArrayList;


public class Partida {
	private int id_partida;
	public int id_lastWin; //flag para identificar ultimo participante ganhador
	public int[] pontuacao_jogadores;
	public ArrayList<Participante> participantes;
	public ArrayList<Peca> pecas_campo;
	public ArrayList<Peca> pecas_dormidas;
	public int extremidade1;
	public int extremidade2;
	public int rodada;
	public int jogadorDaVez;
	private Peca ultima_peca;

	
	public Partida(ArrayList<Participante> participantes){
		this.participantes = participantes;
		pontuacao_jogadores = new int[]{0,0,0,0};
		rodada = 1;
		pecas_dormidas = new ArrayList<Peca>();
		pecas_campo = new ArrayList<Peca>();
		jogadorDaVez = 0;
		id_lastWin = -1;
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
		int id = -1;
		for (Participante participante : participantes) {
			
			int pontos = this.pontuacao();
			id++;
			
			pontuacao_jogadores[id] += pontos;
			
			if(participante.noHasPeca()) {				
				participante.setPontuacao(participante.getPontuacao() + pontos);		
				id_lastWin = id;
				return participante;
			}
		}
		
		return null;		
	}
	
	private int pontuacao() {
		if (extremidade1 == ultima_peca.getValor1() && extremidade2 != ultima_peca.getValor1()
				&& extremidade1 != ultima_peca.getValor2() && extremidade2 != ultima_peca.getValor2())
			return 1;
		
		if (extremidade1 == ultima_peca.getValor1() && extremidade2 != ultima_peca.getValor1()
				&& ultima_peca.getValor1() == ultima_peca.getValor2() || 
				extremidade2 == ultima_peca.getValor1() && extremidade1 != ultima_peca.getValor1()
				&& ultima_peca.getValor1() == ultima_peca.getValor2())
			return 1;
		
		if (extremidade1 == ultima_peca.getValor1() && extremidade2 != ultima_peca.getValor1()
				&& extremidade1 != ultima_peca.getValor2() && extremidade2 == ultima_peca.getValor2())
			return 3;
		
		if (extremidade1 == extremidade2 && extremidade2 == ultima_peca.getValor1()
				&& ultima_peca.getValor1() == ultima_peca.getValor2())
			return 6;
		
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
	
	public int getId_partida() {
		return id_partida;
	}
	public void setId_partida(int id_partida) {
		this.id_partida = id_partida;
	}
}
