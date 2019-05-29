package Simpsons;
import javafx.scene.image.Image;

public class Homero {
	private float posx;
	private float posy;
	private Image homero,homeroder;
	private int direccion;
    

	public Homero(float posxinicial, float posyinicial) {
		super();
		this.posx = posxinicial;
		this.posy = posyinicial;
		this.homero = new Image("Simpsons/homero.png",100,100,true,false);
		this.homeroder= new Image("Simpsons/homeroder.png",100,100,true,false);
		direccion=1;
	    
	}

	
	public float moverArriba() {
		return posy= posy-1;
	}
	public float moverAbajo() {
		return posy= posy+1;
	}
	public float moverDerecha() {
		return posx=posx+1;
	}
	public float moverIzquierda() {
		return posx=posx-1;
	}
	public Image getHomero() {
		if(getDireccion()==0) {
			return homeroder;
		}
		else {
		return homero;
		}
	}
	public int getDireccion() {
		return direccion;
	}


	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}


	public void setHomero(Image homero) {
		this.homero = homero;
	}
	public float getPosx() {
		return posx;
	}
	public void setPosx(float posx) {
		this.posx = posx;
	}
	public float getPosy() {
		return posy;
	}
	public void setPosy(float posy) {
		this.posy = posy;
	}

	
}
