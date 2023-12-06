
package gesfei.pojo;

import java.io.File;

/**
 *
 * @author diana
 */
public class ConstanciaJurado extends Constancia{
    int idConstanciaJurado;
    String director;
    String puesto;
    String licenciatura;
    String alumnos;
    String tituloTrabajo;
    String modalidad;
    String fechaPresentacion;
    String resultadoObtenido;
    String fechaExpedicion;

    public ConstanciaJurado(int idConstanciaJurado, String director, String puesto, String licenciatura, String alumnos, String tituloTrabajo, String modalidad, String fechaPresentacion, String resultadoObtenido, String fechaExpedicion, int idConstancia, String nombreAcademico, String apellidosAcademico, byte[] firmaElectronica) {
        super(idConstancia, nombreAcademico, apellidosAcademico, firmaElectronica);
        this.idConstanciaJurado = idConstanciaJurado;
        this.director = director;
        this.puesto = puesto;
        this.licenciatura = licenciatura;
        this.alumnos = alumnos;
        this.tituloTrabajo = tituloTrabajo;
        this.modalidad = modalidad;
        this.fechaPresentacion = fechaPresentacion;
        this.resultadoObtenido = resultadoObtenido;
        this.fechaExpedicion = fechaExpedicion;
    }

    public ConstanciaJurado(int idConstanciaJurado, String director, String puesto, String licenciatura, String alumnos, String tituloTrabajo, String modalidad, String fechaPresentacion, String resultadoObtenido, String fechaExpedicion) {
        this.idConstanciaJurado = idConstanciaJurado;
        this.director = director;
        this.puesto = puesto;
        this.licenciatura = licenciatura;
        this.alumnos = alumnos;
        this.tituloTrabajo = tituloTrabajo;
        this.modalidad = modalidad;
        this.fechaPresentacion = fechaPresentacion;
        this.resultadoObtenido = resultadoObtenido;
        this.fechaExpedicion = fechaExpedicion;
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

    public ConstanciaJurado() {
    }

    public int getIdConstanciaJurado() {
        return idConstanciaJurado;
    }

    public void setIdConstanciaJurado(int idConstanciaJurado) {
        this.idConstanciaJurado = idConstanciaJurado;
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

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getLicenciatura() {
        return licenciatura;
    }

    public void setLicenciatura(String licenciatura) {
        this.licenciatura = licenciatura;
    }

    public String getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(String alumnos) {
        this.alumnos = alumnos;
    }

    public String getTituloTrabajo() {
        return tituloTrabajo;
    }

    public void setTituloTrabajo(String tituloTrabajo) {
        this.tituloTrabajo = tituloTrabajo;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getFechaPresentacion() {
        return fechaPresentacion;
    }

    public void setFechaPresentacion(String fechaPresentacion) {
        this.fechaPresentacion = fechaPresentacion;
    }

    public String getResultadoObtenido() {
        return resultadoObtenido;
    }

    public void setResultadoObtenido(String resultadoObtenido) {
        this.resultadoObtenido = resultadoObtenido;
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
