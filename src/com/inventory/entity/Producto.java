package com.inventory.entity;

import java.sql.Date;

public class Producto {
	
	private int id_producto;
	private String nombre_producto, capacidad, ph_producto;
	private Cliente id_cliente;
	private Estado id_estado;
	
	
	public int getId_producto() {
		return id_producto;
	}
	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}
	public String getNombre_producto() {
		return nombre_producto;
	}
	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}
	public String getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(String capacidad) {
		this.capacidad = capacidad;
	}
	public String getPh_producto() {
		return ph_producto;
	}
	public void setPh_producto(String ph_producto) {
		this.ph_producto = ph_producto;
	}
	public Cliente getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(Cliente id_cliente) {
		this.id_cliente = id_cliente;
	}
	public Estado getId_estado() {
		return id_estado;
	}
	public void setId_estado(Estado id_estado) {
		this.id_estado = id_estado;
	}
	
	

}
