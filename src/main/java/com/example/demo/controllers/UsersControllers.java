package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;
import web.service.UserServiceImpl;

@Controller
@RequestMapping("/users")
public class UsersControllers {

    private UserService userService;

    @Autowired
    public UsersControllers(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String allUsers(Model model) {
        model.addAttribute("user", userService.allUsers());
        return "/all";
    }

    @GetMapping("/add")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "/add";
    }

    @PostMapping()
    public String saveUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users";    }


    @GetMapping("/{id}/userById")
    public String userById(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.userById(id));
        return "/byID";
    }

    @PatchMapping("{id}")
    public String update(@ModelAttribute("user") User user,
                         @PathVariable("id") int id){
        userService.update(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("{id}")
    public String delete(@ModelAttribute("user") User user,
                         @PathVariable("id") int id){
        userService.delete(id);
        return "redirect:/users";}
}
