package com.springreview.SpringBootReview;

import com.springreview.SpringBootReview.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootReviewApplication  {

	@Autowired
	LibraryRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootReviewApplication.class, args);
	}

//	@Override
//	public void run(String[] args){
//
//		Library library = repository.findById("helloworld100").get();
//		System.out.println(library.getAuthor());
//
//		Library entity = new Library();
//		entity.setAisle(12);
//		entity.setAuthor("Nageshwar");
//		entity.setIsbn("newNumber");
//		entity.setId("newId");
//		entity.setBook_name("Dev-Ops");
//		repository.save(entity);
//		List<Library> records = repository.findAll();
//
//		for(Library item : records){
//			String author = item.getAuthor();
//			int aisle = item.getAisle();
//			System.out.println(author);
//			System.out.println(aisle);
//		}
//
//	}

}
