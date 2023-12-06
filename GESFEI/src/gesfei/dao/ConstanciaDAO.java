package gesfei.dao;

import gesfei.modelo.ConexionBD;
import gesfei.pojo.Constancia;
import gesfei.pojo.ConstanciaImparticion;
import gesfei.pojo.ConstanciaJurado;
import gesfei.pojo.ConstanciaPLADEA;
import gesfei.pojo.ConstanciaProyecto;
import gesfei.pojo.ResultadoOperacion;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author miran
 */

public class ConstanciaDAO {
    
    public static ArrayList<Constancia> consultarConstanciasCreadasPeriodo(String periodo, int idPersonalUv) throws SQLException{

        ArrayList<Constancia> constanciaProyecto = null;
        Connection conexionBD = ConexionBD.abrirConexionBD();
        int generada = 2;
        if(conexionBD != null){

            try {                
                
               String consulta = "SELECT c.nombreConstancia, c.idconstancia\n" +
                                    "FROM constancia c\n" +
                                    "JOIN periodoescolar_has_constancia cper ON cper.constancia_idconstancia = c.idconstancia\n" +
                                    "JOIN periodoescolar p ON cper.periodoescolar_idperiodoescolar = p.idperiodoescolar\n" +
                                    "WHERE p.clavePeriodo = ? AND c.generada = ? AND c.personaluv_idpersonaluv = ?";
               PreparedStatement consultaObtenerTodos = conexionBD.prepareStatement(consulta);
               consultaObtenerTodos.setString(1, periodo);
               consultaObtenerTodos.setInt(2, generada);
               consultaObtenerTodos.setInt(3, idPersonalUv);
               ResultSet resultadoConsulta = consultaObtenerTodos.executeQuery();
               
               constanciaProyecto = new ArrayList<>();
               
               while(resultadoConsulta.next()){
                   
                    Constancia temp = new Constancia();
                    temp.setIdConstancia(resultadoConsulta.getInt("idconstancia"));
                    temp.setNombrePDF(resultadoConsulta.getString("nombreConstancia"));
                   
                   constanciaProyecto.add(temp);
               }
               
            } catch (SQLException ex) {
                ex.printStackTrace();
                
            } finally{
                conexionBD.close();
            }
            
        }
        return constanciaProyecto;
    }
    
    public static File consultarConstanciaCreada(String periodo, int idPersonalUv, int idConstancia) throws SQLException{

        ArrayList<Constancia> constanciaProyecto = null;
        Connection conexionBD = ConexionBD.abrirConexionBD();
        int generada = 2;
        if(conexionBD != null){

            try {                
                String consulta = "SELECT c.constancia\n" +
                                     "FROM constancia c\n" +
                                     "JOIN periodoescolar_has_constancia cper ON cper.constancia_idconstancia = c.idconstancia\n" +
                                     "JOIN periodoescolar p ON cper.periodoescolar_idperiodoescolar = p.idperiodoescolar\n" +
                                     "WHERE p.clavePeriodo = ? AND c.generada = ? AND c.personaluv_idpersonaluv = ? AND c.idconstancia = ?";
                PreparedStatement consultaObtenerTodos = conexionBD.prepareStatement(consulta);
                consultaObtenerTodos.setString(1, periodo);
                consultaObtenerTodos.setInt(2, generada);
                consultaObtenerTodos.setInt(3, idPersonalUv);
                consultaObtenerTodos.setInt(4, idConstancia);
                ResultSet resultadoConsulta = consultaObtenerTodos.executeQuery();
       
                if (resultadoConsulta.next()) {
                    InputStream inputStream = resultadoConsulta.getBinaryStream("constancia");

                    File constanciaPDF = File.createTempFile("constancia", ".pdf");

                    try (FileOutputStream fos = new FileOutputStream(constanciaPDF)) {
                        byte[] buffer = new byte[1024];
                        int bytesRead;
                        while ((bytesRead = inputStream.read(buffer)) != -1) {
                            fos.write(buffer, 0, bytesRead);
                        }
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    } catch (IOException io) {
                        io.getMessage();
                    }
                    return constanciaPDF;
                }  
            } catch (SQLException ex) {
                ex.printStackTrace(); 
            } catch (IOException ex) {
                Logger.getLogger(ConstanciaDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                conexionBD.close();
            }
        }
        return null;
    }
    
    public static ArrayList<ConstanciaImparticion> consultarConstanciasImparticion() throws SQLException{

        ArrayList<ConstanciaImparticion> imparticionBD = null;
        Connection conexionBD = ConexionBD.abrirConexionBD();
        if(conexionBD != null){

            try {                
                
               String consulta = "SELECT ci.*, pu.nombre, pu.apellidos, fe.firmaelectronica\n" +
                                    "FROM constanciaimparticion ci\n" +
                                    "JOIN constancia c ON ci.constancia_idconstancia = c.idconstancia\n" +
                                    "JOIN personaluv pu ON ci.constancia_personaluv_idpersonaluv = pu.idpersonaluv\n" +
                                    "JOIN firmaelectronica fe ON ci.constancia_firmaelectronica_idfirmaelectronica = fe.idfirmaelectronica\n" +
                                    "WHERE ci.constancia_personaluv_idpersonaluv = ? AND c.generada = ?";
               PreparedStatement consultaObtenerTodos = conexionBD.prepareStatement(consulta);
               consultaObtenerTodos.setInt(1, 1);
               consultaObtenerTodos.setInt(2, 1);
               ResultSet resultadoConsulta = consultaObtenerTodos.executeQuery();
               
               imparticionBD = new ArrayList<>();
               
               while(resultadoConsulta.next()){
                   
                    ConstanciaImparticion temp = new ConstanciaImparticion();
                    temp.setIdConstanciaImparticion(resultadoConsulta.getInt("idconstanciaimparticion"));
                    temp.setDirector(resultadoConsulta.getString("director"));
                    temp.setPeriodoImparticion(resultadoConsulta.getString("periodoImparticion"));
                    temp.setProgramaEducativo(resultadoConsulta.getString("programaEducativo"));
                    temp.setHsm(resultadoConsulta.getString("hsm"));
                    temp.setFechaExpedicion(resultadoConsulta.getString("fechaExpedicion"));
                    temp.setNombreAcademico(resultadoConsulta.getString("nombre"));
                    temp.setApellidosAcademico(resultadoConsulta.getString("apellidos"));
                    temp.setFirmaElectronica(resultadoConsulta.getBytes("firmaElectronica"));
                    temp.setIdConstancia(resultadoConsulta.getInt("constancia_idconstancia"));
                   
                   imparticionBD.add(temp);
               }
               
            } catch (SQLException ex) {
                ex.printStackTrace();
                
            } finally{
                conexionBD.close();
            }
            
        }
        return imparticionBD;
    }
    
    public static ConstanciaImparticion recuperarConstanciaImparticion(int idConstanciaImparticion) throws SQLException{
        Connection conexionBD = ConexionBD.abrirConexionBD();
        if(conexionBD != null){

            try {                
                
                String consulta = "SELECT ci.*, pu.nombre, pu.apellidos, fe.firmaelectronica\n" +
                                     "FROM constanciaimparticion ci\n" +
                                     "JOIN personaluv pu ON ci.constancia_personaluv_idpersonaluv = pu.idpersonaluv\n" +
                                     "JOIN firmaelectronica fe ON ci.constancia_firmaelectronica_idfirmaelectronica = fe.idfirmaelectronica\n" +
                                     "WHERE ci.idconstanciaimparticion = ?";
                PreparedStatement consultaObtenerTodos = conexionBD.prepareStatement(consulta);
                consultaObtenerTodos.setInt(1, idConstanciaImparticion);
                ResultSet resultadoConsulta = consultaObtenerTodos.executeQuery();

                ConstanciaImparticion temp = new ConstanciaImparticion();
                temp.setIdConstanciaImparticion(resultadoConsulta.getInt("idconstanciaimparticion"));
                temp.setDirector(resultadoConsulta.getString("director"));
                temp.setPeriodoImparticion(resultadoConsulta.getString("periodoImparticion"));
                temp.setProgramaEducativo(resultadoConsulta.getString("programaEducativo"));
                temp.setHsm(resultadoConsulta.getString("hsm"));
                temp.setFechaExpedicion(resultadoConsulta.getString("fechaExpedicion"));
                temp.setNombreAcademico(resultadoConsulta.getString("nombre"));
                temp.setApellidosAcademico(resultadoConsulta.getString("apellidos"));
                temp.setFirmaElectronica(resultadoConsulta.getBytes("firmaElectronica"));

                return temp;
                
            } catch (SQLException ex) {
                ex.printStackTrace();
                
            } finally{
                conexionBD.close();
            }
            
        }
        return null;
    }
    
    public static ArrayList<ConstanciaJurado> consultarConstanciasJurado() throws SQLException{

        ArrayList<ConstanciaJurado> imparticionBD = null;
        Connection conexionBD = ConexionBD.abrirConexionBD();
        if(conexionBD != null){

            try {                
                
               String consulta = "SELECT cj.*, pu.nombre, pu.apellidos, fe.firmaelectronica\n" +
                                    "FROM constanciajurado cj\n" +
                                    "JOIN constancia c ON cj.constancia_idconstancia = c.idconstancia\n" +
                                    "JOIN personaluv pu ON cj.constancia_personaluv_idpersonaluv = pu.idpersonaluv\n" +
                                    "JOIN firmaelectronica fe ON cj.constancia_firmaelectronica_idfirmaelectronica = fe.idfirmaelectronica\n" +
                                    "WHERE cj.constancia_personaluv_idpersonaluv = ? and c.generada = ?";
               PreparedStatement consultaObtenerTodos = conexionBD.prepareStatement(consulta);
               consultaObtenerTodos.setInt(1, 1);
               consultaObtenerTodos.setInt(2, 1);
               ResultSet resultadoConsulta = consultaObtenerTodos.executeQuery();
               
               imparticionBD = new ArrayList<>();
               
               while(resultadoConsulta.next()){
                   
                   ConstanciaJurado temp = new ConstanciaJurado();
                   temp.setIdConstanciaJurado(resultadoConsulta.getInt("idconstanciajurado"));
                   temp.setDirector(resultadoConsulta.getString("director"));
                   temp.setPuesto(resultadoConsulta.getString("puesto"));
                   temp.setLicenciatura(resultadoConsulta.getString("licenciatura"));
                   temp.setAlumnos(resultadoConsulta.getString("alumnos"));
                   temp.setTituloTrabajo(resultadoConsulta.getString("tituloTrabajo"));
                   temp.setModalidad(resultadoConsulta.getString("modalidad"));
                   temp.setFechaPresentacion(resultadoConsulta.getString("fechaPresentacion"));
                   temp.setResultadoObtenido(resultadoConsulta.getString("resultadoObtenido"));
                   temp.setFechaExpedicion(resultadoConsulta.getString("fechaExpedicion"));
                   temp.setNombreAcademico(resultadoConsulta.getString("nombre"));
                   temp.setApellidosAcademico(resultadoConsulta.getString("apellidos"));
                   temp.setFirmaElectronica(resultadoConsulta.getBytes("firmaElectronica"));
                   temp.setIdConstancia(resultadoConsulta.getInt("constancia_idconstancia"));
                   
                   
                   imparticionBD.add(temp);
               }
               
            } catch (SQLException ex) {
                ex.printStackTrace();
                
            } finally{
                conexionBD.close();
            }
            
        }
        return imparticionBD;
    }
    
    public static ConstanciaJurado recuperarConstanciaJurado(int idConstanciaJurado) throws SQLException{

        Connection conexionBD = ConexionBD.abrirConexionBD();
        if(conexionBD != null){

            try {                
                
                String consulta = "SELECT cj.*, pu.nombre, pu.apellidos, fe.firmaelectronica\n" +
                                    "FROM constanciajurado cj\n" +
                                    "JOIN personaluv pu ON cj.constancia_personaluv_idpersonaluv = pu.idpersonaluv\n" +
                                    "JOIN firmaelectronica fe ON cj.constancia_firmaelectronica_idfirmaelectronica = fe.idfirmaelectronica\n" +
                                    "WHERE cj.idconstanciajurado = ?";
                PreparedStatement consultaObtenerTodos = conexionBD.prepareStatement(consulta);
                consultaObtenerTodos.setInt(1, idConstanciaJurado);
                ResultSet resultadoConsulta = consultaObtenerTodos.executeQuery();

                ConstanciaJurado temp = new ConstanciaJurado();
                temp.setIdConstanciaJurado(resultadoConsulta.getInt("idconstanciajurado"));
                temp.setDirector(resultadoConsulta.getString("director"));
                temp.setPuesto(resultadoConsulta.getString("puesto"));
                temp.setLicenciatura(resultadoConsulta.getString("licenciatura"));
                temp.setAlumnos(resultadoConsulta.getString("alumnos"));
                temp.setTituloTrabajo(resultadoConsulta.getString("tituloTrabajo"));
                temp.setModalidad(resultadoConsulta.getString("modalidad"));
                temp.setFechaPresentacion(resultadoConsulta.getString("fechaPresentacion"));
                temp.setResultadoObtenido(resultadoConsulta.getString("resultadoObtenido"));
                temp.setFechaExpedicion(resultadoConsulta.getString("fechaExpedicion"));
                temp.setNombreAcademico(resultadoConsulta.getString("nombre"));
                temp.setApellidosAcademico(resultadoConsulta.getString("apellidos"));
                temp.setFirmaElectronica(resultadoConsulta.getBytes("firmaElectronica"));
                
                return temp;

            } catch (SQLException ex) {
                ex.printStackTrace();
                
            } finally{
                conexionBD.close();
            }
            
        }
        return null;
    }
    
    public static ArrayList<ConstanciaPLADEA> consultarConstanciasPLADEA() throws SQLException{

        ArrayList<ConstanciaPLADEA> imparticionBD = null;
        Connection conexionBD = ConexionBD.abrirConexionBD();
        if(conexionBD != null){

            try {                
                
               String consulta = "SELECT cp.*, pu.nombre, pu.apellidos, fe.firmaelectronica\n" +
                                    "FROM constanciapladea cp\n" +
                                    "JOIN constancia c ON cp.constancia_idconstancia = c.idconstancia\n" +
                                    "JOIN personaluv pu ON cp.constancia_personaluv_idpersonaluv = pu.idpersonaluv\n" +
                                    "JOIN firmaelectronica fe ON cp.constancia_firmaelectronica_idfirmaelectronica = fe.idfirmaelectronica\n" +
                                    "WHERE cp.constancia_personaluv_idpersonaluv = ? AND c.generada = ?";
               PreparedStatement consultaObtenerTodos = conexionBD.prepareStatement(consulta);
               consultaObtenerTodos.setInt(1, 1);
               consultaObtenerTodos.setInt(2, 1);
               ResultSet resultadoConsulta = consultaObtenerTodos.executeQuery();
               
               imparticionBD = new ArrayList<>();
               
               while(resultadoConsulta.next()){
                   
                   ConstanciaPLADEA temp = new ConstanciaPLADEA();
                   temp.setIdConstanciaPladea(resultadoConsulta.getInt("idconstanciapladea"));
                   temp.setDirector(resultadoConsulta.getString("director"));
                   temp.setFechaContribucion(resultadoConsulta.getString("fechaContribucion"));
                   temp.setEjeEstrategico(resultadoConsulta.getString("ejeEstrategico"));
                   temp.setProgramaEstrategico(resultadoConsulta.getString("programaEstrategico"));
                   temp.setObjetivosGenerales(resultadoConsulta.getString("objetivosGenerales"));
                   temp.setAcciones(resultadoConsulta.getString("acciones"));
                   temp.setMetas(resultadoConsulta.getString("metas"));
                   temp.setFechaExpedicion(resultadoConsulta.getString("fechaExpedicion"));
                   temp.setNombreAcademico(resultadoConsulta.getString("nombre"));
                   temp.setApellidosAcademico(resultadoConsulta.getString("apellidos"));
                   temp.setFirmaElectronica(resultadoConsulta.getBytes("firmaElectronica"));
                   temp.setIdConstancia(resultadoConsulta.getInt("constancia_idconstancia"));
                   
                   imparticionBD.add(temp);
               }
               
            } catch (SQLException ex) {
                ex.printStackTrace();
                
            } finally{
                conexionBD.close();
            }
            
        }
        return imparticionBD;
    }
    
    public static ConstanciaPLADEA recuperarConstanciasPLADEA(int idConstanciaPladea) throws SQLException{

        Connection conexionBD = ConexionBD.abrirConexionBD();
        if(conexionBD != null){

            try {                
                
                String consulta = "SELECT cp.*, pu.nombre, pu.apellidos, fe.firmaelectronica\n" +
                                     "FROM constanciapladea cp\n" +
                                     "JOIN personaluv pu ON cp.constancia_personaluv_idpersonaluv = pu.idpersonaluv\n" +
                                     "JOIN firmaelectronica fe ON cp.constancia_firmaelectronica_idfirmaelectronica = fe.idfirmaelectronica\n" +
                                     "WHERE cp.idconstanciapladea = ?";
                PreparedStatement consultaObtenerTodos = conexionBD.prepareStatement(consulta);
                consultaObtenerTodos.setInt(1, idConstanciaPladea);
                ResultSet resultadoConsulta = consultaObtenerTodos.executeQuery();

                ConstanciaPLADEA temp = new ConstanciaPLADEA();
                temp.setIdConstanciaPladea(resultadoConsulta.getInt("idconstanciapladea"));
                temp.setDirector(resultadoConsulta.getString("director"));
                temp.setFechaContribucion(resultadoConsulta.getString("fechaContribucion"));
                temp.setEjeEstrategico(resultadoConsulta.getString("ejeEstrategico"));
                temp.setProgramaEstrategico(resultadoConsulta.getString("programaEstrategico"));
                temp.setObjetivosGenerales(resultadoConsulta.getString("objetivosGenerales"));
                temp.setAcciones(resultadoConsulta.getString("acciones"));
                temp.setMetas(resultadoConsulta.getString("metas"));
                temp.setFechaExpedicion(resultadoConsulta.getString("fechaExpedicion"));
                temp.setNombreAcademico(resultadoConsulta.getString("nombre"));
                temp.setApellidosAcademico(resultadoConsulta.getString("apellidos"));
                temp.setFirmaElectronica(resultadoConsulta.getBytes("firmaElectronica"));
                   
                return temp;
             
            } catch (SQLException ex) {
                ex.printStackTrace();
                
            } finally{
                conexionBD.close();
            }
            
        }
        return null;
    }
    
    public static ArrayList<ConstanciaProyecto> consultarConstanciasProyecto() throws SQLException{

        ArrayList<ConstanciaProyecto> imparticionBD = null;
        Connection conexionBD = ConexionBD.abrirConexionBD();
        if(conexionBD != null){

            try {                
                
               String consulta = "SELECT cpr.*, pu.nombre, pu.apellidos, fe.firmaelectronica\n" +
                                    "FROM constanciaproyecto cpr\n" +
                                    "JOIN constancia c ON cpr.constancia_idconstancia = c.idconstancia\n" +
                                    "JOIN personaluv pu ON cpr.constancia_personaluv_idpersonaluv = pu.idpersonaluv\n" +
                                    "JOIN firmaelectronica fe ON cpr.constancia_firmaelectronica_idfirmaelectronica = fe.idfirmaelectronica\n" +
                                    "WHERE cpr.constancia_personaluv_idpersonaluv = ? AND c.generada = ?";
               PreparedStatement consultaObtenerTodos = conexionBD.prepareStatement(consulta);
               consultaObtenerTodos.setInt(1, 1);
               consultaObtenerTodos.setInt(2, 1);
               ResultSet resultadoConsulta = consultaObtenerTodos.executeQuery();
               
               imparticionBD = new ArrayList<>();
               
               while(resultadoConsulta.next()){
                   
                   ConstanciaProyecto temp = new ConstanciaProyecto();
                   temp.setIdConstanciaProyecto(resultadoConsulta.getInt("idconstanciaproyecto"));
                   temp.setDirector(resultadoConsulta.getString("director"));
                   temp.setProyectoRealizado(resultadoConsulta.getString("proyectoRealizado"));
                   temp.setDuracion(resultadoConsulta.getString("duracion"));
                   temp.setLugar(resultadoConsulta.getString("lugar"));
                   temp.setNombreInvolucrados(resultadoConsulta.getString("nombreInvolucrados"));
                   temp.setImpactoObtenido(resultadoConsulta.getString("impactoObtenido"));
                   temp.setNombreAcademico(resultadoConsulta.getString("nombre"));
                   temp.setApellidosAcademico(resultadoConsulta.getString("apellidos"));
                   temp.setFirmaElectronica(resultadoConsulta.getBytes("firmaElectronica"));
                   temp.setIdConstancia(resultadoConsulta.getInt("constancia_idconstancia"));
                   
                   imparticionBD.add(temp);
               }
               
            } catch (SQLException ex) {
                ex.printStackTrace();
                
            } finally{
                conexionBD.close();
            }
            
        }
        return imparticionBD;
    }
    
    public static ConstanciaProyecto recuperarConstanciaProyecto(int idConstanciaProyecto) throws SQLException{

        Connection conexionBD = ConexionBD.abrirConexionBD();
        if(conexionBD != null){

            try {                
                
                String consulta = "SELECT cp.*, pu.nombre, pu.apellidos, fe.firmaelectronica\n" +
                                     "FROM constanciaproyecto cp\n" +
                                     "JOIN personaluv pu ON cp.constancia_personaluv_idpersonaluv = pu.idpersonaluv\n" +
                                     "JOIN firmaelectronica fe ON cp.constancia_firmaelectronica_idfirmaelectronica = fe.idfirmaelectronica\n" +
                                     "WHERE cp.idconstanciaproyecto = ?";
                PreparedStatement consultaObtenerTodos = conexionBD.prepareStatement(consulta);
                consultaObtenerTodos.setInt(1, idConstanciaProyecto);
                ResultSet resultadoConsulta = consultaObtenerTodos.executeQuery();
                   
                ConstanciaProyecto temp = new ConstanciaProyecto();
                temp.setIdConstanciaProyecto(resultadoConsulta.getInt("idconstanciaimparticion"));
                temp.setDirector(resultadoConsulta.getString("director"));
                temp.setProyectoRealizado(resultadoConsulta.getString("proyectoRealizado"));
                temp.setDuracion(resultadoConsulta.getString("duracion"));
                temp.setLugar(resultadoConsulta.getString("lugar"));
                temp.setNombreInvolucrados(resultadoConsulta.getString("nombreInvolucrados"));
                temp.setImpactoObtenido(resultadoConsulta.getString("impactoObtenido"));
                temp.setNombreAcademico(resultadoConsulta.getString("nombre"));
                temp.setApellidosAcademico(resultadoConsulta.getString("apellidos"));
                temp.setFirmaElectronica(resultadoConsulta.getBytes("firmaElectronica"));
                   
                return temp;
               
            } catch (SQLException ex) {
                ex.printStackTrace();
                
            } finally{
                conexionBD.close();
            }
            
        }
        return null;
    }
    
    public static ResultadoOperacion guardarConstanciaPDF (File constanciaPDF, String nombrePDF, int idConstancia) throws SQLException{
        ResultadoOperacion respuesta = new ResultadoOperacion();
        respuesta.setError(true);
        respuesta.setFilasAfectadas(-1);
        Connection conexionBD = ConexionBD.abrirConexionBD();
        int generada = 2; 
        
        if(conexionBD != null){
           
            try {

                String sentencia = "INSERT INTO constancia (constancia, nombreConstancia, generada)"
                                   + " VALUES (?, ?, ?) WHERE idconstancia = ?";
                
                PreparedStatement prepararSentencia = conexionBD.prepareStatement(sentencia);
                prepararSentencia.setBlob(1, (Blob) constanciaPDF);
                prepararSentencia.setString(2, nombrePDF);
                prepararSentencia.setInt(3, generada);
                prepararSentencia.setInt(4, idConstancia);

                int numeroFilas = prepararSentencia.executeUpdate();
                if(numeroFilas > 0){
                    respuesta.setError(false);
                    respuesta.setFilasAfectadas(numeroFilas);
                    respuesta.setMensaje("PDF guardado con éxito.");
                }else{
                    respuesta.setMensaje("No se pudo registrar la información de la constancia.");
                }
                
            } catch (SQLException e) {
                respuesta.setMensaje(e.getMessage());
                
            } finally{
                conexionBD.close();
            }
            
        }else{
            respuesta.setMensaje("Error en la conexión con la base de datos. Intente de nuevo más tarde.");
        }
        return respuesta;       
    }
}
