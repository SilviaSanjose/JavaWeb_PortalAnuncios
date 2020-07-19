package daos;

import java.util.List;

import model.Item;

public interface ItemDAO {
	
	public int saveAdvert(Item i);
	public List<Item> listAdvert(String articulo, String categoria, int begin, int count);
	public void deleteAdvert(int id);
	public Item getIdToEdit(int id);
	public void editAdvert(Item i);
	public int countAdverts(String articulo, String categoria);

}
