package com.Tienda40.Repositories;

import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;


import com.Tienda40.Modelo.MCliente;

public interface RCliente extends MongoRepository<MCliente, Long>{
	
	@DeleteQuery("{_id:?0}")
	Long deleteByIdReturningDeletedCount(Long id);

}
