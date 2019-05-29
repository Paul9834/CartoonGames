package Pong;



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
import javafx.stage.Stage;


public class Pong extends Scene implements EventHandler<KeyEvent>  {

	private Image tablero;
	private Canvas canvas;
	private Pelota pelota;
	private int direccion,direccionY;
	private GraphicsContext grafico;
	private Player jugador1,jugador2;
    private  double puntaje1,puntaje2;
	private ImageView regre ;
	private Button regresar,pausar;
	private int Scena=0;
	private Stage copia;
	private Image  gano1, gano2;

	public Pong(Group root,Stage stage ) {
		super(root);
        
		regresar= new Button();
		pausar= new Button();
		direccion=0;
		direccionY=3;
		pelota=new Pelota();
		jugador1= new Player(1,20,200);
		jugador2= new Player(2,960,200);
		puntaje1=0;
		puntaje2=0;
		gano1= new Image("Pong/ga1.png",700,100,true,false);
		gano2= new Image("Pong/ga2.png",700,100,true,false);
		tablero = new Image("Pong/Tablero.png",1005.36,596.4,true,false);
		ImageView iv = new ImageView(new Image("Pong/pausa.png",30,30,true,false));
		regre = new ImageView(new Image("Pong/regresar.png",30,30,true,false));
		regresar.setGraphic(regre);
		pausar.setGraphic(iv);
		regresar.setLayoutX(510);
		pausar.setLayoutX(450);
		canvas = new Canvas(1005.36,596.4);
		grafico=canvas.getGraphicsContext2D();
		copia= stage;
		root.getChildren().addAll(canvas,regresar,pausar);
		this.setOnKeyPressed(this);
	}





	public void runLevel() {
		new AnimationTimer() {
			@Override
			public void handle(long arg0) {

				if (Scena==1) {
					grafico.drawImage(tablero, 0, 0);
					grafico.drawImage(pelota.getPelota(), pelota.getPosX(), pelota.getPosY());
					grafico.drawImage(jugador1.getRaqueta(),jugador1.getPosX(), jugador1.getPosY());
					grafico.drawImage(jugador2.getRaqueta(),jugador2.getPosX(),jugador2.getPosY());
					pelota.moverEjeX(direccion);
					pelota.moverEjeY(direccionY);

					if(pelota.getPosX()==0) {
						puntaje1=puntaje1+0.5;
						
					}
					if(pelota.getPosX()+40==1000)	{
						puntaje2=puntaje2+0.5;
					}
					if (puntaje2==0) {
						grafico.drawImage(jugador1.getCero(), 400, 20);

					}
					if(puntaje2==1) {
						grafico.drawImage(jugador1.getUno(), 400, 20);
					}
					if(puntaje2==2) {
						grafico.drawImage(jugador1.getDos(), 400, 20);
					}
					if(puntaje2==3) {
						grafico.drawImage(jugador1.getTres(), 400, 20);
					}
					if(puntaje2==4) {
						grafico.drawImage(jugador1.getCuatro(), 400, 20);
					}
					if(puntaje2==5) {
						grafico.drawImage(jugador1.getCinco(), 400, 20);
					}
					if(puntaje2==6) {
						grafico.drawImage(jugador1.getSeis(), 400, 20);
					}

					if(puntaje2==7) {
						grafico.drawImage(jugador1.getSiete(), 400, 20);
						
					}
					if (puntaje1==0) {
						grafico.drawImage(jugador2.getCero(), 600, 20);

					}
					if(puntaje1==1) {
						grafico.drawImage(jugador2.getUno(), 600, 20);
					}
					if(puntaje1==2) {
						grafico.drawImage(jugador2.getDos(), 600, 20);
					}
					if(puntaje1==3) {
						grafico.drawImage(jugador2.getTres(), 600, 20);
					}
					if(puntaje1==4) {
						grafico.drawImage(jugador2.getCuatro(), 600, 20);
					}
					if(puntaje1==5) {
						grafico.drawImage(jugador2.getCinco(), 600, 20);
					}
					if(puntaje1==6) {
						grafico.drawImage(jugador2.getSeis(), 600, 20);
					}
					if(puntaje1==7) {
						
						grafico.drawImage(jugador2.getSiete(), 600, 20);
						grafico.drawImage(gano1, 20, 20);
					
					}

					if (jugador1.getPosX()+50>=pelota.getPosX()&& jugador1.getPosY()+50>pelota.getPosY()&&
							jugador1.getPosY()<=pelota.getPosY()) {

						direccion=0;
						direccionY=0;
					}
					if (jugador1.getPosX()+50>=pelota.getPosX()&& jugador1.getPosY()+50<pelota.getPosY()&&
							jugador1.getPosY()+100>=pelota.getPosY()) {
						direccion=0;
						direccionY=1;
					}
					if (jugador2.getPosX()<=pelota.getPosX()+40&& jugador2.getPosY()+50<pelota.getPosY()&&
							jugador2.getPosY()+100>=pelota.getPosY()) {
						direccion=1;
						direccionY=1;
					}
					if (jugador2.getPosX()<=pelota.getPosX()+40&& jugador2.getPosY()+40>pelota.getPosY()&&
							jugador2.getPosY()<=pelota.getPosY()) {

						direccion=1;
						direccionY=0;
					}
					if (pelota.getPosX()>975) {
						direccion=0;
					}
					if (pelota.getPosX()<0) {
						direccion=0;
						if (pelota.getPosY()<200) {
							direccionY=1;
						}
					}
					if(pelota.getPosX()>975) {

						direccion=1;
					}


					if(pelota.getPosY()<0) {
						direccionY=1;
					}
					if ( pelota.getPosY()>556) {
						direccionY=0;
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
		if(event.getCode().equals(KeyCode.W)&&event.getEventType().equals(KeyEvent.KEY_PRESSED)) {
			if(jugador1.getPosY()>0) {
				jugador1.moverArriba();

			}

		}
		if(event.getCode().equals(KeyCode.S)&&event.getEventType().equals(KeyEvent.KEY_PRESSED)) {
			if(jugador1.getPosY()+120<596)
				jugador1.moverAbajo();
		}
		if(event.getCode().equals(KeyCode.UP)&&event.getEventType().equals(KeyEvent.KEY_PRESSED)) {
			if(jugador2.getPosY()>0) {
				jugador2.moverArriba();
			}
		}
		if(event.getCode().equals(KeyCode.DOWN)&&event.getEventType().equals(KeyEvent.KEY_PRESSED)) {
			if(jugador2.getPosY()+120<596)
				jugador2.moverAbajo();
		}

	}
	public void setPuntaje1(double puntaje) {
		puntaje1 = puntaje;
	}
	public void setPuntaje2(double puntaje) {
		puntaje2 = puntaje;
	}
	public Button getRegresar() {
		return regresar;
	}

	public Button getPausar() {
		return pausar;
	}

	public int getScena() {
		return Scena;
	}

	public void setScena(int scena) {
		Scena = scena;
	}
	public void pelota() {
		pelota.setPosX(500);
		pelota.setPosY(250);
	}



}








