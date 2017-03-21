package teste;

import controle.DAO;

public class TesteDelete {
	
	public TesteDelete() {
		DAO dao = new DAO();
		dao.deleteJogador("lilica");
	}
	
	public static void main(String[] args) {
		new TesteDelete();
	}
}
