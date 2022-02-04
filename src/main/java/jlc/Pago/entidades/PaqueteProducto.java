package jlc.Pago.entidades;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PaqueteProducto {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String nombrePaquete;
    private double descuento;
    private boolean visible = true;
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "paqueteProductoList", cascade = CascadeType.ALL)
    private List<Producto> productoList = new ArrayList<Producto>();



    public PaqueteProducto() {
    }

    public PaqueteProducto(String nombrePaquete, double descuento) {
        this.nombrePaquete = nombrePaquete;
        this.descuento = descuento;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean addProducto(Producto producto){
        producto.getPaqueteProductoList().add(this);
        productoList.add(producto);
        return true;
    }

    public BigDecimal getFees(){
        double tot = 0;

        for (Producto aux:productoList
        ) {
            tot+= aux.getPrecio();
        }
        double aux = tot*0.029;
        aux+=0.3;

        BigDecimal total = BigDecimal.valueOf(aux).setScale(2,BigDecimal.ROUND_HALF_UP);
        return total;
    }

    public BigDecimal getTotal(){
        double tot = 0;

        for (Producto aux:productoList
             ) {
            tot+= aux.getPrecio();
        }
        BigDecimal total = BigDecimal.valueOf(tot).setScale(2,BigDecimal.ROUND_HALF_UP);
        return total;
    }


    public BigDecimal getTotalConFees(){
        double tot = 0;

        for (Producto aux:productoList
        ) {
            tot+= aux.getPrecio();
        }
        double aux = tot*0.029;
        aux+=0.3;
        aux+=tot;
        BigDecimal total = BigDecimal.valueOf(aux).setScale(2,BigDecimal.ROUND_HALF_UP);
        return total;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombrePaquete() {
        return nombrePaquete;
    }

    public void setNombrePaquete(String nombrePaquete) {
        this.nombrePaquete = nombrePaquete;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }
}
