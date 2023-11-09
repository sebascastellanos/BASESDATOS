/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package vista;

import java.io.IOException;
import java.sql.DriverManager;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * FXML Controller class
 *
 * @author sebastian
 */
public class LoginController implements Initializable {

    @FXML
    private Button btnEntrar;
    @FXML
    private Button btnCancelar;
    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField txtPass;

    Connection con;
    PreparedStatement pst;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void doEntrar(ActionEvent event) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/inicio.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            InicioController ouControlador = loader.getController();

            Stage stage = new Stage();
            stage.setOnCloseRequest(even -> {
                even.consume(); 
            });
            stage.setResizable(false);
            stage.setTitle("INICIO");
            stage.setScene(scene);
            stage.show();

            Stage myStage = (Stage) this.btnEntrar.getScene().getWindow();
            myStage.close();

        } catch (IOException ex) {
            Logger.getLogger(InicioController.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }
    
    

    @FXML
    private void doCancelar(ActionEvent event) {
        Stage stage = (Stage) this.btnCancelar.getScene().getWindow();
        stage.close();
        System.exit(0);
    }
    
}
