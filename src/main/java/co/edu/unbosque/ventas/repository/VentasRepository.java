package co.edu.unbosque.ventas.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import co.edu.unbosque.ventas.model.Ventas;

public interface VentasRepository extends MongoRepository<Ventas, String>{

}
