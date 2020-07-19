package servletsAdmin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.CategoryDAO;
import daos.ItemDAO;
import daosImpl.CategoryDAOImpl;
import daosImpl.ItemDAOImpl;
import model.Category;
import model.Item;


/**
 * Servlet implementation class ServletEdit
 */
@WebServlet("/admin/ServletEdit")
public class ServletEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");  //recojo el id seleccionado y lo paso a integer
		int idEdit = Integer.parseInt(id);
	
		ItemDAO item = new ItemDAOImpl();
		Item it = item.getIdToEdit(idEdit);
		request.setAttribute("item", it);
		
		//creo objeto de categorias	
		CategoryDAO categoryDAO = new CategoryDAOImpl();
		List<Category> categories = categoryDAO.getCategories();
		request.setAttribute("categories", categories);
		
	 //si envio es true, activo casilla checked en checkbox
		if(it.isEnvio()) {
			request.setAttribute("check", "checked");
		}
		if(it.getCambio().equals("Si")) {
			request.setAttribute("checkedSi", "checked");
		}else {
			request.setAttribute("checkedNo", "checked");
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin/edtiItem.jsp");
	    dispatcher.forward(request, response);
	}
	
	
}
