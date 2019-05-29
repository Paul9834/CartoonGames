package Pong;

import javafx.scene.image.Image;

public class Pelota {
private Image pelota;
private double posX;
private double posY;
public Pelota() {
	super();
	pelota = new Image("Pong/pelota.png",40,40,true,false);
	posX = 500;
	posY = 250;
}
public void moverEjeX(int i) {
	if (i==0) {
	this.posX= posX+10;
	}
    if (i==1) {
		this.posX=posX-10;
	}
	else {
	
		
	}
}
public void moverEjeY(int i) {
	if (i==0) {
	this.posY= posY-4;
	}
	else if (i==1) {
		this.posY=posY+4;
	}
}

public Image getPelota() {
	return pelota;
}
public void setPelota(Image pelota) {
	this.pelota = pelota;
}
public double getPosX() {
	return posX;
}
public void setPosX(double posX) {
	this.posX = posX;
}
public double getPosY() {
	return posY;
}
public void setPosY(double posY) {
	this.posY = posY;
}

}
