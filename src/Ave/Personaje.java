package Ave;

import java.util.Timer;
import java.util.TimerTask;

import javafx.scene.image.Image;

public class Personaje {
	private float posx;
	private float posy;
	private Image naruto,naruto2,sonic,mario,profesor;
	private double vida;
	private int time=0;
	public Personaje() {
		
		naruto = new Image("Ave/naruto.gif",150,150,true,false);
		naruto2 = new Image("Ave/naruto3.png",150,150,true,false);
		sonic= new Image("Ave/sonic.gif",150,150,true,false);
		mario= new Image("Ave/mario.gif",150,150,true,false);
		profesor = new Image("Ave/profesor.gif",150,150,true,false);
	    posx = 100;
		posy = 370;
		vida = 100;
	}


	public void saltar() {
     posy=posy-200;
  
   Timer tiempo= new Timer();
   TimerTask task= new TimerTask(){
	   @Override
	   public void run() {
		 
		   if(time==1) {
			     posy=posy+200;
			      tiempo.cancel();
			   }
		   time=time+1;
	   }   
	   
   };
   tiempo.scheduleAtFixedRate(task,0,350);

	}
	

	public float moverAbajo() {
		
		return posy= posy+2;
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
	public void setTime(int tiempo) {
		this.time=tiempo;
	}
	public void setPosy(float posy) {
		this.posy = posy;
	}
	public Image getPlayer(int i) {
		if(i==0) {
		if(getPosy()<370)
		
		return naruto2;
		else
			return naruto;
		}
		if(i==1) {
			return sonic;
		}
		if(i==2) {
			return mario;
		}
		if(i==3) {
			return profesor;
		}
		return naruto;
	}
	public void setPlayer(Image nuevoPersonaje) {
		this.naruto = nuevoPersonaje;
	}
	public double getVida() {
		return vida;
	}
	public void setVida(double vida) {
		this.vida = vida;
	}
	
}

