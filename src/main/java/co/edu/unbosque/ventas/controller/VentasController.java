package co.edu.unbosque.ventas.controller;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.edu.unbosque.ventas.model.Ventas;
import co.edu.unbosque.ventas.repository.VentasRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class VentasController {
	
	@Autowired
	VentasRepository ventaRepository;

	  @PostMapping("/crear")
	  public ResponseEntity<Ventas> createVenta(@RequestBody Ventas venta) {
		  try {
			    Ventas _venta = ventaRepository.save(new Ventas(venta.getCodigoVenta(), venta.getCedulaCliente(),venta.getDetalleVenta(),venta.getIvaVenta(),venta.getSubtotalVenta(),venta.getTotalVenta()));
			    return new ResponseEntity<>(_venta, HttpStatus.CREATED);
			  } catch (Exception e) {
			    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	  }
	  @GetMapping("/listar")
	  public ResponseEntity<List<Ventas>> getAllVentas() {
		  try {
			    List<Ventas> ventas = new ArrayList<Ventas>();
			    
			    ventaRepository.findAll().forEach(ventas::add);
	
			    if (ventas.isEmpty()) {
			      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			    }

			    return new ResponseEntity<>(ventas, HttpStatus.OK);
			  } catch (Exception e) {
			    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	  }

}
