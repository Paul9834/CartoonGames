package Ave;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Seleccion_Personajes extends Scene {
	private Image fondo,naruto,sonic,mario,profesor;
	private ImageView iv1,iv2,iv3,iv4,iv5;
	private Button personaje1,personaje2,personaje3,personaje4;
	
	
	public Seleccion_Personajes (Group root) {
		super(root);
	personaje1= new Button("SELECCIONAR");
	personaje2= new Button("SELECCIONAR");
	personaje3= new Button("SELECCIONAR");
	personaje4= new Button("SELECCIONAR");
	personaje1.setLayoutX(40);
	personaje1.setLayoutY(120);
	personaje2.setLayoutX(370);
	personaje2.setLayoutY(120);
	personaje3.setLayoutX(640);
	personaje3.setLayoutY(120);
	personaje4.setLayoutX(900);
	personaje4.setLayoutY(120);
	naruto = new Image("Ave/naruto.gif",150,150,true,false);
	sonic= new Image("Ave/sonic.gif",150,150,true,false);
	mario= new Image("Ave/mario.gif",150,150,true,false);
	profesor = new Image("Ave/profesor.gif",150,150,true,false);
	fondo= new Image("Ave/fondoJuego.jpg",1000,1000,true,false);
	iv1= new ImageView(fondo);
	iv2= new ImageView(naruto);
	iv2.setLayoutX(30);
	iv2.setLayoutY(30);
	iv3= new ImageView(sonic);
	iv3.setLayoutX(330);
	iv3.setLayoutY(30);
	iv4= new ImageView(mario);
	iv4.setLayoutX(600);
	iv4.setLayoutY(30);
	iv5= new ImageView(profesor);
	iv5.setLayoutX(880);
	iv5.setLayoutY(30);
	root.getChildren().addAll(iv1,iv2,iv3,iv4,iv5,personaje1,personaje2,personaje3,personaje4);
	}


	public Button getPersonaje1() {
		return personaje1;
	}


	public void setPersonaje1(Button personaje1) {
		this.personaje1 = personaje1;
	}


	public Button getPersonaje2() {
		return personaje2;
	}


	public void setPersonaje2(Button personaje2) {
		this.personaje2 = personaje2;
	}


	public Button getPersonaje3() {
		return personaje3;
	}


	public void setPersonaje3(Button personaje3) {
		this.personaje3 = personaje3;
	}


	public Button getPersonaje4() {
		return personaje4;
	}


	public void setPersonaje4(Button personaje4) {
		this.personaje4 = personaje4;
	}

}
