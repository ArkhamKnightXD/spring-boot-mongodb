package arkham.knight.parcial2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class MovimientoInventario {

    @Id
    private String id;

    //TipoMovimiento, valores: “ENTRADA”, “SALIDA”
    private String tipoMovimiento;
    private int Cantidad;
    private String unidad;

    private Componente componente;


    public MovimientoInventario(String tipoMovimiento, int cantidad, String unidad, Componente componente) {
        this.tipoMovimiento = tipoMovimiento;
        Cantidad = cantidad;
        this.unidad = unidad;
        this.componente = componente;
    }

    public MovimientoInventario() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public Componente getComponente() {
        return componente;
    }

    public void setComponente(Componente componente) {
        this.componente = componente;
    }
}
