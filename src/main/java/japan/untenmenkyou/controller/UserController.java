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
    @Autowired
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
            return "redirect:/register?emailexist";
        }
        userRepository.save(user);
        return "redirect:/login?success";
    }



    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }
    @PostMapping("/login")
    public String loginUser(@ModelAttribute("user") User user, Model model) {
        User existingUser = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
        if (existingUser == null) {
            model.addAttribute("loggedInUser", existingUser);
            return "redirect:/karimen";
        } else {
            return "redirect:/login?error";
        }
    }




    @GetMapping("/karimen")
    public String karimen() {
        return "karimen";
    }

    @GetMapping("/gentsuki")
    public String gentsuki() {
        return "gentsuki";
    }
    @GetMapping("/map")
    public String learn() {
        return "map";
    }
    @GetMapping("/vietnamese")
    public String vietnamese() {
        return "vietnamese";
    }



}




