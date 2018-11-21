package com.burdzi0.spring5webapp.bootstrap;

import com.burdzi0.spring5webapp.model.Author;
import com.burdzi0.spring5webapp.model.Book;
import com.burdzi0.spring5webapp.repositories.AuthorRepository;
import com.burdzi0.spring5webapp.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;

	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		initData();
	}

	private void initData() {
		Author eric = new Author("Eric","Err");
		Book book = new Book("Domain Driven Development", "12345", "HarperCollins");
		eric.getBooks().add(book);
		book.getAuthors().add(eric);

		authorRepository.save(eric);
		bookRepository.save(book);


		Author rod = new Author("Rod","Johnson");
		Book j2ee = new Book("J2EE", "12346", "Apress");

		rod.getBooks().add(j2ee);
		j2ee.getAuthors().add(rod);

		authorRepository.save(rod);
		bookRepository.save(j2ee);

	}
}
