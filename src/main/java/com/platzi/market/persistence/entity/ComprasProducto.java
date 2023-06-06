package com.platzi.market.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "compras_productos")
public class ComprasProducto {
    @EmbeddedId //se usa por ser ID compuesta y dada por otra clase
    private ComprasProductoPK id;
    private Integer cantidad;
    private Double total;
    private Boolean estado;
    //e aqui la relacion de esta clase con otras 2, relacion de muchos a uno tanto con compra y producto

    @ManyToOne  //relacion de muchos a uno
    //@JoinColumn(name = "id_compra" seniala la llave primaria de compra, con la que nos estamos relacionando
    @JoinColumn(name = "id_compra", insertable = false, updatable = false) //no insertar, no actualizar
    private Compra compra;
    @ManyToOne  //relacion de muchos a uno
    //@JoinColumn(name = "id_producto" seniala la llave primaria de producto, con la que nos estamos relacionando
    @JoinColumn(name = "id_producto", insertable = false, updatable = false) //no insertar, no actualizar
    private Producto producto;

    public ComprasProductoPK getId() {
        return id;
    }

    public void setId(ComprasProductoPK id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
