package br.com.webapp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

@Repository
public class EnterpriseRepository {

	@Autowired
	private MongoOperations mongoOperations;
}
