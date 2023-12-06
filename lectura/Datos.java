package lectura;

import com.poiji.annotation.ExcelCell;
import com.poiji.annotation.ExcelSheet;

public class Datos {

    @ExcelCell(1)
    private String nombres;

    @ExcelCell(2)
    private String documento;

    @ExcelCell(3)
    private String fechaInicio;

    @ExcelCell(4)
    private String fechaFin;

    @ExcelCell(5)
    private String Eps;

    public Datos() {
    }

    public Datos(String nombres, String documento, String fechaInicio, String fechaFin, String Eps) {
        this.nombres = nombres;
        this.documento = documento;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.Eps = Eps;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEps() {
        return Eps;
    }

    public void setEps(String Eps) {
        this.Eps = Eps;
    }

    @Override
    public String toString() {
        return "Datos{" + "nombres=" + nombres + ", documento=" + documento + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", Eps=" + Eps + '}';
    }

}
