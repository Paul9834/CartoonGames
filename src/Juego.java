


import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Juego extends Application {
	
	
	public static void main(String[] args) {
		launch(args);

		}

	@Override
	public void start(Stage stage) throws Exception {
	

		Administrador_Scenas scena= new Administrador_Scenas(stage);
		stage.setTitle("juego");
		stage.setScene(scena.Scena());
		stage.getIcons().add(new Image("1.png"));
		stage.show();
		
	}


	}
	
