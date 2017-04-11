package controle;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import modelo.Jogador;

public class PDFRanking {

		public static void gerarPDFRanking() throws IOException, DocumentException {
		
			DAO dao = new DAO();
			ArrayList<Jogador> listaJogadores = dao.pdfDAO();
	
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream("C:\\teste.pdf"));
			
			document.open();
			document.setPageSize(PageSize.A4);
			Paragraph paragrafo = new Paragraph("Relatório PDF jogo dominó");
			document.add(paragrafo);
			
			
			
			PdfPTable tabela = new PdfPTable(6);
			PdfPCell cabecalho = new PdfPCell(new Paragraph("Ranking geral"));
			cabecalho.setColspan(6);
			cabecalho.setHorizontalAlignment(Element.ALIGN_CENTER);
			cabecalho.setBackgroundColor(BaseColor.RED);
			tabela.addCell(cabecalho);
			tabela.addCell("Icone");
			tabela.addCell("Nome");
			tabela.addCell("Pontuação");
			tabela.addCell("Vitórias");
			tabela.addCell("Tempo");
			tabela.addCell("Data");
			
			String pathIcon = null;
			
			for (Jogador jogador : listaJogadores) {
				
				pathIcon = jogador.getIcone();
				pathIcon = pathIcon.replace("\\","/").substring(0, pathIcon.length());
				Image img = Image.getInstance(pathIcon);				
				tabela.addCell(img);
				
				tabela.addCell(jogador.getNome());
				tabela.addCell(String.valueOf(jogador.getPontuacao()));
				tabela.addCell(String.valueOf(jogador.getPartidas_vencidas()));
				tabela.addCell(transformarTempo(jogador.getTempo_rodadas()));
				tabela.addCell(jogador.getUltima_partida());
			}
			
			document.add(tabela);
			document.close();	
			JOptionPane.showMessageDialog(null, "PDF gerado em C:/teste.pdf");
	}
		
	private static String transformarTempo(int num) {
		int hora, min, seg;
		seg = num % 60;
		min = num / 60;
		hora = min / 60;
		
		return String.format("%02d:%02d:%02d", hora, min, seg);		
	}
}
