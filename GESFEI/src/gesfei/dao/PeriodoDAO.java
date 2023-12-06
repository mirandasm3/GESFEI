
package gesfei.dao;

import gesfei.modelo.ConexionBD;
import gesfei.pojo.PeriodoEscolar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author miran
 */
public class PeriodoDAO {
        
    public static ArrayList<PeriodoEscolar> consultarPeriodos() throws SQLException{

        ArrayList<PeriodoEscolar> periodosBD = null;
        Connection conexionBD = ConexionBD.abrirConexionBD();
        if(conexionBD != null){
            try {                 
               String consulta = "SELECT * from periodoescolar";
               PreparedStatement consultaObtenerTodos = conexionBD.prepareStatement(consulta);
               ResultSet resultadoConsulta = consultaObtenerTodos.executeQuery();
               
               periodosBD = new ArrayList<>();
               
               while(resultadoConsulta.next()){
                   
                   PeriodoEscolar temp = new PeriodoEscolar();
                   temp.setIdPeriodoEscolar(resultadoConsulta.getInt("idperiodoescolar"));
                   temp.setClavePerido(resultadoConsulta.getString("clavePeriodo"));
                   temp.setInicioPeriodo(resultadoConsulta.getString("inicioPeriodo"));
                   temp.setFinPeriodo(resultadoConsulta.getString("finPeriodo"));

                   periodosBD.add(temp);
               }
            } catch (SQLException ex) {
                ex.printStackTrace(); 
            } finally{
                conexionBD.close();
            }
        }
        return periodosBD;
    }
    
    public static PeriodoEscolar consultarPeriodo() throws SQLException{

        Connection conexionBD = ConexionBD.abrirConexionBD();
        if(conexionBD != null){
            try {                 
                String consulta = "SELECT * from periodoescolar";
                PreparedStatement consultaObtenerTodos = conexionBD.prepareStatement(consulta);
                ResultSet resultadoConsulta = consultaObtenerTodos.executeQuery();

                PeriodoEscolar temp = new PeriodoEscolar();
                temp.setIdPeriodoEscolar(resultadoConsulta.getInt("idperiodoescolar"));
                temp.setClavePerido(resultadoConsulta.getString("clavePeriodo"));
                temp.setInicioPeriodo(resultadoConsulta.getString("inicioPeriodo"));
                temp.setFinPeriodo(resultadoConsulta.getString("finPeriodo"));
                return temp;
            } catch (SQLException ex) {
                ex.printStackTrace(); 
            } finally{
                conexionBD.close();
            }
        }
        return null;
    }
}
