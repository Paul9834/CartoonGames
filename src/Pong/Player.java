package Pong;

import javafx.scene.image.Image;

public class Player {

	private Image raqueta;
	private int  posY;
	final int posX;
	private Image cero,uno,dos,tres,cuatro,cinco,seis,siete;
	
	public Player(int jugador,int posx ,int  posy) {
		super();
		raqueta = new Image ("Pong/raqueta.png",404,120,true,false);
		posX = posx;
		posY = posy;
		cero= new Image("Pong/cero.png",80,50,true,false);
		uno= new Image("Pong/uno.png",80,50,true,false);
		dos= new Image("Pong/dos.png",80,50,true,false);
		tres= new Image("Pong/tres.png",80,50,true,false);
		cuatro= new Image("Pong/cuatro.png",80,50,true,false);
		cinco= new Image("Pong/cinco.png",80,50,true,false);
		seis= new Image("Pong/seis.png",80,50,true,false);
		siete= new Image("Pong/siete.png",80,50,true,false);
	}

	public void moverArriba() {
		posY=posY-50; 
	}
	public void moverAbajo() {
		posY=posY+50;
	}

	public int getPosX() {
		return posX;
	}
	public Image getRaqueta() {
		return raqueta;
	}

	public void setRaqueta(Image raqueta) {
		this.raqueta = raqueta;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
	public Image getCero() {
		return cero;
	}
	public Image getUno() {
		return uno;
	}
	public Image getDos() {
		return dos;
	}
	public Image getTres() {
		return tres;
	}
	public Image getCuatro() {
		return cuatro;
	}
	public Image getCinco() {
		return cinco;
	}
	public Image getSeis() {
		return seis;
	}
	public Image getSiete() {
		return siete;
	}
	
	
	
	
}
