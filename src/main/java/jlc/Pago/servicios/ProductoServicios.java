package jlc.Pago.servicios;

import jlc.Pago.controlador.GestionadDB;
import jlc.Pago.entidades.Producto;

public class ProductoServicios  extends GestionadDB<Producto> {

    private static ProductoServicios instance;
    public ProductoServicios() {
        super(Producto.class);
    }
    public static ProductoServicios getInstance(){
        if(instance==null){
            instance = new ProductoServicios();
        }
        return instance;
    }
}
