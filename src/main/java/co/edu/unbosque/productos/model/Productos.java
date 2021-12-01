package co.edu.unbosque.productos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "db_productos")
public class Productos {

	@Id
	private int codigoProducto;
	private String nombreProducto;
	private int nitProveedor;
	private long precioCompra;
	private long ivaCompra;
	private long precioVenta;
	
	public Productos() {
		
	}
		
	public Productos(int codigoProducto, String nombreProducto, int nitProveedor, long precioCompra, long ivaCompra, long precioVenta) {

		this.codigoProducto = codigoProducto;
		this.nombreProducto = nombreProducto;
		this.nitProveedor = nitProveedor;
		this.precioCompra = precioCompra;
		this.ivaCompra = ivaCompra;
		this.precioVenta = precioVenta;
	}
	
	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public int getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	public int getNitProveedor() {
		return nitProveedor;
	}
	public void setNitProveedor(int nitProveedor) {
		this.nitProveedor = nitProveedor;
	}
	public long getPrecioCompra() {
		return precioCompra;
	}
	public void setPrecioCompra(long precioCompra) {
		this.precioCompra = precioCompra;
	}
	public long getIvaCompra() {
		return ivaCompra;
	}
	public void setIvaCompra(long ivaCompra) {
		this.ivaCompra = ivaCompra;
	}
	public long getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(long precioVenta) {
		this.precioVenta = precioVenta;
	}
	
	
}
