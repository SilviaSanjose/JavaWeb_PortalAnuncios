package servletsAdmin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServeletLOgOutAdmin
 */
@WebServlet("/admin/ServeletLOgOutAdmin")
public class ServeletLOgOutAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// invalida la sesi�n
		request.getSession().invalidate(); //para ivalidar sesi�n y cerrar.
		response.sendRedirect("../loginAdmin.jsp");
	}

}
