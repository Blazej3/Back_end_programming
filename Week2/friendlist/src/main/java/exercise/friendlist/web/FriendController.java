package exercise.friendlist.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import exercise.friendlist.domain.friend;

@Controller

public class FriendController {

    List<String> FriendsList = new ArrayList<>();

    @GetMapping("/index")
    public String greetingForm(Model model, friend friendo) {
        
        model.addAttribute("FriendsList", FriendsList);
        model.addAttribute("newFriend", new friend());


        if (friendo.getName() != null && !friendo.getName().isEmpty()) {
            FriendsList.add(friendo.getName());
        }

        return "hello.html";
    }
//-------------------------------------
}
