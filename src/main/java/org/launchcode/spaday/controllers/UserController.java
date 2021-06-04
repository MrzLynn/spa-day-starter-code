package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "user")
public class UserController {

    @PostMapping("/add")
    public String displayAddUserForm(){
        return ("user/add");
    }

    @RequestMapping
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify){
        if(user.getPassword() == verify) {
            model.addAttribute("user", user);
            return ("user/index");
        }
        else
            model.addAttribute("error","Wrong password, try again.");
            model.addAttribute("Username", user.getUsername());
            model.addAttribute("Email",user.getEmail());
            return ("user/add");
    }

}
