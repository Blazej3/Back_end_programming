package exercise.bookstore.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface Categoryrepository extends CrudRepository<Category, Long> {

    List<Category> findByCategoryName(String CategoryName);
    
}