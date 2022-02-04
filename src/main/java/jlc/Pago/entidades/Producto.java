package jlc.Pago.entidades;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Producto {
    @Id
    @GeneratedValue(generator = "prod-generator")
    @GenericGenerator(name = "prod-generator", parameters = {@org.hibernate.annotations.Parameter(name = "prefix", value = "prod"),@org.hibernate.annotations.Parameter(name = "longitud", value = "15")}
            , strategy = "jlc.Pago.entidades.MyGenerator")
    private String id;
    private String nombre;
    private double precio;
    private String descripcion;
    @ManyToMany()
    private List<PaqueteProducto> paqueteProductoList = new ArrayList<PaqueteProducto>();






    public Producto() {
    }

    public Producto(String nombre, double precio, String descripcion) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }


    public List<PaqueteProducto> getPaqueteProductoList() {
        return paqueteProductoList;
    }

    public void setPaqueteProductoList(List<PaqueteProducto> paqueteProductoList) {
        this.paqueteProductoList = paqueteProductoList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
