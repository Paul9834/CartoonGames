package Ave;

import javafx.scene.image.Image;

public class Obstaculo {
	private float posx;

	private float posy;
	private Image obstaculo;
	public Obstaculo() {
		
		this.obstaculo = new Image("Ave/obstaculo.png",120,120,true,false);
		this.posx = 700;
		posy =400;

	}
	public Obstaculo( float posyinicial) {
		this.posy = posyinicial;
		
	}

	public float moverArriba() {
		return posy= posy-40;
	}
	public float moverAbajo() {
		return posy= posy+2;
	}
	public float moverIzquierda() {
		return posx=posx-15  ;
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
	public Image getObstaculo() {
		return obstaculo;
	}
	public void setObstaculo(Image obstaculo) {
		this.obstaculo = obstaculo;
	}

	

}
