
package gesfei.pojo;

/**
 *
 * @author diana
 */
public class Clase {
    int idClase;
    String nombre;

    public Clase(int idClase, String nombre) {
        this.idClase = idClase;
        this.nombre = nombre;
    }

    public Clase() {
    }

    public int getIdClase() {
        return idClase;
    }

    public void setIdClase(int idClase) {
        this.idClase = idClase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
