
package gesfei.pojo;

import java.io.File;

/**
 *
 * @author diana
 */
public class ConstanciaPLADEA extends Constancia{
    int idConstanciaPladea;
    String director;
    String fechaContribucion;
    String ejeEstrategico;
    String programaEstrategico;
    String objetivosGenerales;
    String acciones;
    String metas;
    String fechaExpedicion;

    public ConstanciaPLADEA(int idConstanciaPladea, String director, String fechaContribucion, String ejeEstrategico, String programaEstrategico, String objetivosGenerales, String acciones, String metas, String fechaExpedicion, int idConstancia, String nombreAcademico, String apellidosAcademico, byte[] firmaElectronica) {
        super(idConstancia, nombreAcademico, apellidosAcademico, firmaElectronica);
        this.idConstanciaPladea = idConstanciaPladea;
        this.director = director;
        this.fechaContribucion = fechaContribucion;
        this.ejeEstrategico = ejeEstrategico;
        this.programaEstrategico = programaEstrategico;
        this.objetivosGenerales = objetivosGenerales;
        this.acciones = acciones;
        this.metas = metas;
        this.fechaExpedicion = fechaExpedicion;
    }

    public ConstanciaPLADEA(int idConstanciaPladea, String director, String fechaContribucion, String ejeEstrategico, String programaEstrategico, String objetivosGenerales, String acciones, String metas, String fechaExpedicion) {
        this.idConstanciaPladea = idConstanciaPladea;
        this.director = director;
        this.fechaContribucion = fechaContribucion;
        this.ejeEstrategico = ejeEstrategico;
        this.programaEstrategico = programaEstrategico;
        this.objetivosGenerales = objetivosGenerales;
        this.acciones = acciones;
        this.metas = metas;
        this.fechaExpedicion = fechaExpedicion;
    }

    public String getProgramaEstrategico() {
        return programaEstrategico;
    }

    public void setProgramaEstrategico(String programaEstrategico) {
        this.programaEstrategico = programaEstrategico;
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

    public ConstanciaPLADEA() {
    }

    public int getIdConstanciaPladea() {
        return idConstanciaPladea;
    }

    public void setIdConstanciaPladea(int idConstanciaPladea) {
        this.idConstanciaPladea = idConstanciaPladea;
    }

    public int getIdConstancia() {
        return idConstancia;
    }

    public void setIdConstancia(int idConstancia) {
        this.idConstancia = idConstancia;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getFechaContribucion() {
        return fechaContribucion;
    }

    public void setFechaContribucion(String fechaContribucion) {
        this.fechaContribucion = fechaContribucion;
    }

    public String getEjeEstrategico() {
        return ejeEstrategico;
    }

    public void setEjeEstrategico(String ejeEstrategico) {
        this.ejeEstrategico = ejeEstrategico;
    }

    public String getObjetivosGenerales() {
        return objetivosGenerales;
    }

    public void setObjetivosGenerales(String objetivosGenerales) {
        this.objetivosGenerales = objetivosGenerales;
    }

    public String getAcciones() {
        return acciones;
    }

    public void setAcciones(String acciones) {
        this.acciones = acciones;
    }

    public String getMetas() {
        return metas;
    }

    public void setMetas(String metas) {
        this.metas = metas;
    }

    public String getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(String fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
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
}
