package com.inventory.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.inventory.entity.Producto;
import com.inventory.interfaces.IProductoDAO;
import com.inventory.utils.MySqlConexion;



public class MySqlProductoDAO implements IProductoDAO{

	@Override
	public int save(Producto bean) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=MySqlConexion.getConexion();
			String sql="insert producto value (null, ?, ?, ?)";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, bean.getNombre());
			pstm.setDate(2, bean.getFechaCompra());
			pstm.setInt(3, bean.getStock());
			
			salida=pstm.executeUpdate();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return salida;
	}
	
	

	@Override
	public int update(Producto bean) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=MySqlConexion.getConexion();
			String sql="update producto set descripcion = ? , fechaRegistro = ? ,stock = ? where idProducto=?";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, bean.getNombre());
			pstm.setDate(2, bean.getFechaCompra());
			pstm.setInt(3, bean.getStock());
			pstm.setInt(4, bean.getCodigo());
			salida=pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return salida;
	}

	@Override
	public int DeleteById(int cod) {
		int salida=-1;
		Connection conn=null;
		PreparedStatement pstm=null;
		try {
			conn=MySqlConexion.getConexion();
			String sql= "delete from producto where idProducto=?";
			pstm=conn.prepareStatement(sql);
			pstm.setInt(1,cod);
			salida=pstm.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstm!=null) pstm.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		return salida;
	}

	@Override
	public ArrayList<Producto> findAll() {
		ArrayList<Producto> data = new ArrayList<Producto>();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MySqlConexion.getConexion();
			String sql = "select * from producto";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next() == true) {
				Producto pro = new Producto();
				pro.setCodigo(rs.getInt(1));
				pro.setNombre(rs.getString(2));
				pro.setFechaCompra(rs.getDate(3));
				pro.setStock(rs.getInt(4));
				
				data.add(pro);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (cn != null)
					cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return data;
	}


	@Override
	public ArrayList<Producto> listAllByNombre(String nombre) {
		ArrayList<Producto>  data=new ArrayList<Producto>();
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=MySqlConexion.getConexion();
			String sql="select * from producto where descripcion like ? ";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, "%"+nombre+"%");
			rs=pstm.executeQuery();
			while (rs.next() == true) {
				Producto pro = new Producto();
				pro.setCodigo(rs.getInt(1));
				pro.setNombre(rs.getString(2));
				pro.setFechaCompra(rs.getDate(3));
				pro.setStock(rs.getInt(4));
				data.add(pro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return data;
	}



	@Override
	public Producto findById(int codigo) {
		Producto producto = null;
        String sql = "SELECT * FROM producto WHERE idProducto = ?";
        try (Connection cn = MySqlConexion.getConexion();
             PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setInt(1, codigo);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    producto = new Producto();
                    producto.setCodigo(rs.getInt(1));
                    producto.setNombre(rs.getString(2));
                    producto.setFechaCompra(rs.getDate(3));
                    producto.setStock(rs.getInt(4));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return producto;
	}



	





}
