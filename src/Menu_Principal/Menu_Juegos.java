package Menu_Principal;




import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;


public class Menu_Juegos extends Scene {
	private Button juego1,juego2,juego3,volver;
	private Image menu;
	private ImageView naruto,pong,simpson;
	

	public Menu_Juegos(Group root) {
		super(root);

		juego1 = new Button("JUGAR");
		juego2 = new Button ("JUGAR");
		juego3 = new Button("JUGAR");
		volver = new Button("VOLVER A MENU PRINCIPAL");
		menu= new Image ("Menu_Principal/Menu.jpg",1022,592,true,false );
		Image naru= new Image("Menu_Principal/nar.gif",300,150,true,false);
		naruto=new ImageView(naru);
		Image pongImage= new Image("Menu_Principal/pong.gif",300,150,true,false);
		pong=new ImageView(pongImage);
		Image simpsonImage= new Image("Menu_Principal/simp.gif",300,150,true,false);
		simpson=new ImageView(simpsonImage);
		GridPane panel= new GridPane();
		juego1.setPadding(new Insets(10,10,10,10));
		panel.add(juego1, 0, 1);
		panel.add(naruto,0,0);
		panel.add(juego2, 1, 1);
		panel.add(pong, 1, 0);
		panel.add(juego3, 2, 1);
		panel.add(simpson, 2, 0);
		volver.setLayoutX(700);
		volver.setLayoutY(500);
		panel.setPadding(new Insets(100,100,100,100));
		panel.setVgap(10);
		panel.setHgap(10);
		panel.setAlignment(Pos.CENTER);;
		ImageView menu2= new ImageView(menu);
		
		root.getChildren().addAll(menu2,panel,volver);


	}


	public Button getJuego1() {
		return juego1;
	}


	public void setJuego1(Button juego1) {
		this.juego1 = juego1;
	}


	public Button getJuego2() {
		return juego2;
	}


	public void setJuego2(Button juego2) {
		this.juego2 = juego2;
	}


	public Button getJuego3() {
		return juego3;
	}


	public void setJuego3(Button juego3) {
		this.juego3 = juego3;
	}


	public Button getVolver() {
		return volver;
	}


	public void setVolver(Button volver) {
		this.volver = volver;
	}


}
