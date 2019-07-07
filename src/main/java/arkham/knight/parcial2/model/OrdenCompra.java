package arkham.knight.parcial2.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document
public class OrdenCompra {

    @Id
    private String id;

    private Date fechaOrden;
    private float montoTotal;

    //En una orden de compra hay un suplidor
    private Suplidor suplidor;

    // En una orden de compra puede haber uno o varios componentes
    private List<Componente> componentes;

    public OrdenCompra(Date fechaOrden, float montoTotal, Suplidor suplidor, List<Componente> componentes) {
        this.fechaOrden = fechaOrden;
        this.montoTotal = montoTotal;
        this.suplidor = suplidor;
        this.componentes = componentes;
    }

    public OrdenCompra() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public float getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(float montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Suplidor getSuplidor() {
        return suplidor;
    }

    public void setSuplidor(Suplidor suplidor) {
        this.suplidor = suplidor;
    }

    public List<Componente> getComponentes() {
        return componentes;
    }

    public void setComponentes(List<Componente> componentes) {
        this.componentes = componentes;
    }
}
