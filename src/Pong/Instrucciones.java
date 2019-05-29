package Pong;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Instrucciones extends Scene  {
	
	private Image instrucciones;
	private Button volver;
	
	public Instrucciones(Group root) {
		super(root);
		instrucciones= new  Image("Pong/intrucciones.png",1022,592,true,false );
		ImageView iv = new ImageView( instrucciones);
		volver = new Button("VOLVER");
		volver.setLayoutX(910);
		volver.setLayoutY(450);
		root.getChildren().addAll(iv,volver);
	}

	public Button getVolver() {
		return volver;
	}
	

}
