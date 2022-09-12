package com.example.data;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Relation;
import io.micronaut.data.annotation.Relation.Cascade;
import io.micronaut.data.annotation.Relation.Kind;

@MappedEntity
public class Book {
	
	@Id
	private int id;
	
	@NotEmpty
	private String title;
	
	@Relation(value = Kind.MANY_TO_MANY,  cascade = { Cascade.PERSIST, Cascade.UPDATE })
	@Valid
	@NotNull
	private Set<Author> authors = new HashSet<>();

	public Set<Author> getAuthors() {
		return authors;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	};
}
