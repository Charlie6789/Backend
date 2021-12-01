package co.edu.unbosque.productos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import co.edu.unbosque.productos.model.Productos;

public interface ProductosRepository extends MongoRepository<Productos, Integer>{
	
}