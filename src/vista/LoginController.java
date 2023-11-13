/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package vista;

import conexion.Conexion;
import java.io.IOException;
import java.net.URL;
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
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class LoginController implements Initializable {

    @FXML
    private Button btnEntrar;
    @FXML
    private Button btnCancelar;
    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField txtPass;
    @FXML
    private TextField txtMaquina;
    @FXML
    private TextField txtPuerto;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

    }    
    
    static Conexion conexion;
    @FXML
    private void doEntrar(ActionEvent event) {
        
        String userr = /*txtUsuario.getText();*/ "root";
        String password = /*txtPass.getText();*/ "12345";
        String maquina = /*txtMaquina.getText();*/ "localhost";
        String puerto = /*txtPuerto.getText();*/ "3306";
        
        
        conexion = new Conexion(userr, maquina, password, puerto);
        if (conexion.validarUsuario()) {
            abrirNuevaVentana();
        } else {
            JOptionPane.showMessageDialog(null, "Login fallido - No se pudo establecer la conexión al motor de base de datos");
        }
            
    
    }
    
    private void abrirNuevaVentana() {
        
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/inicio.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            InicioController ouControlador = loader.getController();
            

            Stage stage = new Stage();
            stage.setOnCloseRequest(even -> {
                even.consume(); 
            });
            stage.setResizable(false);
            stage.setTitle("CARROS");
            stage.setScene(scene);
            stage.show();

            Stage myStage = (Stage) this.btnEntrar.getScene().getWindow();
            myStage.close();
        }
        catch (IOException ex) {
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
