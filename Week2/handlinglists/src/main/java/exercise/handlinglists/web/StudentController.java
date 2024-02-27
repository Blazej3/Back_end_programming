package exercise.handlinglists.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import exercise.handlinglists.domain.student;
import org.springframework.web.bind.annotation.GetMapping;





@Controller
public class StudentController {

    @GetMapping("/hello")
    public String showStudent(Model model) {

      
        List<student> Students = new ArrayList<>();

        Students.add(new student("Kate", "Cole"));
        Students.add(new student("Dan", "Brown"));
        Students.add(new student("Mike", "Mars"));
        

        model.addAttribute("Students", Students);
        
        return "hello.html";
    }
    



}
