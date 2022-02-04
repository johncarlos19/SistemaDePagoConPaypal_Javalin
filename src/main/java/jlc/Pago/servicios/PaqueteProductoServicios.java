package jlc.Pago.servicios;

import jlc.Pago.controlador.GestionadDB;
import jlc.Pago.entidades.PaqueteProducto;
import jlc.Pago.entidades.Producto;

public class PaqueteProductoServicios extends GestionadDB<PaqueteProducto> {

    private static PaqueteProductoServicios instance;
    public PaqueteProductoServicios() {
        super(PaqueteProducto.class);
    }
    public static PaqueteProductoServicios getInstance(){
        if(instance==null){
            instance = new PaqueteProductoServicios();
        }
        return instance;
    }
}
