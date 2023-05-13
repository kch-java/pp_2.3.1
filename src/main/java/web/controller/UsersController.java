package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Spring MVC Hibernate CRUD application");
        messages.add("kata.academy. Java pre-project. Task 2.3.1");
        messages.add("Click on the link below to continue");
        model.addAttribute("messages", messages);
        return "index";
    }

    @GetMapping("/users")
    public String listUsers(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", userService.listUsers());
        return "users";
    }

    @PostMapping("/users/add")
    public String addUser(@ModelAttribute("user") User user) {
        if (user.getId() == null) {
            userService.add(user);
        } else {
            userService.update(user);
        }
        return "redirect:/users";
    }

    @GetMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") Long id) {
        userService.remove(id);
        return "redirect:/users";
    }

    @GetMapping("edit/{id}")
    public String editUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("listUsers", userService.listUsers());
        return "users";
    }
}
