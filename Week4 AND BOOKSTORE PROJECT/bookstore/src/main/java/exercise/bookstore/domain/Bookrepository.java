package exercise.bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface Bookrepository extends CrudRepository<Book, Long> {

    List<Book> findByAuthor(String author);
    
}

