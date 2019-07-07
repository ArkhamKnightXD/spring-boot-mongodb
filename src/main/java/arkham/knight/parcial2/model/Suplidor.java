package arkham.knight.parcial2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document
public class Suplidor {

    @Id
    private String id;

    private Date tiempoEntrega;
    private float precioCompra;

    //Un suplidor traer uno o varios componentes.
    private List<Componente> componentes;

    public Suplidor(Date tiempoEntrega, float precioCompra, List<Componente> componentes) {
        this.tiempoEntrega = tiempoEntrega;
        this.precioCompra = precioCompra;
        this.componentes = componentes;
    }

    public Suplidor() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getTiempoEntrega() {
        return tiempoEntrega;
    }

    public void setTiempoEntrega(Date tiempoEntrega) {
        this.tiempoEntrega = tiempoEntrega;
    }

    public float getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(float precioCompra) {
        this.precioCompra = precioCompra;
    }


    public List<Componente> getComponentes() {
        return componentes;
    }

    public void setComponentes(List<Componente> componentes) {
        this.componentes = componentes;
    }


}
