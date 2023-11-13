/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package vista;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author sebastian
 */
public class Tabla1Controller implements Initializable {

    @FXML
    private TableView<?> tab;
    
    
    private String nombreBaseDatos;
    @FXML
    private Label lblNombreBasesDatos;
    @FXML
    private Button btnRegresar;
    @FXML
    private TableColumn<String, String> columTablas;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        columTablas.setCellValueFactory(new PropertyValueFactory<>("nombreTabla"));
    }    

    public void setNombreBaseDatos(String nombreBaseDatos) {
        this.nombreBaseDatos = nombreBaseDatos;
        lblNombreBasesDatos.setText("Base de datos seleccionada: " + nombreBaseDatos);
        cargarDatosTabla();
    }
    
    private void cargarDatosTabla() {
        // Limpiar el TableView antes de cargar nuevos datos
        tab.getItems().clear();

        // Crear una lista observable para almacenar las tablas
        ObservableList<String> nombresTablas = FXCollections.observableArrayList();

        // Realizar la consulta para obtener las tablas de la base de datos
        try {
            DatabaseMetaData metaData = LoginController.conexion.getMetaData();
            ResultSet resultSet = metaData.getTables(null, null, "%", null);

            while (resultSet.next()) {
                String nombreTabla = resultSet.getString(3); // El índice 3 contiene el nombre de la tabla
                nombresTablas.add(nombreTabla);
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar errores al obtener las tablas
        }

        // Configurar el ComboBox con la lista de nombres de tablas
        
    }

    @FXML
    private void doRegresar(ActionEvent event) {
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Inicio.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            stage.setTitle("INICIO");
            stage.setScene(scene);
            stage.show();
            Stage myStage = (Stage) this.btnRegresar.getScene().getWindow();
            myStage.close();

        } catch (IOException ex) {
            Logger.getLogger(InicioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
