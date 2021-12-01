package co.edu.unbosque.consolidado.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import co.edu.unbosque.consolidado.model.Consolidado;


public interface ConsolidadoRepository extends MongoRepository<Consolidado, Long>{

}
