package servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import daos.ItemDAO;
import daosImpl.ItemDAOImpl;
import model.Item;

import utils.ValidationsFields;

/**
 * guardo el anuncio
 */

@WebServlet("/ServletSave")
@MultipartConfig  //para tratar el archivo de imagen
public class ServletSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//recogo los datos del formulario
		String articulo = new String(request.getParameter("articulo").getBytes("ISO-8859-1"),"UTF-8");
		String categoria = request.getParameter("id_Category");
		int categoriaInt = Integer.parseInt(categoria);
		String cambio = request.getParameter("cambio");
		String anuncio = new String(request.getParameter("anuncio").getBytes("ISO-8859-1"),"UTF-8");
		String envio = request.getParameter("envio");
		if(envio != null) {
			envio = "true";
		}else {
			envio = "0";
		}
		String precio = request.getParameter("precio").replace(",", ".");
		double precioDouble = -1;
		String telefono = request.getParameter("telefono");
		int telefonoInt = -1;
		String email = request.getParameter("email");
		
	//comprobación de int y double
		boolean digit;
		try {
			precioDouble = Double.parseDouble(precio);
			telefonoInt = Integer.parseInt(telefono);
			digit = true;
		} catch (Exception e) {
			digit = false;
			
		}
		
	//compruebo si hay campos vacios
		ValidationsFields v = new ValidationsFields();
		if(v.emptyFields(articulo).equals("vacio") || v.emptyFields(anuncio).equals("vacio") ||
				v.emptyFields(precio).equals("vacio") || v.emptyFields(telefono).equals("vacio") ||
				v.emptyFields(email).equals("vacio") || !digit || !v.regexEmail(email) || !v.regexTelefono(telefono) ){
			
			//no registro y redirigo al formulario
			request.setAttribute("emptyfields", "Rellena todos los campos correctamente");
			request.setAttribute("articulo", articulo);
			
			request.setAttribute("anuncio", anuncio);
			if(envio.equals("true")) {
				request.setAttribute("checked", "checked");
			}

			request.setAttribute("precio", precio);
			request.setAttribute("telefono", telefono);
			request.setAttribute("email", email);
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ServletGetCategories");
			dispatcher.forward(request, response);
		//fin if validaciones 
		
	
		}else {
		
			ItemDAO item = new ItemDAOImpl();
			Item i = new Item(articulo, cambio, anuncio, Boolean.parseBoolean(envio), precioDouble, telefonoInt, email);
			i.setIdCategoria(categoriaInt);
			
		    int idCreated = item.saveAdvert(i);
		    
		
		//Registrar imagen subida en formulario:
			Part file = request.getPart("img");   //recogo la imagen del formulario
		//Para obtener donde se despliega mi aplicacion realmente se usa : request.getServletContext().getRealPath("");
			String pathApp = request.getServletContext().getRealPath("");
		//ruta donde se va a guardar la imagen
			String pathImg = pathApp + File.separator + "images";  //File.separator  por evitar poner /images
			File f = new File(pathImg);
			if(!f.exists()) {    //si no existe la carpeta /images en la ruta, la crea
				f.mkdir();
			}
			String pathFile = pathImg + File.separator + idCreated + ".jpg";  //guardo la ruta del archivo mas /id.jpg (id de cada anuncio)
			file.write(pathFile);   //escribo el archivo file(obtenido del formulario) en esa ruta.
			System.out.println("Imagen guardada en : " + pathFile);
		//fin registro imagen	

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/itemSaved.jsp");
		    dispatcher.forward(request, response);
		
		}//end else
		
	}//end doPost

}//end class
