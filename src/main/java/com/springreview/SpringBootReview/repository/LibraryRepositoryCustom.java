package com.springreview.SpringBootReview.repository;

import com.springreview.SpringBootReview.controller.Library;

import java.util.List;

public interface LibraryRepositoryCustom {

    List<Library> findAllByAuthor(String authorname);
}
