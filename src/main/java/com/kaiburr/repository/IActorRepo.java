//IActorRepo.java
package com.kaiburr.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kaiburr.document.Actor;

public interface IActorRepo extends MongoRepository<Actor, String> {
	@Query("from Actor where category in(:c1,:c2) order by category") // JPQL query
	public List<Actor> getActorsByCategories(@Param("c1") String category1, @Param("c2") String category2);

}
