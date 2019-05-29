package Simpsons;

import javafx.scene.image.Image;

public class Disparo {
	private float posyPiedra;
	private float posxPiedra;
	private int dire;
	private Image disparo;
	public Disparo(float posyPiedra,float posxPiedra,int direccion ) {
		super();
		this.posyPiedra = posyPiedra;
		this.posxPiedra = posxPiedra;
		this.dire=direccion;
		this.disparo= new Image ("Simpsons/piedra.png",20,20,true,false);
		
		
	}
	public void disparar() {

		if (dire==0) {
			dispararAbajo();
		}	

		if (dire==1) {
			dispararIzquierda();
		}	

		if (dire==2) {
			dispararArriba();
		}	
		if (dire==3) {
		dispararDerecha();
	}	
		
	}
	public void dispararArriba() {
		 posyPiedra= posyPiedra-4;
		
	}
	public void dispararAbajo() {
		 posyPiedra= posyPiedra+4;
		
	}
	public void dispararIzquierda() {
		 posxPiedra= posxPiedra-4;
		
	}
	public void dispararDerecha() {
		 posxPiedra= posxPiedra+4;
		
	}
	public float getPosyPiedra() {
	
		return posyPiedra;
	}
	public void setPosyPiedra(float posyPiedra) {
		this.posyPiedra = posyPiedra;
	}
	public float getPosxPiedra() {
		return posxPiedra;
	}
	public void setPosxPiedra(float posxPiedra) {
		this.posxPiedra = posxPiedra;
	}
	public Image getDisparo() {
		return disparo;
	}
	public void setDisparo(Image disparo) {
		this.disparo = disparo;
	}
	
	

}
