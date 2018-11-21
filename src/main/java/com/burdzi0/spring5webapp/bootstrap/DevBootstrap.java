package com.burdzi0.spring5webapp.bootstrap;

import com.burdzi0.spring5webapp.model.Author;
import com.burdzi0.spring5webapp.model.Book;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		initData();
	}

	private void initData() {
		Author eric = new Author("Eric","Err");
		Book book = new Book("Domain Driven Development", "12345", "HarperCollins");

		eric.getBooks().add(book);
		book.getAuthors().add(eric);

		Author rod = new Author("Rod","Johnson");
		Book j2ee = new Book("J2EE", "12346", "Apress");
		rod.getBooks().add(j2ee);
		j2ee.getAuthors().add(rod);
	}
}
