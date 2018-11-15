package com.burdzi0.spring5webapp.repositories;

import com.burdzi0.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
