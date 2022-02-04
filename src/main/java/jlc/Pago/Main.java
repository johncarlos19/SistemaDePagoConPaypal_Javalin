package jlc.Pago;

import io.javalin.Javalin;
import io.javalin.core.util.RouteOverviewPlugin;
import io.javalin.plugin.rendering.JavalinRenderer;
import io.javalin.plugin.rendering.template.JavalinThymeleaf;
import jlc.Pago.controlador.DataBaseServices;
import jlc.Pago.controlador.RecibirDatosControlador;
import jlc.Pago.entidades.PaqueteProducto;
import jlc.Pago.entidades.Producto;
import jlc.Pago.servicios.PaqueteProductoServicios;
import jlc.Pago.servicios.ProductoServicios;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        DataBaseServices.getInstancia().startDB();

        // Se prueba la conexion con la DB
        DataBaseServices.getInstancia().testConn();

        Producto producto = new Producto("Soporte",30,"Es bueno");
        Producto producto1 = new Producto("Transacion",10,"Es bueno");
        Producto producto2 = new Producto("Servicio En Linea",30,"Es bueno");
        PaqueteProducto paqueteProducto = new PaqueteProducto("Basico",0);
        paqueteProducto = (PaqueteProducto) PaqueteProductoServicios.getInstance().crear(paqueteProducto);


//        producto = ProductoServicios.getInstance().find(((Producto) ProductoServicios.getInstance().crear(producto)).getId());

        System.out.println("Despues"+producto.getId());
//        producto1 = (Producto) ProductoServicios.getInstance().crear(producto1);
        paqueteProducto.addProducto(producto);
        PaqueteProductoServicios.getInstance().editar(paqueteProducto);
//        paqueteProducto.addProducto(producto1);

//        paqueteProducto.addProducto(producto2);


        Javalin app = Javalin.create(config ->{
            config.addStaticFiles("/publico"); //desde la carpeta de resources

            config.registerPlugin(new RouteOverviewPlugin("/rutas")); //aplicando plugins de las rutas
        }).start(getHerokuAssignedPort());
        registrandoPlantillas();
        new RecibirDatosControlador(app).aplicarRutas();

    }

    private static void registrandoPlantillas(){
        //registrando los sistemas de plantilla.
        //JavalinRenderer.register(JavalinFreemarker.INSTANCE, ".ftl");
        JavalinRenderer.register(JavalinThymeleaf.INSTANCE, ".html");
        // JavalinRenderer.register(JavalinVelocity.INSTANCE, ".vm");
    }
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 7000; //Retorna el puerto por defecto en caso de no estar en Heroku.
    }
}
