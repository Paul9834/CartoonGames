package Pong;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;



public class Pausa_Pong extends Scene {

	private Button continuar_Juego , reiniciarJuego,salirJuego;
	private ImageView tablero;
	private double Puntaje1, Puntaje2;

	public Pausa_Pong(Group root) {
		super(root);
		Puntaje1=0;
		Puntaje2=0;
		GridPane panel = new GridPane();
		continuar_Juego = new Button ("CONTINUAR jUEGO");
		reiniciarJuego= new Button("REINICIAR PARTIDA");
		salirJuego= new Button("SALIR JUEGO");
		Image tabler = new Image("Pong/Tablero.png",1005.36,596.4,true,false);
		Image PAUSA = new Image("Pong/PAUSA2.png",500,200,true,false);
		tablero = new ImageView(tabler);
		ImageView pau= new ImageView(PAUSA);
		pau.setTranslateX(260);
		pau.setTranslateY(30);
		panel.add(continuar_Juego,44,12);
		panel.add(reiniciarJuego, 44, 13);
		salirJuego.setLayoutX(460);
		salirJuego.setLayoutY(350);
		panel.setVgap(20);
		panel.setHgap(10);
		root.getChildren().addAll(tablero,pau,panel,salirJuego);

	}

	public Button getSalirJuego() {
		return salirJuego;
	}

	public Button getContinuar_Juego() {
		return continuar_Juego;
	}

	public void setContinuar_Juego(Button continuar_Juego) {
		this.continuar_Juego = continuar_Juego;
	}

	public Button getReiniciarJuego() {
		return reiniciarJuego;
	}

	public void setReiniciarJuego(Button reiniciarJuego) {
		this.reiniciarJuego = reiniciarJuego;
	}

	public double getPuntaje1() {
		return Puntaje1;
	}

	public void setPuntaje1(double puntaje1) {
		Puntaje1 = puntaje1;
	}

	public double getPuntaje2() {
		return Puntaje2;
	}

	public void setPuntaje2(double puntaje2) {
		Puntaje2 = puntaje2;
	}



	public ImageView getTablero() {
		return tablero;
	}

	public void setTablero(ImageView tablero) {
		this.tablero = tablero;
	}




}
