import Ave.Menu_Run;
import Ave.Run;
import Ave.Seleccion_Personajes;
import Menu_Principal.Menu_Juego;
import Menu_Principal.Menu_Juegos;
import Pong.Instrucciones;
import Pong.MenuPong;
import Pong.Pausa_Pong;
import Pong.Pong;
import Simpsons.Los_Simpson;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Administrador_Scenas implements EventHandler<ActionEvent> {
	
	private Menu_Juego menuPrincipal;
	private Menu_Juegos seleccionJuegos; 
	private MenuPong menuPong;
	private Pong pong;
	private Pausa_Pong pausaPong;
	private Instrucciones instrucciones;
	private Los_Simpson simpsons;
	private Run run;
	private Menu_Run menuRun;
	private Seleccion_Personajes personaje;
	private Stage stage1;

	
	public Administrador_Scenas(Stage stage){
		menuPrincipal= new Menu_Juego(new Group()) ; 
		seleccionJuegos= new Menu_Juegos(new Group());
		pong = new Pong(new Group(),stage);
		menuPong= new MenuPong(new Group());
		pausaPong= new Pausa_Pong(new Group());
		simpsons= new Los_Simpson(new Group());
		run= new Run(new Group());
		menuRun= new Menu_Run(new Group());
		instrucciones= new Instrucciones(new Group());
		personaje= new Seleccion_Personajes(new Group());
		menuPrincipal.getJuego1().setOnAction(this);
		menuPrincipal.getSalir().setOnAction(this);
		seleccionJuegos.getVolver().setOnAction(this);
		seleccionJuegos.getJuego2().setOnAction(this);
		seleccionJuegos.getJuego1().setOnAction(this);
		seleccionJuegos.getJuego3().setOnAction(this);
		menuPong.getVolver().setOnAction(this);
		menuPong.getIniciarJuego().setOnAction(this);
		menuPong.getIntrucciones().setOnAction(this);
		pong.getRegresar().setOnAction(this);
		pong.getPausar().setOnAction(this);
		pausaPong.getContinuar_Juego().setOnAction(this);
		pausaPong.getReiniciarJuego().setOnAction(this);
		pausaPong.getSalirJuego().setOnAction(this);
		instrucciones.getVolver().setOnAction(this);
		simpsons.getVolver().setOnAction(this);
		run.getRegresar().setOnAction(this);
		menuRun.getIniciar().setOnAction(this);
		menuRun.getSalirJuego().setOnAction(this);
		menuRun.getSeleccionPersonaje().setOnAction(this);
		personaje.getPersonaje1().setOnAction(this);
		personaje.getPersonaje2().setOnAction(this);
		personaje.getPersonaje3().setOnAction(this);
		personaje.getPersonaje4().setOnAction(this);
		stage1= stage;
		
	}
	public Scene Scena () {
		
		return menuPrincipal;
		
	}
	@Override
	public void handle(ActionEvent event) {
		if (event.getSource().equals(menuPrincipal.getJuego1())){
			stage1.setScene(seleccionJuegos);
			
		}
		if (event.getSource().equals(menuPrincipal.getSalir())){
			stage1.close();
			
		}
		if(event.getSource().equals(seleccionJuegos.getVolver())) {
			stage1.setScene(menuPrincipal);
		
		}
		if(event.getSource().equals(seleccionJuegos.getJuego3())) {
			stage1.setScene(simpsons);
			simpsons.setCerrarRunLevel(1);
			simpsons.runlevel();
		
		}
		if(event.getSource().equals(seleccionJuegos.getJuego1())) {
			stage1.setScene(menuRun);
			
		
		}
		if(event.getSource().equals(seleccionJuegos.getJuego2())) {
			stage1.setScene(menuPong);
			
		}
		if(event.getSource().equals(menuPong.getVolver())) {
			stage1.setScene(seleccionJuegos);
		
		}
		if(event.getSource().equals(menuPong.getIniciarJuego())) {
			stage1.setScene(pong);
			pong.setScena(1);
			pong.runLevel();
			pong.setPuntaje1(0);
			pong.setPuntaje2(0);
			pong.pelota();
			
		}
		if(event.getSource().equals(menuPong.getIntrucciones())) {
			stage1.setScene(instrucciones);
		}
		if(event.getSource().equals(pong.getRegresar())) {
			stage1.setScene(menuPong);
			pong.setScena(0);
		}
		if(event.getSource().equals(pong.getPausar())){
			stage1.setScene(pausaPong);
			pong.setScena(0);
		}
		if(event.getSource().equals(pausaPong.getContinuar_Juego())) {
			stage1.setScene(pong);
			pong.setScena(1);
			pong.runLevel();
		}
		if(event.getSource().equals(pausaPong.getReiniciarJuego())) {
			stage1.setScene(pong);
			pong.setScena(1);
			pong.runLevel();
			pong.setPuntaje1(0);
			pong.setPuntaje2(0);
			pong.pelota();
			
		}
		if(event.getSource().equals(pausaPong.getSalirJuego())) {
			stage1.setScene(menuPong);
			pong.setScena(0);
		}
		if(event.getSource().equals(instrucciones.getVolver())) {
			stage1.setScene(menuPong);
		}
		if (event.getSource().equals(simpsons.getVolver())) {
			stage1.setScene(seleccionJuegos);
			simpsons.setCerrarRunLevel(0);
		}
		if(event.getSource().equals(menuRun.getIniciar())) {
			run.setScena(1);
			stage1.setScene(run);
			run.runlevel();
		}
		if(event.getSource().equals(menuRun.getSalirJuego())) {
			stage1.setScene(seleccionJuegos);
		}
		if(event.getSource().equals(menuRun.getSeleccionPersonaje())) {
			stage1.setScene(personaje);
		}
		if(event.getSource().equals(personaje.getPersonaje1())) {
			run.setPersonaje2(0);
			stage1.setScene(run);
			run.runlevel();
		}
		if(event.getSource().equals(personaje.getPersonaje2())) {
			run.setPersonaje2(1);
			run.setScena(1);
			stage1.setScene(run);
			run.runlevel();
		}
		if(event.getSource().equals(personaje.getPersonaje3())) {
			run.setPersonaje2(2);
			run.setScena(1);
			stage1.setScene(run);
			run.runlevel();
		}
		if(event.getSource().equals(personaje.getPersonaje4())) {
			run.setPersonaje2(3);
			stage1.setScene(run);
			run.setScena(1);
			run.runlevel();
		}
		if(event.getSource().equals(run.getRegresar())) {
			stage1.setScene(menuRun);
			run.setScena(0);
		}
		
		
	}

}
