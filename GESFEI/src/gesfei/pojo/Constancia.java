
package gesfei.pojo;

import java.io.File;

/**
 *
 * @author diana
 */
public class Constancia {
    int idConstancia;
    boolean solicitudModificacion;
    boolean generada;
    int idpersonaluv;
    int idfirmaelectronica;
    File constanciaPDF;
    String nombreAcademico;
    String apellidosAcademico;
    byte[] firmaElectronica;
    String nombrePDF;

    public Constancia(int idConstancia, boolean solicitudModificacion, boolean generada, int idpersonaluv, int idfirmaelectronica, String nombrePDF, File constanciaPDF) {
        this.idConstancia = idConstancia;
        this.solicitudModificacion = solicitudModificacion;
        this.generada = generada;
        this.idpersonaluv = idpersonaluv;
        this.idfirmaelectronica = idfirmaelectronica;
        this.nombrePDF = nombrePDF;
        this.constanciaPDF = constanciaPDF;
    }

    public Constancia(int idConstancia, int idpersonaluv, int idfirmaelectronica) {
        this.idConstancia = idConstancia;
        this.idpersonaluv = idpersonaluv;
        this.idfirmaelectronica = idfirmaelectronica;
    }

    public Constancia(int idConstancia, String nombreAcademico, String apellidosAcademico, byte[] firmaElectronica) {
        this.idConstancia = idConstancia;
        this.nombreAcademico = nombreAcademico;
        this.apellidosAcademico = apellidosAcademico;
        this.firmaElectronica = firmaElectronica;
    }

    public Constancia(String nombrePDF) {
        this.nombrePDF = nombrePDF;
    }

    public File getConstanciaPDF() {
        return constanciaPDF;
    }

    public void setConstanciaPDF(File constanciaPDF) {
        this.constanciaPDF = constanciaPDF;
    }

    public String getNombrePDF() {
        return nombrePDF;
    }

    public void setNombrePDF(String nombrePDF) {
        this.nombrePDF = nombrePDF;
    }
    
    public Constancia() {
    }

    public int getIdConstancia() {
        return idConstancia;
    }

    public void setIdConstancia(int idConstancia) {
        this.idConstancia = idConstancia;
    }

    public boolean isSolicitudModificacion() {
        return solicitudModificacion;
    }

    public void setSolicitudModificacion(boolean solicitudModificacion) {
        this.solicitudModificacion = solicitudModificacion;
    }

    public boolean isGenerada() {
        return generada;
    }

    public void setGenerada(boolean generada) {
        this.generada = generada;
    }

    public int getIdpersonaluv() {
        return idpersonaluv;
    }

    public void setIdpersonaluv(int idpersonaluv) {
        this.idpersonaluv = idpersonaluv;
    }

    public int getIdfirmaelectronica() {
        return idfirmaelectronica;
    }

    public void setIdfirmaelectronica(int idfirmaelectronica) {
        this.idfirmaelectronica = idfirmaelectronica;
    }

    public String getNombreAcademico() {
        return nombreAcademico;
    }

    public void setNombreAcademico(String nombreAcademico) {
        this.nombreAcademico = nombreAcademico;
    }

    public String getApellidosAcademico() {
        return apellidosAcademico;
    }

    public void setApellidosAcademico(String apellidosAcademico) {
        this.apellidosAcademico = apellidosAcademico;
    }

    public byte[] getFirmaElectronica() {
        return firmaElectronica;
    }

    public void setFirmaElectronica(byte[] firmaElectronica) {
        this.firmaElectronica = firmaElectronica;
    }
}
