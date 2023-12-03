
package gesfei.dao;

import gesfei.modelo.ConexionBD;
import gesfei.pojo.Clase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author diana
 */
public class ClaseDAO {
    
    public static ArrayList<Clase> consultarClases() throws SQLException{

        ArrayList<Clase> clasesBD = null;
        Connection conexionBD = ConexionBD.abrirConexionBD();
        if(conexionBD != null){
            try {                 
               String consulta = "SELECT * from clase";
               PreparedStatement consultaObtenerTodos = conexionBD.prepareStatement(consulta);
               ResultSet resultadoConsulta = consultaObtenerTodos.executeQuery();
               
               clasesBD = new ArrayList<>();
               
               while(resultadoConsulta.next()){
                   
                   Clase temp = new Clase();
                   temp.setNombre(resultadoConsulta.getString("nombre"));
                   temp.setIdClase(resultadoConsulta.getInt("idclase"));

                   clasesBD.add(temp);
               }
            } catch (SQLException ex) {
                ex.printStackTrace(); 
            } finally{
                conexionBD.close();
            }
        }
        return clasesBD;
    }
}
