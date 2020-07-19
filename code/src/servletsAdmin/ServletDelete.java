package servletsAdmin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.ItemDAO;
import daosImpl.ItemDAOImpl;

/**
 * Servlet implementation class ServletDelete
 */
@WebServlet("/admin/ServletDelete")
public class ServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");   //recojo el id del anuncio
		int idDelete = Integer.parseInt(id);
		ItemDAO item = new ItemDAOImpl();
		item.deleteAdvert(idDelete);
		response.sendRedirect("ServletListAdmin");
	}

	

}
