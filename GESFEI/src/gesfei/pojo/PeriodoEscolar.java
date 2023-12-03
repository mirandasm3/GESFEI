
package gesfei.pojo;

/**
 *
 * @author diana
 */
public class PeriodoEscolar {
    int idPeriodoEscolar;
    String clavePerido;
    String inicioPeriodo;
    String finPeriodo;

    public PeriodoEscolar(int idPeriodoEscolar, String clavePerido, String inicioPeriodo, String finPeriodo) {
        this.idPeriodoEscolar = idPeriodoEscolar;
        this.clavePerido = clavePerido;
        this.inicioPeriodo = inicioPeriodo;
        this.finPeriodo = finPeriodo;
    }

    public PeriodoEscolar() {
    }

    public int getIdPeriodoEscolar() {
        return idPeriodoEscolar;
    }

    public void setIdPeriodoEscolar(int idPeriodoEscolar) {
        this.idPeriodoEscolar = idPeriodoEscolar;
    }

    public String getClavePerido() {
        return clavePerido;
    }

    public void setClavePerido(String clavePerido) {
        this.clavePerido = clavePerido;
    }

    public String getInicioPeriodo() {
        return inicioPeriodo;
    }

    public void setInicioPeriodo(String inicioPeriodo) {
        this.inicioPeriodo = inicioPeriodo;
    }

    public String getFinPeriodo() {
        return finPeriodo;
    }

    public void setFinPeriodo(String finPeriodo) {
        this.finPeriodo = finPeriodo;
    }
}
