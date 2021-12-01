package co.edu.unbosque.productos.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.edu.unbosque.productos.model.Productos;
import co.edu.unbosque.productos.repository.ProductosRepository;

@CrossOrigin(origins = "http://localhost:8083")
@RestController
@RequestMapping("/api")
public class ProductosController {

	
	@Autowired
	ProductosRepository productosRepository;

	  @GetMapping("/consultar")
	  public ResponseEntity<List<Productos>> getAllProductos() {
		  try {
			    List<Productos> productos = new ArrayList<Productos>();

			    productosRepository.findAll().forEach(productos::add);
			    
			    if (productos.isEmpty()) {
			      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			    }

			    return new ResponseEntity<>(productos, HttpStatus.OK);
			  } catch (Exception e) {
			    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	  }

	  @GetMapping("/consultar/{codigoProducto}")
	  public ResponseEntity<Productos> getProductoById(@PathVariable("codigoProducto") int codigoProducto) {
		  Optional<Productos> productosData = productosRepository.findById(codigoProducto);

		  if (productosData.isPresent()) {
		    return new ResponseEntity<>(productosData.get(), HttpStatus.OK);
		  } else {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }
	  }

	  @PostMapping("/crear")
	  public ResponseEntity<Productos> createProducto(@RequestBody Productos productos) {
		  try {
			  Productos _productos= productosRepository.save(new Productos(productos.getCodigoProducto(),productos.getNombreProducto(), productos.getNitProveedor(), productos.getPrecioCompra(), productos.getIvaCompra(), productos.getPrecioVenta()));
			    return new ResponseEntity<>(_productos, HttpStatus.CREATED);
			  } catch (Exception e) {
			    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	  }

	  @PutMapping("/actualizar/{codigoProducto}")
	  public ResponseEntity<Productos> updateProducto(@PathVariable("codigoProducto") int codigoProducto, @RequestBody Productos producto) {
		  Optional<Productos> productoData = productosRepository.findById(codigoProducto);

		  if (productoData.isPresent()) {
			  Productos _productos = productoData.get();
			  _productos.setNombreProducto(producto.getNombreProducto());
			  _productos.setNitProveedor(producto.getNitProveedor());
			  _productos.setIvaCompra(producto.getIvaCompra());
			  _productos.setPrecioCompra(producto.getPrecioCompra());
			  _productos.setPrecioVenta(producto.getPrecioVenta());
		    return new ResponseEntity<>(productosRepository.save(_productos), HttpStatus.OK);
		  } else {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }
	  }

	  @DeleteMapping("/eliminar/{codigoProducto}")
	  public ResponseEntity<HttpStatus> deleteProducto(@PathVariable("codigoProducto") int codigoProducto) {
		  try {
			  productosRepository.deleteById(codigoProducto);
			    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			  } catch (Exception e) {
			    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	  }

	  @DeleteMapping("/eliminar")
	  public ResponseEntity<HttpStatus> deleteAllProductos() {
		  try {
			  productosRepository.deleteAll();
			    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			  } catch (Exception e) {
			    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	  }
}