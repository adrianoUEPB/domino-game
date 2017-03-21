package teste;

import controle.*;
import modelo.Jogador;

public class TestUpdate {
	public static void main(String[] args) {
		DAO dao = new DAO();
//		System.out.println("procurando");
		Jogador antigo = dao.findJogador("Eleonorarr");
		
		System.out.println(antigo.getId());
		System.out.println(antigo.getNome());
		Jogador novo = new Jogador();
		novo.setNome("Adriano3");
		novo.setIcone(antigo.getIcone());
		novo.setSenha(antigo.getSenha());
		
		dao.updateJogador(novo, antigo);

		
	}
}
