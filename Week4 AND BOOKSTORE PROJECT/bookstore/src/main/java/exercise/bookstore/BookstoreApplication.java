package exercise.bookstore;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import exercise.bookstore.domain.AppUser;
import exercise.bookstore.domain.AppUserRepository;
import exercise.bookstore.domain.Book;
import exercise.bookstore.domain.Bookrepository;
import exercise.bookstore.domain.Category;
import exercise.bookstore.domain.Categoryrepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}



	@Bean
	public CommandLineRunner bookDemo(Bookrepository repository, Categoryrepository c_repository, AppUserRepository urepository) {
		return (args) -> {
			log.info("save a couple of books");

Category category1 = new Category("Fiction");
Category category2 = new Category("NonFiction");
Category category3 = new Category("SineceFiction");
Category category4 = new Category("Cooking");

c_repository.save(category1);
c_repository.save(category2);
c_repository.save(category3);
c_repository.save(category4);

			repository.save(new Book("To Kill a Mockingbird", "Harper Lee", 1960, "978-0-06-112008-4", 12.99, category1));
			repository.save(new Book("Sapiens: A Brief History of Humankind", "Yuval Noah Harari", 2011, "978-0-06-231609-7", 14.99, category2));	
			repository.save(new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adams", 1979, "978-0-345-39181-3", 11.49, category3));
			repository.save(new Book("The Joy of Cooking", "Irma S. Rombauer", 1931, "978-0-7432-4626-2", 25.99, category4));

			AppUser user1 = new AppUser("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6","abc@gmail.com", "USER");
			AppUser user2 = new AppUser("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C","def@gmail.com", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);

			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}
