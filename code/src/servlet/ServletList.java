package servlet;

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


@WebServlet("/ServletList")
public class ServletList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//paginacion
		int begin = 0;
		int next = -1;
		int previous = -1;
		int byPage = 5;
		
		if(request.getParameter("begin") != null) {
			begin = Integer.parseInt(request.getParameter("begin"));
		}
		next = begin + byPage;
		previous = begin - byPage;
		
		//buscador
		//creo objeto de categorias	
		CategoryDAO categoryDAO = new CategoryDAOImpl();
		List<Category> categories = categoryDAO.getCategories();
		request.setAttribute("categories", categories);
		
		String searchArticle = "";
		String searchId_category = "";
		String allCategories = "Todas las categorías";
		if(request.getParameter("article")!= null) {
			searchArticle = request.getParameter("article");
		}
		if(request.getParameter("id_category") != null) {
			searchId_category = request.getParameter("id_category"); 
			if(searchId_category.equals(allCategories)) {
				searchId_category = "";
			}
			
		}
		
	//creo objeto	
		ItemDAO itemsDAo = new ItemDAOImpl();
		List<Item> items = itemsDAo.listAdvert(searchArticle, searchId_category, begin, byPage);
		request.setAttribute("items", items);
		
	//Contador de anuncios
		int total = itemsDAo.countAdverts(searchArticle, searchId_category);
		request.setAttribute("total", total);
	
		request.setAttribute("searchArticle", searchArticle);
		request.setAttribute("searchId_category", searchId_category);
		
		request.setAttribute("next", next);
		request.setAttribute("previous", previous);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listAd.jsp");
	    dispatcher.forward(request, response);

	}

	

}
