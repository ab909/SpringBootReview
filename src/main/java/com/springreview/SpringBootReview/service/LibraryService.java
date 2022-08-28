package com.springreview.SpringBootReview.service;

import com.springreview.SpringBootReview.controller.Library;
import com.springreview.SpringBootReview.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LibraryService {

    @Autowired
    LibraryRepository repository;

    public boolean verifyBookExists(String id) {
        Optional<Library> lib = repository.findById(id);
        if(lib.isPresent()){
            return true;

        } else {
            return false;
        }
    }
    public String buildId(String isbn, int aisle){
        return isbn+aisle;
    }
}
