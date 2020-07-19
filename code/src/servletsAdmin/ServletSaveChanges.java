package servletsAdmin;

import java.io.File;
import java.io.IOException;

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



@WebServlet("/admin/ServletSaveChanges")
@MultipartConfig  //para tratar el archivo de imagen
public class ServletSaveChanges extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recogo los datos del formulario
		String id = request.getParameter("id");
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
		String telefono = request.getParameter("telefono");
		String email = request.getParameter("email");
		
		
		try {
			double precioDouble = Double.parseDouble(precio);
			int telefonoInt = Integer.parseInt(telefono);
			int idInt = Integer.parseInt(id);
			
			Item i = new Item(articulo, cambio, anuncio, Boolean.parseBoolean(envio), precioDouble, telefonoInt, email);
			i.setIdCategoria(categoriaInt);
			i.setId(idInt);
			ItemDAO itemDAO = new ItemDAOImpl();
			
			itemDAO.editAdvert(i);
			
			String newfile = request.getParameter("newfile");
			
			if(newfile != null) {
			//Registrar imagen subida en formulario:
			
				Part file = request.getPart("img");   //recogo la imagen del formulario
				
				//otra opción sería if(file.getSize()!=0)  indico si el peso es distinto de cero.
				if(file != null) {
				String pathApp = request.getServletContext().getRealPath("");
				String pathImg = File.separator + pathApp + File.separator + "images";  
				
				String pathFile = pathImg + File.separator + idInt + ".jpg";   
				file.write(pathFile);   
				System.out.println("Imagen guardada en : " + pathFile);
				}
			//fin registro imagen	
			}

		} catch (Exception e) {
			System.out.println("Error al convertir");

		}
	
	response.sendRedirect("ServletListAdmin");
	}
		
	}
	
	
	
