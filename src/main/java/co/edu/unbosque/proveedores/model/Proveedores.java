package co.edu.unbosque.proveedores.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "db_proveedores")
public class Proveedores {

	 @Id
	  private long nitProveedor;
	  private String nombreProveedor;
	  private String direccionProveedor;
	  private long telefonoProveedor;
	  private String emailProveedor;
	  
	public Proveedores(long nitProveedor, String nombreProveedor, String direccionProveedor, long telefonoProveedor,
			String emailProveedor) {
		super();
		this.nitProveedor = nitProveedor;
		this.nombreProveedor = nombreProveedor;
		this.direccionProveedor = direccionProveedor;
		this.telefonoProveedor = telefonoProveedor;
		this.emailProveedor = emailProveedor;
	}

	public long getNitProveedor() {
		return nitProveedor;
	}

	public void setNitProveedor(long nitProveedor) {
		this.nitProveedor = nitProveedor;
	}

	public String getNombreProveedor() {
		return nombreProveedor;
	}

	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}

	public String getDireccionProveedor() {
		return direccionProveedor;
	}

	public void setDireccionProveedor(String direccionProveedor) {
		this.direccionProveedor = direccionProveedor;
	}

	public long getTelefonoProveedor() {
		return telefonoProveedor;
	}

	public void setTelefonoProveedor(long telefonoProveedor) {
		this.telefonoProveedor = telefonoProveedor;
	}

	public String getEmailProveedor() {
		return emailProveedor;
	}

	public void setEmailProveedor(String emailProveedor) {
		this.emailProveedor = emailProveedor;
	}
	  
	  
}
