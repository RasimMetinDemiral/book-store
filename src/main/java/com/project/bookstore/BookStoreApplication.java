package com.project.bookstore;


import com.project.bookstore.repository.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class BookStoreApplication  {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}
}
