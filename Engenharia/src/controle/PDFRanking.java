package controle;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.io.File;
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

		public void gerarPDFRanking(File path, Jogador emissor) throws IOException, DocumentException {
		
			DAO dao = new DAO();
			ArrayList<Jogador> listaJogadores = dao.pdfDAO();
	
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(path));
			
			document.open();
			document.setPageSize(PageSize.A4);
			Image topo = Image.getInstance("C:\\Domino\\domino-game\\Engenharia\\image\\graphics\\domino_pdf.png");
			topo.scaleToFit(420, 420);
			topo.setAlignment(Element.ALIGN_CENTER);
			document.add(topo);
			
			document.add(new Paragraph(" "));
			
			DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			java.util.Date hoje = new java.util.Date();	
			Paragraph info = new Paragraph("Documento gerado em " + String.valueOf(formato.format(hoje)));
			info.setAlignment(Element.ALIGN_CENTER);
			Paragraph jogador_logado = new Paragraph("Por " + emissor.getNome());
			jogador_logado.setAlignment(Element.ALIGN_CENTER);
			
			document.add(info);
			document.add(jogador_logado);
			
			document.add(new Paragraph(" "));
			
			PdfPTable tabela = new PdfPTable(7);
			tabela.setHorizontalAlignment(Element.ALIGN_CENTER);
			float[] tams = {0.05f, 0.05f, 0.4f, 0.06f, 0.06f, 0.13f, 0.17f}; 
			tabela.setWidths(tams);
			
			PdfPCell C = new PdfPCell(new Paragraph("C"));
			C.setHorizontalAlignment(Element.ALIGN_CENTER);
			C.setBackgroundColor(BaseColor.GRAY);
			tabela.addCell(C);
			
			PdfPCell I = new PdfPCell(new Paragraph("I"));
			I.setHorizontalAlignment(Element.ALIGN_CENTER);
			I.setBackgroundColor(BaseColor.GRAY);
			tabela.addCell(I);
			
			PdfPCell nome = new PdfPCell(new Paragraph("Nome"));
			nome.setHorizontalAlignment(Element.ALIGN_CENTER);
			nome.setBackgroundColor(BaseColor.GRAY);
			tabela.addCell(nome);
			
			PdfPCell pont = new PdfPCell(new Paragraph("P"));
			pont.setHorizontalAlignment(Element.ALIGN_CENTER);
			pont.setBackgroundColor(BaseColor.GRAY);
			tabela.addCell(pont);
			
			PdfPCell PV = new PdfPCell(new Paragraph("V"));
			PV.setHorizontalAlignment(Element.ALIGN_CENTER);
			PV.setBackgroundColor(BaseColor.GRAY);
			tabela.addCell(PV);
			
			PdfPCell Tempo = new PdfPCell(new Paragraph("Tempo"));
			Tempo.setHorizontalAlignment(Element.ALIGN_CENTER);
			Tempo.setBackgroundColor(BaseColor.GRAY);
			tabela.addCell(Tempo);
			
			PdfPCell Data = new PdfPCell(new Paragraph("Data"));
			Data.setHorizontalAlignment(Element.ALIGN_CENTER);
			Data.setBackgroundColor(BaseColor.GRAY);
			tabela.addCell(Data);
			
			String pathIcon = null;
			int posicao = 0;
			for (Jogador jogador : listaJogadores) {				
				
				posicao++;
				PdfPCell pos = new PdfPCell(new Paragraph(String.valueOf(posicao)));
				pos.setHorizontalAlignment(Element.ALIGN_CENTER);
				tabela.addCell(pos);
				
				pathIcon = jogador.getIcone();
				pathIcon = pathIcon.replace("\\","/").substring(0, pathIcon.length());
				Image img = Image.getInstance(pathIcon);
				
				tabela.addCell(img);
				
				tabela.addCell(jogador.getNome());
				
				PdfPCell pontuacao = new PdfPCell(new Paragraph(String.valueOf(jogador.getPontuacao())));
				pontuacao.setHorizontalAlignment(Element.ALIGN_CENTER);
				tabela.addCell(pontuacao);
				
				PdfPCell partidas_vencidas = new PdfPCell(new Paragraph(String.valueOf(String.valueOf(jogador.getPartidas_vencidas()))));
				partidas_vencidas.setHorizontalAlignment(Element.ALIGN_CENTER);
				tabela.addCell(partidas_vencidas);
				
				PdfPCell tempo = new PdfPCell(new Paragraph(transformarTempo(jogador.getTempo_rodadas())));
				tempo.setHorizontalAlignment(Element.ALIGN_CENTER);
				tabela.addCell(tempo);
				
				PdfPCell ult_partida = new PdfPCell(new Paragraph(jogador.getUltima_partida()));
				ult_partida.setHorizontalAlignment(Element.ALIGN_CENTER);
				tabela.addCell(ult_partida);
			}
			

		
			document.add(tabela);
			document.close();	
			JOptionPane.showMessageDialog(null, "PDF gerado em " + path);
	}
		
	private String transformarTempo(int num) {
		int hora, min, seg;
		seg = num % 60;
		min = num / 60;
		hora = min / 60;
		
		return String.format("%02d:%02d:%02d", hora, min, seg);		
	}
}
