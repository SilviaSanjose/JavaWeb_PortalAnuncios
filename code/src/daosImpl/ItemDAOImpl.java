package daosImpl;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import daos.ItemDAO;
import model.Category;
import model.Item;


public class ItemDAOImpl extends MasterDAO implements ItemDAO{

	
	
	@Override
	public int saveAdvert(Item i) {
		connectDb();
		// guardar el anuncio nuevo
		int idCreated =-1;
		try {
			PreparedStatement ps = conexion.prepareStatement(sql.insertSql(), Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, i.getArticulo());
			ps.setString(2, i.getCambio());
			ps.setString(3, i.getAnuncio());
			ps.setBoolean(4, i.isEnvio() );
			ps.setDouble(5, i.getPrecio());
			ps.setInt(6, i.getTelefono());
			ps.setString(7, i.getEmail());
			ps.setInt(8, i.getIdCategoria());
			ps.executeUpdate();
			ResultSet rs =ps.getGeneratedKeys();
			if(rs.next()) {
				idCreated = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			System.out.println("No se ha podido guardar el anuncio");
			e.printStackTrace();
		}
		disconnectDb();
		return idCreated;
	}

	@Override
	public List<Item> listAdvert(String articulo, String id_categoria, int begin, int count) {
		List<Item> items = new ArrayList<Item>();  //creo el objeto con los anuncios que devolverá la funcion
		connectDb();
		
		try {
			PreparedStatement ps = conexion.prepareStatement(sql.getItems());
			ps.setString(1, "%" + articulo + "%");
			ps.setString(2, "%" + id_categoria + "%");
			ps.setInt(3, begin);
			ps.setInt(4, count);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {   //vale true siempre que haya una fila más para leer
				Item i = new Item();
				i.setId(rs.getInt(1));
				i.setArticulo(rs.getString(2));
				i.setCambio(rs.getString(3));
				i.setAnuncio(rs.getString(4));
				i.setEnvio(rs.getBoolean(5));
				i.setPrecio(rs.getDouble(6));
				i.setTelefono(rs.getInt(7));
				i.setEmail(rs.getString(8));
				Category c = new Category();
				c.setNombre(rs.getString(9));
				i.setCategoria(c);
				items.add(i);
			}
	
		} catch (SQLException e) {
			System.out.println("No se han podido recuperar los datos");
			e.printStackTrace();
		}
		disconnectDb();
		return items;
	}

	@Override
	public void deleteAdvert(int id) {
		connectDb();
		try {
			PreparedStatement ps = conexion.prepareStatement(sql.deleteItem());
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Error al borrar Item");
			e.printStackTrace();
		}
		
		disconnectDb();
	}

	@Override
	public Item getIdToEdit(int id) {
		connectDb();
		Item i = new Item();
		try {
			PreparedStatement ps = conexion.prepareStatement(sql.getId());
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {   //vale true siempre que haya una fila más para leer
				
				i.setId(rs.getInt(1));
				i.setArticulo(rs.getString(2));
				i.setCambio(rs.getString(3));
				i.setAnuncio(rs.getString(4));
				i.setEnvio(rs.getBoolean(5));
				i.setPrecio(rs.getDouble(6));
				i.setTelefono(rs.getInt(7));
				i.setEmail(rs.getString(8));
				i.setIdCategoria(rs.getInt(9));
				
			}
		} catch (SQLException e) {
			System.out.println("Error al obtener por id de base de datos");
			e.printStackTrace();
		}
		
		disconnectDb();
		return i;
	}

	@Override
	public void editAdvert(Item i) {
		connectDb();
		try {
			PreparedStatement ps = conexion.prepareStatement(sql.saveChanges());
			ps.setString(1, i.getArticulo());
			ps.setString(2, i.getCambio());
			ps.setString(3, i.getAnuncio());
			ps.setBoolean(4, i.isEnvio() );
			ps.setDouble(5, i.getPrecio());
			ps.setInt(6, i.getTelefono());
			ps.setString(7, i.getEmail());
			ps.setInt(8, i.getIdCategoria());
			ps.setInt(9, i.getId());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("No se ha podido guardar el anuncio actualizado");
			e.printStackTrace();
		}
		
		disconnectDb();
		
	}

	@Override
	public int countAdverts(String articulo, String id_categoria) {
		int total = -1;
		connectDb();
		try {
			PreparedStatement ps = conexion.prepareStatement(sql.getTotal());
			ps.setString(1, "%" + articulo + "%");
			ps.setString(2, "%" + id_categoria + "%");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				total = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("Error al contar los anuncios");
			e.printStackTrace();
		}
		disconnectDb();
		return total;
	}

}
