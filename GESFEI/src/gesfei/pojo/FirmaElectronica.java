
package gesfei.pojo;

/**
 *
 * @author diana
 */
public class FirmaElectronica {
    int idFirmaElectronica;
    String ultimaActualizacion;
    byte[] firmaElectronica;

    public FirmaElectronica(int idFirmaElectronica, String ultimaActualizacion, byte[] firmaElectronica) {
        this.idFirmaElectronica = idFirmaElectronica;
        this.ultimaActualizacion = ultimaActualizacion;
        this.firmaElectronica = firmaElectronica;
    }

    public FirmaElectronica() {
    }

    public int getIdFirmaElectronica() {
        return idFirmaElectronica;
    }

    public void setIdFirmaElectronica(int idFirmaElectronica) {
        this.idFirmaElectronica = idFirmaElectronica;
    }

    public String getUltimaActualizacion() {
        return ultimaActualizacion;
    }

    public void setUltimaActualizacion(String ultimaActualizacion) {
        this.ultimaActualizacion = ultimaActualizacion;
    }

    public byte[] getFirmaElectronica() {
        return firmaElectronica;
    }

    public void setFirmaElectronica(byte[] firmaElectronica) {
        this.firmaElectronica = firmaElectronica;
    }
    
    
}
