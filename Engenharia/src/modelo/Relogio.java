package modelo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.Timer;


public class Relogio {

	 int horas, minutos, segundos; //* 
	static int dias;
	 static DecimalFormat formato;
	 String horario;
	 
	 /*
	 public static void main(String[] args) {
		
		 Relogio relogio = new Relogio();
		 
		 while(true){
			 System.out.println("Horário: "+formatar(relogio.horas)+":"+formatar(relogio.minutos)+":"+formatar(relogio.segundos)+"    dia = "+relogio.dias);
		 }
	}
	*/
	
	public Relogio() {
		
		this.horario = "";
		this.segundos = 0;
    	this.minutos = 0;
    	this.horas = 0;
    	this.dias = 1;
    	
    	Timer time = new Timer(1000,ativar);  
        time.start();
		
	}
	
	private void HORAS(){ 
        
        horario = "Horário: "+formatar(horas)+":"+formatar(minutos)+":"+formatar(segundos);
    	
        //incrementa os minutos
    	if(segundos == 60){
    		segundos = 0;
    		minutos = minutos + 1;
    	}
    	
    	//incrementa a hora
    	if(minutos == 60){
    		minutos = 0;
    		horas = horas + 1;
//    		TelaPrincipal.panelPrincipal.barraDeEnergia.setValue(TelaPrincipal.panelPrincipal.barraDeEnergia.getValue() - 10);
//    		TelaPrincipal.panelPrincipal.barraDeFome.setValue(TelaPrincipal.panelPrincipal.barraDeFome.getValue() - 10);
//    		TelaPrincipal.panelPrincipal.barraDeEstudos.setValue(TelaPrincipal.panelPrincipal.barraDeEstudos.getValue() - 10);
//    		TelaPrincipal.panelPrincipal.barraDeFelicidade.setValue(TelaPrincipal.panelPrincipal.barraDeFelicidade.getValue() - 10);
    	}
    	
    	//incrementa o dia
    	if(horas == 24){
    		horas = 0;
    		dias = dias + 1;
    		
    		//se a idade for menor que 7 - muda as imagens e a idade
    		if(dias <= 7){
//    			TelaPrincipal.panelPrincipal.labelIdade.setText(Integer.toString(dias));
//        		TelaPrincipal.panelPrincipal.bichinhoVirtual.setIdade(dias);
//        		TelaPrincipal.panelPrincipal.labelDaImagemGIF.setIcon(new ImageIcon(getClass().getResource(TelaPrincipal.panelPrincipal.imagemDoGif())));
    		} else {
    			
    			//função para determinar se o tamagotchi vira um anjo ou um demônio
				//esta valor vai de 0 a 100
//				int julgamentoFinal = TelaPrincipal.panelPrincipal.bichinhoVirtual.morte();
				
//				if(julgamentoFinal < 50){
//					TelaPrincipal.panelPrincipal.labelDaImagemGIF.setIcon(new ImageIcon(getClass().getResource("/img/demonio.gif")));
//					TelaPrincipal.panelPrincipal.botaoAlimentar.setEnabled(false);
//					TelaPrincipal.panelPrincipal.botaoLigarDesligarLuz.setEnabled(false);
//					TelaPrincipal.panelPrincipal.botaoEstudar.setEnabled(false);
//					TelaPrincipal.panelPrincipal.botaoBrincar.setEnabled(false);
					
//				} else {
//					TelaPrincipal.panelPrincipal.labelDaImagemGIF.setIcon(new ImageIcon(getClass().getResource("/img/Anjinho.gif")));
//					TelaPrincipal.panelPrincipal.botaoAlimentar.setEnabled(false);
//					TelaPrincipal.panelPrincipal.botaoLigarDesligarLuz.setEnabled(false);
//					TelaPrincipal.panelPrincipal.botaoEstudar.setEnabled(false);
//					TelaPrincipal.panelPrincipal.botaoBrincar.setEnabled(false);
					
//				}
    			
    		}
    	}
    	
    	//System.out.println("Horário: "+formatar(horas)+":"+formatar(minutos)+":"+formatar(segundos)+"    dia = "+dias);
//    	TelaPrincipal.panelPrincipal.labelHorario.setText(formatar(horas)+"h "+formatar(minutos)+"min "+formatar(segundos)+"seg");
//    	segundos = segundos + 1;
    	         
    }  
  
    private static String formatar(int num){  
        formato = new DecimalFormat("00");  
        return formato.format(num);  
    }  
      
    ActionListener ativar = (  
        new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                HORAS();  
            }  
          
        }  
    );
    
    public int getHoras() {
		return horas;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	public int getSegundos() {
		return segundos;
	}

	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}

	public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}
	
	public void resetarRelogio(){
		this.segundos = 0;
		this.minutos = 0;
		this.horas = 0;
		this.dias = 1;
		this.horario = "";
	}

}
