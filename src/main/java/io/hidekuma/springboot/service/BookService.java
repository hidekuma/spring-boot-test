package io.hidekuma.springboot.service;

import java.util.Optional;

import io.hidekuma.springboot.domain.Book;

public interface BookService {
	Optional<Book> findById(Long id);
}
