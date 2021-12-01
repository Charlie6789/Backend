package co.edu.unbosque.consolidado.controller;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.edu.unbosque.consolidado.model.Consolidado;
import co.edu.unbosque.consolidado.repository.ConsolidadoRepository;

@CrossOrigin(origins = "http://localhost:8084")
@RestController
@RequestMapping("/api")
public class ConsolidadoController {
	@Autowired
	  ConsolidadoRepository consolidadoRepository;

	  @GetMapping("/consultar")
	  public ResponseEntity<List<Consolidado>> getAllConsolidado() {
		  try {
			    List<Consolidado> consolidado = new ArrayList<Consolidado>();

			    consolidadoRepository.findAll().forEach(consolidado::add);

			    if (consolidado.isEmpty()) {
			      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			    }

			    return new ResponseEntity<>(consolidado, HttpStatus.OK);
			  } catch (Exception e) {
			    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	  }

	  @GetMapping("/consultar/{id}")
	  public ResponseEntity<Consolidado> getConsolidadoById(@PathVariable("id") Long id) {
		  Optional<Consolidado> consolidadoData = consolidadoRepository.findById(id);

		  if (consolidadoData.isPresent()) {
		    return new ResponseEntity<>(consolidadoData.get(), HttpStatus.OK);
		  } else {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }
	  }

	 @PostMapping("/crear")
	  public ResponseEntity<Consolidado> createConsolidado(@RequestBody Consolidado consolidado) {
		  try {
			  Consolidado _consolidado = consolidadoRepository.save(new Consolidado(consolidado.getId(),consolidado.getCiudad(),consolidado.getTotalVentas()));
			    return new ResponseEntity<>(_consolidado, HttpStatus.CREATED);
			  } catch (Exception e) {
			    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	  }

	  @DeleteMapping("/eliminar/{id}")
	  public ResponseEntity<HttpStatus> deleteConsolidado(@PathVariable("id") Long id) {
		  try {
			  consolidadoRepository.deleteById(id);
			    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			  } catch (Exception e) {
			    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	  }


}