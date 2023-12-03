
package gesfei.pojo;

/**
 *
 * @author diana
 */
public class PersonalUV {
    int idPersonalUV;
    String nombre;
    String apellidos;
    int numeroEmpleado;
    String puesto;

    public PersonalUV(int idPersonalUV, String nombre, String apellidos, int numeroEmpleado, String puesto) {
        this.idPersonalUV = idPersonalUV;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.numeroEmpleado = numeroEmpleado;
        this.puesto = puesto;
    }

    public PersonalUV() {
    }

    public int getIdPersonalUV() {
        return idPersonalUV;
    }

    public void setIdPersonalUV(int idPersonalUV) {
        this.idPersonalUV = idPersonalUV;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(int numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
}
