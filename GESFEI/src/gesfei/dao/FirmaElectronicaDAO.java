
package gesfei.dao;

import gesfei.modelo.ConexionBD;
import gesfei.pojo.FirmaElectronica;
import gesfei.pojo.ResultadoOperacion;
import gesfei.util.Utilidades;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;

/**
 *
 * @author miran
 */
public class FirmaElectronicaDAO {
    
    public static FirmaElectronica recuperarFirma() throws SQLException{
        FirmaElectronica firmaTemporal = null;
        Connection conexionBD = ConexionBD.abrirConexionBD();
        if(conexionBD != null){
            try {
                String consulta = "SELECT * FROM firmaelectronica";
                PreparedStatement consultaDB = conexionBD.prepareStatement(consulta);
                ResultSet resultadoConsulta = consultaDB.executeQuery();
                firmaTemporal = new FirmaElectronica();                
                if(resultadoConsulta.next()){
                    firmaTemporal.setIdFirmaElectronica(resultadoConsulta.getInt("idfirmaelectronica"));
                    firmaTemporal.setUltimaActualizacion(resultadoConsulta.getString("fechaUltimaActualizacion"));
                    firmaTemporal.setFirmaElectronica(resultadoConsulta.getBytes("firmaElectronica"));
                }else{
                    firmaTemporal.setIdFirmaElectronica(-1);
                }
            } catch (SQLException s) {
                s.printStackTrace();
            } finally {
                conexionBD.close();
            }
        }
        return firmaTemporal;
    }
    
    public static ResultadoOperacion actualizarFirma (Image firma) throws SQLException{
        ResultadoOperacion respuesta = new ResultadoOperacion();
        respuesta.setError(true);
        respuesta.setFilasAfectadas(-1);
        Connection conexionBD = ConexionBD.abrirConexionBD();
        LocalDate fechaHoy = LocalDate.now();
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fechaFormateada = fechaHoy.format(formateador);
        Date fechaSql = Date.valueOf(fechaFormateada);
        
        if(conexionBD != null){
           
            try {

                byte[] firmaBytes = Utilidades.convertirImagenABytes(firma);
                
                String sentencia = "UPDATE firmaelectronica set fechaUltimaActualizacion = ?, firmaElectronica = ? WHERE idfirmaelectronica = 1";
                
                PreparedStatement prepararSentencia = conexionBD.prepareStatement(sentencia);
                prepararSentencia.setDate(1, fechaSql);
                prepararSentencia.setBytes(2, firmaBytes);

                int numeroFilas = prepararSentencia.executeUpdate();
                if(numeroFilas > 0){
                    respuesta.setError(false);
                    respuesta.setFilasAfectadas(numeroFilas);
                    respuesta.setMensaje("Firma actualizada con éxito.");
                }else{
                    respuesta.setMensaje("No se pudo registrar la información de la firma.");
                }
                
            } catch (SQLException e) {
                respuesta.setMensaje(e.getMessage());
                
            } catch (IOException ex) {
                respuesta.setMensaje(ex.getMessage());
            } finally{
                conexionBD.close();
            }
            
        }else{
            respuesta.setMensaje("Error en la conexión con la base de datos. Intente de nuevo más tarde.");
        }
        return respuesta;       
    }
}
