package co.edu.unbosque.clientes.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.edu.unbosque.clientes.model.Clientes;

public interface ClientesRepository extends MongoRepository<Clientes, Long>{

}
