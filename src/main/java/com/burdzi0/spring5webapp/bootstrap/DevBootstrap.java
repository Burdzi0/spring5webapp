package com.burdzi0.spring5webapp.bootstrap;

import com.burdzi0.spring5webapp.model.Author;
import com.burdzi0.spring5webapp.model.Book;
import com.burdzi0.spring5webapp.model.Publisher;
import com.burdzi0.spring5webapp.repositories.AuthorRepository;
import com.burdzi0.spring5webapp.repositories.BookRepository;
import com.burdzi0.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;

	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		initData();
	}

	private void initData() {
		Author eric = new Author("Eric","Err");
		Publisher publisher = new Publisher("HarperCollins", "SingleAddress");
		Book book = new Book("Domain Driven Development", "12345");

		publisherRepository.save(publisher);

		book.setPublisher(publisher);
		publisher.setBook(book);
		eric.getBooks().add(book);
		book.getAuthors().add(eric);

		authorRepository.save(eric);
		bookRepository.save(book);


		Author rod = new Author("Rod","Johnson");
		Publisher j2eePublisher = new Publisher("Apress", "SingleAddress2");
		Book j2ee = new Book("J2EE", "12346");

		publisherRepository.save(j2eePublisher);

		j2ee.setPublisher(j2eePublisher);
		j2eePublisher.setBook(j2ee);
		j2ee.getAuthors().add(rod);
		rod.getBooks().add(j2ee);

		authorRepository.save(rod);
		bookRepository.save(j2ee);

	}
}
