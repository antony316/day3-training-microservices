package com.demo.microservice.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.microservice.book.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}