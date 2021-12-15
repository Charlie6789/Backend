package co.edu.unbosque.proveedores.controller;

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
import co.edu.unbosque.proveedores.model.Proveedores;
import co.edu.unbosque.proveedores.repository.ProveedoresRepository;

@CrossOrigin(origins = "http://localhost:8085")
@RestController
@RequestMapping("/api")
public class ProveedoresController {
	@Autowired
	  ProveedoresRepository proveedoresRepository;
	
	 @GetMapping("/consultar")
	  public ResponseEntity<List<Proveedores>> getAllProveedores() {
		  try {
			    List<Proveedores> proveedores = new ArrayList<Proveedores>();

			    proveedoresRepository.findAll().forEach(proveedores::add);

			    if (proveedores.isEmpty()) {
			      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			    }

			    return new ResponseEntity<>(proveedores, HttpStatus.OK);
			  } catch (Exception e) {
			    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	  }

	  @GetMapping("/consultar/{id}")
	  public ResponseEntity<Proveedores> getProveedorById(@PathVariable("id") Long id) {
		  Optional<Proveedores> proveedoresData = proveedoresRepository.findById(id);

		  if (proveedoresData.isPresent()) {
		    return new ResponseEntity<>(proveedoresData.get(), HttpStatus.OK);
		  } else {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }
	  }

	 @PostMapping("/crear")
	  public ResponseEntity<Proveedores> createProveedor(@RequestBody Proveedores proveedor) {
		  try {
			  Proveedores _proveedor = proveedoresRepository.save(new Proveedores(proveedor.getNitProveedor(),proveedor.getNombreProveedor(),proveedor.getDireccionProveedor(),proveedor.getTelefonoProveedor(),proveedor.getEmailProveedor()));
			    return new ResponseEntity<>(_proveedor, HttpStatus.CREATED);
			  } catch (Exception e) {
			    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	  }

	  @PutMapping("/actualizar/{id}")
	  public ResponseEntity<Proveedores> updateProveedor(@PathVariable("id") Long id, @RequestBody Proveedores proveedor) {
		  Optional<Proveedores> proveedorData = proveedoresRepository.findById(id);

		  if (proveedorData.isPresent()) {
			  Proveedores _proveedor= proveedorData.get();
			  proveedor.setNombreProveedor(proveedor.getNombreProveedor());
			  proveedor.setDireccionProveedor(proveedor.getDireccionProveedor());
			  proveedor.setTelefonoProveedor(proveedor.getTelefonoProveedor());
			  proveedor.setEmailProveedor(proveedor.getEmailProveedor());
		    return new ResponseEntity<>(proveedoresRepository.save(_proveedor), HttpStatus.OK);
		  } else {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }
	  }

	  @DeleteMapping("/eliminar/{id}")
	  public ResponseEntity<HttpStatus> deleteProveedor(@PathVariable("id") Long id) {
		  try {
			  proveedoresRepository.deleteById(id);
			    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			  } catch (Exception e) {
			    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	  }


}
