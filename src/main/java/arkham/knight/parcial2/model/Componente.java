package arkham.knight.parcial2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Componente {

    @Id
    private int id;

    private String descripcion;
    private String  codigoAlmacen;
    private float balanceActual;
    private String unidadCompra;

    public Componente(int id, String descripcion, String codigoAlmacen, float balanceActual, String unidadCompra) {
        this.id = id;
        this.descripcion = descripcion;
        this.codigoAlmacen = codigoAlmacen;
        this.balanceActual = balanceActual;
        this.unidadCompra = unidadCompra;
    }

    public Componente() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigoAlmacen() {
        return codigoAlmacen;
    }

    public void setCodigoAlmacen(String codigoAlmacen) {
        this.codigoAlmacen = codigoAlmacen;
    }

    public float getBalanceActual() {
        return balanceActual;
    }

    public void setBalanceActual(float balanceActual) {
        this.balanceActual = balanceActual;
    }

    public String getUnidadCompra() {
        return unidadCompra;
    }

    public void setUnidadCompra(String unidadCompra) {
        this.unidadCompra = unidadCompra;
    }

    @Override
    public String toString() {
        return "Componente{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", codigoAlmacen='" + codigoAlmacen + '\'' +
                ", balanceActual=" + balanceActual +
                ", unidadCompra='" + unidadCompra + '\'' +
                '}';
    }
}
