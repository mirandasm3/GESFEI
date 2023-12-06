
package gesfei.controllers;

import gesfei.util.Utilidades;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author miran
 */
public class FXMLMenuPrincipalController implements Initializable {

    @FXML
    private Text txtBienvenido1;
    @FXML
    private Text txtBienvenido;
    @FXML
    private Text txtBienvenido2;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void clicSalir(ActionEvent event) {
        Stage escenario = (Stage) txtBienvenido.getScene().getWindow();
        escenario.close();
    }

    @FXML
    private void clicConstanciasPendientes(ActionEvent event) {
        try{
            Parent vista = FXMLLoader.load(getClass().getResource("FXMLConsultarConstanciasPendientes.fxml"));
            Scene escenaAdmin = new Scene(vista);
            Stage escenarioNuevo = new Stage();
            escenarioNuevo.setTitle("Consulta de constancias pendientes");
            escenarioNuevo.setScene(escenaAdmin);
            escenarioNuevo.initModality(Modality.APPLICATION_MODAL);
            escenarioNuevo.showAndWait();
        }catch(IOException io){
            Utilidades.mostrarAlertaSimple("Error", "Error al cargar.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void clicHistorial(ActionEvent event) {
        try{
            Parent vista = FXMLLoader.load(getClass().getResource("FXMLConsultarConstanciasPDF.fxml"));
            Scene escenaAdmin = new Scene(vista);
            Stage escenarioNuevo = new Stage();
            escenarioNuevo.setTitle("Consulta historial de constancias");
            escenarioNuevo.setScene(escenaAdmin);
            escenarioNuevo.initModality(Modality.APPLICATION_MODAL);
            escenarioNuevo.showAndWait();
        }catch(IOException io){
            Utilidades.mostrarAlertaSimple("Error", "Error al cargar.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void actualizarFirma(ActionEvent event) {
        try{
            Parent vista = FXMLLoader.load(getClass().getResource("FXMLFirmaElectronica.fxml"));
            Scene escenaAdmin = new Scene(vista);
            Stage escenarioNuevo = new Stage();
            escenarioNuevo.setTitle("Actualizar firma electrónica");
            escenarioNuevo.setScene(escenaAdmin);
            escenarioNuevo.initModality(Modality.APPLICATION_MODAL);
            escenarioNuevo.showAndWait();
        }catch(IOException io){
            Utilidades.mostrarAlertaSimple("Error", "Error al cargar.", Alert.AlertType.ERROR);
        }
    }
}
