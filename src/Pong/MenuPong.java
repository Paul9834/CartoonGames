package Pong;



import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.GridPane;


public class MenuPong extends Scene  {

	private Button iniciarJuego,intrucciones,dificultad,volver;





	public MenuPong(Group root) {
		super(root);
		ImageView fondo = new ImageView (new Image("Menu_Principal/pong2.gif",1022,592,true,false ));
		GridPane panel = new GridPane ();
		iniciarJuego= new Button("INICIAR JUEGO");
		intrucciones= new Button("Instrucciones");
		dificultad= new Button("Dificultad");
		volver= new Button(" Volver a juegos" );
		panel.add(iniciarJuego, 1, 0);
		panel.add(intrucciones, 1, 1);
		panel .add(dificultad, 1, 2);
		panel.add(volver,3 , 4);
		panel.setPadding(new Insets(200,100,100,300));
		panel.setHgap(20);
		panel.setVgap(20);
		root.getChildren().addAll(fondo,panel);


	}


	public Button getVolver() {
		return volver;
	}


	public Button getIniciarJuego() {
		return iniciarJuego;
	}


	public Button getIntrucciones() {
		return intrucciones;
	}


	public Button getDificultad() {
		return dificultad;
	}




}
