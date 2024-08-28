package com.demo.microservice.book.service;

import com.demo.microservice.book.model.Book;
import com.demo.microservice.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Book createBook(Book book) {
        // Validate the book
        if (book.getTitle() == null || book.getAuthor() == null) {
            throw new RuntimeException("Title and Author cannot be null");
        }
        if (book.getYear() <= 0) {
            throw new RuntimeException("Year must be a positive number");
        }
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book book) {
        // Validate the book
        if (book.getTitle() == null || book.getAuthor() == null) {
            throw new RuntimeException("Title and Author cannot be null");
        }
        if (book.getYear() <= 0) {
            throw new RuntimeException("Year must be a positive number");
        }
        Book existingBook = getBookById(id);
        if (existingBook == null) {
            return null;
        }
        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setYear(book.getYear());
        return bookRepository.save(existingBook);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}