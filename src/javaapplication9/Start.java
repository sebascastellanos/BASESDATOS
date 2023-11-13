
package javaapplication9;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author sebastian
 */
public class Start extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        launch(args);
    }
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/vista/login.fxml")); // Arma la ventana con el codigo XML
        Scene scene = new Scene(root);
        stage.setScene(scene);
        
        stage.setTitle("CadooRent");
        stage.setResizable(false); // no permite redimensionar la ventana
        stage.setOnCloseRequest( event -> {event.consume();}); 
        stage.show(); // la muestra  
    }  
    
    
}
