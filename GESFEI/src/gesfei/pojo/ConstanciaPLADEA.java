
package gesfei.pojo;

/**
 *
 * @author diana
 */
public class ConstanciaPLADEA extends Constancia{
    int idConstanciaPladea;
    String director;
    String fechaContribucion;
    String ejeEstrategico;
    String objetivosGenerales;
    String acciones;
    String metas;
    String fechaExpedicion;

    public ConstanciaPLADEA(int idConstanciaPladea, String director, String fechaContribucion, String ejeEstrategico, String objetivosGenerales, String acciones, String metas, String fechaExpedicion, int idConstancia, boolean solicitudModificacion, boolean generada) {
        super(idConstancia, solicitudModificacion, generada);
        this.idConstanciaPladea = idConstanciaPladea;
        this.director = director;
        this.fechaContribucion = fechaContribucion;
        this.ejeEstrategico = ejeEstrategico;
        this.objetivosGenerales = objetivosGenerales;
        this.acciones = acciones;
        this.metas = metas;
        this.fechaExpedicion = fechaExpedicion;
    }

    public ConstanciaPLADEA(int idConstanciaPladea, String director, String fechaContribucion, String ejeEstrategico, String objetivosGenerales, String acciones, String metas, String fechaExpedicion) {
        this.idConstanciaPladea = idConstanciaPladea;
        this.director = director;
        this.fechaContribucion = fechaContribucion;
        this.ejeEstrategico = ejeEstrategico;
        this.objetivosGenerales = objetivosGenerales;
        this.acciones = acciones;
        this.metas = metas;
        this.fechaExpedicion = fechaExpedicion;
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
