package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import web.model.User;
import web.service.UserService;

@Controller
public class UsersController {

    private final UserService service;

    @Autowired
    public UsersController(UserService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public String showUserByID(Model model, @PathVariable int id) {
        model.addAttribute("user", service.showUserByID(id));
        return "show";
    }

    @GetMapping("/")
    public String showUsers(Model model) {
        model.addAttribute("usersList", service.getUsers());
        return "all_users";
    }

    @GetMapping("users/new")
    public String newUser(@ModelAttribute User user) {
        return "new_user";
    }

    @PostMapping
    public String addUser(@ModelAttribute User user) {
        service.addUser(user);
        return "redirect:/";
    }

    @GetMapping("users/{id}/edit")
    public String editUser(Model model, @PathVariable int id) {
        model.addAttribute("user", service.showUserByID(id));
        return "edit_user";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute User user) {
        service.editUser(user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        service.deleteUserById(id);
        return "redirect:/";
    }
}