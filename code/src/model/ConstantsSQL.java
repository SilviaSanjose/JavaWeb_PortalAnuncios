package model;

public class ConstantsSQL {
	
	public String insertSql() {
		return "insert into tabla_anuncios(articulo, cambio, anuncio, envio, precio, telefono,email, id_categoria)" + "values(?,?,?,?,?,?,?,?)";
	}
	public String getItems() {
		//return "SELECT * FROM tabla_anuncios WHERE articulo LIKE ? and id_categoria LIKE ? ORDER BY id DESC";
		return "SELECT tl.id,tl.articulo,tl.cambio,tl.anuncio,tl.envio, tl.precio, tl.telefono, tl.email, tc.nombre FROM tabla_anuncios as tl ," +
				"tabla_categorias as tc where tl.id_categoria = tc.id and tl.articulo like ? and tl.id_categoria like ? order by tl.id desc limit ? , ?;";
	}
	
	public String deleteItem() {
		return "DELETE FROM tabla_anuncios WHERE id =?;";
	}
	
	public String getId() {
		return "SELECT * FROM tabla_anuncios WHERE id = ?;";
	}
	
	public String saveChanges() {
		return "UPDATE tabla_anuncios SET articulo = ?, cambio = ?, anuncio = ?, envio = ?, precio = ?, telefono = ?, email = ?, id_categoria = ?  WHERE id = ?;";
	}
	
	public String getTotal() {
		return "SELECT COUNT(id) FROM tabla_anuncios where articulo like ? and id_categoria like ? ;";
	}
	
	//get Categories
	public String getCategroies() {
		return "SELECT * FROM tabla_categorias;";
	}
}
