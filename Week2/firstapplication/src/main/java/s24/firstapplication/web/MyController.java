package s24.firstapplication.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {

    @RequestMapping("main")
    // @ResponseBody
    public String showMessage(@RequestParam String name, Model model) {

        model.addAttribute("name2", name);

        return "hello.html";
    }
}
