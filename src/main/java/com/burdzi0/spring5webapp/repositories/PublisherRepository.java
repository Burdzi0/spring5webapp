package com.burdzi0.spring5webapp.repositories;

import com.burdzi0.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
