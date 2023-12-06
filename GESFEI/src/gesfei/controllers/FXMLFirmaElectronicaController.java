
package gesfei.controllers;

import gesfei.dao.FirmaElectronicaDAO;
import gesfei.pojo.ResultadoOperacion;
import gesfei.util.Utilidades;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author diana
 */
public class FXMLFirmaElectronicaController implements Initializable {

    @FXML
    private Text txtFechaActualizacion;
    @FXML
    private ImageView ivFirma;
    private Image nuevaFirma;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        recuperarFirma();
    }

    public void recuperarFirma(){
        try {
            String ultimaActualizacion = FirmaElectronicaDAO.recuperarFirma().getUltimaActualizacion();
            txtFechaActualizacion.setText(ultimaActualizacion);
            
            byte[] firmaElectronica = FirmaElectronicaDAO.recuperarFirma().getFirmaElectronica();
            ByteArrayInputStream inputStream = new ByteArrayInputStream(firmaElectronica);
            Image imagenFirma = new Image(inputStream);
            ivFirma.setImage(imagenFirma);
            
        } catch (SQLException ex) {
            Utilidades.mostrarAlertaSimple("Error", "Error en la conexión con la base de datos. Intente de nuevo más tarde.", Alert.AlertType.ERROR);
        }
    }    

    @FXML
    private void volver(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmación");
        alert.setHeaderText("¿Desea cancelar la operación?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            Stage escenario = (Stage) txtFechaActualizacion.getScene().getWindow();
            escenario.close();
        }else{
            alert.close();
        }
    }

    @FXML
    private void actualizarFirma(ActionEvent event) {
        try {
            if (nuevaFirma != null) {
                ResultadoOperacion resultado = FirmaElectronicaDAO.actualizarFirma(nuevaFirma);
                if (resultado.isError()) {
                    Utilidades.mostrarAlertaSimple("Error", "El archivo es muy grande, seleccione uno de menor tamaño.", Alert.AlertType.ERROR);
                } else {
                    Utilidades.mostrarAlertaSimple("Actualización exitosa", "Firma electrónica actualizada con éxito.", Alert.AlertType.INFORMATION);
                    Stage escenario = (Stage) txtFechaActualizacion.getScene().getWindow();
                    escenario.close();
                }
            } else {
                Utilidades.mostrarAlertaSimple("Advertencia", "No se ha seleccionado ninguna nueva firma para guardar.", Alert.AlertType.WARNING);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            Utilidades.mostrarAlertaSimple("Error", "Error al guardar la firma en la base de datos.", Alert.AlertType.ERROR);
        }
    }
    
    @FXML
    private void subirFirma(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar imagen de firma");

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(".png", "*.png");
        fileChooser.getExtensionFilters().add(extFilter);

        File archivoSeleccionado = fileChooser.showOpenDialog(null);

        if (archivoSeleccionado != null) {
            try {
                byte[] firmaBytes = Utilidades.convertirArchivoABytes(archivoSeleccionado);

                ByteArrayInputStream inputStream = new ByteArrayInputStream(firmaBytes);
                nuevaFirma = new Image(inputStream);

                ivFirma.setImage(nuevaFirma);

            } catch (Exception ex) {
                ex.printStackTrace();
                Utilidades.mostrarAlertaSimple("Error", "Error al procesar la imagen. Intente de nuevo.", Alert.AlertType.ERROR);
            }
        }
    }
}
