package com.springreview.SpringBootReview.repository;

import com.springreview.SpringBootReview.controller.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository <Library,String> {
}
