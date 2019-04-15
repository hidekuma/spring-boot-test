package io.hidekuma.springboot.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.hidekuma.springboot.domain.Book;
import io.hidekuma.springboot.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	@Autowired
	BookService bookService;
	
	@GetMapping("/{bookId}")
	public ResponseEntity<Book> findById(Long bookId){
		Book book = bookService.findById(bookId)
				.orElseThrow(() -> new RuntimeException("Not found " + bookId));
		return ResponseEntity.ok(book);
	}
}
