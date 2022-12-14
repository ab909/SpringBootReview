package com.springreview.SpringBootReview.controller;

import com.springreview.SpringBootReview.repository.LibraryRepository;
import com.springreview.SpringBootReview.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class LibraryController {

    @Autowired
    LibraryRepository repository;

    @Autowired
    LibraryService service;

    @PostMapping("/addBook")
    public ResponseEntity addBookImp(@RequestBody Library library){

        AddResponse addResponse = new AddResponse();

        String id = service.buildId(library.getIsbn(),library.getAisle());
        if(!service.verifyBookExists(id)){


        library.setId(library.getIsbn()+library.getAisle());
        library.setId(id);
        repository.save(library);
        HttpHeaders headers = new HttpHeaders();
        headers.add("unique", id);

        addResponse.setMsg("Success: Book is added");
        addResponse.setId(id);

       return new ResponseEntity<AddResponse>(addResponse,headers, HttpStatus.CREATED);

    } else {
            addResponse.setMsg("Book exists");
            addResponse.setId(id);
        }

        return new ResponseEntity<AddResponse>(addResponse, HttpStatus.ACCEPTED);

    }

    @GetMapping("/getBooks/{id}")
    public Library getBookById(@PathVariable(value="id")String id) {

        try {
            Library lib = repository.findById(id).get();
            return lib;

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("getBooks/author")
    public List<Library> getBooksByAuthor(@RequestParam(value = "authorname")String authorname){

       return repository.findAllByAuthor(authorname);

    }

    @PutMapping("/updateBook/{id}")
    public ResponseEntity<Library> updateBook (@PathVariable(value="id")String id, @RequestBody Library library){

        Library existingBook = repository.findById(id).get();

        existingBook.setAisle(library.getAisle());
        existingBook.setAuthor(library.getAuthor());
        existingBook.setBook_name(library.getBook_name());
        repository.save(existingBook);
        return new ResponseEntity<Library>(existingBook, HttpStatus.OK);


    }

    @DeleteMapping("/deleteBook")
    public ResponseEntity<String> deleteBookById(@RequestBody Library library){

       Library deleteBook = repository.findById(library.getId()).get();
       repository.delete(deleteBook);
       return new ResponseEntity<>("Book is deleted",HttpStatus.CREATED);

    }

}
