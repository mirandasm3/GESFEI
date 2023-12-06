
package gesfei.controllers;

import gesfei.dao.ConstanciaDAO;
import gesfei.dao.PeriodoDAO;
import gesfei.pojo.Constancia;
import gesfei.pojo.PeriodoEscolar;
import gesfei.util.Utilidades;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author miran
 */
public class FXMLConsultarConstanciasPDFController implements Initializable {

    @FXML
    private TableView<Constancia> tvConstanciaPDF;
    @FXML
    private ComboBox<String> cbPeriodo;
    @FXML
    private TableColumn clnombrePDF;
    private ObservableList<String> listaPeriodos;
    private ObservableList<Constancia> listaContancias = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        llenarCombo();
        clnombrePDF.setCellValueFactory(new PropertyValueFactory<>("nombrePDF"));
        
        tvConstanciaPDF.setItems(listaContancias);
    }    

    public void llenarCombo(){
        ArrayList<String> pes = new ArrayList<String>();
        ArrayList<PeriodoEscolar> periodoConsulta;
        try {
            periodoConsulta = PeriodoDAO.consultarPeriodos();

            for (PeriodoEscolar pe : periodoConsulta) {
                String clavePeriodo = (pe.getClavePerido());
                pes.add(clavePeriodo);
            }
        } catch (SQLException ex) {
            Utilidades.mostrarAlertaSimple("Error", "Error en la conexión con la base de datos. Intente de nuevo más tarde.", Alert.AlertType.ERROR);
        }
        listaPeriodos = FXCollections.observableArrayList(pes);
        cbPeriodo.setItems(listaPeriodos);
    }
    
    @FXML
    private void buscarPDF(ActionEvent event) {
        String periodo = cbPeriodo.getValue();
        if(periodo == null || periodo.isEmpty()){
            Utilidades.mostrarAlertaSimple("Campos vacíos", "Debe seleccionar el filtro de búsqueda.", Alert.AlertType.WARNING);           
        }else {
            ConstanciaDAO cDao = new ConstanciaDAO();
            try {
                List<Constancia> resultados;
                resultados = ConstanciaDAO.consultarConstanciasCreadasPeriodo(periodo, 1);       
                listaContancias.clear();
                if (resultados != null) {
                listaContancias.addAll(resultados);
                }else{
                    listaContancias.addAll(resultados);
                }
            } catch (SQLException ex) {
                Utilidades.mostrarAlertaSimple("Error", "Error en la conexión con la base de datos. Intente de nuevo más tarde.", Alert.AlertType.ERROR);
            }
        }
    }

    @FXML
    private void consultarPDF(ActionEvent event) {
        String periodo = cbPeriodo.getValue();
        Constancia cSeleccionada = tvConstanciaPDF.getSelectionModel().getSelectedItem();
        int idConstancia = cSeleccionada.getIdConstancia();
        if (cSeleccionada == null) {
            Utilidades.mostrarAlertaSimple("Falta selección", "Debe seleccionar un registro de la tabla", Alert.AlertType.WARNING);
        } else {
            try {
                File consPDF = ConstanciaDAO.consultarConstanciaCreada(periodo, 1, idConstancia);
                if (consPDF != null && consPDF.exists()) {
                    abrirPDF(consPDF);
                } else {
                    Utilidades.mostrarAlertaSimple("Error", "El PDF no pudo ser encontrado.", Alert.AlertType.ERROR);
                }
            } catch (SQLException ex) {
                Utilidades.mostrarAlertaSimple("Error", "Error en la conexión con la base de datos. Intente de nuevo más tarde.", Alert.AlertType.ERROR);
            }
        }
    }

    private void abrirPDF(File pdfFile) {
        Platform.runLater(() -> {
            try {
                Desktop.getDesktop().open(pdfFile);
            } catch (IOException e) {
                e.printStackTrace();
                Utilidades.mostrarAlertaSimple("Error", "Error al abrir el PDF.", Alert.AlertType.ERROR);
            }
        });
    }

    @FXML
    private void volver(ActionEvent event) {
        Stage escenario = (Stage) cbPeriodo.getScene().getWindow();
        escenario.close();
    }
}
