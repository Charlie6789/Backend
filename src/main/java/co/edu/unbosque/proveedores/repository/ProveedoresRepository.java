package co.edu.unbosque.proveedores.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import co.edu.unbosque.proveedores.model.Proveedores;

public interface ProveedoresRepository extends MongoRepository<Proveedores, Long>{

}
