package application;
	
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	private Stage stage;
	private FXMLLoader loader;
	private AnchorPane page;

	@Override
	public void start(Stage primaryStage) {
		stage = primaryStage;        
        carregaPg();
        primaryStage.show();
	}
	
	private void carregaPg() {
		try {
			BrowserFXController login = (BrowserFXController) replaceSceneContent("Browser.fxml");            
            
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
	}

	private Initializable replaceSceneContent(String fxml) throws IOException {
		loader = new FXMLLoader();
        InputStream in = Main.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(Main.class.getResource(fxml));        
        try {
            page = (AnchorPane) loader.load(in);
        } finally {
            in.close();
        }
        
        Scene scene = new Scene(page);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.centerOnScreen();
        return (Initializable) loader.getController();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
