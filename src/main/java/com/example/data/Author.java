package com.example.data;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Relation;
import io.micronaut.data.annotation.Relation.Kind;

@MappedEntity
public class Author {
	
	@Id
	private int id;
	
	@NotEmpty
	private String name;

	@NotNull
	@Relation(value = Kind.MANY_TO_MANY, mappedBy = "authors")
	private Set<Book> books = new HashSet<>();

	public Set<Book> getBooks() {
		return books;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
