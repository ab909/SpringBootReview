package com.springreview.SpringBootReview.repository;

import com.springreview.SpringBootReview.controller.Library;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class LibraryRepositoryImpl implements LibraryRepositoryCustom{

    @Autowired
    LibraryRepository repository;

    public List<Library> findAllByAuthor(String authorname){
        List<Library> books = repository.findAll();
        List<Library> booksWithAuthor = new ArrayList<Library>();
        for (int i=0;i<books.size();i++){
            if(books.get(i).getAuthor().equalsIgnoreCase("Govinda")){
                System.out.println(books.get(i).getAuthor().equalsIgnoreCase("Govinda"));
                booksWithAuthor.add(books.get(i));
            }
        }
        return booksWithAuthor;
    }


}
