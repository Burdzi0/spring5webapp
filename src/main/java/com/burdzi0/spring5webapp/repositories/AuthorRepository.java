package com.burdzi0.spring5webapp.repositories;

import com.burdzi0.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
