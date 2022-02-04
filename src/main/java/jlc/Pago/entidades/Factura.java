package jlc.Pago.entidades;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Se genera el ID automatico
    private long id;
    private String id_order;
    private String status;
    private String name;
    private String last;
    private String email;
    private String payer_id;
    private String address_line_1;
    private String address_line_2;
    private String admin_area_2;
    private String admin_area_1;
    private String postal_code;
    private String country_code;
    private boolean isPack = false;
    private long idPaqueteProducto;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "facturaList", cascade = CascadeType.ALL)
    private List<ProductoVenta> productoList = new ArrayList<ProductoVenta>();


    public Factura() {

    }

    public Factura(String id_order, String status, String name, String last, String email, String payer_id, String address_line_1, String address_line_2, String admin_area_2, String admin_area_1, String postal_code, String country_code) {
        this.id_order = id_order;
        this.status = status;
        this.name = name;
        this.last = last;
        this.email = email;
        this.address_line_1 = address_line_1;
        this.address_line_2 = address_line_2;
        this.admin_area_2 = admin_area_2;
        this.admin_area_1 = admin_area_1;
        this.postal_code = postal_code;
        this.country_code = country_code;
        this.payer_id = payer_id;
    }

    public boolean addProducto(Producto producto){
        System.out.println(producto.getNombre());
        ProductoVenta productoVenta = new ProductoVenta(producto.getNombre(),producto.getPrecio(),producto.getDescripcion(),this);
        productoList.add(productoVenta);
        return true;
    }

    public BigDecimal getFees(){
        double tot = 0;

        for (ProductoVenta aux:productoList
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

        for (ProductoVenta aux:productoList
        ) {
            tot+= aux.getPrecio();
        }
        BigDecimal total = BigDecimal.valueOf(tot).setScale(2,BigDecimal.ROUND_HALF_UP);
        return total;
    }

    public BigDecimal getTotalConFees(){
        double tot = 0;

        for (ProductoVenta aux:productoList
        ) {
            tot+= aux.getPrecio();
        }
        double aux = tot*0.029;
        aux+=0.3;
        aux+=tot;
        BigDecimal total = BigDecimal.valueOf(aux).setScale(2,BigDecimal.ROUND_HALF_UP);
        return total;
    }



    public String getPayer_id() {
        return payer_id;
    }

    public void setPayer_id(String payer_id) {
        this.payer_id = payer_id;
    }

    public boolean isPack() {
        return isPack;
    }

    public void setPack(boolean pack) {
        this.isPack = pack;
    }

    public long getIdPaqueteProducto() {
        return idPaqueteProducto;
    }

    public void setIdPaqueteProducto(long idPaqueteProducto) {
        this.idPaqueteProducto = idPaqueteProducto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getId_order() {
        return id_order;
    }

    public void setId_order(String id_order) {
        this.id_order = id_order;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress_line_1() {
        return address_line_1;
    }

    public void setAddress_line_1(String address_line_1) {
        this.address_line_1 = address_line_1;
    }

    public String getAddress_line_2() {
        return address_line_2;
    }

    public void setAddress_line_2(String address_line_2) {
        this.address_line_2 = address_line_2;
    }

    public String getAdmin_area_2() {
        return admin_area_2;
    }

    public void setAdmin_area_2(String admin_area_2) {
        this.admin_area_2 = admin_area_2;
    }

    public String getAdmin_area_1() {
        return admin_area_1;
    }

    public void setAdmin_area_1(String admin_area_1) {
        this.admin_area_1 = admin_area_1;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public List<ProductoVenta> getProductos() {
        return productoList;
    }

    public void setProductos(List<ProductoVenta> productos) {
        this.productoList = productos;
    }
}
