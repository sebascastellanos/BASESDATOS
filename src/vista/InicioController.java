/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package vista;

import conexion.Conexion;
import java.io.IOException;
import java.net.URL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author sebastian
 */
public class InicioController implements Initializable {

    @FXML
    private Button btnEliminarbase;
    @FXML
    private Button btnCrearbasedatos;
    @FXML
    private Button btnSalir;
    @FXML
    private ComboBox comboInterfaz;

    private Conexion conexion;
    @FXML
    private Button btnAcceder;
    
     
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        cargarBasesDeDatos();
        
        comboInterfaz.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                   
                }
        );
    } 
    
    
    
    
    
     private void cargarBasesDeDatos() {
        if (LoginController.conexion != null) {
            try (Statement statement = LoginController.conexion.createStatement()) {
                ResultSet resultSet = statement.executeQuery("SHOW DATABASES");

                ObservableList<String> basesDeDatos = FXCollections.observableArrayList();

                while (resultSet.next()) {
                    basesDeDatos.add(resultSet.getString(1));
                }

                comboInterfaz.setItems(basesDeDatos);

                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    @FXML
    private void doAcceder(ActionEvent event) {
        String selectedDatabase = (String) comboInterfaz.getValue();

        if (selectedDatabase != null && !selectedDatabase.isEmpty()) {
            abrirNuevaVentana(selectedDatabase);
        } else {
            System.out.println("No se ha seleccionado ninguna base de datos.");
            // Puedes mostrar un mensaje de error al usuario si es necesario
        }
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
    
    private void abrirNuevaVentana(String selectedDatabase) {
        try {
            // Cargar el nuevo FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/tabla1.fxml"));
            Parent root = loader.load();

            // Pasar la información necesaria al controlador del nuevo FXML
            Tabla1Controller nuevoArchivoController = loader.getController();
            nuevoArchivoController.setNombreBaseDatos(selectedDatabase);

            // Mostrar la nueva ventana
            Stage stage = new Stage();
            stage.setTitle("Nueva Ventana");
            stage.setScene(new Scene(root));
            stage.show();
            
            Stage myStage = (Stage) this.btnAcceder.getScene().getWindow();
            myStage.close();
        } catch (IOException e) {
            
            
        }
    }
    
}
