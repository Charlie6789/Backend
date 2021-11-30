package co.edu.unbosque.clientes.controller;

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
import co.edu.unbosque.clientes.model.Clientes;
import co.edu.unbosque.clientes.repository.ClientesRepository;


@CrossOrigin(origins = "http://localhost:8082")
@RestController
@RequestMapping("/api")
public class ClientesController {
	@Autowired
	  ClientesRepository clientesRepository;

	  @GetMapping("/consultar")
	  public ResponseEntity<List<Clientes>> getAllClientes() {
		  try {
			    List<Clientes> clientes = new ArrayList<Clientes>();

			    clientesRepository.findAll().forEach(clientes::add);

			    if (clientes.isEmpty()) {
			      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			    }

			    return new ResponseEntity<>(clientes, HttpStatus.OK);
			  } catch (Exception e) {
			    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	  }

	  @GetMapping("/consultar/{id}")
	  public ResponseEntity<Clientes> getClienteById(@PathVariable("id") Long id) {
		  Optional<Clientes> clientesData = clientesRepository.findById(id);

		  if (clientesData.isPresent()) {
		    return new ResponseEntity<>(clientesData.get(), HttpStatus.OK);
		  } else {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }
	  }

	 @PostMapping("/crear")
	  public ResponseEntity<Clientes> createCliente(@RequestBody Clientes cliente) {
		  try {
			    Clientes _cliente = clientesRepository.save(new Clientes(cliente.getCedula(),cliente.getNombreCliente(),cliente.getDireccionCliente(),cliente.getTelefonoCliente(),cliente.getEmailCliente()));
			    return new ResponseEntity<>(_cliente, HttpStatus.CREATED);
			  } catch (Exception e) {
			    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	  }

	  @PutMapping("/actualizar/{id}")
	  public ResponseEntity<Clientes> updateCliente(@PathVariable("id") Long id, @RequestBody Clientes cliente) {
		  Optional<Clientes> clientesData = clientesRepository.findById(id);

		  if (clientesData.isPresent()) {
		    Clientes _cliente= clientesData.get();
		    cliente.setNombreCliente(cliente.getNombreCliente());
		    cliente.setDireccionCliente(cliente.getDireccionCliente());
		    cliente.setTelefonoCliente(cliente.getTelefonoCliente());
		    cliente.setEmailCliente(cliente.getEmailCliente());
		    return new ResponseEntity<>(clientesRepository.save(_cliente), HttpStatus.OK);
		  } else {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }
	  }

	  @DeleteMapping("/eliminar/{id}")
	  public ResponseEntity<HttpStatus> deleteCliente(@PathVariable("id") Long id) {
		  try {
			  clientesRepository.deleteById(id);
			    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			  } catch (Exception e) {
			    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	  }


}
