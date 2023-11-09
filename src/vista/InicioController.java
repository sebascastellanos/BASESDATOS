/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package vista;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author sebastian
 */
public class InicioController implements Initializable {

    @FXML
    private Button btnEntrar;
    @FXML
    private Button btnEliminarbase;
    @FXML
    private Button btnCrearbasedatos;
    @FXML
    private Button btnSalir;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void doAcceder(ActionEvent event) {
    }

    @FXML
    private void doEliminarbase(ActionEvent event) {
    }

    @FXML
    private void doCrearbasedatos(ActionEvent event) {
    }

    @FXML
    private void doSalir(ActionEvent event) {
        Stage stage = (Stage) this.btnSalir.getScene().getWindow();
        stage.close();
        System.exit(0);
    }
    
}
