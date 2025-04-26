package com.inventory.interfaces;

import java.util.ArrayList;

import com.inventory.entity.Producto;



public interface IProductoDAO {

	
	public int save(Producto bean);
	public int update(Producto bean);
	public int DeleteById(int cod);
	public Producto findById(int codigo);
	
	public ArrayList<Producto> findAll();
	public ArrayList<Producto> listAllByNombre(String nombre);
}
