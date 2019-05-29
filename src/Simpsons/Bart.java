package Simpsons;
import javafx.scene.image.Image;


public class Bart {
	private float posx;
	private float posy;
	private Image Bart,Bartder, perdio,letrero;
    private int vida;
    private Disparo disparo;
	
    
    public Bart() {
		
        this.Bart = new Image("Simpsons/Bart.png",100,100,true,false);
		this.perdio= new Image("Simpsons/Perdio.gif",1024,512,true,false);
		this.letrero=new Image("Simpsons/GameOver.png",400,400,true,false);
		this.Bartder= new Image("Simpsons/BARTdeR.png",100,100,true,false);
		this.posx = 0;
		this.posy = 0; 
		this.vida = 100;
	
	}
	public Bart(float posxinicial, float posyinicial) {
		this.posx = posxinicial;
		this.posy = posyinicial;
        this.Bart = new Image("Simpsons/Bart.png",100,100,true,false);
		this.perdio= new Image("Simpsons/Perdio.gif",1024,512,true,false);
		this.letrero=new Image("Simpsons/GameOver.png",400,400,true,false);
		this.Bartder= new Image("Simpsons/BARTdeR.png",100,100,true,false);
		
		
		this.vida = 100;
	}
	
	
public boolean colision(Homero enemigo) {
	
	if (getPosy()>=enemigo.getPosy()&& getPosy()<=enemigo.getPosy()+60&&
			getPosx()+20>=enemigo.getPosx()&&getPosx()+40<=enemigo.getPosx()+100) {
		return true;
	}
	return false;
}
	
	public Image getPerdio() {
		return perdio;
	}
	public void setPerdio(Image perdio) {
		this.perdio = perdio;
	}
	public Image getLetrero() {
		return letrero;
	}
	public void setLetrero(Image letrero) {
		this.letrero = letrero;
	}
	public float moverArriba() {
		return posy= posy-50;
	}
	public float moverAbajo() {
		return posy= posy+50;
	}
	public float moverDerecha() {
		return posx=posx+50;
	}
	public float moverIzquierda() {
		return posx=posx-50;
	}
	public Image getBart(int direccion) {
		if (direccion==0){ 
			return Bartder;	
		}
		
		else if (direccion==1) {
		
		return Bart;
		}
		return Bart;
	}
	public void setBart(Image Bart) {
		this.Bart = Bart;
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
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	
	
	
	

}

