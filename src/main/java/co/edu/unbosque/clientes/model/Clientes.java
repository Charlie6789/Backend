package co.edu.unbosque.clientes.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "db_clientes")
public class Clientes {

	 @Id
	  private long cedulaCliente;
	  private String nombreCliente;
	  private String direccionCliente;
	  private long telefonoCliente;
	  private String emailCliente;
	  
	  
	 
	public Clientes(long cedulaCliente, String nombreCliente, String direccionCliente, long telefonoCliente, String emailCliente) {
		super();
		this.cedulaCliente = cedulaCliente;
		this.nombreCliente = nombreCliente;
		this.direccionCliente = direccionCliente;
		this.telefonoCliente = telefonoCliente;
		this.emailCliente = emailCliente;
	}
	public Clientes() {
		super();
		
	}

	public long getCedula() {
		return cedulaCliente;
	}
	public void setCedulaCliente(long cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getDireccionCliente() {
		return direccionCliente;
	}
	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}
	public long getTelefonoCliente() {
		return telefonoCliente;
	}
	public void setTelefonoCliente(long telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}
	public String getEmailCliente() {
		return emailCliente;
	}
	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}
	 
	 

}
