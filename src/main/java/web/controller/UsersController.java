package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UsersController {

    private final UserService service;
    @Autowired
    public UsersController(UserService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String showUsers(Model model) {
        model.addAttribute("usersList", service.getUsers());
        return "all_users";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new_user";
    }

    @PostMapping
    public String addUser(@ModelAttribute("user") User user) {
        service.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String editUser(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", service.getUserById(id));
        return "edit_user";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user) {
        service.editUser(user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        service.deleteUserById(id);
        return "redirect:/";
    }
}