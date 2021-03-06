package io.hidekuma.springboot.domain;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {
	@Autowired
	BookRepository repository;
	
	@Test
	public void testSave() {
		Book book =  new Book();
		book.setName("boot.spring.boot");
		book.setIsbn10("sadf");
		book.setIsbn13("asdfdf");
		assertThat(book.isNew()).isTrue();
		repository.save(book);
		assertThat(book.isNew()).isFalse();
	}
	
	@Test
	public void testFindByNameLIke() {
		Book book =  new Book();
		book.setName("boot.spring.boot");
		book.setIsbn10("sadf");
		book.setIsbn13("asdfdf");
	
		repository.save(book);
		
		List<Book> books = repository.findByNameLike("boot.spring.boot");
		System.out.println(books);
		assertThat(books).isNotEmpty();
		
		books = repository.findByNameLike("book");
		assertThat(books).isEmpty();
		
	}
}
