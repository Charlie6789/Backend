package co.edu.unbosque.consolidado.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "db_consolidado")
public class Consolidado {
	
	@Id
	private int id;
	private String ciudad;
	private long totalVentas;
	
	
	public Consolidado() {
		super();
	}


	public Consolidado(int id, String ciudad, long totalVentas) {
		super();
		this.id = id;
		this.ciudad = ciudad;
		this.totalVentas = totalVentas;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCiudad() {
		return ciudad;
	}


	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}


	public long getTotalVentas() {
		return totalVentas;
	}


	public void setTotalVentas(long totalVentas) {
		this.totalVentas = totalVentas;
	}
	
	

}
