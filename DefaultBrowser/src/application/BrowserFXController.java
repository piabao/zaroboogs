package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class BrowserFXController implements Initializable{
	
	@FXML
	WebView browser;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		 WebEngine webEngine = browser.getEngine();
		 webEngine.load("http://www.digitro.com.br");
	}

}
