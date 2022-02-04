package jlc.Pago.servicios;

import jlc.Pago.controlador.GestionadDB;
import jlc.Pago.entidades.Producto;
import jlc.Pago.entidades.ProductoVenta;

public class ProductoVentaServicios extends GestionadDB<ProductoVenta> {

    private static ProductoVentaServicios instance;


    public static ProductoVentaServicios getInstance(){
        if(instance==null){
            instance = new ProductoVentaServicios();
        }
        return instance;
    }
    public ProductoVentaServicios() {
        super(ProductoVenta.class);
    }
}
