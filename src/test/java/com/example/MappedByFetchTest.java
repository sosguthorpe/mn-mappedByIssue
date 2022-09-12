package com.example;

import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.example.data.Author;
import com.example.data.AuthorRepository;
import com.example.data.Book;
import com.example.data.BookRepository;

import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;

@TestInstance(Lifecycle.PER_CLASS)
@MicronautTest
class MappedByFetchTest {

    @Inject
    EmbeddedApplication<?> application;
    
    @Inject
    BookRepository bookRepository;

    @Inject
    AuthorRepository authorRepository;
    
    private final static String BOOK_TITLE = "Black Holes: The Key to Understanding the Universe";
    private final static String AUTHOR_BC = "Professor Brian Cox";
    private final static String AUTHOR_JF = "Professor Jeff Forshaw";
    
    @BeforeAll
    void loadData() {
    	// Create and save a book.
    	bookRepository.save(
			BOOK_TITLE,
			authorRepository.save(AUTHOR_BC),
			authorRepository.save(AUTHOR_JF));
    }
    
    @Test
    void testBookRecall() {
    	Optional<Book> b = bookRepository.findOne(BOOK_TITLE);
    	assert b.isPresent();
    }
    
    @Test
    void testAuthorRecall() {
    	Optional<Author> a = authorRepository.findOne(AUTHOR_BC);
    	assert a.isPresent();
    	
    	a = authorRepository.findOne(AUTHOR_JF);
    	assert a.isPresent();
    }

}
