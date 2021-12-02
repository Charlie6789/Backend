package co.edu.unbosque.ventas.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "db_ventas")
public class Ventas {

	@Id
	private int codigoVenta;
	private long cedulaCliente;
	private List<DetalleVentas> detalleVenta;
	private long ivaVenta;
	private long subtotalVenta;
	private long totalVenta;
	
	public Ventas(int codigoVenta, long cedulaCliente, List<DetalleVentas> detalleVenta, long ivaVenta, long subtotalVenta,
			long totalVenta) {
		super();
		this.codigoVenta = codigoVenta;
		this.cedulaCliente = cedulaCliente;
		this.detalleVenta = detalleVenta;
		this.ivaVenta = ivaVenta;
		this.subtotalVenta = subtotalVenta;
		this.totalVenta = totalVenta;
	}

	public List<DetalleVentas> getDetalleVenta() {
		return detalleVenta;
	}

	public void setDetalleVenta(List<DetalleVentas> detalleVenta) {
		this.detalleVenta = detalleVenta;
	}

	public int getCodigoVenta() {
		return codigoVenta;
	}
	public void setCodigoVenta(int codigoVenta) {
		this.codigoVenta = codigoVenta;
	}
	public long getCedulaCliente() {
		return cedulaCliente;
	}
	public void setCedulaCliente(long cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}
	public long getIvaVenta() {
		return ivaVenta;
	}
	public void setIvaVenta(long ivaVenta) {
		this.ivaVenta = ivaVenta;
	}
	public long getSubtotalVenta() {
		return subtotalVenta;
	}
	public void setSubtotalVenta(long subtotalVenta) {
		this.subtotalVenta = subtotalVenta;
	}
	public long getTotalVenta() {
		return totalVenta;
	}
	public void setTotalVenta(long totalVenta) {
		this.totalVenta = totalVenta;
	}
	
	
}
