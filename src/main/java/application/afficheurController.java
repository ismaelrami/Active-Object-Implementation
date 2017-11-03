package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class afficheurController implements Initializable {

	@FXML
	private BorderPane main;

	@FXML
	public void initialize(URL location, ResourceBundle resources) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/afficheur.fxml"));
			AnchorPane affiche = (AnchorPane) loader.load();
			
			main.setCenter(affiche);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
