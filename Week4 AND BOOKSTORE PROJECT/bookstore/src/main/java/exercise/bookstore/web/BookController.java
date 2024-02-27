package exercise.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import exercise.bookstore.domain.Book;
import exercise.bookstore.domain.Bookrepository;
import exercise.bookstore.domain.Categoryrepository;

@Controller
public class BookController {
    @Autowired
    private Bookrepository repository;

    @Autowired
    private Categoryrepository c_repository;

    @RequestMapping(value = { "/Booklist" })
    public String studentList(Model model) {
        model.addAttribute("books", repository.findAll());
        return "Booklist.html";
    }

    @RequestMapping(value = "/add")
    public String addStudent(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", c_repository.findAll());
        return "addBook.html";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book) {
        repository.save(book);
        return "redirect:Booklist";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long id, Model model) {
        repository.deleteById(id);
        return "redirect:../Booklist";
    }

    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editBookForm(@PathVariable("id") Long id, Model model) {
    	model.addAttribute("book", repository.findById(id));
        model.addAttribute("categories", c_repository.findAll());
    	return "editBook.html";
    }  


}
