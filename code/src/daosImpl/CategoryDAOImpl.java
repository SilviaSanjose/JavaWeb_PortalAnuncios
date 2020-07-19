package daosImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import daos.CategoryDAO;
import model.Category;

public class CategoryDAOImpl extends MasterDAO implements CategoryDAO{

	@Override
	public List<Category> getCategories() {
		List<Category> categories = new ArrayList<Category>();
		connectDb();
		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(sql.getCategroies());
			while(rs.next()) {
				Category c = new Category();
				c.setId(rs.getInt(1));
				c.setNombre(rs.getString(2));
				categories.add(c);
			}
		} catch (SQLException e) {
			System.out.println("error al obatener categorias de DB");
			e.printStackTrace();
		}
		disconnectDb();
		return categories;
	}
	
	

}
