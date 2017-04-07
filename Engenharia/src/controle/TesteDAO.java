package controle;

import java.util.ArrayList;

import modelo.Partida;
import modelo.Peca;

public class TesteDAO {
	public static void main(String[] args) {
		DAO dao = new DAO();
		ArrayList<Peca> pecas;
		
		Partida partida = dao.resgatarPartida(39);
		
		System.out.println(partida.participantes.get(0).getNome());
		pecas = partida.participantes.get(0).getPecas();
		
		for (Peca peca : pecas) {
			System.out.print(peca.getValor1() + " " + peca.getValor2() +" x = " + peca.posicaoX + " y = " + peca.posicaoY + " rotação = " + peca.rotacao+"\n");
		}
		
		System.out.println();
		
		System.out.println(partida.participantes.get(1).getNome());
		pecas = partida.participantes.get(1).getPecas();
		
		for (Peca peca : pecas) {
			System.out.print(peca.getValor1() + " " + peca.getValor2() +" x = " + peca.posicaoX + " y = " + peca.posicaoY + " rotação = " + peca.rotacao+"\n");
		}
		
		System.out.println();
		
		System.out.println(partida.participantes.get(2).getNome());
		pecas = partida.participantes.get(2).getPecas();
		
		for (Peca peca : pecas) {
			System.out.print(peca.getValor1() + " " + peca.getValor2() +" x = " + peca.posicaoX + " y = " + peca.posicaoY + " rotação = " + peca.rotacao+"\n");
		}
		
		System.out.println();
		
		System.out.println(partida.participantes.get(3).getNome());
		pecas = partida.participantes.get(3).getPecas();
		
		for (Peca peca : pecas) {
			System.out.print(peca.getValor1() + " " + peca.getValor2() +" x = " + peca.posicaoX + " y = " + peca.posicaoY + " rotação = " + peca.rotacao+"\n");
		}
		
		System.out.println();
		
		pecas = partida.pecas_dormidas;
		System.out.println("Peças dormidas");
		for (Peca peca : pecas) {
			System.out.print(peca.getValor1() + " " + peca.getValor2() +" x = " + peca.posicaoX + " y = " + peca.posicaoY + " rotação = " + peca.rotacao+"\n");
		}

		System.out.println();
		
		pecas = partida.pecas_dormidas;
		System.out.println("Peças campo");
		for (Peca peca : pecas) {
			System.out.print(peca.getValor1() + " " + peca.getValor2() +" x = " + peca.posicaoX + " y = " + peca.posicaoY + " rotação = " + peca.rotacao+"\n");
		}
		System.out.println();
		
		

	}
}
