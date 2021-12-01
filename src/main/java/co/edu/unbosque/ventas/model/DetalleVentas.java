package co.edu.unbosque.ventas.model;

public class DetalleVentas {

	private int cantidadProducto;
	private int codigoProducto;
	private long valorTotal;
	private long valorVenta;
	private long valorIVA;
	
	public DetalleVentas(int cantidadProducto, int codigoProducto, long valorTotal, long valorVenta, long valorIVA) {
		super();
		this.cantidadProducto = cantidadProducto;
		this.codigoProducto = codigoProducto;
		this.valorTotal = valorTotal;
		this.valorVenta = valorVenta;
		this.valorIVA = valorIVA;
	}
	public int getCantidadProducto() {
		return cantidadProducto;
	}
	public void setCantidadProducto(int cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}
	public int getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	public long getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(long valorTotal) {
		this.valorTotal = valorTotal;
	}
	public long getValorVenta() {
		return valorVenta;
	}
	public void setValorVenta(long valorVenta) {
		this.valorVenta = valorVenta;
	}
	public long getValorIVA() {
		return valorIVA;
	}
	public void setValorIVA(long valorIVA) {
		this.valorIVA = valorIVA;
	}
	
	
}
