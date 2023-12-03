
package gesfei.pojo;

/**
 *
 * @author diana
 */
public class Constancia {
    int idConstancia;
    boolean solicitudModificacion;
    boolean generada;
    PersonalUV academico;
    FirmaElectronica firma;

    public Constancia(int idConstancia, boolean solicitudModificacion, boolean generada, PersonalUV academico, FirmaElectronica firma) {
        this.idConstancia = idConstancia;
        this.solicitudModificacion = solicitudModificacion;
        this.generada = generada;
        this.academico = academico;
        this.firma = firma;
    }

    public Constancia(int idConstancia, boolean solicitudModificacion, boolean generada) {
        this.idConstancia = idConstancia;
        this.solicitudModificacion = solicitudModificacion;
        this.generada = generada;
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
