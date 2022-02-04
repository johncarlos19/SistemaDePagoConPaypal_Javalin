package jlc.Pago.controlador;


import io.javalin.Javalin;
import jlc.Pago.entidades.Factura;
import jlc.Pago.entidades.PaqueteProducto;
import jlc.Pago.entidades.Producto;
import jlc.Pago.servicios.FacturaServicios;
import jlc.Pago.servicios.PaqueteProductoServicios;
import jlc.Pago.servicios.ProductoServicios;
import org.jasypt.util.text.AES256TextEncryptor;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

import static io.javalin.apibuilder.ApiBuilder.*;

public class RecibirDatosControlador extends JavalinControlador {

    AES256TextEncryptor userEncryptor = new AES256TextEncryptor();
    AES256TextEncryptor passwordEncryptor = new AES256TextEncryptor();

    public RecibirDatosControlador(Javalin app) {
        super(app);
        userEncryptor.setPassword("admin");
        passwordEncryptor.setPassword("admin");

    }

    /**
     * Registrando los sistemas de plantillas utilizados.
     */


    @Override
    public void aplicarRutas() {

        app.before(ctx -> {






        });


        app.get("/login", ctx -> {


        });

        app.get("/carrito_process", ctx -> {

        });


        app.get("/carrito", ctx -> {


        });


        /**
         * Ejemplo para leer por parametros de consulta (query param)
         * http://localhost:7000/parametros?matricula=20011126&nombre=Carlos%20Camacho
         */




        app.get("/doItChange", ctx -> {



        });

        app.post("/new_product", ctx -> {


        });
        app.get("/editar/:id", ctx -> {


        });
        app.get("/editar/eliminar/:id_foto/:id_producto", ctx -> {


        });
        app.get("/comentar", ctx -> {


        });
        app.get("/EliminarComentario", ctx -> {


        });
        app.post("/edit_now", ctx -> {



        });
        app.get("/add", ctx -> {

        });

        app.post("/login", ctx -> {


        });

        app.routes(() -> {
            /*
            path("/editar/:id", () -> {

                get(ctx -> {


                    String id_cliente = ctx.sessionAttribute("carroCompra");

                    Producto producto = Mercado.getInstance().getProductoServicios().getProducto(ctx.pathParam("id", Integer.class).getOrNull());
                    int aux = Mercado.getInstance().cant_product(Long.parseLong(id_cliente));
                    Map<String, Object> modelo = new HashMap<>();
                    String userenc = userEncryptor.decrypt(ctx.cookie("Login"));
                    if (userenc != null) {
                        modelo.put("user", userenc + " - Salir");
                        modelo.put("log", "logout");
                    } else {
                        userenc = "Iniciar Seccion";
                        modelo.put("user", userenc);
                        modelo.put("log", "login");
                    }
                    modelo.put("cant", aux);
                    modelo.put("producto", producto);
                    ctx.render("/publico/EditarProducto.html",modelo);
                });
        });*/
            path("/producto", () -> {
                get(ctx -> {



                });
            });

            path("/venta_producto", () -> {

                get(ctx -> {
                    if (ctx.cookie("Login") != null) {



                    } else {
                        ctx.redirect("/");
                    }
                });
            });


            path("/process", () -> {

                get(ctx -> {
                    ctx.render("/publico/successfully.html");
                });
                post(ctx -> {
                    if(ctx.formParam("status").equalsIgnoreCase("COMPLETED")){
                        Factura factura = new Factura(ctx.formParam("id_order"),ctx.formParam("status"),ctx.formParam("name"),ctx.formParam("last"),ctx.formParam("email"),ctx.formParam("payer_id"),ctx.formParam("address_line_1"),ctx.formParam("address_line_2"),
                                ctx.formParam("admin_area_2"),ctx.formParam("admin_area_1"),ctx.formParam("postal_code"),ctx.formParam("country_code"));
                        if(ctx.formParam("id_paquete")!=null){
                            factura.setPack(true);
                            factura.setIdPaqueteProducto(Long.parseLong(ctx.formParam("id_paquete")));
                            PaqueteProducto aux = PaqueteProductoServicios.getInstance().find(Long.parseLong(ctx.formParam("id_paquete")));
                            for (Producto ax: aux.getProductoList()
                                 ) {
                                factura.addProducto(ax);
                            }

                        }
                        FacturaServicios.getInstance().crear(factura);
                        ctx.redirect("/process");

                    }
                });
            });
            path("/checkout", () -> {

                /**
                 * http://localhost:7000/thymeleaf/
                 */
                post(ctx -> {
                    PaqueteProducto aux = PaqueteProductoServicios.getInstance().find(Long.parseLong(ctx.formParam("id")));
                    System.out.println(aux.getFees());


                    Map<String, Object> contexto = new HashMap<>();
                    contexto.put("aux", aux);
                    ctx.render("/publico/checkout.html", contexto);
                });
            });
            path("/", () -> {
                get(ctx -> {

                    Map<String, Object> contexto = new HashMap<>();
                    contexto.put("listaPaqueteProducto", PaqueteProductoServicios.getInstance().ListadoCompleto());
                    ctx.render("/publico/index.html", contexto);


                });
            });
        });

    }
}
