package controle;

import java.util.ArrayList;

import modelo.Jogador;

public class TesteDAO {
	public static void main(String[] args) {
		DAO dao = new DAO();
		
		ArrayList<Jogador> jogador = dao.rankingDAO();
		
		for (Jogador jogador2 : jogador) {
			if (jogador2.getPontuacao() == 0) {
				
			} else {
			System.out.println(jogador2.getNome() + " " + jogador2.getPontuacao() + " " + jogador2.getTempo_rodadas() + " "  + jogador2.getPartidas_vencidas());
			}
		}
	}
}
