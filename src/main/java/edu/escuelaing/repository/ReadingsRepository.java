package edu.escuelaing.repository;

import edu.escuelaing.entity.Readings;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadingsRepository extends MongoRepository<Readings, String> {
    // Define custom query methods if needed
}