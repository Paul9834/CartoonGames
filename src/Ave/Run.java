package Ave;


import java.util.Timer;
import java.util.TimerTask;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Run extends Scene implements EventHandler<KeyEvent> {

	private Personaje personaje;
	private Obstaculo obstaculo;
	private Canvas canvasLevel;
	private Image fondo;
	private Image gameOver;
	private Image vida;
	private Image reiniciar;
	private Image menu;
	private GraphicsContext grafico;
	private boolean perdio;
	private boolean iniciar; 
	private Button inicio;
	private int personaje2= 0;
	private Button regresar;
	private int scena=0;
	private double puntaje=0;


	public Run(Group root) {
		super(root);
		regresar= new Button();
		ImageView regre = new ImageView(new Image("Pong/regresar.png",30,30,true,false));
		regresar.setGraphic(regre);
		regresar.setLayoutX(950);
		perdio=false;
		iniciar= false;
		personaje = new Personaje();
		obstaculo=new Obstaculo();
	    canvasLevel = new Canvas(1000,500);
		fondo = new Image("Ave/fondoJuego.jpg",2500,700,true,false);
		gameOver = new Image("Ave/giphy.gif",1100,800,true,false);
		vida= new Image ("Ave/corazon.png",20,20,true,false);
		reiniciar=new Image ("Ave/ENTER.png",300,200,true,false);
		menu= new Image("Ave/men.png",1000,800,true, false);
		inicio= new Button();
		ImageView iv= new ImageView(vida);
		inicio.setGraphic(iv);
		root.getChildren().addAll(canvasLevel,regresar);
		grafico=canvasLevel.getGraphicsContext2D();
		
     

		this.setOnKeyPressed(this);
	}
	public Button getRegresar() {
		return regresar;
	}
	public void setRegresar(Button regresar) {
		this.regresar = regresar;
	}
	public void runlevel() { 


		new AnimationTimer() {

		

			public void handle(long arg0) {
				
			 
				
			if(scena==1) {
				puntaje();

					pintar1();
				if (perdio==true) {
					perdio();
				}
				if (personaje.getPosy()+150>=obstaculo.getPosy()&& personaje.getPosx()+150>obstaculo.getPosx()&& personaje.getPosx()<obstaculo.getPosx()+100) {
                     System.out.println("si");      
					restarVida();
					
				}
		
						
				if (personaje.getVida()>=75) {
					grafico.drawImage(vida, 85 , 37);
					grafico.drawImage(vida, 105 , 37);
					grafico.drawImage(vida, 125 , 37);
					grafico.drawImage(vida, 145 , 37);
					
				}
				if (personaje.getVida()>=50 ) {
					grafico.drawImage(vida, 85 , 37);
					grafico.drawImage(vida, 105 , 37);
					grafico.drawImage(vida, 125 , 37);


				}
				if (personaje.getVida()>=25 ) {
					grafico.drawImage(vida, 85 , 37);
					grafico.drawImage(vida, 105 , 37);




				}
				if (personaje.getVida()>=0) {
					grafico.drawImage(vida, 85 , 37);


				}
				else {
					perdio=true;
				}
				


				if(obstaculo.getPosx()>-400) {

					obstaculo.moverIzquierda();


				}
				else  {
					obstaculo.setPosx(1000);
				}
			}
			else {
				stop();
			}
			}

		}.start();
	}

	@Override
	public void handle(KeyEvent event) {


		if(event.getCode().equals(KeyCode.ENTER) && event.getEventType().equals(KeyEvent.KEY_PRESSED)){
			if (iniciar==false) {
				iniciar=true;
				puntaje=0;
			}
			perdio=false;
			personaje.setVida(100);
		

 
			
			
		}
		if(event.getCode().equals(KeyCode.UP) && event.getEventType().equals(KeyEvent.KEY_PRESSED)){
		

			try {
				personaje.setTime(0);
				personaje.saltar();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	


	}
	public void pintar1() {



		grafico.drawImage(fondo,0,0);
		grafico.drawImage(personaje.getPlayer(personaje2),personaje.getPosx(),personaje.getPosy());
		grafico.drawImage (obstaculo.getObstaculo(),obstaculo.getPosx(),obstaculo.getPosy());
		grafico.fillText("PUNTAJE: "+(long) puntaje,800, 20);

		grafico.fillText("VIDA: ", 50, 50);
		
	}

	public double getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	public void perdio() {

		grafico.drawImage(gameOver, 0, 0);
		grafico.drawImage(reiniciar, 750, 420);

	}
public void puntaje  () {
	
		   puntaje=puntaje+0.05;
			  
			  
			   }   
	 

	public void menu() {                                          
		
		grafico.drawImage(menu, 0, 0);

        
	} 
	public void restarVida() {
		personaje.setVida(personaje.getVida()-1 ); 
		
	}

	public int getPersonaje2() {
		return personaje2;
	}
	public void setPersonaje2(int personaje2) {
		this.personaje2 = personaje2;
	}


	public int getScena() {
		return scena;
	}
	public void setScena(int scena) {
		this.scena = scena;
	}
}

