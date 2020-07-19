package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletLogIn
 */
@WebServlet("/ServletLogIn")
public class ServletLogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String PW = "123";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("pass").equals(PW)){
			//doy a "userLogin" un valor para que no sea null, y este activa la sesión
			request.getSession().setAttribute("userLogin", "OK");
			response.sendRedirect("loginAdminAcess.jsp");
	
		}else {
			
			request.setAttribute("error", "Contraseña errónea");
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/loginAdmin.jsp");
		    dispatcher.forward(request, response);
			
		}
		
		
	}

}
