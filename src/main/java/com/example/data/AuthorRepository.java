package com.example.data;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

import io.micronaut.data.annotation.Join;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.PageableRepository;

@Join(value = "books", type = Join.Type.FETCH)
@JdbcRepository(dialect = Dialect.H2)
@Transactional
public interface AuthorRepository extends PageableRepository<Author, Integer> {
	Author save(@NotNull final String name);
	

	Optional<Author> findOne( String name );
}
