package arkham.knight.parcial2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// Importante
// Con esta anotacion le indicamos a mongodb que esta clase sera tratada como un documento y sera guardada en una collection y
//el nombre del collection sera el nombre que tiene la clase
@Document
public class Componente {

    // En mongo lo correcto es trabajar el id en string ya que esto funciona diferente de una base de datos relacional
    @Id
    private String id;

    private String descripcion;
    private String  codigoAlmacen;
    private int stock;
    //la unidad de compra basicamente es el precio me confundi debo de cambiar esto
    private String unidadCompra;


    public Componente(String descripcion, String codigoAlmacen, int stock, String unidadCompra) {
        this.descripcion = descripcion;
        this.codigoAlmacen = codigoAlmacen;
        this.stock = stock;
        this.unidadCompra = unidadCompra;
    }

    public Componente() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
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
                "id='" + id + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", codigoAlmacen='" + codigoAlmacen + '\'' +
                ", stock=" + stock +
                ", unidadCompra='" + unidadCompra + '\'' +
                '}';
    }
}
