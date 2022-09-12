package com.example.data;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import io.micronaut.data.annotation.Join;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.PageableRepository;

@Join(value = "authors", type = Join.Type.FETCH)
@JdbcRepository(dialect = Dialect.H2)
@Transactional
public interface BookRepository extends PageableRepository<Book, Integer> {

	default Book save (final String title, Author... authors) {
		return save (title, new HashSet<>(Arrays.asList( authors )));
	}
	
	default Book save (@NotNull final String title, @NotEmpty final Set<Author> authors) {
		Book book = new Book();
		book.setTitle(title);
		book.setAuthors(authors);
		
		return save (book);
	}
	
	Optional<Book> findOne( String title );
}
