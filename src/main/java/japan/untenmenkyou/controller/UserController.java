package japan.untenmenkyou.controller;

import japan.untenmenkyou.entity.User;
import japan.untenmenkyou.repository.UserRepository;
import japan.untenmenkyou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;
    private UserService userService;

    @GetMapping("/")
    public String home() {
        return "home";
    }
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {
        if (userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword()) != null) {
            return "redirect:/register?error";
        }
        userRepository.save(user);
        System.out.println("User registered: " + user.getName()); // Thêm dòng này
        return "redirect:/login?success";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }














}

