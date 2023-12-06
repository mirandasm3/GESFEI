
package gesfei.pojo;

import java.io.File;

/**
 *
 * @author diana
 */
public class ConstanciaProyecto extends Constancia{
    int idConstanciaProyecto;
    String director;
    String proyectoRealizado;
    String duracion;
    String lugar;
    String nombreInvolucrados;
    String impactoObtenido;

    public ConstanciaProyecto(int idConstanciaProyecto, String director, String proyectoRealizado, String duracion, String lugar, String nombreInvolucrados, String impactoObtenido, int idConstancia, String nombreAcademico, String apellidosAcademico, byte[] firmaElectronica) {
        super(idConstancia, nombreAcademico, apellidosAcademico, firmaElectronica);
        this.idConstanciaProyecto = idConstanciaProyecto;
        this.director = director;
        this.proyectoRealizado = proyectoRealizado;
        this.duracion = duracion;
        this.lugar = lugar;
        this.nombreInvolucrados = nombreInvolucrados;
        this.impactoObtenido = impactoObtenido;
    }

    public ConstanciaProyecto(int idConstanciaProyecto, String director, String proyectoRealizado, String duracion, String lugar, String nombreInvolucrados, String impactoObtenido) {
        this.idConstanciaProyecto = idConstanciaProyecto;
        this.director = director;
        this.proyectoRealizado = proyectoRealizado;
        this.duracion = duracion;
        this.lugar = lugar;
        this.nombreInvolucrados = nombreInvolucrados;
        this.impactoObtenido = impactoObtenido;
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

    public ConstanciaProyecto() {
    }

    public int getIdConstanciaProyecto() {
        return idConstanciaProyecto;
    }

    public void setIdConstanciaProyecto(int idConstanciaProyecto) {
        this.idConstanciaProyecto = idConstanciaProyecto;
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

    public String getProyectoRealizado() {
        return proyectoRealizado;
    }

    public void setProyectoRealizado(String proyectoRealizado) {
        this.proyectoRealizado = proyectoRealizado;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getNombreInvolucrados() {
        return nombreInvolucrados;
    }

    public void setNombreInvolucrados(String nombreInvolucrados) {
        this.nombreInvolucrados = nombreInvolucrados;
    }

    public String getImpactoObtenido() {
        return impactoObtenido;
    }

    public void setImpactoObtenido(String impactoObtenido) {
        this.impactoObtenido = impactoObtenido;
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
