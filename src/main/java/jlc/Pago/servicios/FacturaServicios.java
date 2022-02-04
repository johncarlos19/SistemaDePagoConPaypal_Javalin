package jlc.Pago.servicios;

import jlc.Pago.controlador.GestionadDB;
import jlc.Pago.entidades.Factura;


public class FacturaServicios extends GestionadDB<Factura> {

    private static FacturaServicios instance;
    public FacturaServicios() {
        super(Factura.class);
    }
    public static FacturaServicios getInstance(){
        if(instance==null){
            instance = new FacturaServicios();
        }
        return instance;
    }

}
