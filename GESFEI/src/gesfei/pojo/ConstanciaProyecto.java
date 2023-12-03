
package gesfei.pojo;

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

    public ConstanciaProyecto(int idConstanciaProyecto, String director, String proyectoRealizado, String duracion, String lugar, String nombreInvolucrados, String impactoObtenido, int idConstancia, boolean solicitudModificacion, boolean generada) {
        super(idConstancia, solicitudModificacion, generada);
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

    public PersonalUV getAcademico() {
        return academico;
    }

    public void setAcademico(PersonalUV academico) {
        this.academico = academico;
    }

    public FirmaElectronica getFirma() {
        return firma;
    }

    public void setFirma(FirmaElectronica firma) {
        this.firma = firma;
    }
}
