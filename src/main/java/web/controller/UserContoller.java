package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UserContoller {

    private UserService userService;

    @Autowired
    public UserContoller(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getCars(@RequestParam(value = "count", defaultValue = "5") int count, ModelMap model) {
        List<User> users;
        if (count >= 5) {
            // Если count больше либо равен 5, выводим весь список
             users = userService.getUsers(); // или carService.getAllCars();
        } else {
            // В противном случае выводим только нужное количество машин
            users = userService.getUsers();
        }
        model.addAttribute("users", users);
        return "users";
    }
}