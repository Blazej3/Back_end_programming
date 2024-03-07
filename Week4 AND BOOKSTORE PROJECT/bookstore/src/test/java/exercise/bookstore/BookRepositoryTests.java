package exercise.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.Test;

import exercise.bookstore.domain.Book;
import exercise.bookstore.domain.Bookrepository;
import exercise.bookstore.domain.Category;
import exercise.bookstore.domain.Categoryrepository;

@SpringBootTest(classes = BookstoreApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookRepositoryTests {

    @Autowired
    private Bookrepository b_repository;

    @Autowired
    private Categoryrepository c_repository;

    @Test
    public void findByAuthorShouldReturnTitle() {
        List<Book> books = b_repository.findByAuthor("Douglas Adams");

        assertThat(books).hasSize(1);
        assertThat(books.get(0).getTitle()).isEqualTo("The Hitchhiker's Guide to the Galaxy");
    }

    @Test
    public void createNewBook() {
        Category category = new Category("BITE");
        c_repository.save(category);
        Book book = b_repository.save(new Book("1984", "George Orwell", 1949, "978-0451524935", 10.99, category));

        b_repository.save(book);
        assertThat(book.getId()).isNotNull();
    }

    @Test
    public void deleteNewStudent() {
		List<Book> books = b_repository.findByAuthor("Yuval Noah Harari");
		Book book = books.get(0);
		b_repository.delete(book);
		List<Book> newBooks = b_repository.findByAuthor("Yuval Noah Harari");
		assertThat(newBooks).hasSize(0);
     }

}
