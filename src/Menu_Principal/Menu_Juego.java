package Menu_Principal;



import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Menu_Juego extends Scene implements EventHandler<ActionEvent>{
	private Button Iniciar,salir; 
    private ImageView menu;
    private Stage stage;
    private Menu_Juegos juegos;
 

       
	public Menu_Juego(Group root) {
		super(root);
		
		Iniciar = new Button("  JUEGOS  ");
		salir = new Button("      SALIR      ");
		menu=new ImageView (new Image ("Menu_Principal/MenuJuegos.jpg",1022,592,true,false ));
		Iniciar.setLayoutX(490);
		Iniciar.setLayoutY(250);
		salir.setLayoutX(480);
		salir.setLayoutY(300);
	

	
		root.getChildren().addAll(menu,Iniciar,salir);
	
		
	}



	public Button getSalir() {
		return salir;
}



	public Button getJuego1() {
		return Iniciar;
	}

	



	@Override
	public void handle(ActionEvent event) {
		 
		
	if(event.getSource().equals(Iniciar)) {
		stage.setScene(juegos);
		}
  	
		
	}

	
	

}
