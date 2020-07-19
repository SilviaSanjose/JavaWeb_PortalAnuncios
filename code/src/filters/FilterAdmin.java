package filters;

import java.io.IOException;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FilterAdmin implements javax.servlet.Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// Comprobamos si en sesion esta vacio el userLogin. vuelve a la pagina de login
		//filerchain es lo que permite redirigir
				
		
		//Para usar el request del filter  se tiene que hacer un casting y poder usar el request como en servlet.
		
		HttpServletRequest req = (HttpServletRequest)request;
	//recojo si existe adminOK en la sesión.
		if(req.getSession().getAttribute("userLogin") != null) {
			chain.doFilter(request, response);
			
		}else {
			HttpServletResponse res = (HttpServletResponse)response;
			  //se podria hacer un RequestDispatcher, pero hacemos una redirección forzada, que es forzar al navegador 
			//del cliente a pedir la ruta indicada
			res.sendRedirect("loginAdmin.jsp"); 
		
		}
		
	}

}
