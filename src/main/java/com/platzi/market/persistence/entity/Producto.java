package com.platzi.market.persistence.entity;

import jakarta.persistence.*;

@Entity     //indica que esta clase mapeara las tablas de la base de datos
@Table(name = "productos")  //se incluye cuando la clase se llama diferente a la tabla original de base de datos
public class Producto {
    @Id     //debido a que esta columna es mi clave PRIMARIA
    @GeneratedValue(strategy = GenerationType.IDENTITY) //genere ID automaticos a nuestros datos por ser clave primaria
    @Column(name = "id_producto")   //se incluye cuando la clase se llama diferente a la columna original de tabla de datos
    private Integer idProducto;
    private String nombre;
    @Column(name = "id_categoria")  //se incluye cuando la clase se llama diferente a la columna original de tabla de datos
    private Integer idCategoria;
    @Column(name = "codigo_barras")
    private  String codigoBarras;
    @Column(name = "precio_venta")
    private Integer precioVenta;
    @Column(name = "cantidad_stock")
    private Integer cantidadStock;
    private Boolean estado;
    @ManyToOne  //relacion de muchos a uno
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false) //no insertar, no actualizar
    private Categoria categoria;

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Integer getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Integer precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
