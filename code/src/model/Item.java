package model;



public class Item {

	private int id;
	private String articulo;
	private String cambio;
	private String anuncio;
	private boolean envio;
	private double precio;
	private int telefono;
	private String email;
	private int idCategoria;
	
	
	private Category categoria;
	
	
	
	public Item() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Item(String articulo, String cambio, String anuncio, boolean envio, double precio, int telefono,
			String email) {
		super();
		this.articulo = articulo;
		this.cambio = cambio;
		this.anuncio = anuncio;
		this.envio = envio;
		this.precio = precio;
		this.telefono = telefono;
		this.email = email;
	}



	public String getArticulo() {
		return articulo;
	}
	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}
	public String getCambio() {
		return cambio;
	}
	public void setCambio(String cambio) {
		this.cambio = cambio;
	}
	public String getAnuncio() {
		return anuncio;
	}
	public void setAnuncio(String anuncio) {
		this.anuncio = anuncio;
	}
	public boolean isEnvio() {
		return envio;
	}
	public void setEnvio(boolean envio) {
		this.envio = envio;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	public int getIdCategoria() {
		return idCategoria;
	}


	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}


	public Category getCategoria() {
		return categoria;
	}


	public void setCategoria(Category categoria) {
		this.categoria = categoria;
	}
	
	
	
}
