package jlc.Pago.controlador;

import org.h2.tools.Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseServices {
    private static DataBaseServices instancia;
    private String URL = "jdbc:h2:tcp://localhost/~/pagoPaypal"; //Modo Server...
    private Server tcp;


    private DataBaseServices() {

    }

    public static DataBaseServices getInstancia() {
        if (instancia == null) {
            instancia = new DataBaseServices();
        }
        return instancia;
    }

    private void registerDriver() {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConn() {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(URL, "sa", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conexion;
    }

    public void testConn() {
        try {
            getConn().close();
            System.out.println("Conexión exitosa!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void startDB() throws SQLException {
        // Se crea el servidor
        tcp = Server.createTcpServer("-tcpPort", "9092", "-tcpAllowOthers", "-tcpDaemon", "-ifNotExists").start();
    }

    public void stopDB() {
        // Se detiene el servidor
        //Server.shutdownTcpServer("tcp://localhost:9092", "", false, false);
        tcp.stop();
    }
}
