package controle;

import java.io.IOException;
import java.util.ArrayList;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import modelo.Jogador;

public class PDFRanking {

		public static void gerarPDFRanking() throws IOException {
		
			DAO dao = new DAO();
			ArrayList<Jogador> listaJogadores = dao.pdfDAO();
	
			PDDocument document = new PDDocument();
			
			PDPage page = new PDPage(PDRectangle.A4);
			document.addPage( page );
			
			PDFont font = PDType1Font.HELVETICA_BOLD;

			PDPageContentStream contentStream = new PDPageContentStream(document, page);

		// Define a text content stream using the selected font, moving the cursor and drawing the text "Hello World"
			int y = 0;
			contentStream.beginText();
			contentStream.setFont( font, 12 );

			contentStream.newLineAtOffset(40, 800);
			contentStream.showText("Icone                Nome            Pontuação            "
					+ "Vitórias            Tempo          Data ");
			contentStream.endText();
			y = y - 30;
			
			PDImageXObject img;
			String pathIcon = null;
			
			for (Jogador jogador : listaJogadores) {
				
				pathIcon = jogador.getIcone();
				pathIcon = pathIcon.replace("\\","/").substring(0, pathIcon.length()); 
				img = PDImageXObject.createFromFile(pathIcon, document);
				contentStream.drawImage(img, 40, y, 15, 15);
				
				contentStream.beginText();
				contentStream.setFont( font, 12 );
				contentStream.newLineAtOffset(100, y );
				contentStream.showText("        "
				+jogador.getNome()+"        "+jogador.getPontuacao()
				+"         "+jogador.getPartidas_vencidas()+"         "
				+jogador.getTempo_rodadas()+"        "+jogador.getUltima_partida());
				contentStream.endText();
				y = y - 15;	
			}		
			// Make sure that the content stream is closed:
			contentStream.close();		
			// Save the results and ensure that the document is properly closed:
			document.save(System.getProperty("user.home")+"/Desktop/testeDePDF2.pdf");
			document.close();	
	}
}
