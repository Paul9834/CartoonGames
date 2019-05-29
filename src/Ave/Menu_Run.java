package Ave;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Menu_Run extends Scene{
	private Button iniciar ,seleccionPersonaje, salirJuego;
	private Image fondo;
	private ImageView iv;
	public Menu_Run(Group root) {
		super(root);
		iniciar= new Button("INICIAR JUEGO");
		seleccionPersonaje= new Button("SELECCIONAR PERSONAJE");
		salirJuego= new Button("SALIR DEL JUEGO");
		fondo= new Image("Ave/fondoJuego.jpg",1000,1000,true,false);
		iv= new ImageView(fondo);
		iniciar.setLayoutX(420);
		iniciar.setLayoutY(100);
		seleccionPersonaje.setLayoutX(400);
		seleccionPersonaje.setLayoutY(150);
		salirJuego.setLayoutX(420);
		salirJuego.setLayoutY(200);
		root.getChildren().addAll(iv,iniciar,seleccionPersonaje,salirJuego);
	}
	public Button getIniciar() {
		return iniciar;
	}
	public Button getSeleccionPersonaje() {
		return seleccionPersonaje;
	}
	public Button getSalirJuego() {
		return salirJuego;
	}

}
