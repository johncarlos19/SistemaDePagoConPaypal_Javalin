package jlc.Pago.entidades;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class ProductoVenta {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private double precio;
    private String descripcion;
    @ManyToOne()
    private Factura facturaList;





    public ProductoVenta() {
    }

    public ProductoVenta(String nombre, double precio, String descripcion, Factura factura) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.facturaList =factura;
    }

    public Factura getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(Factura facturaList) {
        this.facturaList = facturaList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
