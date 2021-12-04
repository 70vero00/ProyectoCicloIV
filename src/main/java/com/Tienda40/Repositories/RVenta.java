package com.Tienda40.Repositories;

import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.repository.CrudRepository;

import com.Tienda40.Modelo.MVenta;

public interface RVenta extends MongoRepository<MVenta, Long>{
	@DeleteQuery("{_id:?0}")
	Long deleteByIdReturningDeletedCount(Long id);
}
