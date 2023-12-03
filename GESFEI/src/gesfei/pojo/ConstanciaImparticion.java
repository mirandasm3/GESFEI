
package gesfei.pojo;

/**
 *
 * @author diana
 */
public class ConstanciaImparticion extends Constancia{
    int idConstanciaImparticion;
    String director;
    String periodoImparticion;
    String programaEducativo;
    String bloqueSeccionCreditos;
    String hsm;
    String fechaExpedicion;

    public ConstanciaImparticion(int idConstanciaImparticion, String director, String periodoImparticion, String programaEducativo, String bloqueSeccionCreditos, String hsm, String fechaExpedicion, int idConstancia, boolean solicitudModificacion, boolean generada) {
        super(idConstancia, solicitudModificacion, generada);
        this.idConstanciaImparticion = idConstanciaImparticion;
        this.director = director;
        this.periodoImparticion = periodoImparticion;
        this.programaEducativo = programaEducativo;
        this.bloqueSeccionCreditos = bloqueSeccionCreditos;
        this.hsm = hsm;
        this.fechaExpedicion = fechaExpedicion;
    }

    public ConstanciaImparticion(int idConstanciaImparticion, String director, String periodoImparticion, String programaEducativo, String bloqueSeccionCreditos, String hsm, String fechaExpedicion) {
        this.idConstanciaImparticion = idConstanciaImparticion;
        this.director = director;
        this.periodoImparticion = periodoImparticion;
        this.programaEducativo = programaEducativo;
        this.bloqueSeccionCreditos = bloqueSeccionCreditos;
        this.hsm = hsm;
        this.fechaExpedicion = fechaExpedicion;
    }

    public ConstanciaImparticion() {
    }

    public int getIdConstanciaImparticion() {
        return idConstanciaImparticion;
    }

    public void setIdConstanciaImparticion(int idConstanciaImparticion) {
        this.idConstanciaImparticion = idConstanciaImparticion;
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

    public String getPeriodoImparticion() {
        return periodoImparticion;
    }

    public void setPeriodoImparticion(String periodoImparticion) {
        this.periodoImparticion = periodoImparticion;
    }

    public String getProgramaEducativo() {
        return programaEducativo;
    }

    public void setProgramaEducativo(String programaEducativo) {
        this.programaEducativo = programaEducativo;
    }

    public String getBloqueSeccionCreditos() {
        return bloqueSeccionCreditos;
    }

    public void setBloqueSeccionCreditos(String bloqueSeccionCreditos) {
        this.bloqueSeccionCreditos = bloqueSeccionCreditos;
    }

    public String getHsm() {
        return hsm;
    }

    public void setHsm(String hsm) {
        this.hsm = hsm;
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
