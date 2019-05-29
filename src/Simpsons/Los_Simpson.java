package Simpsons;
import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Los_Simpson extends Scene implements  EventHandler<KeyEvent> {

	private Bart player;
	private Homero enemigo;
	private Canvas canvasLevel;
	private Image fondo,menuImage,play,comenza,regresar;
	private Disparo piedra;
	private Button volver;
	private GraphicsContext grafico;
	private boolean perdio, disparo,menu;
	private int direccionBart;
	private ArrayList<Disparo> disparos;
	private ArrayList <Homero> enemigos;
	private GridPane juego;
	private int numeroEnemigos;
	private int cerrarRunLevel=0;
	
  


	public Los_Simpson(Group root ) {
		super(root);
		regresar= new Image("Pong/regresar.png",30,30,true,false);
		ImageView iv2 = new ImageView(regresar);
		numeroEnemigos=1;
		menu=true;
		direccionBart=0;
		volver= new Button();
		volver.setGraphic(iv2);
		disparos=new ArrayList<Disparo>();
		enemigos= new ArrayList<Homero>();
		perdio= false;
		disparo=false;
		player = new Bart();
		enemigo=new Homero(400,300);
		enemigos.add(enemigo);
		canvasLevel = new Canvas(1045,530);
		fondo = new Image("Simpsons/fono.jpg",2500,700,true,false);
		menuImage = new Image("Simpsons/menu.jpg",2500,800,true,false);
		Image play = new Image ("Simpsons/iniciar.png",200,100,true ,false);
		ImageView iv = new ImageView(play);
		juego= new GridPane(); 
		root.getChildren().addAll(canvasLevel,juego,volver);
		grafico=canvasLevel.getGraphicsContext2D();
		this.setOnKeyPressed(this);



		if(menu==true) {

			Button iniciar= new Button();
			iniciar.setGraphic(iv);
	    	
			juego.addRow(0, iniciar);
			juego.setPadding(new Insets(100,10,10,820));
			EventHandler<MouseEvent> event = new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent arg0) {

					menu=false;
					iniciar.setVisible(false);

				}	  
			};	
			iniciar.addEventHandler(MouseEvent.MOUSE_CLICKED,event);




		}
	}


	public Button getVolver() {
		return volver;
	}


	public void setCerrarRunLevel(int cerrarRunLevel) {
		this.cerrarRunLevel = cerrarRunLevel;
	}


	public void runlevel() {

		new AnimationTimer() {

			public void handle(long arg0) {
				if(cerrarRunLevel==1) {
				if (perdio==false&& menu==false) {
					pintarJuego();
					disparar();
				}
				if (menu==true ) {
					menu();
				}

				if (perdio==true) {
					perdio();
				}
				for (int i = 0; i <enemigos.size(); i++) {	

					perdio =player.colision(enemigos.get(i));
					
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
		if (menu==true&&event.getCode().equals(KeyCode.ENTER)&&event.getEventType().equals(KeyEvent.KEY_PRESSED)) {
			menu=false;
		}
		if (perdio==true&&event.getCode().equals(KeyCode.ENTER)&&event.getEventType().equals(KeyEvent.KEY_PRESSED)) {
			perdio=false;
			player.setPosx(0);
			player.setPosy(0);
			enemigo=new Homero(400,300);
			enemigos.add(enemigo);

		}

		if (event.getCode().equals(KeyCode.D)&&event.getEventType().equals(KeyEvent.KEY_PRESSED)){
			Disparo temporal = new Disparo(player.getPosy(),player.getPosx(),3);
			disparos.add(temporal);

		}
		if (event.getCode().equals(KeyCode.S)&&event.getEventType().equals(KeyEvent.KEY_PRESSED)){
			Disparo temporal = new Disparo(player.getPosy(),player.getPosx(),0);
			disparos.add(temporal);

		}
		if (event.getCode().equals(KeyCode.A)&&event.getEventType().equals(KeyEvent.KEY_PRESSED)){
			Disparo temporal = new Disparo(player.getPosy(),player.getPosx(),1);
			disparos.add(temporal);

		}
		if (event.getCode().equals(KeyCode.W)&&event.getEventType().equals(KeyEvent.KEY_PRESSED)){
			Disparo temporal = new Disparo(player.getPosy(),player.getPosx(),2);
			disparos.add(temporal);

		}

		if(event.getCode().equals(KeyCode.RIGHT) && event.getEventType().equals(KeyEvent.KEY_PRESSED)){

			if(player.getPosx()>=920) {

				player.setPosx(920);
			}
			player.moverDerecha();
			direccionBart=0;
		}
		if(event.getCode().equals(KeyCode.LEFT) && event.getEventType().equals(KeyEvent.KEY_PRESSED)){
			if(player.getPosx()<=0) {
				player.setPosx(0);
			}
			player.moverIzquierda();
			direccionBart=1;
		}
		if(event.getCode().equals(KeyCode.DOWN) && event.getEventType().equals(KeyEvent.KEY_PRESSED)){
			if(player.getPosy()>390) {
				player.setPosy(440);
			}
			player.moverAbajo();


		}
		if(event.getCode().equals(KeyCode.UP) && event.getEventType().equals(KeyEvent.KEY_PRESSED)){
			if(player.getPosy()<=0){
				player.setPosy(0);
			}

			player.moverArriba();

		}


	}
	public void menu() {

		grafico.drawImage(menuImage, 0,0);
		
	}
	public void pintarJuego() {

		grafico.drawImage(fondo,0,0);
		grafico.drawImage(player.getBart(direccionBart),player.getPosx(),player.getPosy());
		grafico.fillText("PUNTAJE:  ",750, 30);
		int num= numeroEnemigos*10;
		String puntaje=Integer.toString(num); 
		grafico.fillText(" "+puntaje,800,30);


	}
	public void perdio() {
		grafico.drawImage(player.getPerdio(), 0, 0);
		grafico.drawImage(player.getLetrero(), 150, 430);

	}

	public void disparar () {
		try {
			for (int j = 0; j < enemigos.size(); j++) {

				if(player.getPosy()<=enemigos.get(j).getPosy()) {
					enemigos.get(j).moverArriba();
				
				}
				if(player.getPosy()>=enemigos.get(j).getPosy()) {
					enemigos.get(j).moverAbajo();
				}
				if(player.getPosx()<=enemigos.get(j).getPosx()) {
					enemigos.get(j).moverIzquierda();
					enemigos.get(j).setDireccion(1);

				}
				if(player.getPosx()>=enemigos.get(j).getPosx()) {
					enemigos.get(j).moverDerecha();
					enemigos.get(j).setDireccion(0);

				}	

				grafico.drawImage (enemigos.get(j).getHomero(),enemigos.get(j).getPosx(),enemigos.get(j).getPosy());
				for (int i = 0; i< disparos.size(); i++) {
					
				     if (disparos.get(i).getPosxPiedra()>=enemigos.get(j).getPosx()&&disparos.get(i).getPosxPiedra()<=enemigos.get(j).getPosx()+100&&
							disparos.get(i).getPosyPiedra()>=enemigos.get(j).getPosy()&&disparos.get(i).getPosyPiedra()<=enemigos.get(j).getPosy()+60) {
				    	 disparos.remove(i);
						enemigos.remove(j);
						if(enemigos.size()==0) {
							 numeroEnemigos=numeroEnemigos+1;
						  crearEnemigo(numeroEnemigos);
						}
					}
					disparos.get(i).disparar();
					grafico.drawImage(disparos.get(i).getDisparo(), disparos.get(i).getPosxPiedra(), disparos.get(i).getPosyPiedra());
				}
			    


			}}
		catch(java.lang.IndexOutOfBoundsException error) {


		}
	}


	public void crearEnemigo(int j) {
		int i=0;
		while(i<j) {
		Homero nuevoEnemigo = new Homero((int) (Math.random() * 900) + 1,(int) (Math.random() * 390) + 1);
		enemigos.add(nuevoEnemigo);
		i++;
		}
		
	}
	


	
	


}



